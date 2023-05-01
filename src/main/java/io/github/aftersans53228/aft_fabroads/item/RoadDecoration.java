package io.github.aftersans53228.aft_fabroads.item;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry.*;
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.*;

public class RoadDecoration {
    public static ItemGroup get() {
        return ITEM_GROUP;
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("aft_fabroads", "road_decoration"))
            .icon(() -> new ItemStack(TrafficLightItem))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(RailingsItem));
                stacks.add(new ItemStack(BarrierBarItem));
                stacks.add(new ItemStack(PavementRailingsItem));
                stacks.add(new ItemStack(ExpresswayRailingsBaseItem));
                stacks.add(new ItemStack(ExpresswayRailingsItem));
                stacks.add(new ItemStack(ExpresswayRailingsType2Item));
                stacks.add(new ItemStack(InsulationPanelsRailingsItem));
                stacks.add(new ItemStack(InsulationPanelsGrayPart1Item));
                stacks.add(new ItemStack(InsulationPanelsGrayPart2Item));
                stacks.add(new ItemStack(InsulationPanelsGrayPart3Item));
                stacks.add(new ItemStack(InsulationPanelsGrayPart4Item));
                stacks.add(new ItemStack(InsulationPanelsGrayPart5Item));
                stacks.add(new ItemStack(InsulationPanelsGrayPart6Item));
                stacks.add(new ItemStack(TrafficLightItem));
                stacks.add(new ItemStack(TrafficLightPavementItem));
                stacks.add(new ItemStack(RoadLightItem));
                stacks.add(new ItemStack(PillarBaseItem));
                stacks.add(new ItemStack(HorizontalStraightPillarItem));
                stacks.add(new ItemStack(VerticalStraightPillarItem));
                stacks.add(new ItemStack(HorizontalCornerPillarItem));
                stacks.add(new ItemStack(VerticalCornerPillarItem));
                stacks.add(new ItemStack(HorizontalTshapedPillarItem));
                stacks.add(new ItemStack(VerticalTshapedPillarItem));
                stacks.add(new ItemStack(VerticalTshapedPillarType2Item));
                stacks.add(new ItemStack(HorizontalStraightPillarThinItem));
                stacks.add(new ItemStack(VerticalStraightPillarThinItem));
                stacks.add(new ItemStack(VerticalCornerPillarThinItem));
                stacks.add(new ItemStack(RoadMastPillarBaseItem));
                stacks.add(new ItemStack(RoadMastPillarItem));
                stacks.add(new ItemStack(SignIndicatorDirectionLeftItem));
                stacks.add(new ItemStack(SignIndicatorDirectionRightItem));
                stacks.add(new ItemStack(SignIndicatorDirectionCarItem));
                stacks.add(new ItemStack(SignIndicatorDirectionBicycleItem));
                stacks.add(new ItemStack(SignBanNoDriveItem));
                stacks.add(new ItemStack(SignBanStopItem));
                stacks.add(new ItemStack(SignBanSpeedLimit05Item));
                stacks.add(new ItemStack(SignBanSpeedLimit20Item));
                stacks.add(new ItemStack(SignBanSpeedLimit30Item));
                stacks.add(new ItemStack(SignBanSpeedLimit40Item));
                stacks.add(new ItemStack(SignBanSpeedLimit50Item));
                stacks.add(new ItemStack(SignBanSpeedLimit60Item));
                stacks.add(new ItemStack(SignBanSpeedLimit70Item));
                stacks.add(new ItemStack(SignBanSpeedLimit80Item));
                stacks.add(new ItemStack(RubbishBinMetalItem));
                stacks.add(new ItemStack(TrashBinGreenItem));
                stacks.add(new ItemStack(RoadNameSignItem));
            })
            .build();
}

