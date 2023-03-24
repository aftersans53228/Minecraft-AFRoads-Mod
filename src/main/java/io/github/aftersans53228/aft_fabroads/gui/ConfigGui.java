package io.github.aftersans53228.aft_fabroads.gui;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WToggleButton;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class ConfigGui extends LightweightGuiDescription {

    public ConfigGui() {
        //定义root
        WGridPanel root = new WGridPanel(9);
        setFullscreen(true);

        root.setSize(270, 180);
        root.setInsets(Insets.ROOT_PANEL);
        setRootPanel(root);

        WToggleButton render_enable = new WToggleButton(new TranslatableText("text.gui.aft_fabroads.render_enable_text_font"));
        render_enable.setToggle(true);
        root.add(render_enable, 0, 2, 2, 2);

        WButton cancel = new WButton(new TranslatableText("text.gui.aft_fabroads.road_name_sign_cancel"));
        cancel.setAlignment(HorizontalAlignment.RIGHT);
        root.add(cancel, 19, 18, 5, 3);

        //当取消被按下后关闭gui
        cancel.setOnClick(() -> {
            // Close gui
            AFRoads.LOGGER.info("Close the\"Config\"'s gui. ");

            MinecraftClient.getInstance().setScreen((Screen)null);
        });
    }
}
