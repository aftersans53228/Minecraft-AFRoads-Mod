package io.github.aftersans53228.aft_fabroads.item;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class NormalRoadBlock {
    public static ItemGroup get() {
        return ITEM_GROUP;
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("aft_fabroads", "normal_road_blocks"))
            .icon(() -> new ItemStack(AFRoads.RoadBlock))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(AFRoads.RoadBlock));
                stacks.add(new ItemStack(AFRoads.RoadBlockConcrete));
                stacks.add(new ItemStack(AFRoads.ManholeCover));
                stacks.add(new ItemStack(AFRoads.ManholeCoverConcrete));
                stacks.add(new ItemStack(AFRoads.RoadSeamsBlock));
                stacks.add(new ItemStack(AFRoads.RoadSeamsBlockConcrete));
                stacks.add(new ItemStack(AFRoads.ConcreteSlab));
                stacks.add(new ItemStack(AFRoads.ConcreteStairs));
                stacks.add(new ItemStack(AFRoads.ConcreteStairsSmooth));
                stacks.add(new ItemStack(AFRoads.ConcreteColumnsCorner));
            })
            .build();
}
