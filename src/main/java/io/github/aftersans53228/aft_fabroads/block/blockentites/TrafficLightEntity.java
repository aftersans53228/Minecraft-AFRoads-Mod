package io.github.aftersans53228.aft_fabroads.block.blockentites;

import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;


public class TrafficLightEntity  extends BlockEntity implements BlockEntityClientSerializable {
    private BlockPos boxPos ;

    public TrafficLightEntity(BlockPos pos, BlockState state) {
        super(AFRoadsBlockRegistry.TRAFFIC_LIGHT_ENTITY, pos, state);
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
    public NbtCompound writeNbt(NbtCompound nbt) {
        if (boxPos!=null) {
            nbt.putInt("box_x", boxPos.getX());
            nbt.putInt("box_y", boxPos.getY());
            nbt.putInt("box_z", boxPos.getZ());
        }
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
