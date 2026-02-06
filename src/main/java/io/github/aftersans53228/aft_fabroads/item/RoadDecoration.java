package io.github.aftersans53228.aft_fabroads.item;

import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.*;

public class RoadDecoration {
    public static ItemGroup get() {
        return ITEM_GROUP;
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(TrafficLightItem))
            .displayName(Text.translatable("itemGroup.aft_fabroads.road_decoration"))
            .entries(((context, entries) -> {
                entries.add(new ItemStack(RailingsItem));
                entries.add(new ItemStack(BarrierBarItem));
                entries.add(new ItemStack(PavementRailingsItem));
                entries.add(new ItemStack(ExpresswayRailingsBaseItem));
                entries.add(new ItemStack(ExpresswayIronRailingsItem));
                entries.add(new ItemStack(ExpresswayIronRailings2Item));
                entries.add(new ItemStack(ExpresswayRailingsItem));
                entries.add(new ItemStack(ExpresswayRailingsType2Item));
                entries.add(new ItemStack(InsulationPanelsRailingsItem));
                entries.add(new ItemStack(InsulationPanelsGrayPart1Item));
                entries.add(new ItemStack(InsulationPanelsGrayPart2Item));
                entries.add(new ItemStack(InsulationPanelsGrayPart3Item));
                entries.add(new ItemStack(InsulationPanelsGrayPart4Item));
                entries.add(new ItemStack(InsulationPanelsGrayPart5Item));
                entries.add(new ItemStack(InsulationPanelsGrayPart6Item));
                entries.add(new ItemStack(TrafficLightsControlBoxItem));
                entries.add(new ItemStack(TrafficLightItem));
                entries.add(new ItemStack(TrafficLightLeftTurnItem));
                entries.add(new ItemStack(TrafficLightPavementItem));
                entries.add(new ItemStack(RoadLightItem));
                entries.add(new ItemStack(PillarBaseItem));
                entries.add(new ItemStack(HorizontalStraightPillarItem));
                entries.add(new ItemStack(VerticalStraightPillarItem));
                entries.add(new ItemStack(HorizontalCornerPillarItem));
                entries.add(new ItemStack(VerticalCornerPillarItem));
                entries.add(new ItemStack(HorizontalTshapedPillarItem));
                entries.add(new ItemStack(VerticalTshapedPillarItem));
                entries.add(new ItemStack(VerticalTshapedPillarLargeItem));
                entries.add(new ItemStack(VerticalTshapedPillarType2Item));
                entries.add(new ItemStack(HorizontalStraightPillarThinItem));
                entries.add(new ItemStack(VerticalStraightPillarThinItem));
                entries.add(new ItemStack(VerticalCornerPillarThinItem));
                entries.add(new ItemStack(RoadMastPillarBaseItem));
                entries.add(new ItemStack(RoadMastPillarItem));
                entries.add(new ItemStack(SmartPillarItem));
                entries.add(new ItemStack(SmartPillarThinItem));
                entries.add(new ItemStack(SignIndicatorDirectionLeftItem));
                entries.add(new ItemStack(SignIndicatorDirectionRightItem));
                entries.add(new ItemStack(SignIndicatorDirectionCarItem));
                entries.add(new ItemStack(SignIndicatorDirectionBicycleItem));
                entries.add(new ItemStack(SignBanNoDriveItem));
                entries.add(new ItemStack(SignBanStopItem));
                entries.add(new ItemStack(SignBanSpeedLimit05Item));
                entries.add(new ItemStack(SignBanSpeedLimit20Item));
                entries.add(new ItemStack(SignBanSpeedLimit30Item));
                entries.add(new ItemStack(SignBanSpeedLimit40Item));
                entries.add(new ItemStack(SignBanSpeedLimit50Item));
                entries.add(new ItemStack(SignBanSpeedLimit60Item));
                entries.add(new ItemStack(SignBanSpeedLimit70Item));
                entries.add(new ItemStack(SignBanSpeedLimit80Item));
                entries.add(new ItemStack(RubbishBinMetalItem));
                entries.add(new ItemStack(TrashBinGreenItem));
                entries.add(new ItemStack(RoadNameSignItem));
            }))
            .build();
}

