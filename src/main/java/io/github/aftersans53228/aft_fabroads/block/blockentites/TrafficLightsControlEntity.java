package io.github.aftersans53228.aft_fabroads.block.blockentites;

import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


/**
 * @author aftersans53228(AFT Transportation)
 */
public class TrafficLightsControlEntity extends BlockEntity  implements BlockEntityClientSerializable {
    private int timerTraffic = 0;
    private int timerOrder = 0;
    private int[] timeSequence = new int[]{};
    private String NSlightType = "";
    private String WElightType = "";


    public TrafficLightsControlEntity(BlockPos pos, BlockState state) {
        super(AFRoadsBlockRegistry.TRAFFIC_LIGHTS_CONTROL_ENTITY, pos, state);
        this.reset();
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        this.NSlightType = nbt.getString("NS");
        this.WElightType = nbt.getString("WE");
        this.timeSequence = nbt.getIntArray("time_sequence");
        this.timerTraffic = nbt.getInt("timer");
        this.timerOrder = nbt.getInt("tod");
        super.readNbt(nbt);
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.putString("NS",this.NSlightType);
        nbt.putString("WE",this.WElightType);
        nbt.putIntArray("time_sequence",this.timeSequence);
        nbt.putInt("timer",this.timerTraffic);
        nbt.putInt("tod",this.timerOrder);
        return super.writeNbt(nbt);
    }

    @Override
    public void fromClientTag(NbtCompound tag) {
        this.readNbt(tag);
    }

    @Override
    public NbtCompound toClientTag(NbtCompound tag) {
        return this.writeNbt(tag);
    }

    public String getLightType(String arg){
        return switch (arg) {
            case "NS" -> this.NSlightType;
            case "WE" -> this.WElightType;
            default -> throw new IllegalStateException("Unexpected traffic lights value type: " + arg);
        };
    }

    public int[] getTimerData(){
        return this.timeSequence;
    }
    public void setTimeData(int[] timeSequence){
        if (this.world != null) {
            this.timeSequence = timeSequence;
            this.markDirty();
            this.world.updateListeners(pos,this.world.getBlockState(pos),this.world.getBlockState(pos), Block.NOTIFY_LISTENERS);
        }
    }

    public void start(){
        this.timerTraffic=0;
        if (this.world != null) {
            this.world.setBlockState(this.pos,this.world.getBlockState(this.pos).with(BooleanProperty.of("is_enable"),true));
        }
    }
    public void stop(){
        this.timerTraffic=0;
        if (this.world != null) {
            this.world.setBlockState(this.pos,this.world.getBlockState(this.pos).with(BooleanProperty.of("is_enable"),false));
        }
    }
    public static String getTimeLeft(TrafficLightsControlEntity et,String type){ //What am fk doing??
        if (!Integer.valueOf(type.charAt(0)-'0').equals(et.timerOrder) && !Integer.valueOf(type.charAt(0)-'0').equals((et.timerOrder + 1)>3 ? 0 : et.timerOrder + 1)){
            return "";
        }
        if (type.charAt(2) == 'R'){
            if (et.timerTraffic < 160 && et.timerTraffic >= 0) {
                return (et.timerTraffic / 20 + 1 + 4) < 10 ? "0" + (et.timerTraffic / 20 + 1 + 4) : Integer.toString(et.timerTraffic / 20 + 1 + 4);
            } else if (et.timerTraffic < 0) {
                return "0" + ((et.timerTraffic + 80) / 20 + 1);
            }
        }
        else if(type.charAt(2) == 'G'){
            if (et.timerTraffic < 200 && et.timerTraffic >= 0) {
                return (et.timerTraffic / 20 + 1) < 10 ? "0" + (et.timerTraffic / 20 + 1) : Integer.toString(et.timerTraffic / 20 + 1);
            }
            else{
                return "";
            }
        }
        return "";
    }

    private void reset(){
        this.stop();
        this.timerTraffic = -40;
        this.timeSequence = new int[]{30,0,30,0};
        this.NSlightType = "disable";
        this.WElightType = "disable";
        this.markDirty();
        if (this.world!=null && !this.world.isClient()) {
            this.world.updateListeners(pos, this.getCachedState(), this.getCachedState(), Block.NOTIFY_LISTENERS);
        }
    }


