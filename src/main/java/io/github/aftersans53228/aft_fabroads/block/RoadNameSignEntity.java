package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class RoadNameSignEntity extends BlockEntity  {

    public RoadNameSignEntity(BlockPos pos, BlockState state){
            super(AFRoads.ROAD_NAME_SIGN_ENTITY, pos, state);
    }

}

