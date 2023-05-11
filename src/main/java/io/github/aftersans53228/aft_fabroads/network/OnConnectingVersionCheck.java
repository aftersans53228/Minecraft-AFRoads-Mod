package io.github.aftersans53228.aft_fabroads.network;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class OnConnectingVersionCheck {

    public static void sendVersionCheck(ServerPlayerEntity player) {
        PacketByteBuf packet = PacketByteBufs.create();
        packet.writeString(AFRoadsStatics.MOD_VERSION);
        ServerPlayNetworking.send(player, new Identifier(AFRoadsStatics.MOD_ID,"version_check"), packet);
    }
    public static void receiveVersionCheck(PacketByteBuf packet) {
        String version = packet.readString();
        MinecraftClient client = MinecraftClient.getInstance();
        client.execute(()->{
            if(!AFRoadsStatics.MOD_VERSION.equals(version)){
                ClientConnection connection = client.getNetworkHandler().getConnection();
                if (connection != null ){
                    connection.disconnect(
                            new LiteralText(
                            I18n.translate("text.gui.aft_fabroads.version_mistake")+"\n\n"
                            +I18n.translate("text.gui.aft_fabroads.version_mistake_client")+"§4"+AFRoadsStatics.MOD_VERSION+"\n"
                            +I18n.translate("text.gui.aft_fabroads.version_mistake_server")+"§2"+version+"\n"
                            )
                    );
                }
            }

        });
    }
}