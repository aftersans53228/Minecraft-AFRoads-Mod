package io.github.aftersans53228.aft_fabroads.network;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.block.RoadNameSignEntity;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightsControlEntity;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author aftersans53228
 */
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
                if (player.getEntityWorld().getBlockEntity(signPos) != null && player.getEntityWorld().getBlockEntity(signPos).getType() == AFRoadsBlockRegistry.ROAD_NAME_SIGN_ENTITY) {
                    RoadNameSignEntity blockEntity = (RoadNameSignEntity) player.getEntityWorld().getBlockEntity(signPos);
                    World world =player.getEntityWorld();
                    world.setBlockState(signPos,world.getBlockState(signPos).with(BooleanProperty.of("dir_left"), dirLeft));
                    world.setBlockState(signPos,world.getBlockState(signPos).with(BooleanProperty.of("dir_right"), dirRight));
                    blockEntity.setCachedState(blockEntity.getCachedState().with(BooleanProperty.of("dir_left"), dirLeft));
                    blockEntity.setCachedState(blockEntity.getCachedState().with(BooleanProperty.of("dir_right"), dirRight));
                    if (!Objects.equals(roadName, "") &&roadName !=null ){
                        blockEntity.setRoadNames(roadName);
                        AFRoads.LOGGER.info("Set Sign Name Sign {"+roadName+"}  " + blockEntity.getCachedState());
                    }
                    if(!Objects.equals(roadName2rd, "")&& roadName2rd !=null) {
                        blockEntity.setRoadNames2(roadName2rd);
                        AFRoads.LOGGER.info("Set Sign Name Sign {"+roadName2rd+ "} " + blockEntity.getCachedState());
                    }
                }
                else if (player.getEntityWorld().getBlockEntity(signPos) == null) {
                    AFRoads.LOGGER.info("Invalid Block Entity.");
                }
            });
        }

    }
    public static void receiveGuiCloseTrafficLightsControlBox(PacketByteBuf buf, ServerPlayerEntity player){
        MinecraftServer server =player.getServer();
        BlockPos boxPos =buf.readBlockPos();//坐标
        int[] timeData= buf.readIntArray();
        Boolean enabled = buf.readBoolean();
        if (server != null) {
            server.execute(()-> {
                if (player.getEntityWorld().getBlockEntity(boxPos) != null && player.getEntityWorld().getBlockEntity(boxPos).getType() == AFRoadsBlockRegistry.TRAFFIC_LIGHTS_CONTROL_ENTITY) {
                    TrafficLightsControlEntity blockEntity = (TrafficLightsControlEntity) player.getEntityWorld().getBlockEntity(boxPos);
                    World world =player.getEntityWorld();
                    world.setBlockState(boxPos,world.getBlockState(boxPos).with(BooleanProperty.of("is_enable"),enabled));
                    blockEntity.setCachedState(blockEntity.getCachedState().with(BooleanProperty.of("is_enable"),enabled));
                    ArrayList<Integer> timeForward = new ArrayList<>();
                    ArrayList<Integer> timeTurn = new ArrayList<>();
                    timeForward.add(timeData[0]);
                    timeForward.add(timeData[1]);
                    timeTurn.add(timeData[2]);
                    timeTurn.add(timeData[2]);
                    blockEntity.setTimeData(timeForward,timeTurn);
                    AFRoads.LOGGER.info("Set Traffic lights Control Box {"+ Arrays.toString(timeData) + "} ,"+enabled );
                }
                else if (player.getEntityWorld().getBlockEntity(boxPos) == null) {
                    AFRoads.LOGGER.info("Invalid Block Entity.");
                }
            });
        }


    }

}
