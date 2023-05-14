package io.github.aftersans53228.aft_fabroads;


import io.github.aftersans53228.aft_fabroads.block.RoadLightEntity;
import io.github.aftersans53228.aft_fabroads.block.RoadNameSignEntity;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightEntity;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightPavementEntity;
import io.github.aftersans53228.aft_fabroads.command.AftCommand;
import io.github.aftersans53228.aft_fabroads.item.NormalRoadBlock;
import io.github.aftersans53228.aft_fabroads.item.RoadDecoration;
import io.github.aftersans53228.aft_fabroads.item.RoadStickers;
import io.github.aftersans53228.aft_fabroads.network.GuiCloseNetwork;
import io.github.aftersans53228.aft_fabroads.network.OnConnectingVersionCheck;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry.*;


public class AFRoads implements ModInitializer {
	// 此记录器用于将文本写入控制台和日志文件。
	// 使用您的 mod id 作为记录器的名称被认为是最佳实践。
	// 这样一来，很清楚哪个 mod 写了信息、警告和错误。
	public static final Logger LOGGER = LogManager.getLogger("aft_fabroads");

	public static void registerPlayerJoinEvent(Consumer<ServerPlayerEntity> consumer) {
		ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
			if (entity instanceof ServerPlayerEntity
			) {
				consumer.accept((ServerPlayerEntity) entity);
			}
		});
	}
	public static void registerGuiClose(Identifier id,BiConsumer<PacketByteBuf,ServerPlayerEntity> consumer) {
		ServerPlayNetworking.registerGlobalReceiver(id,(server, player, handler, buf, responseSender)->{
			consumer.accept(buf,player);
		});
	}




	//交通灯计时器
	public static int traffic_lights_timer =0 ;

	//方块实体
	public static BlockEntityType<TrafficLightEntity> TRAFFIC_LIGHT_ENTITY;
	public static BlockEntityType<TrafficLightPavementEntity> TRAFFIC_LIGHT_PAVEMENT_ENTITY;
	public static BlockEntityType<RoadLightEntity>ROAD_LIGHT_ENTITY;
	public static BlockEntityType<RoadNameSignEntity>ROAD_NAME_SIGN_ENTITY;


	//创建物品组
	public static final ItemGroup NormalRoadBlockGROUP = NormalRoadBlock.get();
	public static final ItemGroup RoadStickersGROUP = RoadStickers.get();
	public static final ItemGroup RoadDecorationsGROUP = RoadDecoration.get();





    @Override
	public void onInitialize() {
		AFRoadsBlockRegistry.RegisterBlock();
		AFRoadsItemRegistry.RegisterItem();
		//注册方块实体
		TRAFFIC_LIGHT_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "aft_fabroads:traffic_light_entity", FabricBlockEntityTypeBuilder.create(TrafficLightEntity::new,TrafficLight).build(null));
		TRAFFIC_LIGHT_PAVEMENT_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "aft_fabroads:traffic_light_pavement_entity", FabricBlockEntityTypeBuilder.create(TrafficLightPavementEntity::new,TrafficLightPavement).build(null));
		ROAD_LIGHT_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "aft_fabroads:road_light_entity", FabricBlockEntityTypeBuilder.create(RoadLightEntity::new,RoadLight).build(null));
		ROAD_NAME_SIGN_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "aft_fabroads:road_name_sign_entity", FabricBlockEntityTypeBuilder.create(RoadNameSignEntity::new,RoadNameSign).build(null));

		//command
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> AftCommand.register(dispatcher));

		//红绿灯计时器逻辑
		ServerTickEvents.END_SERVER_TICK.register((server)->
		{
			traffic_lights_timer = traffic_lights_timer +1 ;
			if (traffic_lights_timer == 1200){
				traffic_lights_timer = 0;
			}
		});

		//服务端接发包
		registerPlayerJoinEvent(OnConnectingVersionCheck::sendVersionCheck);
		registerGuiClose(new Identifier(AFRoadsStatics.MOD_ID,"road_name_sign_gui_close"), GuiCloseNetwork::receiveGuiCloseRNS);



		LOGGER.info("AFRoads Misc Initialized");







	}

}
