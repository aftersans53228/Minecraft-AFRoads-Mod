package io.github.aftersans53228.aft_fabroads.render;

import io.github.aftersans53228.aft_fabroads.block.RoadNameSignEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.HorizontalFacingBlock;
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
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;

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
        if (true) {
            String roadName = entity.getRoadNames().get(0);
            String roadName2rd = entity.getRoadNames().get(1);
            Boolean dirLeft = entity.getCachedState().get(BooleanProperty.of("dir_left"));
            Boolean dirRight = entity.getCachedState().get(BooleanProperty.of("dir_right"));
            String leftDir;
            String rightDir;

            int lightAbove =15728880;
            if (entity.getWorld()!=null){
                lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
            }

            //中文渲染1
            matrices.push();
            matrices.translate(0f, 0.89f, 0f);
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
            int strLenHalved = this.textRenderer.getWidth(roadName);
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(facing.asRotation()));
            //System.out.println(facing);
            //System.out.println(facing.asRotation());
            switch (facing) {
                case NORTH -> matrices.translate(0.5f, 0f, -0.55f);
                case SOUTH -> matrices.translate(-0.5f, 0f, 0.45f);
                case EAST -> matrices.translate(0.5f, 0f, 0.45f);
                case WEST -> matrices.translate(-0.5f, 0f, -0.55f);
            }
            //MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(Items.BARRIER), ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);

            matrices.scale(0.032f, 0.032F, 0.032f);
            this.textRenderer.draw(roadName, (float) (-strLenHalved) / 2, 0F, 0xFFFFFF, false, matrices.peek().getModel(), vertexConsumers, false, 0, lightAbove);
            matrices.pop();

            //中文渲染2
            matrices.push();
            matrices.translate(0f, 0.89f, 0f);
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(facing.asRotation() - 180));
            //System.out.println(facing);
            //System.out.println(facing.asRotation());
            switch (facing) {
                case SOUTH -> matrices.translate(0.5f, 0f, -0.55f);
                case NORTH -> matrices.translate(-0.5f, 0f, 0.45f);
                case WEST -> matrices.translate(0.5f, 0f, 0.45f);
                case EAST -> matrices.translate(-0.5f, 0f, -0.55f);
            }
            matrices.scale(0.032f, 0.032F, 0.032f);
            this.textRenderer.draw(roadName, (float) (-strLenHalved) / 2, 0F, 0xFFFFFF, false, matrices.peek().getModel(), vertexConsumers, false, 0, lightAbove);
            matrices.pop();

            //中文渲染方向1.1
            matrices.push();
            matrices.translate(0f, 0.85f, 0f);
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(facing.asRotation()));
            //System.out.println(facing);
            //System.out.println(facing.asRotation());
            switch (facing) {
                case SOUTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    leftDir = "东";
                }
                case NORTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "西";
                }
                case WEST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    leftDir = "南";
                }
                case EAST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    leftDir = "北";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "?";
                }
            }
            if (dirLeft) {
                matrices.translate(-1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(-1f,0f,0f);
                case WEST ->matrices.translate(-1f,0f,0f);
                case NORTH->matrices.translate(-1f,0f,0f);
                case EAST -> matrices.translate(-1f,0f,0f);
            }
             */
                matrices.scale(0.02f, 0.02F, 0.02f);
                this.textRenderer.draw(leftDir, (float) -(this.textRenderer.getWidth(leftDir)) / 2, 0F, 0xFFFFFF, false, matrices.peek().getModel(), vertexConsumers, false, 0, lightAbove);
            }
            else {
                matrices.translate(-1f, 0.08f, 0.02f);
                matrices.scale(0.5f, 0.5F, 0.5f);
                MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(Items.BARRIER), ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
            }
            matrices.pop();

            //中文渲染方向1.2
            matrices.push();
            matrices.translate(0f, 0.85f, 0f);
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(facing.asRotation()));
            //System.out.println(facing);
            //System.out.println(facing.asRotation());
            switch (facing) {
                case SOUTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    rightDir = "西";
                }
                case NORTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "东";
                }
                case WEST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    rightDir = "北";
                }
                case EAST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    rightDir = "南";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "?";
                }
            }
            if (dirRight) {
                matrices.translate(1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(1f,0f,0f);
                case WEST ->matrices.translate(1f,0f,0f);
                case NORTH->matrices.translate(1f,0f,0f);
                case EAST -> matrices.translate(1f,0f,0f);
            }

             */
                matrices.scale(0.02f, 0.02F, 0.02f);
                this.textRenderer.draw(rightDir, (float) -(this.textRenderer.getWidth(rightDir)) / 2, 0F, 0xFFFFFF, false, matrices.peek().getModel(), vertexConsumers, false, 0, lightAbove);
            }
            else {
                matrices.translate(1f, 0.08f, 0.02f);
                matrices.scale(0.5f, 0.5F, 0.5f);
                MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(Items.BARRIER), ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
            }
            matrices.pop();

            //中文渲染方向2.1
            matrices.push();
            matrices.translate(0f, 0.85f, 0f);
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(facing.asRotation() - 180));
            //System.out.println(facing);
            //System.out.println(facing.asRotation());
            switch (facing) {
                case NORTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    leftDir = "西";
                }
                case SOUTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "东";
                }
                case EAST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    leftDir = "北";
                }
                case WEST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    leftDir = "南";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "?";
                }
            }
            if (dirLeft) {
                matrices.translate(1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(1f,0f,0f);
                case WEST ->matrices.translate(1f,0f,0f);
                case NORTH->matrices.translate(1f,0f,0f);
                case EAST -> matrices.translate(1f,0f,0f);
            }
             */
                matrices.scale(0.02f, 0.02F, 0.02f);
                this.textRenderer.draw(leftDir, (float) -(this.textRenderer.getWidth(leftDir)) / 2, 0F, 0xFFFFFF, false, matrices.peek().getModel(), vertexConsumers, false, 0, lightAbove);
            }
            else {
                matrices.translate(1f, 0.08f, 0.02f);
                matrices.scale(0.5f, 0.5F, 0.5f);
                MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(Items.BARRIER), ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
            }
            matrices.pop();

            //中文渲染方向2.2
            matrices.push();
            matrices.translate(0f, 0.85f, 0f);
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(facing.asRotation() - 180));
            //System.out.println(facing);
            //System.out.println(facing.asRotation());
            switch (facing) {
                case NORTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    rightDir = "东";
                }
                case SOUTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "西";
                }
                case EAST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    rightDir = "南";
                }
                case WEST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    rightDir = "北";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "?";
                }
            }
            if (dirRight) {
                matrices.translate(-1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(-1f,0f,0f);
                case WEST ->matrices.translate(-1f,0f,0f);
                case NORTH->matrices.translate(-1f,0f,0f);
                case EAST -> matrices.translate(-1f,0f,0f);
            }
            */
                matrices.scale(0.02f, 0.02F, 0.02f);
                this.textRenderer.draw(rightDir, (float) -(this.textRenderer.getWidth(rightDir)) / 2, 0F, 0xFFFFFF, false, matrices.peek().getModel(), vertexConsumers, false, 0, lightAbove);
            }
            else {
                matrices.translate(-1f, 0.08f, 0.02f);
                matrices.scale(0.5f, 0.5F, 0.5f);
                MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(Items.BARRIER), ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
            }
            matrices.pop();

            //英文渲染
            matrices.push();
            matrices.translate(0f, 0.53f, 0f);
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
            int Halved2 = this.textRenderer.getWidth(roadName2rd);
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(facing.asRotation()));
            //System.out.println(facing);
            //System.out.println(facing.asRotation());
            switch (facing) {
                case NORTH -> matrices.translate(0.5f, 0f, -0.55f);
                case SOUTH -> matrices.translate(-0.5f, 0f, 0.45f);
                case EAST -> matrices.translate(0.5f, 0f, 0.45f);
                case WEST -> matrices.translate(-0.5f, 0f, -0.55f);
            }
            //MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(Items.BARRIER), ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);

            matrices.scale(0.015f, 0.015F, 0.015f);
            this.textRenderer.draw(roadName2rd, (float) (-Halved2) / 2, 0F, 0x000000, false, matrices.peek().getModel(), vertexConsumers, false, 0, lightAbove);
            matrices.pop();

            //英文渲染2
            matrices.push();
            matrices.translate(0f, 0.53f, 0f);
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(facing.asRotation() - 180));
            //System.out.println(facing);
            //System.out.println(facing.asRotation());
            switch (facing) {
                case SOUTH -> matrices.translate(0.5f, 0f, -0.55f);
                case NORTH -> matrices.translate(-0.5f, 0f, 0.45f);
                case WEST -> matrices.translate(0.5f, 0f, 0.45f);
                case EAST -> matrices.translate(-0.5f, 0f, -0.55f);
            }
            matrices.scale(0.015f, 0.015F, 0.015f);
            this.textRenderer.draw(roadName2rd, (float) (-Halved2) / 2, 0F, 0x000000, false, matrices.peek().getModel(), vertexConsumers, false, 0, lightAbove);
            matrices.pop();

            //en渲染方向1.1
            matrices.push();
            matrices.translate(0f, 0.53f, 0f);
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(facing.asRotation()));
            //System.out.println(facing);
            //System.out.println(facing.asRotation());
            switch (facing) {
                case SOUTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    leftDir = "E";
                }
                case NORTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "W";
                }
                case WEST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    leftDir = "S";
                }
                case EAST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    leftDir = "N";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "?";
                }
            }
            if (dirLeft) {
                matrices.translate(-1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(-1f,0f,0f);
                case WEST ->matrices.translate(-1f,0f,0f);
                case NORTH->matrices.translate(-1f,0f,0f);
                case EAST -> matrices.translate(-1f,0f,0f);
            }
             */
                matrices.scale(0.017f, 0.017F, 0.017f);
                this.textRenderer.draw(leftDir, (float) -(this.textRenderer.getWidth(leftDir)) / 2, 0F, 0x000000, false, matrices.peek().getModel(), vertexConsumers, false, 0, lightAbove);
            }
            matrices.pop();
            //en渲染方向1.2
            matrices.push();
            matrices.translate(0f, 0.53f, 0f);
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(facing.asRotation()));
            //System.out.println(facing);
            //System.out.println(facing.asRotation());
            switch (facing) {
                case SOUTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    rightDir = "W";
                }
                case NORTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "E";
                }
                case WEST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    rightDir = "N";
                }
                case EAST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    rightDir = "S";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "?";
                }
            }
            if (dirRight) {
                matrices.translate(1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(1f,0f,0f);
                case WEST ->matrices.translate(1f,0f,0f);
                case NORTH->matrices.translate(1f,0f,0f);
                case EAST -> matrices.translate(1f,0f,0f);
            }

             */
                matrices.scale(0.017f, 0.017F, 0.017f);
                this.textRenderer.draw(rightDir, (float) -(this.textRenderer.getWidth(rightDir)) / 2, 0F, 0x000000, false, matrices.peek().getModel(), vertexConsumers, false, 0, lightAbove);
            }
            matrices.pop();

            //en渲染方向2.1
            matrices.push();
            matrices.translate(0f, 0.53f, 0f);
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(facing.asRotation() - 180));
            //System.out.println(facing);
            //System.out.println(facing.asRotation());
            switch (facing) {
                case NORTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    leftDir = "W";
                }
                case SOUTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "E";
                }
                case EAST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    leftDir = "N";
                }
                case WEST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    leftDir = "S";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    leftDir = "?";
                }
            }
            if (dirLeft) {
                matrices.translate(1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(1f,0f,0f);
                case WEST ->matrices.translate(1f,0f,0f);
                case NORTH->matrices.translate(1f,0f,0f);
                case EAST -> matrices.translate(1f,0f,0f);
            }
             */
                matrices.scale(0.017f, 0.017F, 0.017f);
                this.textRenderer.draw(leftDir, (float) -(this.textRenderer.getWidth(leftDir)) / 2, 0F, 0x000000, false, matrices.peek().getModel(), vertexConsumers, false, 0, lightAbove);
            }
            matrices.pop();
            //en渲染方向2.2
            matrices.push();
            matrices.translate(0f, 0.53f, 0f);
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(facing.asRotation() - 180));
            //System.out.println(facing);
            //System.out.println(facing.asRotation());
            switch (facing) {
                case NORTH -> {
                    matrices.translate(-0.5f, 0f, 0.45f);
                    rightDir = "E";
                }
                case SOUTH -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "W";
                }
                case EAST -> {
                    matrices.translate(-0.5f, 0f, -0.55f);
                    rightDir = "S";
                }
                case WEST -> {
                    matrices.translate(0.5f, 0f, 0.45f);
                    rightDir = "N";
                }
                default -> {
                    matrices.translate(0.5f, 0f, -0.55f);
                    rightDir = "?";
                }
            }
            if (dirRight) {
                matrices.translate(-1f, 0f, 0f);
            /*
            switch (facing){
                case SOUTH->matrices.translate(-1f,0f,0f);
                case WEST ->matrices.translate(-1f,0f,0f);
                case NORTH->matrices.translate(-1f,0f,0f);
                case EAST -> matrices.translate(-1f,0f,0f);
            }
            */
                matrices.scale(0.017f, 0.017F, 0.017f);
                this.textRenderer.draw(rightDir, (float) -(this.textRenderer.getWidth(rightDir)) / 2, 0F, 0x000000, false, matrices.peek().getModel(), vertexConsumers, false, 0, lightAbove);
            }
            matrices.pop();
        }
        else{
            matrices.push();
            matrices.translate(0f, 0.89f, 0f);
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(facing.asRotation()));
            //System.out.println(facing);
            //System.out.println(facing.asRotation());
            switch (facing) {
                case NORTH -> matrices.translate(0.5f, 0f, -0.55f);
                case SOUTH -> matrices.translate(-0.5f, 0f, 0.45f);
                case EAST -> matrices.translate(0.5f, 0f, 0.45f);
                case WEST -> matrices.translate(-0.5f, 0f, -0.55f);
            }
            matrices.scale(1.1f,1.1f,1.1f);
            MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(Items.BARRIER), ModelTransformation.Mode.GROUND, 15728880, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);

        }
    }
}
