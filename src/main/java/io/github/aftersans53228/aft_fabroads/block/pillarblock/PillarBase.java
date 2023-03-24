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

public class PillarBase extends Block {
    public PillarBase() {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.40054375, 0, 0, 0.59945625, 0.0625, 1));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.40054375, 0, 0, 0.59945625, 0.0625, 1));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.40054375, 0, 0, 0.59945625, 0.0625, 1));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.40054375, 0, 0, 0.59945625, 0.0625, 1));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.40054375, 0, 0, 0.59945625, 0.0625, 1));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0, 0.40054375, 1, 0.0625, 0.59945625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0, 0.40054375, 1, 0.0625, 0.59945625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0, 0.40054375, 1, 0.0625, 0.59945625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.450271875, 0.59375, 0.25, 0.549728125, 0.65625, 0.75));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.450271875, 0.59375, 0.25, 0.549728125, 0.65625, 0.75));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.450271875, 0.59375, 0.25, 0.549728125, 0.65625, 0.75));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.450271875, 0.59375, 0.25, 0.549728125, 0.65625, 0.75));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.450271875, 0.59375, 0.25, 0.549728125, 0.65625, 0.75));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.59375, 0.450271875, 0.75, 0.65625, 0.549728125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.59375, 0.450271875, 0.75, 0.65625, 0.549728125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.59375, 0.450271875, 0.75, 0.65625, 0.549728125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.0625, 0.375, 0.625, 1, 0.625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.46875, 0.0625, 0.1875, 0.53125, 0.125, 0.25));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.46875, 0.625, 0.625, 0.53125, 0.6875, 0.6875));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.46875, 0.625, 0.3125, 0.53125, 0.6875, 0.375));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.75, 0.0625, 0.46875, 0.8125, 0.125, 0.53125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.625, 0.625, 0.46875, 0.6875, 0.6875, 0.53125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.625, 0.46875, 0.375, 0.6875, 0.53125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.0625, 0.46875, 0.25, 0.125, 0.53125));

        return shape;
    }
}
