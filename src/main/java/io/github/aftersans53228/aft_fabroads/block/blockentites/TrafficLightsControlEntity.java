package io.github.aftersans53228.aft_fabroads.block.blockentites;

import blue.endless.jankson.annotation.Nullable;
import io.github.aftersans53228.aft_fabroads.registry.AFRoadsBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;


/**
 * @author aftersans53228(AFT Transportation)
 */
public class TrafficLightsControlEntity extends BlockEntity{
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
    public void writeNbt(NbtCompound nbt) {
        nbt.putString("NS",this.NSlightType);
        nbt.putString("WE",this.WElightType);
        nbt.putIntArray("time_sequence",this.timeSequence);
        nbt.putInt("timer",this.timerTraffic);
        nbt.putInt("tod",this.timerOrder);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
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
    public String getTimeLeft(String type) {
        if (type == null || type.length() < 3) {
            return "";
        }
        if (this.timeSequence == null || this.timeSequence.length != 4) {
            return "";
        }
        int group = type.charAt(0) - '0';   // 组别（0~3）
        char mode = type.charAt(2);          // 'R' 或 'G'
        int current = this.timerOrder;
        int next = (current + 1) % 4;
        int skip = (current + 2) % 4;       // 隔一个
        // 如果 timeSequence[next] <= 0，说明该阶段配置为 0 秒（空闲/过渡态），
        // 在 tick() 中会表现为 timerTraffic 立即变负并快速归零到 -80 然后重置。
        // 此时我们应该“隔一个”，即跳过下一个，匹配下下个（skip）。
        boolean isNextInvalid = (this.timeSequence[next] <= 0);
        int target1 = current;
        int target2 = isNextInvalid ? skip : next;
        // 如果 type 的组别不匹配 target1 或 target2，则不显示
        if (group != target1 && group != target2) {
            return "";
        }
        int ticks = this.timerTraffic;
        int seconds = -1;

        if (mode == 'R') { // 剩余时间模式（包含黄灯补偿）
            if (ticks >= 0 && ticks < 160) {
                seconds = ticks / 20 + 5;   // 加 4 秒（黄灯/过渡补偿）
            } else if (ticks < 0) {
                seconds = (ticks + 80) / 20 + 1;
            }
        } else if (mode == 'G') { // 绿灯纯计时模式
            if (ticks >= 0 && ticks < 200) {
                seconds = ticks / 20 + 1;
            }
        }
        if (seconds <= 0) {
            return "";
        }
        return String.format("%02d", seconds);
    }

    private void reset(){
        this.stop();
        this.timerTraffic = -80;
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
            test:
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
        else if(!Objects.equals(entity.NSlightType, "disabled")){
            entity.NSlightType = "disabled";
            entity.WElightType = "disabled";
            entity.markDirty();
            world.updateListeners(entity.pos,world.getBlockState(entity.pos),world.getBlockState(entity.pos),Block.NOTIFY_LISTENERS);
        }
    }
}
