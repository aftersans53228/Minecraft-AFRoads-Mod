package io.github.aftersans53228.aft_fabroads.render;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.block.RoadLightEntity;
import io.github.aftersans53228.aft_fabroads.block.RoadNameSignEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
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
        //Content
        final Direction facing = entity.getCachedState().get(HorizontalFacingBlock.FACING);
        //获取路牌属性
        String roadName =entity.getRoadNames().get(0);
        String roadName2rd=entity.getRoadNames().get(1);
        Boolean dirLeft = entity.getCachedState().get(BooleanProperty.of("dir_left"));
        Boolean dirRight = entity.getCachedState().get(BooleanProperty.of("dir_right"));

        //1
        matrices.push();
        int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
        matrices.translate(0f,0f,0f) ;
        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));

        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(facing.asRotation()));
        //System.out.println(facing);
        //System.out.println(facing.asRotation());
        matrices.scale(0.04F,0.04F,0.04F);



        int strLenHalved = this.textRenderer.getWidth(roadName);
        this.textRenderer.draw(roadName,-strLenHalved,0F,0xFFFFFF,false,matrices.peek().getModel(),vertexConsumers,false,0,lightAbove);
        matrices.pop();






    }
}
