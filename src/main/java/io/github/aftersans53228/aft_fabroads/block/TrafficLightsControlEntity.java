package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.system.CallbackI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author aftersans53228(AFT Transportation)
 */
public class TrafficLightsControlEntity extends BlockEntity  implements BlockEntityClientSerializable {
    private int timerTraffic =0;
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
        super.readNbt(nbt);
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.putString("NS",this.NSlightType);
        nbt.putString("WE",this.WElightType);
        nbt.putIntArray("time_sequence",this.timeSequence);
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
    public String getTimeLeft(){
        if (this.timerTraffic < 200 && this.timerTraffic >=0){
            return (this.timerTraffic/20 + 1) < 10 ? "0" + (this.timerTraffic / 20 + 1) : Integer.toString(this.timerTraffic/20 + 1);
        }
        else{
            return " ";
        }
    }

    private void reset(){
        this.stop();
        this.timerTraffic = -60;
        this.timeSequence = new int[]{30,0,30,0};
        this.NSlightType = "disable";
        this.WElightType = "disable";
        this.markDirty();
        if (this.world!=null && !this.world.isClient()) {
            this.world.updateListeners(pos, this.getCachedState(), this.getCachedState(), Block.NOTIFY_LISTENERS);
        }
    }


    /*
    * This method's logic is originally from "Solid-Block".
    */
    public static void tick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        TrafficLightsControlEntity entity = (TrafficLightsControlEntity)blockEntity;
        if(entity.timeSequence.length != 4){
            entity.reset();
        }
        if (state.get(BooleanProperty.of("is_enable"))){
            entity.timerTraffic --;
            if (entity.timerTraffic < -40){
                if (entity.timerOrder != 3){
                    entity.timerOrder ++;
                    entity.timerTraffic = entity.timeSequence[entity.timerOrder] * 20;
                }
                else {
                    entity.timerOrder = 0;
                    entity.timerTraffic = entity.timeSequence[0] * 20;
                }
            }
            if(entity.timerTraffic < 0) {
                switch (entity.timerOrder) {
                    case 0 -> {
                        entity.NSlightType = "forward_yellow";
                        entity.WElightType = "forward_red";
                    }
                    case 1 -> {
                        entity.NSlightType = "turn_yellow";
                        entity.WElightType = "turn_red";
                    }
                    case 2 -> {
                        entity.NSlightType = "forward_red";
                        entity.WElightType = "forward_yellow";
                    }
                    case 3 -> {
                        entity.NSlightType = "turn_red";
                        entity.WElightType = "turn_yellow";
                    }
                }
            }
            else if(entity.timerTraffic < 50){
                switch (entity.timerOrder) {
                    case 0 -> {
                        if(entity.timerTraffic/10 == 4 || entity.timerTraffic/10 == 2 || entity.timerTraffic/10 == 0) entity.NSlightType = "forward_green";
                        else entity.NSlightType = "forward_air";

                        entity.WElightType = "forward_red";
                    }
                    case 1 -> {
                        if(entity.timerTraffic/10 == 4 || entity.timerTraffic/10 == 2 || entity.timerTraffic/10 == 0) entity.NSlightType = "turn_green";
                        else entity.NSlightType = "turn_air";

                        entity.WElightType = "turn_red";
                    }
                    case 2 -> {
                        entity.NSlightType = "forward_red";

                        if(entity.timerTraffic/10 == 4 || entity.timerTraffic/10 == 2 || entity.timerTraffic/10 == 0) entity.WElightType = "forward_green";
                        else  entity.WElightType = "forward_air";
                    }
                    case 3 -> {
                        entity.NSlightType = "turn_red";

                        if(entity.timerTraffic/10 == 4 || entity.timerTraffic/10 == 2 || entity.timerTraffic/10 == 0) entity.WElightType = "turn_green";
                        else  entity.WElightType = "turn_air";
                    }
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
            }
            entity.markDirty();
            world.updateListeners(entity.pos,world.getBlockState(entity.pos),world.getBlockState(entity.pos),Block.NOTIFY_LISTENERS);

        }
        else{
            entity.NSlightType = "disabled";
            entity.WElightType = "disabled";
        }
    }
}
