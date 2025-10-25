package io.github.aftersans53228.aft_fabroads.item;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.command.BlockDataObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RoadToolAttribute extends Item {
    public RoadToolAttribute() {
        super(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1).maxDamage(10));
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        // 默认为白色文本
        tooltip.add( Text.translatable(" ") );
        tooltip.add( Text.translatable("item.aft_fabroads.road_tool_a.tip1") );
        tooltip.add( Text.translatable("item.aft_fabroads.road_tool_a.tip2") );
        tooltip.add( Text.translatable(" ") );
        tooltip.add( Text.translatable("item.aft_fabroads.road_tool.tip_all") );
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        final World world = context.getWorld();
        if(!world.isClient()) {
            final BlockPos pos = context.getBlockPos();
            List<String> attributes = new ArrayList<>();
            if (!world.getBlockState(pos).getEntries().isEmpty()) {
               attributes.add(world.getBlockState(pos).toString());
            }
            else {
                attributes.add("None.");
            }

            if(world.getBlockEntity(pos) !=null) {
                final BlockDataObject bdo = new BlockDataObject(world.getBlockEntity(pos), pos);
                attributes.add(bdo.getNbt().toString());
            }
            else {
                attributes.add("None.");
            }
            if (context.getPlayer()!=null) {
                sendAttributeItem((ServerPlayerEntity) context.getPlayer(),attributes);
            }

        }
        return ActionResult.SUCCESS;
    }
    public static void sendAttributeItem(ServerPlayerEntity player,List<String> attributes) {
        PacketByteBuf packet = PacketByteBufs.create();
        for(String o:attributes) {
            packet.writeString(o);
        }
        ServerPlayNetworking.send(player, new Identifier(AFRoadsStatics.MOD_ID,"attributes_item_required"), packet);
    }
    public static void receiveAttributeItem(String s1,String s2, ClientPlayerEntity player) {
        MinecraftClient client = MinecraftClient.getInstance();
        client.execute(()->{
            StringBuilder textBuilder = new StringBuilder();
            textBuilder.append(I18n.translate("text.return.aft_fabroads.tool_attribute1"));
            textBuilder.append(s1);
            textBuilder.append(I18n.translate("text.return.aft_fabroads.tool_attribute2"));
            textBuilder.append(s2);
            textBuilder.append(I18n.translate("text.return.aft_fabroads.tool_attribute3"));
            if (player!=null) {
                player.sendMessage(Text.literal(textBuilder.toString()), false);
            }
        });
    }


}
