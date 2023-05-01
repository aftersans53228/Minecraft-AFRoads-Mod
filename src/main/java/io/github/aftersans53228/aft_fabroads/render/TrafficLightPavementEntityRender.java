package io.github.aftersans53228.aft_fabroads.render;

import io.github.aftersans53228.aft_fabroads.block.TrafficLightPavementEntity;
import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.block.TrafficLightPavement;
import io.github.aftersans53228.aft_fabroads.item.RoadTool;
import io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Vec3f;

import static net.minecraft.util.math.Direction.*;


public class TrafficLightPavementEntityRender implements BlockEntityRenderer<TrafficLightPavementEntity> {
    //获得物品stack
    private static final ItemStack stackRed = new ItemStack(AFRoadsItemRegistry.TrafficLightPavementBulbRed, 1);
    private static final ItemStack stackGreen = new ItemStack(AFRoadsItemRegistry.TrafficLightPavementBulbGreen, 1);


    public TrafficLightPavementEntityRender(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(TrafficLightPavementEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        /*
        //测试用1
        FabroadsMod.LOGGER.info(blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING));
        FabroadsMod.LOGGER.info(blockEntity.getCachedState().get(TrafficLightPavement.TrafficType));
         */
        /*
        //测试用2
        System.out.println(blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING));
        System.out.println(blockEntity.getCachedState().get(TrafficLightPavement.TrafficType));
        */

        //调用GL
        matrices.push();
        //设置坐标
        matrices.translate(0.5, 0.5, 0.5);
        //设置旋转
        if (blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING)==SOUTH){
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180));
        }
        else{
            if (blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING)==NORTH){
                matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(0));
            }
            else{
                if (blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING)==EAST){
                    matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(270));
                }
                else{
                    if (blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING)==WEST){
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90));
                    }
                    else{
                        AFRoads.LOGGER.info("Unexpected traffic light orientation state.");
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(0));
                    }
                }
            }
        }
        //选择渲染类型
        if (blockEntity.getCachedState().get(TrafficLightPavement.TrafficType)==0){
            MinecraftClient.getInstance().getItemRenderer().renderItem(stackRed, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
        }
        else{
            if (blockEntity.getCachedState().get(TrafficLightPavement.TrafficType)==1){
                MinecraftClient.getInstance().getItemRenderer().renderItem(stackRed, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
            }
            else{
                if (blockEntity.getCachedState().get(TrafficLightPavement.TrafficType)==2){
                    MinecraftClient.getInstance().getItemRenderer().renderItem(stackGreen, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                }
                else{
                    AFRoads.LOGGER.info("Unexpected traffic light color state.");
                    MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(new RoadTool(),1), ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                }
            }
        }

        //GL拜拜了您内
        matrices.pop();
    }


}
