package net.aftersans53228.aft_fabroads.block.VOXEL;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class SignSouth {
	public static VoxelShape getShape() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.91875, 0.599456183689829, 1, 0.9375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.91875, 0.599456183689829, 1, 0.9375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.91875, 0.599456183689829, 1, 0.9375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.91875, 0.599456183689829, 1, 0.9375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.91875, 0.599456183689829, 1, 0.9375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.400543816310171, 0.91875, 1, 0.599456183689829, 0.9375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.400543816310171, 0.91875, 1, 0.599456183689829, 0.9375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.400543816310171, 0.91875, 1, 0.599456183689829, 0.9375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.25, 0.9186875, 0.75, 0.75, 0.9186875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.9375, 0.599456183689829, 1, 0.95));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.9375, 0.599456183689829, 1, 0.95));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.9375, 0.599456183689829, 1, 0.95));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.9375, 0.599456183689829, 1, 0.95));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.9375, 0.599456183689829, 1, 0.95));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.400543816310171, 0.9375, 1, 0.599456183689829, 0.95));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.400543816310171, 0.9375, 1, 0.599456183689829, 0.95));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.400543816310171, 0.9375, 1, 0.599456183689829, 0.95));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.4375, 0.9375, 0.5625, 0.5625, 1));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0, 0.91875, 1, 1, 0.95));

		return shape;
	}
}