package io.github.aftersans53228.aft_fabroads.item;

import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.TrafficLightItem;

public class RoadDecoration {
    public static ItemGroup get() {
        return ITEM_GROUP;
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(AFRoadsStatics.MOD_ID,"road_decoration"))
            .icon(() -> new ItemStack(TrafficLightItem))
            .displayName(Text.translatable("itemGroup.aft_fabroads.road_decoration"))
            .build();
}

