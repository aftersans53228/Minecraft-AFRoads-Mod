package io.github.aftersans53228.aft_fabroads.block.structureblock;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.List;

public class RoadFullBlock extends HorizontalFacingBlock {
    private String type = "";
    public RoadFullBlock(String type) {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
        this.type = type;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        switch (this.type) {
            case "road_block" -> tooltip.add(new TranslatableText("item.aft_fabroads.road_block"));
            case "road_manhole_cover" -> tooltip.add(new TranslatableText("item.aft_fabroads.manhole"));
            case "road_seam" -> tooltip.add(new TranslatableText("item.aft_fabroads.road_seams"));
            default -> tooltip.add(new LiteralText(""));
        }
    }


}
