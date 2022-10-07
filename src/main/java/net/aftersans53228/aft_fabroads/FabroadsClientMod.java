package net.aftersans53228.aft_fabroads;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.CallbackI;

@Environment(EnvType.CLIENT)
public class FabroadsClientMod implements ClientModInitializer {
    public static boolean is_logo_tool = false;

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
        //普通方块
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.RoadBlock, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.RoadBlockConcrete, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ManholeCover, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.ManholeCoverConcrete, RenderLayer.getCutoutMipped());
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
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.TrafficLight, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.PillarBase, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.HorizontalStraightPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.VerticalStraightPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.HorizontalCornerPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.VerticalTshapedPillar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FabroadsMod.HorizontalTshapedPillar, RenderLayer.getCutout());

        //运行按键绑定
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding.wasPressed()) {
                is_logo_tool = !is_logo_tool;
                assert client.player != null;
                client.player.sendMessage(new LiteralText("道路工具模型已修改为"+is_logo_tool+"."), true);
            }
        });

        //注册一个道路工具变种模型
        FabricModelPredicateProviderRegistry.register(FabroadsMod.RoadTool, new Identifier("is_logo_tool"), (itemStack, clientWorld, livingEntity , i) -> {
            if(FabroadsClientMod.is_logo_tool){
                return 1;
            }
            else{
                return 0;
            }
        });

        //结束客户端
    }
}
