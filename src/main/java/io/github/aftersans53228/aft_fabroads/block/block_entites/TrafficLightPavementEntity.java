package io.github.aftersans53228.aft_fabroads.block.block_entites;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightPavement;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;


public class TrafficLightPavementEntity extends BlockEntity {

    public TrafficLightPavementEntity(BlockPos pos, BlockState state) {
        super(AFRoadsBlockRegistry.TRAFFIC_LIGHT_PAVEMENT_ENTITY, pos, state);
    }
    public static void tick(World world, BlockPos pos, BlockState state, Direction dir) {
        world.setBlockState(pos, state.with(TrafficLightPavement.TrafficType, 1));
    }


}
