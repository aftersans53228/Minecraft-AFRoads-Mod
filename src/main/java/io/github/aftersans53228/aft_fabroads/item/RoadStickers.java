package io.github.aftersans53228.aft_fabroads.item;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class RoadStickers {
    public static ItemGroup get() {
        return ITEM_GROUP;
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("aft_fabroads", "road_stickers"))
            .icon(() -> new ItemStack(AFRoads.ArrowForward))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(AFRoads.LineStraight));
                stacks.add(new ItemStack(AFRoads.LineCorner));
                stacks.add(new ItemStack(AFRoads.LineTshaped));
                stacks.add(new ItemStack(AFRoads.LineCross));
                stacks.add(new ItemStack(AFRoads.LineDiagonal));
                stacks.add(new ItemStack(AFRoads.LineLeftBend));
                stacks.add(new ItemStack(AFRoads.LineRightBend));
                stacks.add(new ItemStack(AFRoads.LineForkLeft));
                stacks.add(new ItemStack(AFRoads.LineForkRight));
                stacks.add(new ItemStack(AFRoads.LineStraightThick));
                stacks.add(new ItemStack(AFRoads.LineStraightDuoLine));
                stacks.add(new ItemStack(AFRoads.LineStraightDuoThick));
                stacks.add(new ItemStack(AFRoads.LineStraightDuoThickDashed));
                stacks.add(new ItemStack(AFRoads.LineDecelerateNoLine));
                stacks.add(new ItemStack(AFRoads.LineDecelerateNoLineFlip));
                stacks.add(new ItemStack(AFRoads.LineDecelerateWithLine));
                stacks.add(new ItemStack(AFRoads.LineDecelerateWithLineFlip));

                stacks.add(new ItemStack(AFRoads.ArrowForward));
                stacks.add(new ItemStack(AFRoads.ArrowLeft));
                stacks.add(new ItemStack(AFRoads.ArrowRight));
                stacks.add(new ItemStack(AFRoads.ArrowForwardLeft));
                stacks.add(new ItemStack(AFRoads.ArrowForwardRight));
                stacks.add(new ItemStack(AFRoads.ArrowLeftRight));
                stacks.add(new ItemStack(AFRoads.ArrowBack));
                stacks.add(new ItemStack(AFRoads.ArrowBackLeft));
                stacks.add(new ItemStack(AFRoads.ArrowBackForward));
                stacks.add(new ItemStack(AFRoads.ArrowConfluenceLeft));
                stacks.add(new ItemStack(AFRoads.ArrowConfluenceRight));
            })
            .build();
}
