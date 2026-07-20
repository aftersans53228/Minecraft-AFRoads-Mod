package io.github.aftersans53228.aft_fabroads;

import io.github.aftersans53228.aft_fabroads.network.ClientReceive;
import io.github.aftersans53228.aft_fabroads.registry.AFRoadsBlockRegistry;
import io.github.aftersans53228.aft_fabroads.render.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Style;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

import static io.github.aftersans53228.aft_fabroads.AFRoadsStatics.*;
import static io.github.aftersans53228.aft_fabroads.registry.AFRoadsBlockRegistry.*;

/**
 * @author Aftersans53228
 * Mod Client Main Class
 */
@Environment(EnvType.CLIENT)
public class AFRoadsClient implements ClientModInitializer {
    public static final Style DIGIT7_STYLE = Style.EMPTY.withFont(new Identifier(MOD_ID,"font_digit7"));
    public static final Style JTZYF_STYLE = Style.EMPTY.withFont(new Identifier(MOD_ID,"traffic_bzzyzt_1"));
    public static void registerNetworkReceiver(Identifier id, Consumer<PacketByteBuf> consumer) {
        ClientPlayNetworking.registerGlobalReceiver(id, (client, handler, packet, responseSender) -> consumer.accept(packet));
    }

    @Override
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
        BlockRenderLayerMap.INSTANCE.putBlock(TrafficLightLeftTurn, RenderLayer.getCutout());
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

        //注册方块实体渲染
        BlockEntityRendererFactories.register(AFRoadsBlockRegistry.TRAFFIC_LIGHT_ENTITY, TrafficLightEntityRender::new);
        BlockEntityRendererFactories.register(TRAFFIC_LIGHT_LEFT_TURN_ENTITY, TrafficLightLeftTurnEntityRender::new);
        BlockEntityRendererFactories.register(AFRoadsBlockRegistry.TRAFFIC_LIGHT_PAVEMENT_ENTITY, TrafficLightPavementEntityRender::new);
        BlockEntityRendererFactories.register(AFRoadsBlockRegistry.ROAD_LIGHT_ENTITY, RoadLightEntityRender::new);
        BlockEntityRendererFactories.register(AFRoadsBlockRegistry.ROAD_NAME_SIGN_ENTITY, RoadNameSignEntityRender::new);

        //gui
        registerNetworkReceiver(
                new Identifier(MOD_ID, "road_name_sign_gui_open"),
                ClientReceive::receiveRoadNameSignGuiOpen
        );
        registerNetworkReceiver(
                new Identifier(MOD_ID, "traffic_control_box_gui_open"),
                ClientReceive::receiveTrafficLightsControlBoxGuiOpen
        );
        //version check
        registerNetworkReceiver(
                new Identifier(MOD_ID,"version_check"),
                ClientReceive::receiveVersionCheck
        );
        //attributes tool send message
        registerNetworkReceiver(
                new Identifier(MOD_ID,"attributes_item_required"),
                ClientReceive::receiveToolCallBlockAttributes
        );



    }
}
