package net.aftersans53228.aft_fabroads.block;

import net.aftersans53228.aft_fabroads.FabroadsMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class ExpresswayRailingsType2 extends HorizontalFacingBlock {
    public static final IntProperty is_Turn = IntProperty.of("is_turn",0,2);
    public ExpresswayRailingsType2() {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        setDefaultState(getStateManager().getDefaultState().with(is_Turn, 0));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
        stateManager.add(is_Turn);
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getMainHandStack().getItem()== FabroadsMod.RoadTool){
            switch (state.get(is_Turn)) {
                case 0 -> world.setBlockState(pos, state.with(is_Turn, 1));
                case 1 -> world.setBlockState(pos, state.with(is_Turn, 2));
                case 2 -> world.setBlockState(pos, state.with(is_Turn, 0));
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
            case SOUTH:
                return VoxelShapes.cuboid(0.125f, 0.0f, 0.0f, 0.875f, 1.5f, 1.0f);
            case EAST:
            case WEST:
                return VoxelShapes.cuboid(0.0f, 0.0f, 0.125f, 1.0f, 1.5f, 0.875f);
            default:
                return VoxelShapes.fullCube();
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.aft_fabroads.railing_tip"));
    }

}
