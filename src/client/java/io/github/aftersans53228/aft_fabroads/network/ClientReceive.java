package io.github.aftersans53228.aft_fabroads.network;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import io.github.aftersans53228.aft_fabroads.block.blockentites.RoadNameSignEntity;
import io.github.aftersans53228.aft_fabroads.block.blockentites.TrafficLightsControlEntity;
import io.github.aftersans53228.aft_fabroads.gui.RoadNameSignGui;
import io.github.aftersans53228.aft_fabroads.gui.TrafficControlBoxGui;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

import java.util.List;

@Environment(EnvType.CLIENT)
public class ClientReceive {
    public static void receiveVersionCheck(PacketByteBuf packet) {
        String version = packet.readString();
        MinecraftClient client = MinecraftClient.getInstance();
        client.execute(()->{
            if(!AFRoadsStatics.MOD_VERSION.equals(version)){
                if (client.getNetworkHandler() != null ){
                ClientConnection connection = client.getNetworkHandler().getConnection();
                    connection.disconnect(
                            Text.literal(
                                    I18n.translate("text.gui.aft_fabroads.version_mistake")
                                    + "\n\n"
                                    + I18n.translate("text.gui.aft_fabroads.version_mistake_client")
                                    + "§4" + AFRoadsStatics.MOD_VERSION + "\n"
                                    + I18n.translate("text.gui.aft_fabroads.version_mistake_server")
                                    + "§2" + version + "\n"
                            )
                    );
                }
            }

        });
    }
    public static void receiveRoadNameSignGuiOpen(PacketByteBuf buf) {
        BlockPos pos = buf.readBlockPos();
        MinecraftClient client = MinecraftClient.getInstance();
        client.execute(() -> {
            if (client.world == null) return;
            RoadNameSignEntity entity = (RoadNameSignEntity) client.world.getBlockEntity(pos);
            if (entity == null) {
                AFRoads.LOGGER.warn("RoadNameSignEntity not found at {}", pos);
                return;
            }
            List<String> roadNames = entity.getRoadNames();
            // 打开 GUI（CottonClientScreen 请确保已在 client 源集中）
            client.setScreen(new CottonClientScreen(new RoadNameSignGui(pos, roadNames, client.world)));
            AFRoads.LOGGER.info("Opened Road Name Sign GUI at {}", pos);
        });
    }

    public static void receiveToolCallBlockAttributes(PacketByteBuf buf) {
        String s1 = buf.readString();
        String s2 = buf.readString();
        MinecraftClient client = MinecraftClient.getInstance();
        client.execute(() -> {
            ClientPlayerEntity player = client.player;
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
        });
    }
    public static void receiveTrafficLightsControlBoxGuiOpen(PacketByteBuf buf) {
        BlockPos controlBoxPos = buf.readBlockPos();
        MinecraftClient client = MinecraftClient.getInstance();
        client.execute(() -> {
            TrafficLightsControlEntity entity= null;
            if (client.world != null) {
                entity = (TrafficLightsControlEntity)client.world.getBlockEntity(controlBoxPos);
                client.setScreen(new CottonClientScreen(new TrafficControlBoxGui(controlBoxPos,client.world.getBlockState(controlBoxPos).get(BooleanProperty.of("is_enable")),entity.getTimerData())));
                AFRoads.LOGGER.info("Open the\"Traffic Control Box\"'s gui. ");
            }
        });
    }
}
