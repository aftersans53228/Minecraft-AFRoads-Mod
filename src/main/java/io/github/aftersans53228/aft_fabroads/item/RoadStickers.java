package io.github.aftersans53228.aft_fabroads.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import static io.github.aftersans53228.aft_fabroads.registry.AFRoadsItemRegistry.*;

public class RoadStickers {
    public static ItemGroup get() {
        return ITEM_GROUP;
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ArrowForwardItem))
            .displayName(Text.translatable("itemGroup.aft_fabroads.road_stickers"))
            .entries(((context, entries) -> {
                entries.add(new ItemStack(LineStraightItem));
                entries.add(new ItemStack(LineCornerItem));
                entries.add(new ItemStack(LineTshapedItem));
                entries.add(new ItemStack(LineCrossItem));
                entries.add(new ItemStack(LineDiagonalItem));
                entries.add(new ItemStack(LineLeftBendItem));
                entries.add(new ItemStack(LineRightBendItem));
                entries.add(new ItemStack(LineForkLeftItem));
                entries.add(new ItemStack(LineForkRightItem));
                entries.add(new ItemStack(LineStraightThickItem));
                entries.add(new ItemStack(LineStraightDuoLineItem));
                entries.add(new ItemStack(LineStraightDuoThickItem));
                entries.add(new ItemStack(LineStraightDuoThickDashedItem));
                entries.add(new ItemStack(LineDecelerateNoLineItem));
                entries.add(new ItemStack(LineDecelerateNoLineFlipItem));
                entries.add(new ItemStack(LineDecelerateWithLineItem));
                entries.add(new ItemStack(LineDecelerateWithLineFlipItem));
                entries.add(new ItemStack(LineDecelerateDoubleWLItem));
                entries.add(new ItemStack(LineDecelerateDoubleNLItem));
                entries.add(new ItemStack(LineReversibleLanesItem));
                entries.add(new ItemStack(LineReversibleLanesFlipItem));
                entries.add(new ItemStack(LineReversibleLanesDoubleItem));

                entries.add(new ItemStack(ArrowForwardItem));
                entries.add(new ItemStack(ArrowLeftItem));
                entries.add(new ItemStack(ArrowRightItem));
                entries.add(new ItemStack(ArrowForwardLeftItem));
                entries.add(new ItemStack(ArrowForwardRightItem));
                entries.add(new ItemStack(ArrowLeftRightItem));
                entries.add(new ItemStack(ArrowBackItem));
                entries.add(new ItemStack(ArrowBackLeftItem));
                entries.add(new ItemStack(ArrowBackForwardItem));
                entries.add(new ItemStack(ArrowConfluenceLeftItem));
                entries.add(new ItemStack(ArrowConfluenceRightItem));

                entries.add(new ItemStack(IconDecelerateStickerItem));
                entries.add(new ItemStack(IconStopStickerItem));
            }))
            .build();
}
