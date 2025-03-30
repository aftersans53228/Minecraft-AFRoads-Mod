package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.block.blockentites.TrafficLightLeftTurnEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public  class TrafficLightLeftTurn extends TrafficLight {
    public TrafficLightLeftTurn(){
        super();
    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TrafficLightLeftTurnEntity(pos, state);
    }
}
