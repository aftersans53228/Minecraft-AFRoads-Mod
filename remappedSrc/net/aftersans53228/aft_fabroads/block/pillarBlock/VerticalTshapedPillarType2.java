package net.aftersans53228.aft_fabroads.block.pillarBlock;

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

public class VerticalTshapedPillarType2 extends HorizontalFacingBlock {

    public VerticalTshapedPillarType2() {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        return switch (dir) {
            case SOUTH -> VoxelShapes.cuboid(0.375, 0f, 0, 0.625, 1, 0.625);
            case NORTH -> VoxelShapes.cuboid(0.375, 0f, 0.375, 0.625, 1, 1f);
            case WEST -> VoxelShapes.cuboid(0.375, 0f, 0.375, 1.0f, 1, 0.625);
            case EAST -> VoxelShapes.cuboid(0.0f, 0f, 0.375, 0.625, 1, 0.625);
            default -> VoxelShapes.fullCube();
        };
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
}