package io.github.aftersans53228.aft_fabroads.block.voxelshapes;

import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class PillarShapes {

	// ===== PillarBase =====
	public static VoxelShape getBaseShape() {
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

	// ===== TrafficLightPavement (Ptl) =====
	public static VoxelShape getPtlShape(Direction dir) {
		switch (dir) {
			case NORTH: return getPtlNorthShape();
			case SOUTH: return getPtlSouthShape();
			case EAST: return getPtlEastShape();
			case WEST: return getPtlWestShape();
			default: return VoxelShapes.fullCube();
		}
	}

	private static VoxelShape getPtlNorthShape() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.875, 0.3125, 0.6875, 0.9375, 0.375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.5, 0.3125, 0.6875, 0.875, 0.375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.1875, 0.3125, 0.6875, 0.5, 0.375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.0625, 0.1875, 0.8125, 1, 0.3125));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.9, 0.375, 0.6875, 0.93125, 0.5625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.5499999999999999, 0.375, 0.6875, 0.5812499999999999, 0.5625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.6124999999999999, 0.375, 0.625, 0.8624999999999999, 0.40625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.23125, 0.375, 0.625, 0.48125, 0.40625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.4375, 0, 0.5625, 0.5625, 0.1875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.125, 0.3125, 0.3125, 0.9375, 0.4375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.6875, 0.125, 0.3125, 0.75, 0.9375, 0.4375));
		return shape;
	}

	private static VoxelShape getPtlSouthShape() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.875, 0.625, 0.6875, 0.9375, 0.6875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.5, 0.625, 0.6875, 0.875, 0.6875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.1875, 0.625, 0.6875, 0.5, 0.6875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.0625, 0.6875, 0.8125, 1, 0.8125));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.9, 0.4375, 0.6875, 0.93125, 0.625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.5499999999999999, 0.4375, 0.6875, 0.5812499999999999, 0.625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.6124999999999999, 0.59375, 0.625, 0.8624999999999999, 0.625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.23125, 0.59375, 0.625, 0.48125, 0.625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.4375, 0.8125, 0.5625, 0.5625, 1));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.6875, 0.125, 0.5625, 0.75, 0.9375, 0.6875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.125, 0.5625, 0.3125, 0.9375, 0.6875));
		return shape;
	}

	private static VoxelShape getPtlEastShape() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.625, 0.875, 0.3125, 0.6875, 0.9375, 0.6875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.625, 0.5, 0.3125, 0.6875, 0.875, 0.6875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.625, 0.1875, 0.3125, 0.6875, 0.5, 0.6875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.6875, 0.0625, 0.1875, 0.8125, 1, 0.8125));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.9, 0.3125, 0.625, 0.93125, 0.6875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.5499999999999999, 0.3125, 0.625, 0.5812499999999999, 0.6875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.59375, 0.6124999999999999, 0.375, 0.625, 0.8624999999999999, 0.625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.59375, 0.23125, 0.375, 0.625, 0.48125, 0.625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.8125, 0.4375, 0.4375, 1, 0.5625, 0.5625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5625, 0.125, 0.25, 0.6875, 0.9375, 0.3125));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5625, 0.125, 0.6875, 0.6875, 0.9375, 0.75));
		return shape;
	}

	private static VoxelShape getPtlWestShape() {
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

	// ===== HorizontalCornerPillar =====
	public static VoxelShape getHorizontalCornerShape(Direction dir) {
		return switch (dir) {
			case NORTH -> VoxelShapes.cuboid(0, 0.375, 0.375, 0.625, 0.625, 1.0f);
			case SOUTH -> VoxelShapes.cuboid(0.375, 0.375, 0f, 1f, 0.625, 0.625);
			case EAST -> VoxelShapes.cuboid(0.0f, 0.375, 0f, 0.625, 0.625, 0.625);
			case WEST -> VoxelShapes.cuboid(0.375, 0.375, 0.375, 1.0f, 0.625, 1f);
			default -> VoxelShapes.fullCube();
		};
	}

	// ===== HorizontalStraightPillar =====
	public static VoxelShape getHorizontalStraightShape(Direction dir) {
		return switch (dir) {
			case NORTH, SOUTH -> VoxelShapes.cuboid(0.375, 0.375, 0.0f, 0.625, 0.625, 1.0f);
			case EAST, WEST -> VoxelShapes.cuboid(0.0f, 0.375, 0.375, 1.0f, 0.625, 0.625);
			default -> VoxelShapes.fullCube();
		};
	}

	// ===== HorizontalStraightPillarThin (same as HorizontalStraightPillar) =====
	public static VoxelShape getHorizontalStraightThinShape(Direction dir) {
		return getHorizontalStraightShape(dir);
	}

	// ===== HorizontalTshapedPillar =====
	public static VoxelShape getHorizontalTShape(Direction dir) {
		return switch (dir) {
			case NORTH -> VoxelShapes.cuboid(0f, 0.375, 0.375, 1f, 0.625, 1.0f);
			case SOUTH -> VoxelShapes.cuboid(0f, 0.375, 0f, 1f, 0.625, 0.625);
			case WEST -> VoxelShapes.cuboid(0.375, 0.375, 0f, 1f, 0.625, 1f);
			case EAST -> VoxelShapes.cuboid(0f, 0.375, 0f, 0.625, 0.625, 1f);
			default -> VoxelShapes.fullCube();
		};
	}

	// ===== VerticalCornerPillar =====
	public static VoxelShape getVerticalCornerShape(Direction dir) {
		return switch (dir) {
			case NORTH -> VoxelShapes.cuboid(0.375, 0f, 0, 0.625, 0.625, 0.625);
			case SOUTH -> VoxelShapes.cuboid(0.375, 0f, 0.375, 0.625, 0.625, 1f);
			case EAST -> VoxelShapes.cuboid(0.375, 0f, 0.375, 1.0f, 0.625, 0.625);
			case WEST -> VoxelShapes.cuboid(0.0f, 0f, 0.375, 0.625, 0.625, 0.625);
			default -> VoxelShapes.fullCube();
		};
	}

	// ===== VerticalCornerPillarThin (same as VerticalCornerPillar) =====
	public static VoxelShape getVerticalCornerThinShape(Direction dir) {
		return getVerticalCornerShape(dir);
	}

	// ===== VerticalStraightPillar =====
	public static VoxelShape getVerticalStraightShape() {
		return VoxelShapes.cuboid(0.375, 0f, 0.375, 0.625, 1f, 0.625);
	}

	// ===== VerticalStraightPillarThin (same as VerticalStraightPillar) =====
	public static VoxelShape getVerticalStraightThinShape() {
		return getVerticalStraightShape();
	}

	// ===== VerticalTshapedPillar =====
	public static VoxelShape getVerticalTShape(Direction dir) {
		return switch (dir) {
			case NORTH, SOUTH -> VoxelShapes.cuboid(0, 0f, 0.375, 1f, 0.625, 0.625);
			case EAST, WEST -> VoxelShapes.cuboid(0.375, 0f, 0f, 0.625, 0.625, 1f);
			default -> VoxelShapes.fullCube();
		};
	}

	// ===== VerticalTshapedPillarType2 =====
	public static VoxelShape getVerticalTType2Shape(Direction dir) {
		return switch (dir) {
			case SOUTH -> VoxelShapes.cuboid(0.375, 0f, 0, 0.625, 1, 0.625);
			case NORTH -> VoxelShapes.cuboid(0.375, 0f, 0.375, 0.625, 1, 1f);
			case WEST -> VoxelShapes.cuboid(0.375, 0f, 0.375, 1.0f, 1, 0.625);
			case EAST -> VoxelShapes.cuboid(0.0f, 0f, 0.375, 0.625, 1, 0.625);
			default -> VoxelShapes.fullCube();
		};
	}

	// ===== RoadMastPillar =====
	public static VoxelShape getRoadMastShape(Direction dir) {
		return switch (dir) {
			case NORTH, SOUTH -> VoxelShapes.cuboid(0, 0f, 0.375, 1f, 1f, 0.625);
			case EAST, WEST -> VoxelShapes.cuboid(0.375, 0f, 0f, 0.625, 1f, 1f);
			default -> VoxelShapes.fullCube();
		};
	}

	// ===== RoadMastPillarBase =====
	public static VoxelShape getRoadMastBaseShape(Direction dir) {
		return switch (dir) {
			case SOUTH -> VoxelShapes.cuboid(0.375, 0f, 0, 0.625, 1, 0.625);
			case NORTH -> VoxelShapes.cuboid(0.375, 0f, 0.375, 0.625, 1, 1f);
			case WEST -> VoxelShapes.cuboid(0.375, 0f, 0.375, 1.0f, 1, 0.625);
			case EAST -> VoxelShapes.cuboid(0.0f, 0f, 0.375, 0.625, 1, 0.625);
			default -> VoxelShapes.fullCube();
		};
	}
}
