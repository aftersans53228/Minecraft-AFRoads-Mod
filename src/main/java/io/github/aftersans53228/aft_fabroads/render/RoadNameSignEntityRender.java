package io.github.aftersans53228.aft_fabroads.render;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.block.RoadLightEntity;
import io.github.aftersans53228.aft_fabroads.block.RoadNameSignEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Vec3f;

import static net.minecraft.util.math.Direction.*;
import static net.minecraft.util.math.Direction.WEST;

@Environment(EnvType.CLIENT)
public class RoadNameSignEntityRender implements BlockEntityRenderer<RoadNameSignEntity> {

    private final TextRenderer textRenderer;
    public RoadNameSignEntityRender(BlockEntityRendererFactory.Context ctx) {
        this.textRenderer = ctx.getTextRenderer();
    }
    @Override
    public void render(RoadNameSignEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        //获取路牌属性
        String roadName =entity.getRoadNames().get(0);
        String roadName2rd=entity.getRoadNames().get(1);
        Boolean dirLeft = entity.getCachedState().get(BooleanProperty.of("dir_left"));
        Boolean dirRight = entity.getCachedState().get(BooleanProperty.of("dir_right"));

        matrices.push();
        //设置坐标
        matrices.translate(0.5f,0.5f,0.5f);
        matrices.multiply(Vec3f.NEGATIVE_Z.getDegreesQuaternion(180));
        matrices.scale(0.04f,0.0375f,0);
        matrices.translate(0,0.60625f,1);

        //设置旋转
        /*
        if (entity.getCachedState().get(Properties.HORIZONTAL_FACING)==SOUTH){
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180));
        }
        else if (entity.getCachedState().get(Properties.HORIZONTAL_FACING) == NORTH) {
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(0));
        }
        else if (entity.getCachedState().get(Properties.HORIZONTAL_FACING) == EAST) {
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(270));
        }
        else if (entity.getCachedState().get(Properties.HORIZONTAL_FACING) == WEST) {
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90));
        }
        else {
            AFRoads.LOGGER.info("Unexpected road name sign orientation state.");
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(0));
        }
        */


        int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
        this.textRenderer.draw(roadName,0f,1,0xFFFFFF,false,matrices.peek().getModel(),vertexConsumers,false,0,lightAbove);

        matrices.pop();






    }
}
