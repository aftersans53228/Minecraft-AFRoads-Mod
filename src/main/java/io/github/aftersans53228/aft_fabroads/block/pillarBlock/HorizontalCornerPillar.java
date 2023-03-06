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

public class HorizontalCornerPillar extends HorizontalFacingBlock {

    public HorizontalCornerPillar() {
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
            case NORTH -> VoxelShapes.cuboid(0, 0.375, 0.375, 0.625, 0.625, 1.0f);
            case SOUTH -> VoxelShapes.cuboid(0.375, 0.375, 0f, 1f, 0.625, 0.625);
            case EAST -> VoxelShapes.cuboid(0.0f, 0.375, 0f, 0.625, 0.625, 0.625);
            case WEST -> VoxelShapes.cuboid(0.375, 0.375, 0.375, 1.0f, 0.625, 1f);
            default -> VoxelShapes.fullCube();
        };
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
}
