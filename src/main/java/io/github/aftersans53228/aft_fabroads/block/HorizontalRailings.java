package io.github.aftersans53228.aft_fabroads.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
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

import java.util.ArrayList;
import java.util.List;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadTool;

public class HorizontalRailings extends HorizontalFacingBlock {
    public static final IntProperty is_Turn = IntProperty.of("is_turn",0,2);
    public List<VoxelShape> railingShapes = new ArrayList<>();
    public HorizontalRailings() {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
        this.railingShapes.add(0,VoxelShapes.empty());
        this.railingShapes.add(1,VoxelShapes.empty());
        this.railingShapes.add(2,VoxelShapes.empty());
        this.railingShapes.add(3,VoxelShapes.empty());
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        setDefaultState(getStateManager().getDefaultState().with(is_Turn, 0));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
        stateManager.add(is_Turn);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getMainHandStack().getItem()== RoadTool){
            switch (state.get(is_Turn)) {
                case 0 -> world.setBlockState(pos, state.with(is_Turn, 1));
                case 1 -> world.setBlockState(pos, state.with(is_Turn, 2));
                case 2 -> world.setBlockState(pos, state.with(is_Turn, 0));
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        return switch (dir) {
            case NORTH ,SOUTH-> this.railingShapes.get(0);
            case EAST ,WEST->this.railingShapes.get(1);
            default -> VoxelShapes.fullCube();
        };
    }

    public HorizontalRailings setVoxelShapes(List<VoxelShape> shapes){
        this.railingShapes.set(0, shapes.get(0));
        this.railingShapes.set(1, shapes.get(1));
        return this;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("item.aft_fabroads.railing_tip"));
    }

}



