package io.github.aftersans53228.aft_fabroads;

import io.github.aftersans53228.aft_fabroads.gui.RoadNameSignGui;
import io.github.aftersans53228.aft_fabroads.gui.TrafficControlBoxGui;
import io.github.aftersans53228.aft_fabroads.item.RoadToolAttribute;
import io.github.aftersans53228.aft_fabroads.network.OnConnectingVersionCheck;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry;
import io.github.aftersans53228.aft_fabroads.render.RoadLightEntityRender;
import io.github.aftersans53228.aft_fabroads.render.RoadNameSignEntityRender;
import io.github.aftersans53228.aft_fabroads.render.TrafficLightEntityRender;
import io.github.aftersans53228.aft_fabroads.render.TrafficLightPavementEntityRender;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.function.Consumer;

import static io.github.aftersans53228.aft_fabroads.AFRoadsStatics.MOD_ID;
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry.*;

/**
 * @author Aftersans53228
 * Mod Client Main Class
 */
@Environment(EnvType.CLIENT)
public class AFRoadsClient implements ClientModInitializer {
    public static void registerNetworkReceiver(Identifier id, Consumer<PacketByteBuf> consumer) {
        ClientPlayNetworking.registerGlobalReceiver(id, (client, handler, packet, responseSender) -> consumer.accept(packet));
    }


