package io.github.aftersans53228.aft_fabroads.render;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightEntity;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightsControlEntity;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;

import static net.minecraft.util.math.Direction.*;

@Environment(EnvType.CLIENT)
public class TrafficLightEntityRender implements BlockEntityRenderer<TrafficLightEntity> {
    //获得物品stack
    private static final ItemStack STACK_RED = new ItemStack(AFRoadsItemRegistry.TrafficLightBulbRed, 1);
    private static final ItemStack STACK_GREEN = new ItemStack(AFRoadsItemRegistry.TrafficLightBulbGreen, 1);
    private static final ItemStack STACK_YELLOW = new ItemStack(AFRoadsItemRegistry.TrafficLightBulbYellow, 1);
    private final TextRenderer textRenderer;


    public TrafficLightEntityRender(BlockEntityRendererFactory.Context ctx) {
        this.textRenderer = ctx.getTextRenderer();
    }

    @Override
    public void render(TrafficLightEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        //GL 拉取
        matrices.push();
        //选择渲染类型,标记
        logicProgram:
        if(blockEntity.getWorld() !=  null) {//world is not NULL
            TrafficLightsControlEntity controlBox;
            //设置坐标
            matrices.translate(0.5, 0.5, 0.5);
            //设置旋转
            Direction dir =blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING);
            if (dir==SOUTH){
                matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180));
            }
            else if (dir==NORTH){
                matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(0));
            }
            else if (dir==EAST){
                matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(270));
            }
            else if (dir==WEST){
                matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90));
            }
            else{
                AFRoads.LOGGER.info("Unexpected traffic light orientation state.");
                matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(0));
            }
            if (blockEntity.getControlBoxPos() != null) {
                controlBox = (TrafficLightsControlEntity) blockEntity.getWorld().getBlockEntity(blockEntity.getControlBoxPos());

            } else {
                break logicProgram;
            }
            if (controlBox != null) {
                switch (dir) {
                    case SOUTH, NORTH -> {
                        String type = controlBox.getLightType("NS");
                        switch (type) {
                            case "forward_green" ->
                                    MinecraftClient.getInstance().getItemRenderer().renderItem(STACK_GREEN, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                            case "forward_yellow" ->
                                    MinecraftClient.getInstance().getItemRenderer().renderItem(STACK_YELLOW, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                            case "forward_air", "disabled" -> {
                                    break logicProgram;
                            }
                            default -> //and red
                                    MinecraftClient.getInstance().getItemRenderer().renderItem(STACK_RED, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                        }
                    }
                    case EAST, WEST -> {
                        String type = controlBox.getLightType("WE");
                        switch (type) {
                            case "forward_green" ->
                                    MinecraftClient.getInstance().getItemRenderer().renderItem(STACK_GREEN, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                            case "forward_yellow" ->
                                    MinecraftClient.getInstance().getItemRenderer().renderItem(STACK_YELLOW, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                            case "forward_air", "disabled" -> {
                                    break logicProgram;
                            }
                            default -> //and red
                                    MinecraftClient.getInstance().getItemRenderer().renderItem(STACK_RED, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                        }
                    }

                }
                String timeLeft = controlBox.getTimeLeft();
                final int lightAbove = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos().up());
                this.textRenderer.draw(timeLeft, (float) -(this.textRenderer.getWidth(timeLeft)) / 2, 0F, 0xFFFFFF, false, matrices.peek().getModel(), vertexConsumers, false, 0, lightAbove);
            }
        }
        else{
            MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(Items.BARRIER), ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
        }

        //结束程序，弹出GL
        matrices.pop();
    }


}
