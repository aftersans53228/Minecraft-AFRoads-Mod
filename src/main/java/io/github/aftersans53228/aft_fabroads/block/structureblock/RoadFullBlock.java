package io.github.aftersans53228.aft_fabroads.block.structureblock;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

import java.util.List;
import java.util.Random;

public class RoadFullBlock extends HorizontalFacingBlock {
    private String type = "";
    public RoadFullBlock(String type) {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        this.type = type;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        switch (this.type) {
            case "road_manhole_cover" -> tooltip.add(new TranslatableText("item.aft_fabroads.manhole"));
            case "road_seam" -> tooltip.add(new TranslatableText("item.aft_fabroads.road_seams"));
            default -> tooltip.add(new LiteralText(""));
        }
    }


}