    /*
    * This method's logic was originally from "Solid-Block" and I made some extra parts.
    */
    public static void tick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        TrafficLightsControlEntity entity = (TrafficLightsControlEntity)blockEntity;
        if(entity.timeSequence.length != 4){
            entity.reset();
        }
        if (state.get(BooleanProperty.of("is_enable"))){
            entity.timerTraffic --;
            if (entity.timerTraffic < -80){
                if (entity.timerOrder != 3){
                    entity.timerOrder ++;
                    entity.timerTraffic = entity.timeSequence[entity.timerOrder] * 20;
                }
                else {
                    entity.timerOrder = 0;
                    entity.timerTraffic = entity.timeSequence[0] * 20;
                }
            }
            if(entity.timerTraffic < 0 ) {
                switch (entity.timerOrder) {
                    case 0 -> {
                        entity.NSlightType = entity.timerTraffic > -41 ? "forward_yellow" : "forward_redE";
                        entity.WElightType = "forward_red";
                    }
                    case 1 -> {
                        entity.NSlightType = entity.timerTraffic > -41 ? "turn_yellow" : "turn_redE";
                        entity.WElightType = "turn_red";
                    }
                    case 2 -> {
                        entity.NSlightType = "forward_red";
                        entity.WElightType = entity.timerTraffic > -41 ? "forward_yellow" : "forward_redE";
                    }
                    case 3 -> {
                        entity.NSlightType = "turn_red";
                        entity.WElightType = entity.timerTraffic > -41 ? "turn_yellow" : "turn_redE";
                    }
                }
                if (entity.timerTraffic % 10 == 0 ){
                    entity.markDirty();
                    world.updateListeners(entity.pos,world.getBlockState(entity.pos),world.getBlockState(entity.pos),Block.NOTIFY_LISTENERS);
                }
            }
            else if(entity.timerTraffic < 50){
                switch (entity.timerOrder) {
                    case 0 -> {
                        if(entity.timerTraffic/10 == 4 || entity.timerTraffic/10 == 2 || entity.timerTraffic/10 == 0) entity.NSlightType = "forward_green";
                        else entity.NSlightType = "forward_airG";

                        entity.WElightType = "forward_red";
                    }
                    case 1 -> {
                        if(entity.timerTraffic/10 == 4 || entity.timerTraffic/10 == 2 || entity.timerTraffic/10 == 0) entity.NSlightType = "turn_green";
                        else entity.NSlightType = "turn_airG";

                        entity.WElightType = "turn_red";
                    }
                    case 2 -> {
                        entity.NSlightType = "forward_red";

                        if(entity.timerTraffic/10 == 4 || entity.timerTraffic/10 == 2 || entity.timerTraffic/10 == 0) entity.WElightType = "forward_green";
                        else  entity.WElightType = "forward_airG";
                    }
                    case 3 -> {
                        entity.NSlightType = "turn_red";

                        if(entity.timerTraffic/10 == 4 || entity.timerTraffic/10 == 2 || entity.timerTraffic/10 == 0) entity.WElightType = "turn_green";
                        else  entity.WElightType = "turn_airG";
                    }
                }
                if (entity.timerTraffic % 10 == 0){
                    entity.markDirty();
                    world.updateListeners(entity.pos,world.getBlockState(entity.pos),world.getBlockState(entity.pos),Block.NOTIFY_LISTENERS);
                }
            }
            else{
                switch (entity.timerOrder) {
                    case 0 -> {
                        entity.NSlightType = "forward_green";
                        entity.WElightType = "forward_red";
                    }
                    case 1 -> {
                        entity.NSlightType = "turn_green";
                        entity.WElightType = "turn_red";
                    }
                    case 2 -> {
                        entity.NSlightType = "forward_red";
                        entity.WElightType = "forward_green";
                    }
                    case 3 -> {
                        entity.NSlightType = "turn_red";
                        entity.WElightType = "turn_green";
                    }
                }
                if (entity.timerTraffic % 20 == 0){
                    entity.markDirty();
                    world.updateListeners(entity.pos,world.getBlockState(entity.pos),world.getBlockState(entity.pos),Block.NOTIFY_LISTENERS);
                }
            }

        }
        else{
            entity.NSlightType = "disabled";
            entity.WElightType = "disabled";
        }
    }
}
