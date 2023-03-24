package io.github.aftersans53228.aft_fabroads.block.pillarblock;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class VerticalStraightPillarThin extends Block {

    public VerticalStraightPillarThin() {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.2f));
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
            return VoxelShapes.cuboid(0.375, 0f, 0.375, 0.625, 1f, 0.625);
    }
}