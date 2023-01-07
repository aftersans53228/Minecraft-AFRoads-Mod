package net.aftersans53228.aft_fabroads.block.VOXEL;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class PtlWest {
public static VoxelShape getShape() {
	VoxelShape shape = VoxelShapes.empty();
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.875, 0.3125, 0.375, 0.9375, 0.6875));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.5, 0.3125, 0.375, 0.875, 0.6875));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.1875, 0.3125, 0.375, 0.5, 0.6875));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.0625, 0.1875, 0.3125, 1, 0.8125));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.9, 0.3125, 0.5625, 0.93125, 0.6875));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.5499999999999999, 0.3125, 0.5625, 0.5812499999999999, 0.6875));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.6124999999999999, 0.375, 0.40625, 0.8624999999999999, 0.625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.23125, 0.375, 0.40625, 0.48125, 0.625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.4375, 0.4375, 0.1875, 0.5625, 0.5625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.125, 0.6875, 0.4375, 0.9375, 0.75));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.125, 0.25, 0.4375, 0.9375, 0.3125));

	return shape;
}
}