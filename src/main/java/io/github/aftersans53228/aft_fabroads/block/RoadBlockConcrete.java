package io.github.aftersans53228.aft_fabroads.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class RoadBlockConcrete extends Block {
    public RoadBlockConcrete() {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
    }
}
