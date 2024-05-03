package io.github.aftersans53228.aft_fabroads.gui;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import io.github.aftersans53228.aft_fabroads.network.GuiCloseNetwork;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;


/**
 * @author aftersans53228
 */
@Environment(EnvType.CLIENT)
public class RoadNameSignGui extends LightweightGuiDescription {
    private Direction leftFace;
    private Direction rightFace;

    public RoadNameSignGui(BlockPos posOfBlock, List<String> names, ClientWorld clientWorld){
        //获得已设置信息
        Direction dirBlock = clientWorld.getBlockState(posOfBlock).get(Properties.HORIZONTAL_FACING);
        switch(dirBlock){
            case EAST :
                this.leftFace =Direction.NORTH;
                this.rightFace = Direction.SOUTH;
                break;
            case WEST :
                this.leftFace =Direction.SOUTH;
                this.rightFace = Direction.NORTH;
                break;
            case NORTH :
                this.leftFace =Direction.WEST;
                this.rightFace = Direction.EAST;
                break;
            case SOUTH :
                this.leftFace =Direction.EAST;
                this.rightFace = Direction.WEST;
                break;
            default:
                this.leftFace =Direction.UP;
                this.rightFace = Direction.UP;
                break;

        }

        Boolean dirLeft = clientWorld.getBlockState(posOfBlock).get(BooleanProperty.of("dir_left"));
        Boolean dirRight = clientWorld.getBlockState(posOfBlock).get(BooleanProperty.of("dir_right"));
        String name1=names.get(0);
        String name2=names.get(1);


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
        WTextField roadName = new WTextField(new TranslatableText("text.gui.aft_fabroads.road_name_sign_name-tip"));
        roadName.setText(name1);
        root.add(roadName,0,4,11,2);
        WTextField roadName2rd = new WTextField(new TranslatableText("text.gui.aft_fabroads.road_name_sign_name-tip2rd"));
        roadName2rd.setText(name2);
        root.add(roadName2rd,0,9,11,2);

        //放置于左右的方向设置开关
        WToggleButton toggleButtonLeft = new WToggleButton();
        toggleButtonLeft.setToggle(dirLeft);
        root.add(toggleButtonLeft, 13, 8, 3, 3);

        WToggleButton toggleButtonRight = new WToggleButton();
        toggleButtonRight.setToggle(dirRight);
        root.add(toggleButtonRight, 20,8, 3, 3);

        //开关动态文字
        WDynamicLabel labelLeftDir = new WDynamicLabel(()-> I18n.translate("text.gui.aft_fabroads.road_name_sign_dir_left",this.leftFace.getName().toUpperCase()));
        root.add(labelLeftDir, 12, 6, 2, 1);
        WDynamicLabel labelRightDir = new WDynamicLabel(()-> I18n.translate("text.gui.aft_fabroads.road_name_sign_dir_right",this.rightFace.getName().toUpperCase()));
        root.add(labelRightDir, 19,6, 2, 1);

        //应用和取消
        WButton apply = new WButton(new TranslatableText("text.gui.aft_fabroads.apply"));
        root.add(apply, 22, 16, 4, 3);

        WButton cancel = new WButton(new TranslatableText("text.gui.aft_fabroads.cancel"));
        root.add(cancel, 17, 16, 4, 3);

        //重置
        WButton reset = new WButton(new TranslatableText("text.gui.aft_fabroads.reset"));
        root.add(reset, 0, 13, 11, 3);

        //当取消被按下后关闭gui
        cancel.setOnClick(() -> {
            // Close gui
            AFRoads.LOGGER.info("Close the\"Road Name Sign\"'s gui. ");
            MinecraftClient.getInstance().setScreen((Screen)null);
        });
        apply.setOnClick(()->{
            String roadName1 = roadName.getText();
            String roadName2 = roadName2rd.getText();
                //output value
                PacketByteBuf buf = PacketByteBufs.create();
                buf.writeBlockPos(posOfBlock);//方块坐标
                buf.writeString(roadName1);//道路名称
                buf.writeString(roadName2);//英语名称
                buf.writeBoolean(toggleButtonLeft.getToggle());//左侧方向指示
                buf.writeBoolean(toggleButtonRight.getToggle());//右侧方向指示

                AFRoads.LOGGER.info("Close the\"Road Name Sign\"'s gui. ");
                GuiCloseNetwork.sendGuiClose(new Identifier(AFRoadsStatics.MOD_ID,"road_name_sign_gui_close"),buf);
                MinecraftClient.getInstance().setScreen((Screen) null);

        });
        reset.setOnClick(()->{
            roadName.setText("未命名");
            roadName2rd.setText("Unnamed");
            toggleButtonLeft.setToggle(true);
            toggleButtonRight.setToggle(true);
        });


    }
}
