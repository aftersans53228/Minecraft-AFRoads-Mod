package io.github.aftersans53228.aft_fabroads.network;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ClientSend {
    public static void sendGuiClose(Identifier id, PacketByteBuf buf){
        ClientPlayNetworking.send(id,buf);
    }
}
