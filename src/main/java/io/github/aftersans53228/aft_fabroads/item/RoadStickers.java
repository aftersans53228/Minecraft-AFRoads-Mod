package io.github.aftersans53228.aft_fabroads.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.*;

public class RoadStickers {
    public static ItemGroup get() {
        return ITEM_GROUP;
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ArrowForwardItem))
            .displayName(Text.translatable("itemGroup.aft_fabroads.road_stickers"))
            .entries(((context, entries) -> {
                entries.add(new ItemStack(RoadBlockItem));
                entries.add(new ItemStack(RoadBlockConcreteItem));
                entries.add(new ItemStack(ManholeCoverItem));
                entries.add(new ItemStack(ManholeCoverConcreteItem));
                entries.add(new ItemStack(RoadSeamsBlockItem));
                entries.add(new ItemStack(RoadSeamsBlockConcreteItem));
                entries.add(new ItemStack(ConcreteSlabItem));
                entries.add(new ItemStack(ConcreteStairsItem));
                entries.add(new ItemStack(ConcreteStairsSmoothItem));
                entries.add(new ItemStack(ConcreteColumnsCornerItem));
            }))
            .build();
}
