package net.aftersans53228.aft_fabroads.item;

import net.aftersans53228.aft_fabroads.FabroadsMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class RoadDecoration {
    public static ItemGroup get() {
        return ITEM_GROUP;
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("aft_fabroads", "road_decoration"))
            .icon(() -> new ItemStack(FabroadsMod.Railings))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(FabroadsMod.Railings));
                stacks.add(new ItemStack(FabroadsMod.BarrierBar));
                stacks.add(new ItemStack(FabroadsMod.PavementRailings));
                stacks.add(new ItemStack(FabroadsMod.ExpresswayRailingsBase));
                stacks.add(new ItemStack(FabroadsMod.ExpresswayRailings));
                stacks.add(new ItemStack(FabroadsMod.ExpresswayRailingsType2));
                stacks.add(new ItemStack(FabroadsMod.InsulationPanelsRailings));
                stacks.add(new ItemStack(FabroadsMod.TrafficLight));
                stacks.add(new ItemStack(FabroadsMod.PillarBase));
                stacks.add(new ItemStack(FabroadsMod.HorizontalStraightPillar));
                stacks.add(new ItemStack(FabroadsMod.VerticalStraightPillar));
                stacks.add(new ItemStack(FabroadsMod.HorizontalCornerPillar));
                stacks.add(new ItemStack(FabroadsMod.VerticalCornerPillar));
                stacks.add(new ItemStack(FabroadsMod.HorizontalTshapedPillar));
                stacks.add(new ItemStack(FabroadsMod.VerticalTshapedPillar));
                stacks.add(new ItemStack(FabroadsMod.SignIndicatorDirectionLeft));
                stacks.add(new ItemStack(FabroadsMod.SignIndicatorDirectionRight));
            })
            .build();
}

