package net.aftersans53228.aft_fabroads.block.arrowblock;

import net.aftersans53228.aft_fabroads.FabroadsMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
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


public class ArrowBackLeft extends HorizontalFacingBlock {
    public static final BooleanProperty is_Mini = BooleanProperty.of("is_mini");
    public ArrowBackLeft() {
        super(FabricBlockSettings.of(Material.STONE).hardness(0.1f).nonOpaque());
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        setDefaultState(getStateManager().getDefaultState().with(is_Mini, false));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState>stateManager) {
        stateManager.add(is_Mini);
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getMainHandStack().getItem()== FabroadsMod.RoadTool){
            if (state.get(is_Mini)) world.setBlockState(pos, state.with(is_Mini, false));
            else world.setBlockState(pos, state.with(is_Mini, true));
        }
        return ActionResult.SUCCESS;
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        if (state.get(is_Mini)) return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1f, 0.00500f, 1.0f);
        else return VoxelShapes.cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 0.00500f, 2.0f);
    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("item.aft_fabroads.arrow_tip"));
    }

}
