package io.github.aftersans53228.aft_fabroads.block.voxelshapes;

import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class SignShapes {

	public static VoxelShape getShape(Direction dir) {
        return switch (dir) {
            case NORTH -> getNorthShape();
            case SOUTH -> getSouthShape();
            case EAST -> getEastShape();
            case WEST -> getWestShape();
            default -> VoxelShapes.fullCube();
        };
	}

	private static VoxelShape getNorthShape() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.0625, 0.599456183689829, 1, 0.08125000000000004));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.0625, 0.599456183689829, 1, 0.08125000000000004));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.0625, 0.599456183689829, 1, 0.08125000000000004));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.0625, 0.599456183689829, 1, 0.08125000000000004));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.0625, 0.599456183689829, 1, 0.08125000000000004));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.400543816310171, 0.0625, 1, 0.599456183689829, 0.08125000000000004));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.400543816310171, 0.0625, 1, 0.599456183689829, 0.08125000000000004));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.400543816310171, 0.0625, 1, 0.599456183689829, 0.08125000000000004));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.25, 0.08131250000000001, 0.75, 0.75, 0.08131250000000001));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.050000000000000044, 0.599456183689829, 1, 0.0625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.050000000000000044, 0.599456183689829, 1, 0.0625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.050000000000000044, 0.599456183689829, 1, 0.0625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.050000000000000044, 0.599456183689829, 1, 0.0625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.400543816310171, 0, 0.050000000000000044, 0.599456183689829, 1, 0.0625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.400543816310171, 0.050000000000000044, 1, 0.599456183689829, 0.0625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.400543816310171, 0.050000000000000044, 1, 0.599456183689829, 0.0625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.400543816310171, 0.050000000000000044, 1, 0.599456183689829, 0.0625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.4375, 0, 0.5625, 0.5625, 0.0625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0, 0.050000000000000044, 1, 1, 0.08125000000000004));
		return shape;
	}

	private static VoxelShape getSouthShape() {
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

	private static VoxelShape getEastShape() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.91875, 0, 0.400543816310171, 0.9375, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.91875, 0, 0.400543816310171, 0.9375, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.91875, 0, 0.400543816310171, 0.9375, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.91875, 0, 0.400543816310171, 0.9375, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.91875, 0, 0.400543816310171, 0.9375, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.91875, 0.400543816310171, 0, 0.9375, 0.599456183689829, 1));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.91875, 0.400543816310171, 0, 0.9375, 0.599456183689829, 1));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.91875, 0.400543816310171, 0, 0.9375, 0.599456183689829, 1));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9186875, 0.25, 0.25, 0.9186875, 0.75, 0.75));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9375, 0, 0.400543816310171, 0.95, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9375, 0, 0.400543816310171, 0.95, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9375, 0, 0.400543816310171, 0.95, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9375, 0, 0.400543816310171, 0.95, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9375, 0, 0.400543816310171, 0.95, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9375, 0.400543816310171, 0, 0.95, 0.599456183689829, 1));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9375, 0.400543816310171, 0, 0.95, 0.599456183689829, 1));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9375, 0.400543816310171, 0, 0.95, 0.599456183689829, 1));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9375, 0.4375, 0.4375, 1, 0.5625, 0.5625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.91875, 0, 0, 0.95, 1, 1));
		return shape;
	}

	private static VoxelShape getWestShape() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0, 0.400543816310171, 0.08125000000000004, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0, 0.400543816310171, 0.08125000000000004, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0, 0.400543816310171, 0.08125000000000004, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0, 0.400543816310171, 0.08125000000000004, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0, 0.400543816310171, 0.08125000000000004, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.400543816310171, 0, 0.08125000000000004, 0.599456183689829, 1));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.400543816310171, 0, 0.08125000000000004, 0.599456183689829, 1));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.400543816310171, 0, 0.08125000000000004, 0.599456183689829, 1));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.08131250000000001, 0.25, 0.25, 0.08131250000000001, 0.75, 0.75));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.050000000000000044, 0, 0.400543816310171, 0.0625, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.050000000000000044, 0, 0.400543816310171, 0.0625, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.050000000000000044, 0, 0.400543816310171, 0.0625, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.050000000000000044, 0, 0.400543816310171, 0.0625, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.050000000000000044, 0, 0.400543816310171, 0.0625, 1, 0.599456183689829));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.050000000000000044, 0.400543816310171, 0, 0.0625, 0.599456183689829, 1));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.050000000000000044, 0.400543816310171, 0, 0.0625, 0.599456183689829, 1));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.050000000000000044, 0.400543816310171, 0, 0.0625, 0.599456183689829, 1));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.4375, 0.4375, 0.0625, 0.5625, 0.5625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.050000000000000044, 0, 0, 0.08125000000000004, 1, 1));
		return shape;
	}
}
