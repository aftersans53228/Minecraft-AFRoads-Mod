package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.block.blockentites.TrafficLightPavementEntity;
import io.github.aftersans53228.aft_fabroads.block.voxelshapes.PtlEast;
import io.github.aftersans53228.aft_fabroads.block.voxelshapes.PtlNorth;
import io.github.aftersans53228.aft_fabroads.block.voxelshapes.PtlSouth;
import io.github.aftersans53228.aft_fabroads.block.voxelshapes.PtlWest;

import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;

import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public  class TrafficLightPavement extends BlockWithEntity implements BlockEntityProvider {
    public static final IntProperty TrafficType = IntProperty.of("type",0,2);
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;


    public TrafficLightPavement(){
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f).nonOpaque().luminance(3));
        setDefaultState(getStateManager().getDefaultState().with(TrafficType, 0));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(TrafficType);
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        return switch (dir) {
            case NORTH -> PtlNorth.getShape();
            case SOUTH -> PtlSouth.getShape();
            case EAST -> PtlEast.getShape();
            case WEST -> PtlWest.getShape();
            default -> VoxelShapes.fullCube();
        };
    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate(state.get(FACING)));
    }
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("item.aft_fabroads.traffic_light_tip"));
        tooltip.add(Text.translatable("item.aft_fabroads.traffic_light_tip3"));
    }



    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TrafficLightPavementEntity(pos, state);
    }
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
