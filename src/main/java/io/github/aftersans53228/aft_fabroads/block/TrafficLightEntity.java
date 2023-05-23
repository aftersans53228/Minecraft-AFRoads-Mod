package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;


public class TrafficLightEntity  extends BlockEntity {

    public TrafficLightEntity(BlockPos pos, BlockState state) {
        super(AFRoadsBlockRegistry.TRAFFIC_LIGHT_ENTITY, pos, state);
    }
    public static void tick(World world, BlockPos pos, BlockState state, Direction dir) {
        int timer =  AFRoads.traffic_lights_timer;
        switch(dir) {
            case SOUTH:
            case NORTH:
                if (timer > 0 & timer < 40) {
                    world.setBlockState(pos, state.with(TrafficLight.TrafficType, 1));
                    break;
                }
                if (timer > 40 & timer <= 620) {
                    world.setBlockState(pos, state.with(TrafficLight.TrafficType, 0));
                    break;
                }
                if (timer > 620) {
                    world.setBlockState(pos, state.with(TrafficLight.TrafficType, 2));
                    break;
                }
            case EAST:
            case WEST:
                if (timer > 40 & timer < 580) {
                    world.setBlockState(pos, state.with(TrafficLight.TrafficType, 2));
                    break;
                }
                if (timer >= 580 & timer <= 620) {
                    world.setBlockState(pos, state.with(TrafficLight.TrafficType, 1));
                    break;
                }
                if (timer > 620) {
                    world.setBlockState(pos, state.with(TrafficLight.TrafficType, 0));
                    break;
                }
        }
    }

}
