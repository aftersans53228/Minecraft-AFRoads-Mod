package io.github.aftersans53228.aft_fabroads.network;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import io.github.aftersans53228.aft_fabroads.block.RoadNameSignEntity;
import io.github.aftersans53228.aft_fabroads.gui.ConfigGui;
import io.github.aftersans53228.aft_fabroads.gui.ConfigScreen;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiCloseNetwork {
    public static void sendGuiClose(Identifier id,PacketByteBuf buf){
        ClientPlayNetworking.send(id,buf);
    }
    public static void receiveGuiCloseRNS(PacketByteBuf buf, ServerPlayerEntity player){
        MinecraftServer server =player.getServer();
        BlockPos signPos =buf.readBlockPos();//坐标
        String roadName = buf.readString();//路名
        String roadName2rd = buf.readString();//路名2
        boolean dirLeft =buf.readBoolean();//左边
        boolean dirRight =buf.readBoolean();//右边
        if (server != null) {
            server.execute(()->{
                if (player.getEntityWorld().getBlockEntity(signPos) != null && player.getEntityWorld().getBlockEntity(signPos).getType() == AFRoads.ROAD_NAME_SIGN_ENTITY) {
                    RoadNameSignEntity blockEntity__ = (RoadNameSignEntity) player.getEntityWorld().getBlockEntity(signPos);
                    World world =player.getEntityWorld();
                    world.setBlockState(signPos,world.getBlockState(signPos).with(BooleanProperty.of("dir_left"), dirLeft));
                    world.setBlockState(signPos,world.getBlockState(signPos).with(BooleanProperty.of("dir_right"), dirRight));
                    blockEntity__.setCachedState(blockEntity__.getCachedState().with(BooleanProperty.of("dir_left"), dirLeft));
                    blockEntity__.setCachedState(blockEntity__.getCachedState().with(BooleanProperty.of("dir_right"), dirRight));
                    if (roadName !=null && roadName2rd !=null){
                        blockEntity__.setRoadNames(roadName,roadName2rd);
                    }
                    else{
                        AFRoads.LOGGER.info("Invalid Road Name");
                    }
                    AFRoads.LOGGER.info("Set Sign Name Sign {"+roadName+"} {"+roadName2rd+ "} " + blockEntity__.getCachedState());
                }
                else if (player.getEntityWorld().getBlockEntity(signPos) == null) {
                    AFRoads.LOGGER.info("Invalid Block Entity");
                }
            });
        }

    }

}
