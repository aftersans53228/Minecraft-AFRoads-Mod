package io.github.aftersans53228.aft_fabroads.block.block_entites;

import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

public class RoadNameSignEntity extends BlockEntity  implements BlockEntityClientSerializable {
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
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.putString("road_name",this.roadName);
        nbt.putString("road_name2rd",this.roadName2rd);
        return super.writeNbt(nbt);
    }

    @Override
    public void fromClientTag(NbtCompound tag) {
        this.readNbt(tag);
        this.roadName = tag.getString("road_name");
        this.roadName2rd = tag.getString("road_name2rd");
    }

    @Override
    public NbtCompound toClientTag(NbtCompound tag) {
        return this.writeNbt(tag);
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

