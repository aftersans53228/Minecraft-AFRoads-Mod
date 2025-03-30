package io.github.aftersans53228.aft_fabroads.block.voxelshapes;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class PBase {
	public static VoxelShape getShape() {
		VoxelShape shape = VoxelShapes.empty();

		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.0625, 0.375, 0.625, 1, 0.625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.34375, 0.0625, 0.34375, 0.65625, 0.5625, 0.65625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4875, 0.0625, 0.25, 0.5125, 0.5, 0.75));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.39375, 0.0625, 0.25, 0.41875, 0.5, 0.75));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.0625, 0.4875, 0.75, 0.5, 0.5125));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.0625, 0.58125, 0.75, 0.5, 0.60625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.0625, 0.39375, 0.75, 0.5, 0.41875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.58125, 0.0625, 0.25, 0.60625, 0.5, 0.75));

		return shape;
	}
}