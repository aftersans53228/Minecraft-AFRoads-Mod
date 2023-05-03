package io.github.aftersans53228.aft_fabroads.block.pillarblock;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.List;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry.*;
import static io.github.aftersans53228.aft_fabroads.AFRoadsStatics.*;

public class SmartPillar extends ConnectingBlock {
    public SmartPillar() {
        super(0.125f, FabricBlockSettings.of(Material.STONE).hardness(1.5f) );
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
                .with(DOWN, blockState.isOf(this) || blockState.isOf(SmartPillarThin) || isStateInList(blockState,PILLAR_BLOCKS)|| isStateInList(blockState,CAN_PILLAR_CONNECT)||blockState.isFullCube(world,pos.down()))
                .with(UP, blockState2.isOf(this) || blockState2.isOf(SmartPillarThin)|| isStateInList(blockState2,PILLAR_BLOCKS)|| isStateInList(blockState2,CAN_PILLAR_CONNECT))
                .with(NORTH, blockState3.isOf(this) || blockState3.isOf(SmartPillarThin)|| isStateInList(blockState3,PILLAR_BLOCKS)|| isStateInList(blockState3,CAN_PILLAR_CONNECT))
                .with(EAST, blockState4.isOf(this) || blockState4.isOf(SmartPillarThin)|| isStateInList(blockState4,PILLAR_BLOCKS)|| isStateInList(blockState4,CAN_PILLAR_CONNECT))
                .with(SOUTH, blockState5.isOf(this) || blockState5.isOf(SmartPillarThin)|| isStateInList(blockState5,PILLAR_BLOCKS)|| isStateInList(blockState5,CAN_PILLAR_CONNECT))
                .with(WEST, blockState6.isOf(this) || blockState6.isOf(SmartPillarThin)|| isStateInList(blockState6,PILLAR_BLOCKS)|| isStateInList(blockState6,CAN_PILLAR_CONNECT));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        boolean bl =
                neighborState.isOf(this) ||
                neighborState.isOf(SmartPillarThin) ||
                isStateInList(neighborState,PILLAR_BLOCKS)||
                isStateInList(neighborState,CAN_PILLAR_CONNECT)
                ;
        return state.with(FACING_PROPERTIES.get(direction), bl);
    }

    public boolean isStateInList(BlockState state, List<Block> list){
        for(Block block :list){
            if (state.isOf(block)){
                return true;
            }
        }
        return false;
    }
    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( new TranslatableText("item.aft_fabroads.smart_pillar") );
    }
}
