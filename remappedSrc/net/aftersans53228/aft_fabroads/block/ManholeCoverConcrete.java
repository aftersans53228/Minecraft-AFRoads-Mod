package net.aftersans53228.aft_fabroads.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
 
import net.minecraft.world.BlockView;

import java.util.List;

public class ManholeCoverConcrete extends Block {
    public ManholeCoverConcrete() {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
    }
    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( Text.translatable("item.aft_fabroads.manhole") );
    }
}
