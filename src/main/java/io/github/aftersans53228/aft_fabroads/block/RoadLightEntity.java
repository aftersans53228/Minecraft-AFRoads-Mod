package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class RoadLightEntity extends BlockEntity {
    public RoadLightEntity(BlockPos pos, BlockState state){
            super(AFRoadsBlockRegistry.ROAD_LIGHT_ENTITY, pos, state);
    }
}

