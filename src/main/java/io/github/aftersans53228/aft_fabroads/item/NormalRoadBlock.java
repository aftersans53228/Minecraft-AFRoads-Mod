package io.github.aftersans53228.aft_fabroads.item;

import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static io.github.aftersans53228.aft_fabroads.registry.AFRoadsItemRegistry.RoadBlockItem;

public class NormalRoadBlock {
    public static ItemGroup get() {
        return ITEM_GROUP;
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(AFRoadsStatics.MOD_ID, "normal_road_blocks"))
            .icon(() -> new ItemStack(RoadBlockItem))
            .displayName(Text.translatable("itemGroup.aft_fabroads.normal_road_blocks"))
            .build();
}
