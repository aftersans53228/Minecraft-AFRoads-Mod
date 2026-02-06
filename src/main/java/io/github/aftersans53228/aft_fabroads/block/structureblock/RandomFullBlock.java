package io.github.aftersans53228.aft_fabroads.block.structureblock;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.world.BlockView;

import java.util.List;

public class RandomFullBlock extends HorizontalFacingBlock {
    private String type = "";
    public RandomFullBlock(String type) {
        super(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).hardness(1.8f).nonOpaque());
        this.type = type;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        switch (this.type) {
            case "road_block" -> tooltip.add(Text.translatable("item.aft_fabroads.road_block"));
            case "todo" -> tooltip.add(Text.translatable(" "));
            default -> tooltip.add(Text.translatable(""));
        }
    }


}
