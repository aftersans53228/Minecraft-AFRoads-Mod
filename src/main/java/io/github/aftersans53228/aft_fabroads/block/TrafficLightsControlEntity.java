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
import java.util.List;


public class TrafficLightsControlEntity extends BlockEntity  implements BlockEntityClientSerializable {
    private int timerTraffic =0;
    private List<Integer> timeForward = new ArrayList<>();
    private List<Integer> timeTurn = new ArrayList<>();
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
        super.readNbt(nbt);
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.putString("NS",this.NSlightType);
        nbt.putString("WE",this.WElightType);
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

    private void start(){
        this.timerTraffic=0;
        if (this.world != null) {
            this.world.setBlockState(this.pos,this.world.getBlockState(this.pos).with(BooleanProperty.of("is_enable"),true));
        }
    }

    private void reset(){
        if (this.world != null) {
            this.world.setBlockState(this.pos,this.world.getBlockState(this.pos).with(BooleanProperty.of("is_enable"),false));
        }
        this.timerTraffic=0;
        this.timeForward = new ArrayList<>();
            this.timeForward.add(0,10);//绿（秒）
            this.timeForward.add(1,10);//红（秒）
        this.timeTurn =new ArrayList<>();
            this.timeTurn.add(0,0);//转弯绿左（秒）
            this.timeTurn.add(0,0);//转弯红左（秒）
        this.NSlightType = "disable";
        this.WElightType = "disable";
        this.markDirty();
        if (this.world!=null && !this.world.isClient()) {
            this.world.updateListeners(pos, this.getCachedState(), this.getCachedState(), Block.NOTIFY_LISTENERS);
        }

    }
    private int getTimerLength(){
        int timer = 40;
        for(Integer i:this.timeForward){
            timer+=(i*20);
        }
        for(Integer i:this.timeTurn){
            timer+=(i*20);
        }
        return timer*2;
    }

    public static void tick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        TrafficLightsControlEntity entity = (TrafficLightsControlEntity) blockEntity;
        if(Boolean.TRUE.equals(state.get(BooleanProperty.of("is_enable")))){
            if(!world.isClient()){
                int temporaryVar = 0;
                entity.timerTraffic +=1;
                if(entity.timerTraffic == entity.getTimerLength()){
                    entity.timerTraffic =0;
                }
                if (entity.timerTraffic <= entity.timeForward.get(0)*20){
                    entity.NSlightType = "forward_green";
                    entity.WElightType = "forward_red";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2)*20){
                    entity.NSlightType = "forward_yellow";
                    entity.WElightType = "forward_red";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1))*20){
                    entity.NSlightType = "turn_left_red";
                    entity.WElightType = "forward_red";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1)+ entity.timeTurn.get(0))*20){
                    entity.NSlightType = "turn_left";
                    entity.WElightType = "forward_red";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1)+ entity.timeTurn.get(0)+2)*20){
                    entity.NSlightType = "turn_left_yellow";
                    entity.WElightType = "forward_red";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1)+ entity.timeTurn.get(0)+2+entity.timeForward.get(1))*20){
                    entity.NSlightType = "forward_red";
                    entity.WElightType = "forward_green";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1)+ entity.timeTurn.get(0)+2+entity.timeForward.get(1)+2)*20){
                    entity.NSlightType = "forward_red";
                    entity.WElightType = "forward_yellow";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1)+ entity.timeTurn.get(0)+2+entity.timeForward.get(1)+2+ entity.timeTurn.get(1))*20){
                    entity.NSlightType = "forward_red";
                    entity.WElightType = "turn_left_red";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1)+ entity.timeTurn.get(0)+2+entity.timeForward.get(1)+2+ entity.timeTurn.get(1)+ entity.timeTurn.get(0))*20){
                    entity.NSlightType = "forward_red";
                    entity.WElightType = "turn_left_green";
                }
                else if (entity.timerTraffic <= (entity.timeForward.get(0)+2+entity.timeForward.get(1)+ entity.timeTurn.get(1)+ entity.timeTurn.get(0)+2+entity.timeForward.get(1)+2+ entity.timeTurn.get(1)+ entity.timeTurn.get(0)+2)*20){
                    entity.NSlightType = "forward_red";
                    entity.WElightType = "turn_left_yellow";
                }
                entity.markDirty();
                world.updateListeners(pos,entity.getCachedState(),entity.getCachedState(), Block.NOTIFY_LISTENERS);
            }
        }
        else{
            entity.NSlightType = "disable";
            entity.WElightType = "disable";
            entity.reset();
            entity.start();
        }

    }
}
