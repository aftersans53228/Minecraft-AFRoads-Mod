package io.github.aftersans53228.aft_fabroads.item;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class RoadDecoration {
    public static ItemGroup get() {
        return ITEM_GROUP;
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("aft_fabroads", "road_decoration"))
            .icon(() -> new ItemStack(AFRoads.TrafficLight))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(AFRoads.Railings));
                stacks.add(new ItemStack(AFRoads.BarrierBar));
                stacks.add(new ItemStack(AFRoads.PavementRailings));
                stacks.add(new ItemStack(AFRoads.ExpresswayRailingsBase));
                stacks.add(new ItemStack(AFRoads.ExpresswayRailings));
                stacks.add(new ItemStack(AFRoads.ExpresswayRailingsType2));
                stacks.add(new ItemStack(AFRoads.InsulationPanelsRailings));
                stacks.add(new ItemStack(AFRoads.InsulationPanelsGrayPart1));
                stacks.add(new ItemStack(AFRoads.InsulationPanelsGrayPart2));
                stacks.add(new ItemStack(AFRoads.InsulationPanelsGrayPart3));
                stacks.add(new ItemStack(AFRoads.InsulationPanelsGrayPart4));
                stacks.add(new ItemStack(AFRoads.InsulationPanelsGrayPart5));
                stacks.add(new ItemStack(AFRoads.InsulationPanelsGrayPart6));
                stacks.add(new ItemStack(AFRoads.TrafficLight));
                stacks.add(new ItemStack(AFRoads.TrafficLightPavement));
                stacks.add(new ItemStack(AFRoads.RoadLight));
                stacks.add(new ItemStack(AFRoads.PillarBase));
                stacks.add(new ItemStack(AFRoads.HorizontalStraightPillar));
                stacks.add(new ItemStack(AFRoads.VerticalStraightPillar));
                stacks.add(new ItemStack(AFRoads.HorizontalCornerPillar));
                stacks.add(new ItemStack(AFRoads.VerticalCornerPillar));
                stacks.add(new ItemStack(AFRoads.HorizontalTshapedPillar));
                stacks.add(new ItemStack(AFRoads.VerticalTshapedPillar));
                stacks.add(new ItemStack(AFRoads.VerticalTshapedPillarType2));
                stacks.add(new ItemStack(AFRoads.HorizontalStraightPillarThin));
                stacks.add(new ItemStack(AFRoads.VerticalStraightPillarThin));
                stacks.add(new ItemStack(AFRoads.VerticalCornerPillarThin));
                stacks.add(new ItemStack(AFRoads.RoadMastPillarBase));
                stacks.add(new ItemStack(AFRoads.RoadMastPillar));
                stacks.add(new ItemStack(AFRoads.SignIndicatorDirectionLeft));
                stacks.add(new ItemStack(AFRoads.SignIndicatorDirectionRight));
                stacks.add(new ItemStack(AFRoads.SignIndicatorDirectionCar));
                stacks.add(new ItemStack(AFRoads.SignIndicatorDirectionBicycle));
                stacks.add(new ItemStack(AFRoads.SignBanNoDrive));
                stacks.add(new ItemStack(AFRoads.SignBanStop));
                stacks.add(new ItemStack(AFRoads.SignBanSpeedLimit05));
                stacks.add(new ItemStack(AFRoads.SignBanSpeedLimit20));
                stacks.add(new ItemStack(AFRoads.SignBanSpeedLimit30));
                stacks.add(new ItemStack(AFRoads.SignBanSpeedLimit40));
                stacks.add(new ItemStack(AFRoads.SignBanSpeedLimit50));
                stacks.add(new ItemStack(AFRoads.SignBanSpeedLimit60));
                stacks.add(new ItemStack(AFRoads.SignBanSpeedLimit70));
                stacks.add(new ItemStack(AFRoads.SignBanSpeedLimit80));
                stacks.add(new ItemStack(AFRoads.RubbishBinMetal));
                stacks.add(new ItemStack(AFRoads.TrashBinGreen));
                stacks.add(new ItemStack(AFRoads.RoadNameSign));
            })
            .build();
}

