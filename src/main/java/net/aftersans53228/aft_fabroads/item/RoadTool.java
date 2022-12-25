package net.aftersans53228.aft_fabroads.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class RoadTool extends Item {
    public RoadTool() {
        super(new FabricItemSettings().maxCount(1));
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // 默认为白色文本
        tooltip.add(Text.translatable(" ") );
        tooltip.add(Text.translatable("item.aft_fabroads.road_tool.tip1") );
        tooltip.add(Text.translatable("item.aft_fabroads.road_tool.tip2") );
        tooltip.add(Text.translatable("item.aft_fabroads.road_tool.tip3") );
        tooltip.add(Text.translatable(" ") );
        tooltip.add(Text.translatable("item.aft_fabroads.road_tool.tip4") );
    }
}
