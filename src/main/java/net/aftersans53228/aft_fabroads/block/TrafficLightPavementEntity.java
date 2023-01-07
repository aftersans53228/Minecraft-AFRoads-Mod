package net.aftersans53228.aft_fabroads.block;

import net.aftersans53228.aft_fabroads.FabroadsMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;


public class TrafficLightPavementEntity extends BlockEntity {


    public TrafficLightPavementEntity(BlockPos pos, BlockState state) {
        super(FabroadsMod.TRAFFIC_LIGHT_PAVEMENT_ENTITY, pos, state);
    }
    public static <TrafficLightPavementEntity> void tick(World world, BlockPos pos, BlockState state, TrafficLightPavementEntity be ,Direction dir) {
        int timer =  FabroadsMod.traffic_lights_timer;
        switch(dir) {
            case SOUTH:
            case NORTH:
                if (timer > 0 & timer < 40) {
                world.setBlockState(pos, state.with(TrafficLightPavement.TrafficType, 1));
                break;
                }
                if (timer > 40 & timer <= 620) {
                world.setBlockState(pos, state.with(TrafficLightPavement.TrafficType, 0));
                break;
                }
                if (timer > 620) {
                world.setBlockState(pos, state.with(TrafficLightPavement.TrafficType, 2));
                break;
                }
            case EAST:
            case WEST:

                if (timer > 40 & timer < 580) {
                    world.setBlockState(pos, state.with(TrafficLightPavement.TrafficType, 2));
                    break;
                }
                if (timer >= 580 & timer <= 620) {
                    world.setBlockState(pos, state.with(TrafficLightPavement.TrafficType, 1));
                    break;
                }
                if (timer > 620) {
                    world.setBlockState(pos, state.with(TrafficLightPavement.TrafficType, 0));
                    break;
                }




        }
    }


}
