package io.github.aftersans53228.aft_fabroads.item;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry.*;
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.*;

public class RoadStickers {
    public static ItemGroup get() {
        return ITEM_GROUP;
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("aft_fabroads", "road_stickers"))
            .icon(() -> new ItemStack(ArrowForwardItem))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(LineStraightItem));
                stacks.add(new ItemStack(LineCornerItem));
                stacks.add(new ItemStack(LineTshapedItem));
                stacks.add(new ItemStack(LineCrossItem));
                stacks.add(new ItemStack(LineDiagonalItem));
                stacks.add(new ItemStack(LineLeftBendItem));
                stacks.add(new ItemStack(LineRightBendItem));
                stacks.add(new ItemStack(LineForkLeftItem));
                stacks.add(new ItemStack(LineForkRightItem));
                stacks.add(new ItemStack(LineStraightThickItem));
                stacks.add(new ItemStack(LineStraightDuoLineItem));
                stacks.add(new ItemStack(LineStraightDuoThickItem));
                stacks.add(new ItemStack(LineStraightDuoThickDashedItem));
                stacks.add(new ItemStack(LineDecelerateNoLineItem));
                stacks.add(new ItemStack(LineDecelerateNoLineFlipItem));
                stacks.add(new ItemStack(LineDecelerateWithLineItem));
                stacks.add(new ItemStack(LineDecelerateWithLineFlipItem));
                stacks.add(new ItemStack(LineReversibleLanesItem));
                stacks.add(new ItemStack(LineReversibleLanesFlipItem));

                stacks.add(new ItemStack(ArrowForwardItem));
                stacks.add(new ItemStack(ArrowLeftItem));
                stacks.add(new ItemStack(ArrowRightItem));
                stacks.add(new ItemStack(ArrowForwardLeftItem));
                stacks.add(new ItemStack(ArrowForwardRightItem));
                stacks.add(new ItemStack(ArrowLeftRightItem));
                stacks.add(new ItemStack(ArrowBackItem));
                stacks.add(new ItemStack(ArrowBackLeftItem));
                stacks.add(new ItemStack(ArrowBackForwardItem));
                stacks.add(new ItemStack(ArrowConfluenceLeftItem));
                stacks.add(new ItemStack(ArrowConfluenceRightItem));

                stacks.add(new ItemStack(IconDecelerateStickerItem));
                stacks.add(new ItemStack(IconStopStickerItem));
            })
            .build();
}
