package io.github.aftersans53228.aft_fabroads.block.structureblock;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

import java.util.List;
import java.util.Random;

public class RandomFullBlock extends HorizontalFacingBlock {
    private String type = "";
    public RandomFullBlock(String type) {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
        this.type = type;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Random rand = new Random();
        return switch(rand.nextInt(5)){
                case 1-> this.getDefaultState().with(Properties.HORIZONTAL_FACING,Direction.SOUTH);
                case 2-> this.getDefaultState().with(Properties.HORIZONTAL_FACING,Direction.WEST);
                case 3-> this.getDefaultState().with(Properties.HORIZONTAL_FACING,Direction.EAST);
                default -> this.getDefaultState().with(Properties.HORIZONTAL_FACING,Direction.NORTH);
        };
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
