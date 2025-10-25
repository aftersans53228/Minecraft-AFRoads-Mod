package io.github.aftersans53228.aft_fabroads.item;

import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightPavement;
import io.github.aftersans53228.aft_fabroads.block.blockentites.TrafficLightEntity;
import io.github.aftersans53228.aft_fabroads.block.blockentites.TrafficLightLeftTurnEntity;
import io.github.aftersans53228.aft_fabroads.block.blockentites.TrafficLightPavementEntity;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry.*;

/**
 * @author aftersans53228
 */
public class RoadToolLinked extends Item {
    private BlockPos boxPos = null;
    public RoadToolLinked() {
        super(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1).maxDamage(10));
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // 默认为白色文本
        tooltip.add( Text.translatable(" ") );
        tooltip.add( Text.translatable("item.aft_fabroads.road_tool_l.tip1") );
        tooltip.add( Text.translatable("item.aft_fabroads.road_tool_l.tip2") );
        tooltip.add( Text.translatable(" ") );
        tooltip.add( Text.translatable("item.aft_fabroads.road_tool.tip_all") );
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(AFRoadsStatics.CAN_LINK_BLOCK_PARENT.contains(context.getWorld().getBlockState(context.getBlockPos()).getBlock()) && context.getWorld().getBlockEntity(context.getBlockPos()) !=null) {
            if (!context.getWorld().isClient() && context.getWorld().getBlockEntity(context.getBlockPos()).getType().equals(AFRoadsBlockRegistry.TRAFFIC_LIGHTS_CONTROL_ENTITY)) {
                if (this.boxPos == null) {
                    this.boxPos = context.getBlockPos();
                    context.getPlayer().sendMessage(Text.translatable("text.gui.aft_fabroads.traffic_link_start"), true);
                } else {
                    context.getPlayer().sendMessage(Text.translatable("text.gui.aft_fabroads.traffic_link_start_wrong"), true);
                }
                return ActionResult.SUCCESS;
            }
        }
        else if(AFRoadsStatics.CAN_LINK_BLOCK_SUB.contains(context.getWorld().getBlockState(context.getBlockPos()).getBlock()) && context.getWorld().getBlockEntity(context.getBlockPos()) !=null) {
            if (!context.getWorld().isClient()) {
                if (this.boxPos != null) {
                    BlockEntity entity0 = context.getWorld().getBlockEntity(context.getBlockPos());
                    if (entity0 instanceof TrafficLightEntity) {
                        ((TrafficLightEntity) entity0).setControlBoxPos(this.boxPos);
                    } else if (entity0 instanceof TrafficLightLeftTurnEntity) {
                        ((TrafficLightLeftTurnEntity) entity0).setControlBoxPos(this.boxPos);
                    } else if (entity0 instanceof TrafficLightPavementEntity) {
                        ((TrafficLightPavementEntity) entity0).setControlBoxPos(this.boxPos);
                    }
                    context.getPlayer().sendMessage(Text.translatable("text.gui.aft_fabroads.traffic_link_end"), true);
                    this.boxPos = null;
                    return ActionResult.SUCCESS;
                } else {
                    context.getPlayer().sendMessage(Text.translatable("text.gui.aft_fabroads.traffic_link_end_wrong"), true);
                    return ActionResult.PASS;
                }
            }
        }
        else {
            context.getPlayer().sendMessage(Text.translatable("text.gui.aft_fabroads.traffic_link_start_wrong"), true);
        }
        return ActionResult.PASS;
    }

}
