package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class TrafficLightsControlBox extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty isEnable = BooleanProperty.of("is_enable");

    public TrafficLightsControlBox() {
        super(FabricBlockSettings.of(Material.METAL).hardness(1.5f));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        setDefaultState(getStateManager().getDefaultState().with(isEnable,false));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
        stateManager.add(isEnable);
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
            case SOUTH:
                return VoxelShapes.cuboid(0.125, 0, 0.25, 0.875, 1.0625, 0.75);
            case EAST:
            case WEST:
                return VoxelShapes.cuboid(0.25, 0, 0.125, 0.75, 1.0625, 0.875);
            default:
                return VoxelShapes.fullCube();
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate(state.get(FACING)));
    }
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TrafficLightsControlEntity(pos, state);
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
            return world.isClient ? null:checkType(type, AFRoadsBlockRegistry.TRAFFIC_LIGHTS_CONTROL_ENTITY, TrafficLightsControlEntity::tick);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
