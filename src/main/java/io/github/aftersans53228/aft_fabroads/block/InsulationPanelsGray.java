package io.github.aftersans53228.aft_fabroads.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.ArrayList;
import java.util.List;

public class InsulationPanelsGray extends HorizontalFacingBlock {
    public List<VoxelShape> railingShapes = new ArrayList<>();
    private boolean tipsMode = true;
    public InsulationPanelsGray() {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f).nonOpaque());
        this.railingShapes.add(VoxelShapes.empty());
        this.railingShapes.add(VoxelShapes.empty());
        this.railingShapes.add(VoxelShapes.empty());
        this.railingShapes.add(VoxelShapes.empty());

        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        return switch (dir) {
            case NORTH ->this.railingShapes.get(0);
            case SOUTH-> this.railingShapes.get(1);
            case EAST ->this.railingShapes.get(2);
            case WEST->this.railingShapes.get(3);
            default -> VoxelShapes.fullCube();
        };
    }
    public InsulationPanelsGray setVoxelShapes(List<VoxelShape> shapes){
        this.railingShapes.set(0, shapes.get(0));
        this.railingShapes.set(1, shapes.get(1));
        this.railingShapes.set(2, shapes.get(2));
        this.railingShapes.set(3, shapes.get(3));
        return this;
    }
    public InsulationPanelsGray setTipsMode(boolean mode){
        this.tipsMode = mode;
        return  this;
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        if (this.tipsMode){
            tooltip.add(new TranslatableText("item.aft_fabroads.insulation_gray_tip"));
        }
    }
}
