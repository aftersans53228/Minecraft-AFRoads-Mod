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

import java.util.ArrayList;
import java.util.List;

public class RoadNameSignEntity extends BlockEntity{
    private String roadName = "未命名";
    private String roadName2rd = "Unnamed";


    public RoadNameSignEntity(BlockPos pos, BlockState state){
            super(AFRoadsBlockRegistry.ROAD_NAME_SIGN_ENTITY, pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.roadName = nbt.getString("road_name");
        this.roadName2rd = nbt.getString("road_name2rd");
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        nbt.putString("road_name",this.roadName);
        nbt.putString("road_name2rd",this.roadName2rd);
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

    public void setRoadNames(String roadName) {
        this.roadName = roadName;
        this.markDirty();
        world.updateListeners(pos, this.getCachedState(), this.getCachedState(), Block.NOTIFY_LISTENERS);
    }
    public void setRoadNames2(String roadName2rd){
        this.roadName2rd = roadName2rd;
        this.markDirty();
        world.updateListeners(pos, this.getCachedState(), this.getCachedState(), Block.NOTIFY_LISTENERS);
    }
    public List<String> getRoadNames(){
        List<String> names= new ArrayList<>();
        names.add(0,this.roadName);
        names.add(1,this.roadName2rd);
        return names;
    }
}

