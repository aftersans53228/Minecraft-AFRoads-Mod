package net.aftersans53228.aft_fabroads.block;

import net.aftersans53228.aft_fabroads.FabroadsMod;
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
import net.minecraft.text.TranslatableText;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public  class TrafficLight extends BlockWithEntity implements BlockEntityProvider {
    public static final IntProperty TrafficType = IntProperty.of("type",0,2);
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;


    public TrafficLight(){
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f).nonOpaque());
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
        switch(dir) {
            case NORTH:
                return VoxelShapes.cuboid(0.1875, 0.0f, 0, 0.8125, 1.3215, 0.5625);
            case SOUTH:
                return VoxelShapes.cuboid(0.1875, 0.0f, 0.5625, 0.8125, 1.3215, 1.0f);
            case EAST:
                return VoxelShapes.cuboid(0.4375, 0.0f, 0.1875, 1.0f, 1.3215, 0.8125);
            case WEST:
                return VoxelShapes.cuboid(0.0f, 0.0f, 0.1875, 0.4375, 1.3215f, 0.8125);
            default:
                return VoxelShapes.fullCube();
        }
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
        tooltip.add(new TranslatableText("item.aft_fabroads.traffic_light_tip"));
    }



    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TrafficLightEntity(pos, state);
    }
    public BlockRenderType getRenderType(BlockState state) {
        // 由于继承了BlockWithEntity，这个默认为INVISIBLE，所以我们需要更改它！
        return BlockRenderType.MODEL;
    }
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, FabroadsMod.TRAFFIC_LIGHT_ENTITY, (world1, pos, state1, be) -> TrafficLightEntity.tick(world1, pos, state1, be,state.get(FACING)));
    }
}
