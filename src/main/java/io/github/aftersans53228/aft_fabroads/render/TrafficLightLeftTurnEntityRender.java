package io.github.aftersans53228.aft_fabroads.render;

import io.github.aftersans53228.aft_fabroads.block.blockentites.TrafficLightLeftTurnEntity;
import io.github.aftersans53228.aft_fabroads.block.blockentites.TrafficLightsControlEntity;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;

import static io.github.aftersans53228.aft_fabroads.AFRoadsClient.DIGIT7_STYLE;
import static io.github.aftersans53228.aft_fabroads.block.TrafficLight.hasTimer;

/**
 * @author aftersans53228
 */
@Environment(EnvType.CLIENT)
public class TrafficLightLeftTurnEntityRender implements BlockEntityRenderer<TrafficLightLeftTurnEntity> {
    //获得物品stack
    private static final ItemStack STACK_RED = new ItemStack(AFRoadsItemRegistry.TrafficLightLeftBulbRed, 1);
    private static final ItemStack STACK_GREEN = new ItemStack(AFRoadsItemRegistry.TrafficLightLeftBulbGreen, 1);
    private static final ItemStack STACK_YELLOW = new ItemStack(AFRoadsItemRegistry.TrafficLightLeftBulbYellow, 1);
    private final TextRenderer textRenderer;


    public TrafficLightLeftTurnEntityRender(BlockEntityRendererFactory.Context ctx) {
        this.textRenderer = ctx.getTextRenderer();
    }

    @Override
    public void render(TrafficLightLeftTurnEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        //选择渲染类型,标记
        logicProgram:
        if(blockEntity.getWorld() !=  null) {//world is not NULL
            TrafficLightsControlEntity controlBox;
            if (blockEntity.getControlBoxPos() != null) {
                controlBox = (TrafficLightsControlEntity) blockEntity.getWorld().getBlockEntity(blockEntity.getControlBoxPos());
                Direction dir =blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING);

                matrices.push();
                //设置坐标
                matrices.translate(0.5, 0.5, 0.5);
                getRotate(matrices,dir);
                this.renderLights(blockEntity,controlBox,dir,matrices,vertexConsumers);
                matrices.pop();

            } else {
                break logicProgram;
            }
        }
        else{
            matrices.push();
            MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(Items.BARRIER), ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
            matrices.pop();
        }

    }
    public static void getRotate(MatrixStack matrices,Direction dir){
        //设置旋转
        switch(dir){
            case NORTH,SOUTH -> matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(dir.asRotation()-180));
            case WEST,EAST -> matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(dir.asRotation()));
        }
    }
    private void renderLights(TrafficLightLeftTurnEntity blockEntity,TrafficLightsControlEntity controlBox ,Direction dir,MatrixStack matrices, VertexConsumerProvider vertexConsumers){
        switch (dir) {
            case SOUTH, NORTH -> {
                String type = controlBox.getLightType("NS");
                switch (type) {
                    case "turn_green" -> {
                        MinecraftClient.getInstance().getItemRenderer().renderItem(STACK_GREEN, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                        this.renderTexts(blockEntity,controlBox,dir,matrices,vertexConsumers,0,"1tG");//meaning: North&South Turn Green
                    }
                    case "turn_yellow" -> {
                        MinecraftClient.getInstance().getItemRenderer().renderItem(STACK_YELLOW, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                    }
                    case "turn_airG" -> {
                        this.renderTexts(blockEntity, controlBox,dir, matrices, vertexConsumers, 0,"1tG");//meaning: North&South Turn Green
                    }
                    case "turn_redE"-> {//ending red
                        MinecraftClient.getInstance().getItemRenderer().renderItem(STACK_RED, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                    }
                    case "disabled"->{}
                    default -> {//and red
                        MinecraftClient.getInstance().getItemRenderer().renderItem(STACK_RED, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                        this.renderTexts(blockEntity, controlBox,dir, matrices, vertexConsumers, 2,"1tR");//meaning: North&South Turn Red
                    }
                }
            }
            case EAST, WEST -> {
                String type = controlBox.getLightType("WE");
                switch (type) {
                    case "turn_green" -> {
                        MinecraftClient.getInstance().getItemRenderer().renderItem(STACK_GREEN, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                        this.renderTexts(blockEntity, controlBox,dir, matrices, vertexConsumers, 0,"3tG");//meaning: West&East Turn Green
                    }
                    case "turn_yellow" -> {
                        MinecraftClient.getInstance().getItemRenderer().renderItem(STACK_YELLOW, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                    }
                    case "turn_airG" -> {
                        this.renderTexts(blockEntity, controlBox,dir, matrices, vertexConsumers, 0,"3tG");//meaning: West&East Turn Green
                    }
                    case "turn_redE"-> {//ending red
                        MinecraftClient.getInstance().getItemRenderer().renderItem(STACK_RED, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                    }
                    case "disabled"->{}
                    default -> {//and red
                        MinecraftClient.getInstance().getItemRenderer().renderItem(STACK_RED, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                        this.renderTexts(blockEntity, controlBox, dir,matrices, vertexConsumers, 2,"3tR");//meaning: West&East Turn Red
                    }
                }
            }

        }
    }
    private void renderTexts(TrafficLightLeftTurnEntity blockEntity,TrafficLightsControlEntity controlBox,Direction dir,MatrixStack matrices, VertexConsumerProvider vertexConsumers,int colorType,String dirType){
        if(blockEntity.getWorld().getBlockState(blockEntity.getPos()).get(hasTimer)){
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180));
            String timeLeft = TrafficLightsControlEntity.getTimeLeft(controlBox,dirType);
            matrices.translate(0, -0.2f, 0);
            matrices.translate(0f, 0f, 0.1f);
            if (timeLeft.contains("11")) matrices.translate(-0.037f, 0f, 0f);
            else if (timeLeft.contains("1")) matrices.translate(-0.017f, 0f, 0f);
            matrices.scale(0.015f, 0.015F, 0.015f);
            switch (colorType) {
                case 0 -> this.textRenderer.draw(new LiteralText(timeLeft).setStyle(DIGIT7_STYLE), (float) -(this.textRenderer.getWidth(timeLeft)), 0F, 0x00ff33, false, matrices.peek().getModel(), vertexConsumers, false, 0, 15728880);
                case 1 -> this.textRenderer.draw(new LiteralText(timeLeft).setStyle(DIGIT7_STYLE), (float) -(this.textRenderer.getWidth(timeLeft)), 0F, 0xffcc00, false, matrices.peek().getModel(), vertexConsumers, false, 0, 15728880);
                case 2 -> this.textRenderer.draw(new LiteralText(timeLeft).setStyle(DIGIT7_STYLE), (float) -(this.textRenderer.getWidth(timeLeft)), 0F, 0xff0000, false, matrices.peek().getModel(), vertexConsumers, false, 0, 15728880);
            }
        }

    }


}
