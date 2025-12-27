package io.github.aftersans53228.aft_fabroads.render;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.block.RoadLight;
import io.github.aftersans53228.aft_fabroads.block.blockentites.RoadLightEntity;
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
import net.minecraft.util.math.Vec3f;

import static net.minecraft.util.math.Direction.*;

@Environment(EnvType.CLIENT)
public class RoadLightEntityRender implements BlockEntityRenderer<RoadLightEntity> {
    //获得物品stack
    private static final ItemStack ROAD_LIGHT_BULB_COLD = new ItemStack(AFRoadsItemRegistry.RoadLightBulbCold, 1);
    private static final ItemStack ROAD_LIGHT_BULB_WARM = new ItemStack(AFRoadsItemRegistry.RoadLightBulbWarm, 1);

    public RoadLightEntityRender(BlockEntityRendererFactory.Context ctx) {}
    @Override
    public void render(RoadLightEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        //调用GL
        matrices.push();
        //设置坐标
        matrices.translate(0.5, 0.5, 0.5);
        //设置旋转
        if (blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING)==SOUTH){
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180));
        }
        else if (blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING)==NORTH){
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(0));
        }
        else if (blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING)==EAST){
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(270));
        }
        else if (blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING)==WEST){
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90));
        }
        else{
            AFRoads.LOGGER.info("Unexpected road light orientation state.");
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(0));
        }
        //选择渲染类型
            if (blockEntity.getCachedState().get(RoadLight.LightType)==0){
                MinecraftClient.getInstance().getItemRenderer().renderItem(ROAD_LIGHT_BULB_COLD, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
            }
            else{
                MinecraftClient.getInstance().getItemRenderer().renderItem(ROAD_LIGHT_BULB_WARM, ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
            }

        //GL拜拜了您内
        matrices.pop();
    }

}

