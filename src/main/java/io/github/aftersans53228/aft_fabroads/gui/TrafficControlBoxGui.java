package io.github.aftersans53228.aft_fabroads.gui;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import io.github.aftersans53228.aft_fabroads.network.GuiCloseNetwork;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Axis;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.sql.Array;
import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * @author aftersans53228
 */
@Environment(EnvType.CLIENT)
public class TrafficControlBoxGui extends LightweightGuiDescription {
    public TrafficControlBoxGui(BlockPos posOfBlock, Boolean enabled, int[] timeData){
        WGridPanel root = new WGridPanel(9);
        root.setSize(254,160);
        root.setInsets(Insets.ROOT_PANEL);
        setRootPanel(root);

        //标题
        WLabel title = new WLabel(Text.translatable("block.aft_fabroads.traffic_lights_control_box"));
        title.setVerticalAlignment(VerticalAlignment.TOP);
        root.add(title,0, 0, 12, 3);

        WLabel title2 = new WLabel(Text.translatable("text.gui.aft_fabroads.traffic_control_box"));
        title.setVerticalAlignment(VerticalAlignment.TOP);
        root.add(title2,2, 2, 12, 3);

        //内容
        WLabel labelFNS = new WLabel(Text.translatable("text.gui.aft_fabroads.traffic_control_box_fns"));
        root.add(labelFNS,0, 4, 8, 2);
        WLabel labelFWE = new WLabel(Text.translatable("text.gui.aft_fabroads.traffic_control_box_fwe"));
        root.add(labelFWE,0, 8, 8, 2);
        WLabel labelTNS = new WLabel(Text.translatable("text.gui.aft_fabroads.traffic_control_box_tns"));
        root.add(labelTNS,0, 12, 8, 2);
        WLabel labelTWE = new WLabel(Text.translatable("text.gui.aft_fabroads.traffic_control_box_twe"));
        root.add(labelTWE,0, 16, 8, 2);

        //滑块
        WSlider sliderFNS =new WSlider(15,60, Axis.HORIZONTAL);
        WSlider sliderFWE =new WSlider(15,60, Axis.HORIZONTAL);
        WSlider sliderTNS =new WSlider(0,50, Axis.HORIZONTAL);
        WSlider sliderTWE =new WSlider(0,50, Axis.HORIZONTAL);
        //设置滑块当前值
        sliderFNS.setValue(timeData[0]);
        sliderFWE.setValue(timeData[2]);
        sliderTNS.setValue(timeData[1]);
        sliderTWE.setValue(timeData[3]);
        //显示滑块
        root.add(sliderFNS,0,5,10,2);
        root.add(sliderFWE,0,9,10,2);
        root.add(sliderTNS,0,13,10,2);
        root.add(sliderTWE,0,17,10,2);

        //预览值
        WDynamicLabel labelShowRed = new WDynamicLabel(()-> I18n.translate("text.gui.aft_fabroads.traffic_control_box_second_preview",sliderFNS.getValue()));
        root.add(labelShowRed,11, 6, 4, 1);
        WDynamicLabel labelShowGreen = new WDynamicLabel(()-> I18n.translate("text.gui.aft_fabroads.traffic_control_box_second_preview",sliderFWE.getValue()));
        root.add(labelShowGreen,11, 10, 4, 1);
        WDynamicLabel labelShowRedTurn = new WDynamicLabel(()-> I18n.translate("text.gui.aft_fabroads.traffic_control_box_second_preview",sliderTNS.getValue()));
        root.add(labelShowRedTurn,11, 14, 4, 1);
        WDynamicLabel labelShowGreenTurn = new WDynamicLabel(()-> I18n.translate("text.gui.aft_fabroads.traffic_control_box_second_preview",sliderTWE.getValue()));
        root.add(labelShowGreenTurn,11, 18, 4, 1);

        //应用和取消
        WButton apply = new WButton(Text.translatable("text.gui.aft_fabroads.apply"));
        root.add(apply, 22, 16, 4, 3);

        WButton cancel = new WButton(Text.translatable("text.gui.aft_fabroads.cancel"));
        root.add(cancel, 17, 16, 4, 3);

        //重置
        WButton reset = new WButton(Text.translatable("text.gui.aft_fabroads.reset"));
        root.add(reset, 20, 3, 4, 3);

        //是否启用灯箱
        WLabel whetherEnabled = new WLabel(Text.translatable("text.gui.aft_fabroads.traffic_control_box_whether_enabled"));
        WToggleButton toggleButtonTimer = new WToggleButton();
        toggleButtonTimer.setToggle(enabled);
        root.add(whetherEnabled, 20, 9, 2, 2);
        root.add(toggleButtonTimer, 21, 10, 2, 2);



        //当取消被按下后关闭gui
        cancel.setOnClick(() -> {
            // Close gui
            AFRoads.LOGGER.info("Close the\"Traffic Control Box\"'s gui. ");
            MinecraftClient.getInstance().setScreen((Screen)null);
        });
        reset.setOnClick(()->{
            // 这其实是默认值
            sliderFNS.setValue(30);
            sliderFWE.setValue(30);
            sliderTNS.setValue(0);
            sliderTWE.setValue(0);
            toggleButtonTimer.setToggle(false);
        });
        apply.setOnClick(()->{
            //output value
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeBlockPos(posOfBlock);//方块坐标
            buf.writeIntArray(new int[]{sliderFNS.getValue(), sliderTNS.getValue() == 0 ? -80 :sliderTNS.getValue(), sliderFWE.getValue(), sliderTWE.getValue() == 0 ? -80 :sliderTWE.getValue()});
            buf.writeBoolean(toggleButtonTimer.getToggle());
            AFRoads.LOGGER.info("Close the\"Traffic Control Box\"'s gui. ");
            GuiCloseNetwork.sendGuiClose(new Identifier(AFRoadsStatics.MOD_ID,"traffic_lights_control_box_gui_close"),buf);
            MinecraftClient.getInstance().setScreen((Screen) null);
        });

    }
}
