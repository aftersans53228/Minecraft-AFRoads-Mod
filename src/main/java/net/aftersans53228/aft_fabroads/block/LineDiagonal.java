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


public class LineDiagonal extends HorizontalFacingBlock {
    public static final BooleanProperty is_Yellow = BooleanProperty.of("is_yellow");
    public LineDiagonal() {
        super(FabricBlockSettings.of(Material.STONE).hardness(0.1f).nonOpaque());
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        setDefaultState(getStateManager().getDefaultState().with(is_Yellow,false));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState>stateManager) {
        stateManager.add(is_Yellow);
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getMainHandStack().getItem()== FabroadsMod.RoadTool){
            if (state.get(is_Yellow)) world.setBlockState(pos, state.with(is_Yellow, false));
            else world.setBlockState(pos, state.with(is_Yellow, true));
        }
        return ActionResult.SUCCESS;
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1f, 0.00500f, 1.0f);
    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.aft_fabroads.line_tip"));
    }

}
