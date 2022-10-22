package net.aftersans53228.aft_fabroads.item;

import net.aftersans53228.aft_fabroads.FabroadsMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class NormalRoadBlock {
    public static ItemGroup get() {
        return ITEM_GROUP;
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("aft_fabroads", "normal_road_blocks"))
            .icon(() -> new ItemStack(FabroadsMod.RoadBlock))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(FabroadsMod.RoadBlock));
                stacks.add(new ItemStack(FabroadsMod.RoadBlockConcrete));
                stacks.add(new ItemStack(FabroadsMod.ManholeCover));
                stacks.add(new ItemStack(FabroadsMod.ManholeCoverConcrete));
                stacks.add(new ItemStack(FabroadsMod.RoadSeamsBlock));
                stacks.add(new ItemStack(FabroadsMod.RoadSeamsBlockConcrete));
            })
            .build();
}
