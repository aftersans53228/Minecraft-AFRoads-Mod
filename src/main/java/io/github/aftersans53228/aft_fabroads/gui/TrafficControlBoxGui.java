package io.github.aftersans53228.aft_fabroads.gui;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Axis;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class TrafficControlBoxGui extends LightweightGuiDescription {
    public TrafficControlBoxGui(BlockPos posOfBlock){
        WGridPanel root = new WGridPanel(9);
        root.setSize(252,153);
        root.setInsets(Insets.ROOT_PANEL);
        setRootPanel(root);

        //标题
        WLabel title = new WLabel(new TranslatableText("block.aft_fabroads.traffic_lights_control_box"));
        title.setVerticalAlignment(VerticalAlignment.TOP);
        root.add(title,0, 0, 12, 3);

        //标题
        WLabel labelRed = new WLabel(new TranslatableText("text.gui.aft_fabroads.traffic_control_box_red"));
        root.add(labelRed,0, 2, 8, 2);
        WLabel labelGreen = new WLabel(new TranslatableText("text.gui.aft_fabroads.traffic_control_box_green"));
        root.add(labelGreen,0, 6, 8, 2);
        WLabel labelRedTurn = new WLabel(new TranslatableText("text.gui.aft_fabroads.traffic_control_box_red"));
        root.add(labelRedTurn,0, 10, 8, 2);
        WLabel labelGreenTurn = new WLabel(new TranslatableText("text.gui.aft_fabroads.traffic_control_box_red"));
        root.add(labelGreenTurn,0, 14, 8, 2);

        //滑块
        WSlider sliderRed =new WSlider(10,60, Axis.HORIZONTAL);
        WSlider sliderGreen =new WSlider(10,60, Axis.HORIZONTAL);
        WSlider sliderRedTurn =new WSlider(0,5, Axis.HORIZONTAL);
        WSlider sliderGreenTurn =new WSlider(0,30, Axis.HORIZONTAL);
        sliderRed.setValue(30);
        sliderGreen.setValue(30);
        sliderRedTurn.setValue(0);
        sliderGreenTurn.setValue(0);
        root.add(sliderRed,0,4,10,2);
        root.add(sliderGreen,0,8,10,2);
        root.add(sliderRedTurn,0,12,10,2);
        root.add(sliderGreenTurn,0,16,10,2);

        //应用和取消
        WButton apply = new WButton(new TranslatableText("text.gui.aft_fabroads.apply"));
        root.add(apply, 22, 16, 4, 3);

        WButton cancel = new WButton(new TranslatableText("text.gui.aft_fabroads.cancel"));
        root.add(cancel, 17, 16, 4, 3);

        //当取消被按下后关闭gui
        cancel.setOnClick(() -> {
            // Close gui
            AFRoads.LOGGER.info("Close the\"Traffic Control Box\"'s gui. ");
            MinecraftClient.getInstance().setScreen((Screen)null);
        });
    }
}
