package io.github.aftersans53228.aft_fabroads.block.pillarBlock;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class VerticalStraightPillar extends Block {

    public VerticalStraightPillar() {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
      }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
            return VoxelShapes.cuboid(0.375, 0f, 0.375, 0.625, 1f, 0.625);
    }
}