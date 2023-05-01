package io.github.aftersans53228.aft_fabroads.gui;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.AFRoadsClient;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.MinecraftClientGame;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;


@Environment(EnvType.CLIENT)
public class RoadNameSignGui extends LightweightGuiDescription {

    public RoadNameSignGui(BlockPos posofblock){
        //定义root
        WGridPanel root = new WGridPanel(9);

        root.setSize(252,153);
        root.setInsets(Insets.ROOT_PANEL);
        setRootPanel(root);

        //标题
        WLabel title = new WLabel(new TranslatableText("block.aft_fabroads.road_name_sign"));
        title.setVerticalAlignment(VerticalAlignment.TOP);
        root.add(title,0, 0, 12, 3);

        //内容
        WLabel label = new WLabel(new TranslatableText("text.gui.aft_fabroads.road_name_sign_name"));
        root.add(label,0, 2, 8, 2);


        WLabel label2 = new WLabel(new TranslatableText("text.gui.aft_fabroads.road_name_sign_name2"));
        root.add(label2, 0, 7, 8, 2);

        //路牌名输入
        WTextField road_name = new WTextField(new TranslatableText("text.gui.aft_fabroads.road_name_sign_name-tip"));
        root.add(road_name,0,4,10,2);
        WTextField road_name2rd = new WTextField(new TranslatableText("text.gui.aft_fabroads.road_name_sign_name-tip2rd"));
        root.add(road_name2rd,0,9,10,2);

        //放置于左右的方向设置
        WToggleButton toggleButtonLeft = new WToggleButton(new TranslatableText("text.gui.aft_fabroads.road_name_sign_dir_left"));
        toggleButtonLeft.setToggle(true);
        root.add(toggleButtonLeft, 0, 12, 2, 2);

        WToggleButton toggleButtonRight = new WToggleButton(new TranslatableText("text.gui.aft_fabroads.road_name_sign_dir_right"));
        toggleButtonRight.setToggle(true);
        root.add(toggleButtonRight, 0,14, 2, 2);

        //应用和取消
        WButton apply = new WButton(new TranslatableText("text.gui.aft_fabroads.road_name_sign_apply"));
        root.add(apply, 22, 16, 4, 3);

        WButton cancel = new WButton(new TranslatableText("text.gui.aft_fabroads.road_name_sign_cancel"));
        root.add(cancel, 17, 16, 4, 3);

        //当取消被按下后关闭gui
        cancel.setOnClick(() -> {
            // Close gui
            AFRoads.LOGGER.info("Close the\"Road Name Sign\"'s gui. ");

            MinecraftClient.getInstance().setScreen((Screen)null);
        });
        apply.setOnClick(()->{
            boolean dirLeft = toggleButtonLeft.getToggle();
            boolean dirRight = toggleButtonRight.getToggle();
            String roadName = road_name.getText();
            String roadName2 = road_name2rd.getText();
                //output value
                PacketByteBuf buf = PacketByteBufs.create();
                buf.writeBlockPos(posofblock);//方块坐标
                buf.writeString(roadName);//道路名称
                buf.writeString(roadName2);//英语名称
                buf.writeBoolean(dirLeft);//左侧方向指示
                buf.writeBoolean(dirRight);//右侧方向指示

                AFRoads.LOGGER.info("Close the\"Road Name Sign\"'s gui. ");
                ClientPlayNetworking.send(new Identifier("aft_fabroads:road_name_sign_gui_close"), buf);
                MinecraftClient.getInstance().setScreen((Screen) null);

        });


    }
}
