package io.github.aftersans53228.aft_fabroads.block.pillarblock;

import io.github.aftersans53228.aft_fabroads.block.voxelshapes.PillarShapes;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class VerticalStraightPillarThin extends Block {

    public VerticalStraightPillarThin() {
        super(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).hardness(1.5f).nonOpaque());
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
            return PillarShapes.getVerticalStraightThinShape();
    }
}