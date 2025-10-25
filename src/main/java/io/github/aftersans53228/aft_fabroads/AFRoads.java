package io.github.aftersans53228.aft_fabroads;


import io.github.aftersans53228.aft_fabroads.command.AftCommand;
import io.github.aftersans53228.aft_fabroads.item.NormalRoadBlock;
import io.github.aftersans53228.aft_fabroads.item.RoadDecoration;
import io.github.aftersans53228.aft_fabroads.item.RoadStickers;
import io.github.aftersans53228.aft_fabroads.network.GuiCloseNetwork;
import io.github.aftersans53228.aft_fabroads.network.OnConnectingVersionCheck;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemGroup;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


/**
 * @author Aftersans53228
 * Mod Main Class
 */
public class AFRoads implements ModInitializer {
	// 此记录器用于将文本写入控制台和日志文件。
	// 使用您的 mod id 作为记录器的名称被认为是最佳实践。
	// 这样一来，很清楚哪个 mod 打印了信息、警告和错误。
	public static final Logger LOGGER = LogManager.getLogger("aft_fabroads");


	public static void registerPlayerJoinEvent(Consumer<ServerPlayerEntity> consumer) {
		ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
			if (entity instanceof ServerPlayerEntity
			) {
				consumer.accept((ServerPlayerEntity) entity);
			}
		});
	}
	public static void registerGuiClose(Identifier id,BiConsumer<PacketByteBuf, ServerPlayerEntity> consumer) {
		ServerPlayNetworking.registerGlobalReceiver(id,(server, player, handler, buf, responseSender)->{
				consumer.accept(buf,player);
		});
	}



	//创建物品组
	public static final ItemGroup NormalRoadBlockGROUP = NormalRoadBlock.get();
	public static final ItemGroup RoadStickersGROUP = RoadStickers.get();
	public static final ItemGroup RoadDecorationsGROUP = RoadDecoration.get();





    @Override
	public void onInitialize() {

		AFRoadsBlockRegistry.RegisterBlock();
		AFRoadsItemRegistry.RegisterItem();



		//command
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> AftCommand.register(dispatcher));

		//服务端接发包
		registerPlayerJoinEvent(OnConnectingVersionCheck::sendVersionCheck);
		registerGuiClose(new Identifier(AFRoadsStatics.MOD_ID,"road_name_sign_gui_close"),GuiCloseNetwork::receiveGuiCloseRNS);
		registerGuiClose(new Identifier(AFRoadsStatics.MOD_ID,"traffic_lights_control_box_gui_close"),GuiCloseNetwork::receiveGuiCloseTrafficLightsControlBox);




		LOGGER.info("AFRoads Misc Initialized");

	}

}
