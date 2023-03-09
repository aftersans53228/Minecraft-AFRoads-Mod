package io.github.aftersans53228.aft_fabroads;

import io.github.aftersans53228.aft_fabroads.block.RoadNameSign;
import io.github.aftersans53228.aft_fabroads.block.signBlock.SignBanNoDrive;
import io.github.aftersans53228.aft_fabroads.gui.ConfigGui;
import io.github.aftersans53228.aft_fabroads.gui.ConfigScreen;
import io.github.aftersans53228.aft_fabroads.gui.RoadNameSignGui;
import io.github.aftersans53228.aft_fabroads.gui.RoadNameSignScreen;
import io.github.aftersans53228.aft_fabroads.render.RoadLightEntityRender;
import io.github.aftersans53228.aft_fabroads.render.RoadNameSignEntityRender;
import io.github.aftersans53228.aft_fabroads.render.TrafficLightEntityRender;
import io.github.aftersans53228.aft_fabroads.render.TrafficLightPavementEntityRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class AFRoadsClient implements ClientModInitializer {
    public static int tool_mode = 0;

    private static KeyBinding keyBinding;{
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        "key.aft_fabroads.change_tool_model", // 键绑定名称的翻译键
        InputUtil.Type.KEYSYM, //键绑定的类型，键盘用 键SYM ，鼠标用 mouse 。
        GLFW.GLFW_KEY_U, // 按下的键
        "key.aft_fabroads.tool_keys" // 键绑定类别的翻译键。
    ));}

    @Override
    @SuppressWarnings("all")
    public void onInitializeClient() {
        //client Initialize
        // 如果有半透明纹理，可以将 RenderLayer.getCutout() 替换为 RenderLayer.getTranslucent()。
        //普通方块
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.RoadBlock, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.RoadBlockConcrete, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ManholeCover, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ManholeCoverConcrete, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.RoadSeamsBlock, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.RoadSeamsBlockConcrete, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ConcreteSlab, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ConcreteStairs, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ConcreteStairsSmooth, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ConcreteColumnsCorner, RenderLayer.getCutout());
        //地面划线
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.LineStraight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.LineCorner, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.LineTshaped, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.LineCross, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.LineDiagonal, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.LineLeftBend, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.LineRightBend, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.LineForkLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.LineForkRight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.LineStraightThick, RenderLayer.getCutout());
        //地面箭头
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ArrowForward, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ArrowLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ArrowRight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ArrowForwardLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ArrowForwardRight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ArrowBack, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ArrowLeftRight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ArrowBackLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ArrowBackForward, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ArrowConfluenceLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ArrowConfluenceRight, RenderLayer.getCutout());
        //道路装饰
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.Railings, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.BarrierBar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.PavementRailings, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ExpresswayRailingsBase, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ExpresswayRailings, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.ExpresswayRailingsType2, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.InsulationPanelsRailings, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.InsulationPanelsGrayPart1, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.InsulationPanelsGrayPart2, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.InsulationPanelsGrayPart3, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.InsulationPanelsGrayPart4, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.InsulationPanelsGrayPart5, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.InsulationPanelsGrayPart6, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.TrafficLight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.TrafficLightPavement, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.RoadLight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.PillarBase, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.HorizontalStraightPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.VerticalStraightPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.VerticalCornerPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.HorizontalCornerPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.VerticalTshapedPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.VerticalTshapedPillarType2, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.HorizontalTshapedPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.HorizontalStraightPillarThin, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.VerticalStraightPillarThin, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.VerticalCornerPillarThin, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.RoadMastPillarBase, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.RoadMastPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.SignIndicatorDirectionLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.SignIndicatorDirectionRight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.SignIndicatorDirectionCar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.SignIndicatorDirectionBicycle, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.SignBanNoDrive, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.SignBanStop, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.SignBanSpeedLimit05, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.SignBanSpeedLimit20, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.SignBanSpeedLimit30, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.SignBanSpeedLimit40, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.SignBanSpeedLimit50, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.SignBanSpeedLimit60, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.SignBanSpeedLimit70, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.SignBanSpeedLimit80, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.RubbishBinMetal, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.TrashBinGreen, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AFRoads.RoadNameSign, RenderLayer.getCutout());




        //运行按键绑定
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding.wasPressed()) {
                if (tool_mode == 0) {
                    assert client.player != null;
                    tool_mode = 1;
                    client.player.sendMessage(new TranslatableText("item.aft_fabroads.tool-mode_connect"), true);
                }
                else{
                    if(tool_mode == 1){
                        assert client.player != null;
                        tool_mode = 0;
                        client.player.sendMessage(new TranslatableText("item.aft_fabroads.tool-mode_normal"), true);
                    }
                }
            }
        });




        //注册一个道路工具变种模型
        FabricModelPredicateProviderRegistry.register(AFRoads.RoadTool, new Identifier("tool_mode"), (itemStack, clientWorld, livingEntity , i) -> AFRoadsClient.tool_mode);

        //注册方块实体渲染
        BlockEntityRendererRegistry.register(AFRoads.TRAFFIC_LIGHT_ENTITY, TrafficLightEntityRender::new);
        BlockEntityRendererRegistry.register(AFRoads.TRAFFIC_LIGHT_PAVEMENT_ENTITY, TrafficLightPavementEntityRender::new);
        BlockEntityRendererRegistry.register(AFRoads.ROAD_LIGHT_ENTITY, RoadLightEntityRender::new);
        BlockEntityRendererRegistry.register(AFRoads.ROAD_NAME_SIGN_ENTITY, RoadNameSignEntityRender::new);

        //gui
        ClientPlayNetworking.registerGlobalReceiver( new Identifier("aft_fabroads:road_name_sign_gui_open"), (client, handler, buf, responseSender) -> {
            BlockPos RoadNameSignPos = buf.readBlockPos();
            client.execute(() -> {
                // 此 lambda 中的所有内容都在渲染线程上运行
                client.setScreen(new RoadNameSignScreen(new RoadNameSignGui(RoadNameSignPos)));
                AFRoads.LOGGER.info("Open the\"Road Name Sign\"'s gui. ");
            });
        });
        ClientPlayNetworking.registerGlobalReceiver( new Identifier("aft_fabroads:config_open"), (client, handler, buf, responseSender) -> {
            client.execute(() -> {
                client.setScreen(new ConfigScreen(new TranslatableText("text.gui.aft_fabroads.config_title"),new ConfigGui()));
                AFRoads.LOGGER.info("Open the\"Config Menu\"");
            });
        });
    }
}
