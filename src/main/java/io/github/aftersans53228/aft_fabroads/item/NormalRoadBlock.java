package io.github.aftersans53228.aft_fabroads.item;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry.*;
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.*;

public class NormalRoadBlock {
    public static ItemGroup get() {
        return ITEM_GROUP;
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("aft_fabroads", "normal_road_blocks"))
            .icon(() -> new ItemStack(RoadBlockItem))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(RoadBlockItem));
                stacks.add(new ItemStack(RoadBlockConcreteItem));
                stacks.add(new ItemStack(ManholeCoverItem));
                stacks.add(new ItemStack(ManholeCoverConcreteItem));
                stacks.add(new ItemStack(RoadSeamsBlockItem));
                stacks.add(new ItemStack(RoadSeamsBlockConcreteItem));
                stacks.add(new ItemStack(ConcreteSlabItem));
                stacks.add(new ItemStack(ConcreteStairsItem));
                stacks.add(new ItemStack(ConcreteStairsSmoothItem));
                stacks.add(new ItemStack(ConcreteColumnsCornerItem));
            })
            .build();
}
