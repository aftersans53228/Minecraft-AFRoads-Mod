package io.github.aftersans53228.aft_fabroads.block.pillarblock;

import io.github.aftersans53228.aft_fabroads.block.voxelshapes.PBase;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class PillarBase extends Block {
    public PillarBase() {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return PBase.getShape();
    }
}
