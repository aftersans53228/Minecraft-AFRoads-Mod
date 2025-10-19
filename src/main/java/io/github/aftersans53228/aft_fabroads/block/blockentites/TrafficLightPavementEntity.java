package io.github.aftersans53228.aft_fabroads.block.blockentites;

import blue.endless.jankson.annotation.Nullable;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;


public class TrafficLightPavementEntity extends BlockEntity{
    private BlockPos boxPos ;

    public TrafficLightPavementEntity(BlockPos pos, BlockState state) {
        super(AFRoadsBlockRegistry.TRAFFIC_LIGHT_PAVEMENT_ENTITY, pos, state);
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        if (nbt.contains("box_x")) {
            this.boxPos = new BlockPos(
                    nbt.getInt("box_x"),
                    nbt.getInt("box_y"),
                    nbt.getInt("box_z")
            );
        }
        super.readNbt(nbt);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        if (boxPos!=null) {
            nbt.putInt("box_x", boxPos.getX());
            nbt.putInt("box_y", boxPos.getY());
            nbt.putInt("box_z", boxPos.getZ());
        }
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

    public void setControlBoxPos(BlockPos pos){
        this.boxPos =pos;
        this.markDirty();
        if (this.world != null) {
            this.world.updateListeners(this.pos,this.world.getBlockState(this.pos),this.world.getBlockState(this.pos),Block.NOTIFY_LISTENERS);
        }
    }
    public BlockPos getControlBoxPos(){
        if (this.world != null && this.boxPos !=null &&this.world.getBlockState(boxPos)!=null && ! this.world.getBlockState(boxPos).getBlock().equals(AFRoadsBlockRegistry.TrafficLightsControlBox)) {
            this.boxPos = null;
        }
        return this.boxPos;
    }

}
