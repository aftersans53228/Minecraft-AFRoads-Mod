package io.github.aftersans53228.aft_fabroads.item;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.command.BlockDataObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.stream.Collectors;


public class RoadToolAttribute extends Item {
    public RoadToolAttribute() {
        super(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1).maxDamage(10));
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        // 默认为白色文本
        tooltip.add( new TranslatableText(" ") );
        tooltip.add( new TranslatableText("item.aft_fabroads.road_tool_a.tip1") );
        tooltip.add( new TranslatableText("item.aft_fabroads.road_tool_a.tip2") );
        tooltip.add( new TranslatableText(" ") );
        tooltip.add( new TranslatableText("item.aft_fabroads.road_tool.tip_all") );
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        final World world = context.getWorld();
        if(!world.isClient()) {
            final BlockPos pos = context.getBlockPos();
            StringBuilder textBuilder = new StringBuilder();

            textBuilder.append(I18n.translate("text.return.aft_fabroads.tool_attribute1"));

            if (!world.getBlockState(pos).getEntries().isEmpty()) {
                textBuilder.append(world.getBlockState(pos).toString());
            }
            else {
                textBuilder.append("None.");
            }

            textBuilder.append(I18n.translate("text.return.aft_fabroads.tool_attribute2"));

            if(world.getBlockEntity(pos) !=null) {
                final BlockDataObject bdo = new BlockDataObject(world.getBlockEntity(pos), pos);
                textBuilder.append(bdo.getNbt().toString());
            }
            else {
                textBuilder.append("None.");
            }

            textBuilder.append(I18n.translate("text.return.aft_fabroads.tool_attribute3"));

            if (context.getPlayer()!=null) {
                context.getPlayer().sendMessage(new LiteralText(textBuilder.toString()), false);
            }
        }
        return ActionResult.SUCCESS;
    }


}
