package io.github.aftersans53228.aft_fabroads.block.structureblock;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.StairsBlock;

public class ConcreteStairs extends StairsBlock {
    public ConcreteStairs() {
        super(Blocks.WHITE_CONCRETE.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).hardness(1.5f));
    }
}
