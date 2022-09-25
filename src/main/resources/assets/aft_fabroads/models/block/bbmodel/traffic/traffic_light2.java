public VoxelShape makeShape(){
	VoxelShape shape = VoxelShapes.empty();
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.8125, 0.625, 0.6875, 1.1875, 0.6875));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.4375, 0.625, 0.6875, 0.8125, 0.6875));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.125, 0.625, 0.6875, 0.4375, 0.6875));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0, 0.6875, 0.8125, 1.3125, 0.8125));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 1.15625, 0.4375, 0.6875, 1.20625, 0.6875));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.8125, 0.4375, 0.6875, 0.8625, 0.625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.45625, 0.4375, 0.6875, 0.50625, 0.625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.875, 0.61875, 0.625, 1.125, 0.625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.5375, 0.61875, 0.625, 0.7875, 0.625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.1875, 0.61875, 0.625, 0.4375, 0.625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.4375, 0.8125, 0.5625, 0.5625, 1));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.6875, 0.0625, 0.5625, 0.75, 1.1875, 0.6875));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.0625, 0.5625, 0.3125, 1.1875, 0.6875));

	return shape;
}