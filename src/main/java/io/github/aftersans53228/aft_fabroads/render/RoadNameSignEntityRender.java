package io.github.aftersans53228.aft_fabroads.render;

import io.github.aftersans53228.aft_fabroads.block.blockentites.RoadNameSignEntity;
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
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class RoadNameSignEntityRender implements BlockEntityRenderer<RoadNameSignEntity> {

    private final TextRenderer textRenderer;
    public RoadNameSignEntityRender(BlockEntityRendererFactory.Context ctx) {
        this.textRenderer = ctx.getTextRenderer();
    }
    // 方向映射表
    private static final Map<Direction, Map<String, String>> DIRECTION_MAP = Map.of(
            Direction.NORTH, Map.of(
                    "left_1st", "西", "right_1st", "东",
                    "left_2nd", "W", "right_2nd", "E",
                    "back_left_1st", "西", "back_right_1st", "东",
                    "back_left_2nd", "W", "back_right_2nd", "E"
            ),
            Direction.SOUTH, Map.of(
                    "left_1st", "东", "right_1st", "西",
                    "left_2nd", "E", "right_2nd", "W",
                    "back_left_1st", "东", "back_right_1st", "西",
                    "back_left_2nd", "E", "back_right_2nd", "W"
            ),
            Direction.EAST, Map.of(
                    "left_1st", "北", "right_1st", "南",
                    "left_2nd", "N", "right_2nd", "S",
                    "back_left_1st", "北", "back_right_1st", "南",
                    "back_left_2nd", "N", "back_right_2nd", "S"
            ),
            Direction.WEST, Map.of(
                    "left_1st", "南", "right_1st", "北",
                    "left_2nd", "S", "right_2nd", "N",
                    "back_left_1st", "南", "back_right_1st", "北",
                    "back_left_2nd", "S", "back_right_2nd", "N"
            )
    );
    @Override
    public void render(RoadNameSignEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        final Direction facing = entity.getCachedState().get(HorizontalFacingBlock.FACING);
        String roadName = entity.getRoadNames().get(0);
        String roadName2rd = entity.getRoadNames().get(1);
        Boolean dirLeft = entity.getCachedState().get(BooleanProperty.of("dir_left"));
        Boolean dirRight = entity.getCachedState().get(BooleanProperty.of("dir_right"));
        // 渲染中文主文本
        renderTextLayer(matrices, vertexConsumers, roadName, facing, false, 0.89f, 0.032f, 0xFFFFFF, light);
        renderTextLayer(matrices, vertexConsumers, roadName, facing, true, 0.89f, 0.032f, 0xFFFFFF, light);
        // 渲染方向指示器（中文）
        renderDirectionIndicator(matrices, vertexConsumers, facing, dirLeft, "left_1st", false, false, 0.85f, 0.02f, 0xFFFFFF, light);
        renderDirectionIndicator(matrices, vertexConsumers, facing, dirRight, "right_1st", true, false, 0.85f, 0.02f, 0xFFFFFF, light);
        renderDirectionIndicator(matrices, vertexConsumers, facing, dirLeft, "back_left_1st", false, true, 0.85f, 0.02f, 0xFFFFFF, light);
        renderDirectionIndicator(matrices, vertexConsumers, facing, dirRight, "back_right_1st", true, true, 0.85f, 0.02f, 0xFFFFFF, light);
        // 渲染英文文本
        renderTextLayer(matrices, vertexConsumers, roadName2rd, facing, false, 0.54f, 0.015f, 0x000000, light);
        renderTextLayer(matrices, vertexConsumers, roadName2rd, facing, true, 0.54f, 0.015f, 0x000000, light);
        // 渲染方向指示器（英文）
        renderDirectionIndicator(matrices, vertexConsumers, facing, dirLeft, "left_2nd", false, false, 0.54f, 0.017f, 0x000000, light);
        renderDirectionIndicator(matrices, vertexConsumers, facing, dirRight, "right_2nd", true, false, 0.54f, 0.017f, 0x000000, light);
        renderDirectionIndicator(matrices, vertexConsumers, facing, dirLeft, "back_left_2nd", false, true, 0.54f, 0.017f, 0x000000, light);
        renderDirectionIndicator(matrices, vertexConsumers, facing, dirRight, "back_right_2nd", true, true, 0.54f, 0.017f, 0x000000, light);
    }
    // 渲染文本层（主路名）
    private void renderTextLayer(MatrixStack matrices, VertexConsumerProvider vertexConsumers, String text, Direction facing, boolean isBackFace, float yOffset, float scale, int color, int light) {
        matrices.push();
        matrices.translate(0f, yOffset, 0f);
        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
        float rotation = facing.asRotation() + (isBackFace ? -180 : 0);
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(rotation));
        // 设置位置偏移
        switch (facing) {
            case NORTH -> matrices.translate(isBackFace ? -0.5f : 0.5f, 0f, isBackFace ? 0.46f : -0.54f);
            case SOUTH -> matrices.translate(isBackFace ? 0.5f : -0.5f, 0f, isBackFace ? -0.54f : 0.46f);
            case EAST -> matrices.translate(isBackFace ? -0.5f : 0.5f, 0f, isBackFace ? -0.54f : 0.46f);
            case WEST -> matrices.translate(isBackFace ? 0.5f : -0.5f, 0f, isBackFace ? 0.46f : -0.54f);
        }
        matrices.scale(scale, scale, scale);
        int textWidth = textRenderer.getWidth(text);
        textRenderer.draw(new LiteralText(text),
                (float) -textWidth / 2, 0f, color, false, matrices.peek().getModel(), vertexConsumers, false, 0, light
        );
        matrices.pop();
    }

    // 渲染方向指示器
    private void renderDirectionIndicator(MatrixStack matrices, VertexConsumerProvider vertexConsumers, Direction facing, boolean isEnabled, String directionKey, boolean isRightSide, boolean isBackFace, float yOffset, float scale, int color, int light) {
        matrices.push();
        matrices.translate(0f, yOffset, 0f);
        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));

        float rotation = facing.asRotation() + (isBackFace ? -180 : 0);
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(rotation));
        // 设置基础位置
        switch (facing) {
            case NORTH -> matrices.translate(isBackFace ? -0.5f : 0.5f, 0f, isBackFace ? 0.46f : -0.54f);
            case SOUTH -> matrices.translate(isBackFace ? 0.5f : -0.5f, 0f, isBackFace ? -0.54f : 0.46f);
            case EAST -> matrices.translate(isBackFace ? -0.5f : 0.5f, 0f, isBackFace ? -0.54f : 0.46f);
            case WEST -> matrices.translate(isBackFace ? 0.5f : -0.5f, 0f, isBackFace ? 0.46f : -0.54f);
        }
        // 设置左右偏移
        float xOffset = isRightSide ? 1f : -1f;
        if (isBackFace) {
            xOffset *= -1; // 背面方向反转
        }
        matrices.translate(xOffset, 0f, 0f);
        if (isEnabled) {
            // 渲染方向文本
            String directionText = DIRECTION_MAP.get(facing).get(directionKey);
            matrices.scale(scale, scale, scale);
            int textWidth = textRenderer.getWidth(directionText);
            textRenderer.draw(new LiteralText(directionText),
                    (float) -textWidth / 2, 0f, color, false, matrices.peek().getModel(), vertexConsumers, false, 0, light
            );
        }
        else {
            // 渲染无方向时屏障图标
            if (directionKey.contains("1st")) {
                matrices.translate(0f, 0.08f, 0.012f);
                matrices.scale(0.3f, 0.3f, 0.3f);
                MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(Items.BARRIER), ModelTransformation.Mode.GROUND, light, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
            }
        }
        
        matrices.pop();
    }
}