    @Override
    @SuppressWarnings("all")
    public void onInitializeClient() {
        //client Initialize
        // 如果有半透明纹理，可以将 RenderLayer.getCutout() 替换为 RenderLayer.getTranslucent()。
        //普通方块
        BlockRenderLayerMap.INSTANCE.putBlock(RoadBlock, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(RoadBlockConcrete, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ManholeCover, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ManholeCoverConcrete, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(RoadSeamsBlock, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(RoadSeamsBlockConcrete, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ConcreteSlab, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ConcreteStairs, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ConcreteStairsSmooth, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ConcreteColumnsCorner, RenderLayer.getCutout());
        //地面划线
        BlockRenderLayerMap.INSTANCE.putBlock(LineStraight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineCorner, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineTshaped, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineCross, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineDiagonal, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineLeftBend, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineRightBend, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineForkLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineForkRight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineStraightThick, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineStraightDuoLine, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineStraightDuoThick, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineStraightDuoThickDashed, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineDecelerateNoLine, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineDecelerateNoLineFlip, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineDecelerateWithLine, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineDecelerateWithLineFlip, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineDecelerateDoubleWL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineDecelerateDoubleNL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineReversibleLanes, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineReversibleLanesFlip, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LineReversibleLanesDouble, RenderLayer.getCutout());
        //地面箭头
        BlockRenderLayerMap.INSTANCE.putBlock(ArrowForward, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArrowLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArrowRight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArrowForwardLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArrowForwardRight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArrowBack, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArrowLeftRight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArrowBackLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArrowBackForward, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArrowConfluenceLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArrowConfluenceRight, RenderLayer.getCutout());
        //地面图标
        BlockRenderLayerMap.INSTANCE.putBlock(IconDecelerateSticker, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(IconStopSticker, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(IconGiverWaySticker, RenderLayer.getCutout());
        //道路装饰
        BlockRenderLayerMap.INSTANCE.putBlock(Railings, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BarrierBar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PavementRailings, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ExpresswayRailingsBase, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ExpresswayIronRailings, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ExpresswayIronRailings2, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ExpresswayRailings, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ExpresswayRailingsType2, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(InsulationPanelsRailings, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(InsulationPanelsGrayPart1, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(InsulationPanelsGrayPart2, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(InsulationPanelsGrayPart3, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(InsulationPanelsGrayPart4, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(InsulationPanelsGrayPart5, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(InsulationPanelsGrayPart6, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(TrafficLightsControlBox, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(TrafficLight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TrafficLightPavement, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RoadLight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PillarBase, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HorizontalStraightPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerticalStraightPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerticalCornerPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HorizontalCornerPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerticalTshapedPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerticalTshapedPillarType2, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HorizontalTshapedPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HorizontalStraightPillarThin, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerticalStraightPillarThin, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerticalCornerPillarThin, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RoadMastPillarBase, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RoadMastPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SmartPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SmartPillarThin, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SignIndicatorDirectionLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SignIndicatorDirectionRight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SignIndicatorDirectionCar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SignIndicatorDirectionBicycle, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SignBanNoDrive, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SignBanStop, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SignBanSpeedLimit05, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SignBanSpeedLimit20, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SignBanSpeedLimit30, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SignBanSpeedLimit40, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SignBanSpeedLimit50, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SignBanSpeedLimit60, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SignBanSpeedLimit70, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SignBanSpeedLimit80, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RubbishBinMetal, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TrashBinGreen, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RoadNameSign, RenderLayer.getCutout());





        //注册一个道路工具变种模型
        //FabricModelPredicateProviderRegistry.register(RoadTool, new Identifier("tool_mode"), (itemStack, clientWorld, livingEntity , i) -> tool_mode);

        //注册方块实体渲染
        BlockEntityRendererRegistry.register(AFRoadsBlockRegistry.TRAFFIC_LIGHT_ENTITY, TrafficLightEntityRender::new);
        BlockEntityRendererRegistry.register(AFRoadsBlockRegistry.TRAFFIC_LIGHT_PAVEMENT_ENTITY, TrafficLightPavementEntityRender::new);
        BlockEntityRendererRegistry.register(AFRoadsBlockRegistry.ROAD_LIGHT_ENTITY, RoadLightEntityRender::new);
        BlockEntityRendererRegistry.register(AFRoadsBlockRegistry.ROAD_NAME_SIGN_ENTITY, RoadNameSignEntityRender::new);

        //gui
        ClientPlayNetworking.registerGlobalReceiver( new Identifier("aft_fabroads:road_name_sign_gui_open"), (client, handler, buf, responseSender) -> {
            BlockPos roadNameSignPos = buf.readBlockPos();
            client.execute(() -> {
                // 此 lambda 中的所有内容都在渲染线程上运行
                client.setScreen(new CottonClientScreen(new RoadNameSignGui(roadNameSignPos)));
                AFRoads.LOGGER.info("Open the\"Road Name Sign\"'s gui. ");
            });
        });
        ClientPlayNetworking.registerGlobalReceiver( new Identifier("aft_fabroads:traffic_control_box_gui_open"), (client, handler, buf, responseSender) -> {
            BlockPos controlBoxPos = buf.readBlockPos();
            client.execute(() -> {
                // 此 lambda 中的所有内容都在渲染线程上运行
                client.setScreen(new CottonClientScreen(new TrafficControlBoxGui(controlBoxPos)));
                    AFRoads.LOGGER.info("Open the\"Traffic Control Box\"'s gui. ");
            });
        });
        ClientPlayNetworking.registerGlobalReceiver(new Identifier(MOD_ID,"disconnect_self"),((client, handler, buf, responseSender) -> {
            client.execute(()->{
                ClientConnection connection = client.getNetworkHandler().getConnection();
                if (connection !=null){
                    connection.disconnect(
                        new LiteralText(
                        I18n.translate("text.gui.aft_fabroads.version_mistake")+"\n\n"
                                +I18n.translate("text.gui.aft_fabroads.version_mistake_client")+"§4"+"AFRoadsStatics.MOD_VERSION(Client)\n"
                                +I18n.translate("text.gui.aft_fabroads.version_mistake_server")+"§2"+"AFRoadsStatics.MOD_VERSION(Server)\n"
                                +"§f(The operator self-disconnected.)")
                    );
                };
            });
        }));

        registerNetworkReceiver(new Identifier(MOD_ID,"version_check"),OnConnectingVersionCheck::receiveVersionCheck);

        ClientPlayNetworking.registerGlobalReceiver(new Identifier(MOD_ID,"attributes_item_required"),((client, handler, buf, responseSender) -> {
            String s1 = buf.readString();
            String s2 = buf.readString();
            client.execute(() -> {
                RoadToolAttribute.receiveAttributeItem(s1,s2, client.player);
            });
        }));

    }
}
