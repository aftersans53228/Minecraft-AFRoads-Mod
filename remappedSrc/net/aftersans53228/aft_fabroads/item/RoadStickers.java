package net.aftersans53228.aft_fabroads.item;

import net.aftersans53228.aft_fabroads.FabroadsMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class RoadStickers {
    public static ItemGroup get() {
        return ITEM_GROUP;
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("aft_fabroads", "road_stickers"))
            .icon(() -> new ItemStack(FabroadsMod.LineStraight))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(FabroadsMod.LineStraight));
                stacks.add(new ItemStack(FabroadsMod.LineCorner));
                stacks.add(new ItemStack(FabroadsMod.LineTshaped));
                stacks.add(new ItemStack(FabroadsMod.LineCross));
                stacks.add(new ItemStack(FabroadsMod.LineDiagonal));
                stacks.add(new ItemStack(FabroadsMod.LineLeftBend));
                stacks.add(new ItemStack(FabroadsMod.LineRightBend));
                stacks.add(new ItemStack(FabroadsMod.LineForkLeft));
                stacks.add(new ItemStack(FabroadsMod.LineForkRight));
                stacks.add(new ItemStack(FabroadsMod.LineStraightThick));

                stacks.add(new ItemStack(FabroadsMod.ArrowForward));
                stacks.add(new ItemStack(FabroadsMod.ArrowLeft));
                stacks.add(new ItemStack(FabroadsMod.ArrowRight));
                stacks.add(new ItemStack(FabroadsMod.ArrowForwardLeft));
                stacks.add(new ItemStack(FabroadsMod.ArrowForwardRight));
                stacks.add(new ItemStack(FabroadsMod.ArrowLeftRight));
                stacks.add(new ItemStack(FabroadsMod.ArrowBack));
                stacks.add(new ItemStack(FabroadsMod.ArrowBackLeft));
                stacks.add(new ItemStack(FabroadsMod.ArrowBackForward));
                stacks.add(new ItemStack(FabroadsMod.ArrowConfluenceLeft));
                stacks.add(new ItemStack(FabroadsMod.ArrowConfluenceRight));
            })
            .build();
}
