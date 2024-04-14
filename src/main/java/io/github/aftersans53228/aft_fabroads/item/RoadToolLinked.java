package io.github.aftersans53228.aft_fabroads.item;

import io.github.aftersans53228.aft_fabroads.block.TrafficLightEntity;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightsControlBox;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
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

import java.util.ArrayList;
import java.util.List;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry.*;

public class RoadToolLinked extends Item {
    private BlockPos boxPos = null;
    private List<Block> canLinkBlock = new ArrayList<>();
    public RoadToolLinked() {
        super(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1).maxDamage(10));
        this.canLinkBlock.add(TrafficLightsControlBox);
        this.canLinkBlock.add(TrafficLight);
        this.canLinkBlock.add(TrafficLightPavement);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // 默认为白色文本
        tooltip.add( new TranslatableText(" ") );
        tooltip.add( new TranslatableText("item.aft_fabroads.road_tool_l.tip1") );
        tooltip.add( new TranslatableText("item.aft_fabroads.road_tool_l.tip2") );
        tooltip.add( new TranslatableText(" ") );
        tooltip.add( new TranslatableText("item.aft_fabroads.road_tool.tip_all") );
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(this.canLinkBlock.contains(context.getWorld().getBlockState(context.getBlockPos()).getBlock()) && context.getWorld().getBlockEntity(context.getBlockPos()) !=null) {
            if (!context.getWorld().isClient()&& context.getWorld().getBlockEntity(context.getBlockPos()).getType().equals(AFRoadsBlockRegistry.TRAFFIC_LIGHTS_CONTROL_ENTITY)) {
                if (this.boxPos == null) {
                    this.boxPos = context.getBlockPos();
                    context.getPlayer().sendMessage(new LiteralText("Select the CONTROL BOX."), true);
                } else {
                    context.getPlayer().sendMessage(new LiteralText("Can't set CONTROL BOX as another."), true);
                }
                return ActionResult.SUCCESS;
            }
            if (!context.getWorld().isClient()&& context.getWorld().getBlockEntity(context.getBlockPos()).getType().equals(AFRoadsBlockRegistry.TRAFFIC_LIGHT_ENTITY)) {
                if (this.boxPos != null) {
                    TrafficLightEntity entity = (TrafficLightEntity) context.getWorld().getBlockEntity(context.getBlockPos());
                    entity.setControlBoxPos(this.boxPos);
                    context.getPlayer().sendMessage(new LiteralText("Set Traffic Light the CONTROL BOX."), true);
                    this.boxPos=null;
                } else {
                    context.getPlayer().sendMessage(new LiteralText("Traffic Lights aren't the linking starting."), true);
                }
                return ActionResult.SUCCESS;
            }
        }
        else{
            context.getPlayer().sendMessage(new LiteralText("This block can't be linked."), true);
        }
        return ActionResult.PASS;
    }

}
