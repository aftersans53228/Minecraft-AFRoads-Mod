package net.aftersans53228.aft_fabroads;

import net.aftersans53228.aft_fabroads.block.TrafficLightEntity;
import net.aftersans53228.aft_fabroads.block.TrafficLightEntityRender;
import net.aftersans53228.aft_fabroads.block.TrafficLightPavementEntityRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.CallbackI;

@Environment(EnvType.CLIENT)
public class FabroadsClientMod implements ClientModInitializer {
    public static int tool_mode = 0;

    private static KeyBinding keyBinding;{
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        "key.aft_fabroads.change_tool_model", // 键绑定名称的翻译键
        InputUtil.Type.KEYSYM, //键绑定的类型，键盘用 键SYM ，鼠标用 mouse 。
        GLFW.GLFW_KEY_U, // 按下的键
        "key.aft_fabroads.tool_keys" // 键绑定类别的翻译键。
    ));}

    @Override
    public void onInitializeClient() {
        //client Initialize
        // 如果有半透明纹理，可以将 RenderLayer.getCutout() 替换为 RenderLayer.getTranslucent()。
        //普通方块
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.RoadBlock, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.RoadBlockConcrete, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ManholeCover, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ManholeCoverConcrete, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.RoadSeamsBlock, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.RoadSeamsBlockConcrete, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ConcreteSlab, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ConcreteStairs, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ConcreteStairsSmooth, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ConcreteColumnsCorner, RenderLayer.getCutout());
        //地面划线
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.LineStraight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.LineCorner, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.LineTshaped, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.LineCross, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.LineDiagonal, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.LineLeftBend, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.LineRightBend, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.LineForkLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.LineForkRight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.LineStraightThick, RenderLayer.getCutout());
        //地面箭头
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ArrowForward, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ArrowLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ArrowRight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ArrowForwardLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ArrowForwardRight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ArrowBack, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ArrowLeftRight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ArrowBackLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ArrowBackForward, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ArrowConfluenceLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ArrowConfluenceRight, RenderLayer.getCutout());
        //道路装饰
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.Railings, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.BarrierBar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.PavementRailings, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ExpresswayRailingsBase, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ExpresswayRailings, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ExpresswayRailingsType2, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.InsulationPanelsRailings, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.InsulationPanelsGrayPart1, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.InsulationPanelsGrayPart2, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.InsulationPanelsGrayPart3, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.InsulationPanelsGrayPart4, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.InsulationPanelsGrayPart5, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.InsulationPanelsGrayPart6, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.TrafficLight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.TrafficLightPavement, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.PillarBase, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.HorizontalStraightPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.VerticalStraightPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.HorizontalCornerPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.VerticalTshapedPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.VerticalTshapedPillarType2, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.HorizontalTshapedPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.RoadMastPillarBase, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.RoadMastPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.SignIndicatorDirectionLeft, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.SignIndicatorDirectionRight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.SignIndicatorDirectionCar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.SignIndicatorDirectionBicycle, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.SignBanNoDrive, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.SignBanStop, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.SignBanSpeedLimit05, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.SignBanSpeedLimit20, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.SignBanSpeedLimit30, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.SignBanSpeedLimit40, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.SignBanSpeedLimit50, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.SignBanSpeedLimit60, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.SignBanSpeedLimit70, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.SignBanSpeedLimit80, RenderLayer.getCutout());



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
        FabricModelPredicateProviderRegistry.register(FabroadsMod.RoadTool, new Identifier("tool_mode"), (itemStack, clientWorld, livingEntity , i) -> FabroadsClientMod.tool_mode);

        //注册方块实体渲染
        BlockEntityRendererRegistry.register(FabroadsMod.TRAFFIC_LIGHT_ENTITY, TrafficLightEntityRender::new);
        BlockEntityRendererRegistry.register(FabroadsMod.TRAFFIC_LIGHT_PAVEMENT_ENTITY, TrafficLightPavementEntityRender::new);
    }
}
