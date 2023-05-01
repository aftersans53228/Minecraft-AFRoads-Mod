package io.github.aftersans53228.aft_fabroads.block.pillarblock;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class SmartPillar extends ConnectingBlock {
    public SmartPillar() {
        super(0.0625f, FabricBlockSettings.of(Material.STONE).hardness(1.5f) );
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(NORTH, false)
                .with(EAST, false)
                .with(SOUTH, false)
                .with(WEST, false)
                .with(UP, false)
                .with(DOWN, false));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.withConnectionProperties(ctx.getWorld(), ctx.getBlockPos());
    }

    public BlockState withConnectionProperties(BlockView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.down());
        BlockState blockState2 = world.getBlockState(pos.up());
        BlockState blockState3 = world.getBlockState(pos.north());
        BlockState blockState4 = world.getBlockState(pos.east());
        BlockState blockState5 = world.getBlockState(pos.south());
        BlockState blockState6 = world.getBlockState(pos.west());
        return this.getDefaultState()
                .with(DOWN, blockState.isOf(this) || blockState.isOf(Blocks.CHORUS_FLOWER) || blockState.isOf(Blocks.END_STONE))
                .with(UP, blockState2.isOf(this) || blockState2.isOf(Blocks.CHORUS_FLOWER))
                .with(NORTH, blockState3.isOf(this) || blockState3.isOf(Blocks.CHORUS_FLOWER))
                .with(EAST, blockState4.isOf(this) || blockState4.isOf(Blocks.CHORUS_FLOWER))
                .with(SOUTH, blockState5.isOf(this) || blockState5.isOf(Blocks.CHORUS_FLOWER))
                .with(WEST, blockState6.isOf(this) || blockState6.isOf(Blocks.CHORUS_FLOWER));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        boolean bl =
                neighborState.isOf(this) ||
                neighborState.isOf(Blocks.CHORUS_FLOWER) ||
                direction == Direction.DOWN && neighborState.isOf(Blocks.END_STONE);
        return state.with(FACING_PROPERTIES.get(direction), bl);
    }
}
