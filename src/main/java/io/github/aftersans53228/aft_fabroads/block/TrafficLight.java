package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.block.blockentites.TrafficLightEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadTool;

public  class TrafficLight extends BlockWithEntity implements BlockEntityProvider {
    public static final BooleanProperty hasTimer = BooleanProperty.of("has_timer");
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;


    public TrafficLight(){
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f).nonOpaque().luminance(3));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        setDefaultState(getStateManager().getDefaultState().with(hasTimer,false));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
        stateManager.add(hasTimer);
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getMainHandStack().getItem()== RoadTool ){
            world.setBlockState(pos, state.with(hasTimer, !state.get(hasTimer)));
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
                VoxelShape shape = VoxelShapes.empty();
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.8125, 0.3125, 0.6875, 1.1875, 0.375));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.4375, 0.3125, 0.6875, 0.8125, 0.375));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.125, 0.3125, 0.6875, 0.4375, 0.375));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.8125, 1.3125, 0.3125));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 1.15625, 0.3125, 0.6875, 1.20625, 0.5625));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.8125, 0.375, 0.6875, 0.8625, 0.5625));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.45625, 0.375, 0.6875, 0.50625, 0.5625));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.875, 0.375, 0.625, 1.125, 0.38125));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.5375, 0.375, 0.625, 0.7875, 0.38125));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.1875, 0.375, 0.625, 0.4375, 0.38125));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.4375, 0, 0.5625, 0.5625, 0.1875));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.0625, 0.3125, 0.3125, 1.1875, 0.4375));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.6875, 0.0625, 0.3125, 0.75, 1.1875, 0.4375));
                return shape;
            case SOUTH:
                shape = VoxelShapes.empty();
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
            case EAST:
                shape = VoxelShapes.empty();
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.625, 0.8125, 0.3125, 0.6875, 1.1875, 0.6875));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.625, 0.4375, 0.3125, 0.6875, 0.8125, 0.6875));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.625, 0.125, 0.3125, 0.6875, 0.4375, 0.6875));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.6875, 0, 0.1875, 0.8125, 1.3125, 0.8125));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 1.15625, 0.3125, 0.6875, 1.20625, 0.6875));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.8125, 0.3125, 0.625, 0.8625, 0.6875));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.45625, 0.3125, 0.625, 0.50625, 0.6875));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.61875, 0.875, 0.375, 0.625, 1.125, 0.625));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.61875, 0.5375, 0.375, 0.625, 0.7875, 0.625));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.61875, 0.1875, 0.375, 0.625, 0.4375, 0.625));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.8125, 0.4375, 0.4375, 1, 0.5625, 0.5625));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5625, 0.0625, 0.25, 0.6875, 1.1875, 0.3125));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5625, 0.0625, 0.6875, 0.6875, 1.1875, 0.75));
                return shape;
            case WEST:
                shape = VoxelShapes.empty();
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.8125, 0.3125, 0.375, 1.1875, 0.6875));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.4375, 0.3125, 0.375, 0.8125, 0.6875));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.125, 0.3125, 0.375, 0.4375, 0.6875));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.3125, 1.3125, 0.8125));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 1.15625, 0.3125, 0.5625, 1.20625, 0.6875));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.8125, 0.3125, 0.5625, 0.8625, 0.6875));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.45625, 0.3125, 0.5625, 0.50625, 0.6875));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.875, 0.375, 0.38125, 1.125, 0.625));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.5375, 0.375, 0.38125, 0.7875, 0.625));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.1875, 0.375, 0.38125, 0.4375, 0.625));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.4375, 0.4375, 0.1875, 0.5625, 0.5625));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.0625, 0.6875, 0.4375, 1.1875, 0.75));
                shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.0625, 0.25, 0.4375, 1.1875, 0.3125));
                return shape;
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
        tooltip.add(Text.translatable("item.aft_fabroads.traffic_light_tip"));
        tooltip.add(Text.translatable("item.aft_fabroads.traffic_light_tip2"));
        tooltip.add(Text.translatable("item.aft_fabroads.traffic_light_tip3"));
    }



    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TrafficLightEntity(pos, state);
    }
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

}
