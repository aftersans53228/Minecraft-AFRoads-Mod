package io.github.aftersans53228.aft_fabroads.render;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightEntity;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightsControlEntity;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;

import static net.minecraft.util.math.Direction.*;

@Environment(EnvType.CLIENT)
public class TrafficLightEntityRender implements BlockEntityRenderer<TrafficLightEntity> {
    //获得物品stack
    private static final ItemStack stackRed = new ItemStack(AFRoadsItemRegistry.TrafficLightBulbRed, 1);
    private static final ItemStack stackGreen = new ItemStack(AFRoadsItemRegistry.TrafficLightBulbGreen, 1);
    private static final ItemStack stackYellow = new ItemStack(AFRoadsItemRegistry.TrafficLightBulbYellow, 1);


    public TrafficLightEntityRender(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(TrafficLightEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        /*
        //测试用1
        FabroadsMod.LOGGER.info(blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING));
        FabroadsMod.LOGGER.info(blockEntity.getCachedState().get(TrafficLight.TrafficType));
         */
        /*
        //测试用2
        System.out.println(blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING));
        System.out.println(blockEntity.getCachedState().get(TrafficLight.TrafficType));
        */

        //调用GL
        matrices.push();
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
        //选择渲染类型
        if(blockEntity.getWorld()!=null) {
            TrafficLightsControlEntity controlBox;
            if(blockEntity.getControlBoxPos()!=null) {
                 controlBox= (TrafficLightsControlEntity) blockEntity.getWorld().getBlockEntity(blockEntity.getControlBoxPos());
            }
            else{
                controlBox =null;
            }
            if (controlBox != null) {
                switch (dir) {
                    case SOUTH, NORTH -> {
                        String type = controlBox.getLightType("NS");
                        switch (type) {
                            case "forward_green" ->
                                    MinecraftClient.getInstance().getItemRenderer().renderItem(stackGreen, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                            case "forward_red" ->
                                    MinecraftClient.getInstance().getItemRenderer().renderItem(stackRed, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                            case "forward_yellow", "disable" ->
                                    MinecraftClient.getInstance().getItemRenderer().renderItem(stackYellow, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                            default ->
                                    MinecraftClient.getInstance().getItemRenderer().renderItem(stackRed, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                        }
                    }
                    case EAST, WEST -> {
                        String type = controlBox.getLightType("WE");
                        switch (type) {
                            case "forward_green" ->
                                    MinecraftClient.getInstance().getItemRenderer().renderItem(stackGreen, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                            case "forward_red" ->
                                    MinecraftClient.getInstance().getItemRenderer().renderItem(stackRed, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                            case "forward_yellow", "disable" ->
                                    MinecraftClient.getInstance().getItemRenderer().renderItem(stackYellow, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                            default ->
                                    MinecraftClient.getInstance().getItemRenderer().renderItem(stackRed, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                        }
                    }

                }
            }
        }



        //GL拜拜了您内
        matrices.pop();
    }


}
