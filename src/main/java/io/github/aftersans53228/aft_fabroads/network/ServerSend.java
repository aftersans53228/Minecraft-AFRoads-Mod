package io.github.aftersans53228.aft_fabroads.network;

import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class ServerSend {
    public static void sendVersionCheck(ServerPlayerEntity player) {
        PacketByteBuf packet = PacketByteBufs.create();
        packet.writeString(AFRoadsStatics.MOD_VERSION);
        ServerPlayNetworking.send(player, new Identifier(AFRoadsStatics.MOD_ID,"version_check"), packet);
    }
}
