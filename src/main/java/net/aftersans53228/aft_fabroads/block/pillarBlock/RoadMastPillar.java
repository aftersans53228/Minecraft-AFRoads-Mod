package net.aftersans53228.aft_fabroads.block.pillarBlock;

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

public class RoadMastPillar extends HorizontalFacingBlock {
    public static final BooleanProperty is_Bracket = BooleanProperty.of("is_bracket");
    public RoadMastPillar() {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        setDefaultState(getStateManager().getDefaultState().with(is_Bracket, false));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(is_Bracket);
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getMainHandStack().getItem()== FabroadsMod.RoadTool){
            if (state.get(is_Bracket)) world.setBlockState(pos, state.with(is_Bracket, false));
            else world.setBlockState(pos, state.with(is_Bracket, true));
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        return switch(dir) {
            case NORTH, SOUTH -> VoxelShapes.cuboid(0, 0f, 0.375, 1f, 1f, 0.625);
            case EAST, WEST -> VoxelShapes.cuboid(0.375, 0f, 0f, 0.625, 1f, 1f);
            default -> VoxelShapes.fullCube();
        };
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.aft_fabroads.mast-pillar_tip"));
    }
}