package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class RoadLightEntity extends BlockEntity {
    public RoadLightEntity(BlockPos pos, BlockState state){
            super(AFRoads.ROAD_LIGHT_ENTITY, pos, state);
    }
}

