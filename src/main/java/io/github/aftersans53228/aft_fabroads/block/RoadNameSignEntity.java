package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class RoadNameSignEntity extends BlockEntity  {
    public NbtCompound nbt_road_name;
    public String roadName = "未命名";
    public String roadName2rd = "Unnamed";

    public RoadNameSignEntity(BlockPos pos, BlockState state){
            super(AFRoads.ROAD_NAME_SIGN_ENTITY, pos, state);
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        if (this.nbt_road_name != null){
            roadName=nbt_road_name.getString("road_name");
            roadName2rd=nbt_road_name.getString("road_name2rd");
        }
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        this.nbt_road_name =nbt;
        return super.writeNbt(nbt);
    }

    public NbtCompound getNbt_road_name() {
        return nbt_road_name;
    }
}

