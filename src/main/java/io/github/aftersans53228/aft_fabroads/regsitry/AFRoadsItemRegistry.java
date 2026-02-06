package io.github.aftersans53228.aft_fabroads.regsitry;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import io.github.aftersans53228.aft_fabroads.item.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry.*;

public class AFRoadsItemRegistry {
    private static Item register(String id, Item item) {
        return (Item)Registry.register(Registries.ITEM, new Identifier(AFRoadsStatics.MOD_ID,id), item);
    }
    private static Item registerBlock(String id, Block block) {
        return (Item)Registry.register(Registries.ITEM, new Identifier(AFRoadsStatics.MOD_ID,id), new BlockItem(block,new Item.Settings()));
    }
    private static Item registerSticker(String id, Block block) {
        return (Item)Registry.register(Registries.ITEM,new Identifier(AFRoadsStatics.MOD_ID,id), new BlockItem(block,new Item.Settings()));
    }
    private static Item registerDecoration(String id, Block block) {
        return (Item)Registry.register(Registries.ITEM, new Identifier(AFRoadsStatics.MOD_ID,id), new BlockItem(block,new Item.Settings()));
    }
    
    public static  Item RoadTool;
    public static  Item RoadToolLinked;
    public static  Item RoadToolAttribute;
    public static  Item TrafficLightBulbRed;
    public static  Item TrafficLightBulbGreen;
    public static  Item TrafficLightBulbYellow;
    public static  Item TrafficLightLeftBulbRed;
    public static  Item TrafficLightLeftBulbGreen;
    public static  Item TrafficLightLeftBulbYellow;
    public static  Item TrafficLightPavementBulbRed;
    public static  Item TrafficLightPavementBulbGreen;
    public static  Item RoadLightBulbCold;
    public static  Item RoadLightBulbWarm;

    public static  Item RoadBlockItem;
    public static  Item RoadBlockConcreteItem;
    public static  Item ManholeCoverItem;
    public static  Item ManholeCoverConcreteItem;
    public static  Item RoadSeamsBlockItem ;
    public static  Item RoadSeamsBlockConcreteItem ;
    public static  Item ConcreteSlabItem ;
    public static  Item ConcreteStairsItem;
    public static  Item ConcreteStairsSmoothItem ;
    public static  Item ConcreteColumnsCornerItem;
    //创建划线贴纸
    public static  Item LineStraightItem;
    public static  Item LineCornerItem ;
    public static  Item LineTshapedItem ;
    public static  Item LineCrossItem ;
    public static  Item LineDiagonalItem ;
    public static  Item LineLeftBendItem ;
    public static  Item LineRightBendItem ;
    public static  Item LineForkLeftItem ;
    public static  Item LineForkRightItem ;
    public static  Item LineStraightThickItem;
    public static  Item LineStraightDuoLineItem;
    public static  Item LineStraightDuoThickItem;
    public static  Item LineStraightDuoThickDashedItem;
    public static  Item LineDecelerateWithLineItem ;
    public static  Item LineDecelerateWithLineFlipItem ;
    public static  Item LineDecelerateNoLineItem ;
    public static  Item LineDecelerateNoLineFlipItem ;
    public static  Item LineDecelerateDoubleWLItem ;
    public static  Item LineDecelerateDoubleNLItem ;
    public static  Item LineReversibleLanesItem ;
    public static  Item LineReversibleLanesFlipItem ;
    public static  Item LineReversibleLanesDoubleItem ;
    //创建箭头贴纸
    public static  Item ArrowForwardItem;
    public static  Item ArrowLeftItem ;
    public static  Item ArrowRightItem;
    public static  Item ArrowForwardLeftItem ;
    public static  Item ArrowForwardRightItem ;
    public static  Item ArrowBackItem ;
    public static  Item ArrowLeftRightItem ;
    public static  Item ArrowBackLeftItem ;
    public static  Item ArrowBackForwardItem ;
    public static  Item ArrowConfluenceLeftItem ;
    public static  Item ArrowConfluenceRightItem ;
    //创建图标贴纸
    public static  Item IconDecelerateStickerItem;
    public static  Item IconStopStickerItem;
    public static  Item IconGiveWayStickerItem;
    //创建装饰方块
    public static  Item RailingsItem ;
    public static  Item PavementRailingsItem ;
    public static  Item ExpresswayRailingsBaseItem ;
    public static  Item ExpresswayIronRailingsItem;
    public static  Item ExpresswayIronRailings2Item;
    public static  Item ExpresswayRailingsItem ;
    public static  Item ExpresswayRailingsType2Item ;
    public static  Item InsulationPanelsRailingsItem ;
    public static  Item InsulationPanelsGrayPart1Item ;
    public static  Item InsulationPanelsGrayPart2Item;
    public static  Item InsulationPanelsGrayPart3Item ;
    public static  Item InsulationPanelsGrayPart4Item;
    public static  Item InsulationPanelsGrayPart5Item;
    public static  Item InsulationPanelsGrayPart6Item ;

    public static  Item BarrierBarItem;
    public static  Item TrafficLightsControlBoxItem ;
    public static  Item TrafficLightItem ;
    public static  Item TrafficLightLeftTurnItem ;
    public static  Item TrafficLightPavementItem ;
    public static  Item RoadLightItem ;

    public static  Item PillarBaseItem ;
    public static  Item HorizontalStraightPillarItem;
    public static  Item VerticalStraightPillarItem ;
    public static  Item HorizontalCornerPillarItem ;
    public static  Item VerticalCornerPillarItem ;
    public static  Item HorizontalTshapedPillarItem ;
    public static  Item VerticalTshapedPillarItem ;
    public static  Item VerticalTshapedPillarLargeItem ;
    public static  Item VerticalTshapedPillarType2Item ;
    public static  Item RoadMastPillarBaseItem ;
    public static  Item RoadMastPillarItem;
    public static  Item HorizontalStraightPillarThinItem ;
    public static  Item VerticalStraightPillarThinItem ;
    public static  Item VerticalCornerPillarThinItem;
    public static  Item SmartPillarItem;
    public static  Item SmartPillarThinItem;

    public static  Item SignIndicatorDirectionLeftItem ;
    public static  Item SignIndicatorDirectionRightItem;
    public static  Item SignIndicatorDirectionCarItem ;
    public static  Item SignIndicatorDirectionBicycleItem ;
    public static  Item SignBanNoDriveItem ;
    public static  Item SignBanStopItem;
    public static  Item SignBanSpeedLimit05Item ;
    public static  Item SignBanSpeedLimit20Item ;
    public static  Item SignBanSpeedLimit30Item ;
    public static  Item SignBanSpeedLimit40Item ;
    public static  Item SignBanSpeedLimit50Item ;
    public static  Item SignBanSpeedLimit60Item ;
    public static  Item SignBanSpeedLimit70Item ;
    public static  Item SignBanSpeedLimit80Item ;

    public static  Item RubbishBinMetalItem;
    public static  Item TrashBinGreenItem;
    public static  Item RoadNameSignItem ;
    
    
    public static void RegisterItem(){
        //Items
        RoadTool=register("road_tool",new RoadTool());
        RoadToolLinked=register("road_tool_linked",new RoadToolLinked());
        RoadToolAttribute =register("road_tool_attribute",new RoadToolAttribute());
        TrafficLightBulbRed=register("traffic_light_red_bulb", new Item(new FabricItemSettings()));
        TrafficLightBulbGreen=register("traffic_light_green_bulb", new Item(new FabricItemSettings()));
        TrafficLightBulbYellow=register("traffic_light_yellow_bulb", new Item(new FabricItemSettings()));
        TrafficLightLeftBulbRed=register("traffic_light_left_red_bulb", new Item(new FabricItemSettings()));
        TrafficLightLeftBulbGreen=register("traffic_light_left_green_bulb", new Item(new FabricItemSettings()));
        TrafficLightLeftBulbYellow=register("traffic_light_left_yellow_bulb", new Item(new FabricItemSettings()));
        TrafficLightPavementBulbRed=register("traffic_light_pavement_red_bulb", new Item(new FabricItemSettings()));
        TrafficLightPavementBulbGreen=register("traffic_light_pavement_green_bulb", new Item(new FabricItemSettings()));
        RoadLightBulbCold=register("road_light_bulb_cold", new Item(new FabricItemSettings()));
        RoadLightBulbWarm=register("road_light_bulb_warm", new Item(new FabricItemSettings()));
        ////BlockItems
        RoadBlockItem =registerBlock("road_block",RoadBlock);
        RoadBlockConcreteItem =registerBlock("road_block_concrete",RoadBlockConcrete);
        ManholeCoverItem =registerBlock("manhole_cover",ManholeCover);
        ManholeCoverConcreteItem =registerBlock("manhole_cover_concrete",ManholeCoverConcrete);
        RoadSeamsBlockItem =registerBlock("road_seams_block",RoadSeamsBlock);
        RoadSeamsBlockConcreteItem =registerBlock("road_seams_block_concrete",RoadSeamsBlockConcrete);
        ConcreteSlabItem =registerBlock("concrete_slab",ConcreteSlab);
        ConcreteStairsItem =registerBlock("concrete_stairs",ConcreteStairs);
        ConcreteStairsSmoothItem =registerBlock("concrete_stairs_smooth",ConcreteStairsSmooth);
        ConcreteColumnsCornerItem =registerBlock("concrete_columns_corner",ConcreteColumnsCorner);
        //创建划线贴纸
        LineStraightItem =registerSticker("line_straight",LineStraight);
        LineCornerItem =registerSticker("line_corner",  LineCorner);
        LineTshapedItem =registerSticker("line_tshaped",LineTshaped);
        LineCrossItem =registerSticker("line_cross", LineCross);
        LineDiagonalItem =registerSticker("line_diagonal",  LineDiagonal);
        LineLeftBendItem =registerSticker("line_left_bend", LineLeftBend);
        LineRightBendItem =registerSticker("line_right_bend", LineRightBend);
        LineForkLeftItem =registerSticker("line_fork_left",   LineForkLeft);
        LineForkRightItem =registerSticker("line_fork_right",LineForkRight);
        LineStraightThickItem =registerSticker("thick_line_straight",  LineStraightThick);
        LineStraightDuoLineItem =registerSticker("line_duo_straight", LineStraightDuoLine);
        LineStraightDuoThickItem =registerSticker("thick_line_duo_straight",LineStraightDuoThick);
        LineStraightDuoThickDashedItem =registerSticker("thick_line_duo_straight_dashed",LineStraightDuoThickDashed);
        LineDecelerateWithLineItem =registerSticker("line_decelerate_w_line",     LineDecelerateWithLine);
        LineDecelerateWithLineFlipItem =registerSticker("line_decelerate_w_line_flip"   ,LineDecelerateWithLineFlip);
        LineDecelerateNoLineItem =registerSticker("line_decelerate", LineDecelerateNoLine);
        LineDecelerateNoLineFlipItem =registerSticker("line_decelerate_flip",LineDecelerateNoLineFlip);
        LineDecelerateDoubleWLItem =registerSticker("line_decelerate_d_w_l",LineDecelerateDoubleWL);
        LineDecelerateDoubleNLItem =registerSticker("line_decelerate_d_n_l",LineDecelerateDoubleNL);
        LineReversibleLanesItem =registerSticker("line_reversible_lanes",LineReversibleLanes);
        LineReversibleLanesFlipItem =registerSticker("line_reversible_lanes_flip",LineReversibleLanesFlip);
        LineReversibleLanesDoubleItem =registerSticker("line_reversible_lanes_double",LineReversibleLanesDouble);
        //创建箭头贴纸
        ArrowForwardItem =registerSticker("arrow_forward",ArrowForward);
        ArrowLeftItem =registerSticker("arrow_left",ArrowLeft);
        ArrowRightItem =registerSticker("arrow_right", ArrowRight);
        ArrowForwardLeftItem =registerSticker("arrow_forward_left",ArrowForwardLeft);
        ArrowForwardRightItem =registerSticker("arrow_forward_right",ArrowForwardRight);
        ArrowBackItem =registerSticker("arrow_back",ArrowBack);
        ArrowLeftRightItem =registerSticker("arrow_left_right", ArrowLeftRight);
        ArrowBackLeftItem =registerSticker("arrow_back_left",ArrowBackLeft);
        ArrowBackForwardItem =registerSticker("arrow_back_forward",   ArrowBackForward);
        ArrowConfluenceLeftItem =registerSticker("arrow_confluence_left", ArrowConfluenceLeft);
        ArrowConfluenceRightItem =registerSticker("arrow_confluence_right",  ArrowConfluenceRight);
        //创建图标贴纸
        IconDecelerateStickerItem = registerSticker("icon_decelerate_sticker",IconDecelerateSticker);
        IconStopStickerItem = registerSticker("icon_stop_sticker",IconStopSticker);
        IconGiveWayStickerItem =registerSticker("icon_give_way_sticker",IconGiverWaySticker);
        //创建装饰方块
        RailingsItem =registerDecoration("railings",Railings);
        PavementRailingsItem =registerDecoration("pavement_railings",PavementRailings);
        ExpresswayRailingsBaseItem =registerDecoration("expressway_railings_base",ExpresswayRailingsBase);
        ExpresswayIronRailingsItem =registerDecoration("expressway_iron_railings",ExpresswayIronRailings);
        ExpresswayIronRailings2Item =registerDecoration("expressway_iron_railings2",ExpresswayIronRailings2);
        ExpresswayRailingsItem =registerDecoration("expressway_railings",ExpresswayRailings);
        ExpresswayRailingsType2Item =registerDecoration("expressway_railings_type2",ExpresswayRailingsType2);
        InsulationPanelsRailingsItem =registerDecoration("insulation_panels_railings",InsulationPanelsRailings);
        InsulationPanelsGrayPart1Item =registerDecoration("insulation_panels_gray_part1",InsulationPanelsGrayPart1);
        InsulationPanelsGrayPart2Item =registerDecoration("insulation_panels_gray_part2",InsulationPanelsGrayPart2);
        InsulationPanelsGrayPart3Item =registerDecoration("insulation_panels_gray_part3",InsulationPanelsGrayPart3);
        InsulationPanelsGrayPart4Item =registerDecoration("insulation_panels_gray_part4",InsulationPanelsGrayPart4);
        InsulationPanelsGrayPart5Item =registerDecoration("insulation_panels_gray_part5",InsulationPanelsGrayPart5);
        InsulationPanelsGrayPart6Item =registerDecoration("insulation_panels_gray_part6",InsulationPanelsGrayPart6);

        BarrierBarItem =registerDecoration("barrier_bar",BarrierBar);
        TrafficLightsControlBoxItem =registerDecoration("traffic_lights_control_box", TrafficLightsControlBox);
        TrafficLightItem =registerDecoration("traffic_light",TrafficLight);
        TrafficLightLeftTurnItem =registerDecoration("traffic_light_left_turn",TrafficLightLeftTurn);
        TrafficLightPavementItem =registerDecoration("traffic_light_pavement",TrafficLightPavement);
        RoadLightItem =registerDecoration("road_light",RoadLight);

        PillarBaseItem =registerDecoration("pillar_base",PillarBase);
        HorizontalStraightPillarItem =registerDecoration("horizontal_straight_pillar",HorizontalStraightPillar);
        VerticalStraightPillarItem =registerDecoration("vertical_straight_pillar",VerticalStraightPillar);
        HorizontalCornerPillarItem =registerDecoration("horizontal_corner_pillar",HorizontalCornerPillar);
        VerticalCornerPillarItem =registerDecoration("vertical_corner_pillar",VerticalCornerPillar);
        HorizontalTshapedPillarItem =registerDecoration("horizontal_tshaped_pillar",HorizontalTshapedPillar);
        VerticalTshapedPillarItem =registerDecoration("vertical_tshaped_pillar",VerticalTshapedPillar);
        VerticalTshapedPillarLargeItem =registerDecoration("vertical_tshaped_pillar_large",VerticalTshapedPillarLarge);
        VerticalTshapedPillarType2Item =registerDecoration("vertical_tshaped_pillar_type2",VerticalTshapedPillarType2);
        RoadMastPillarBaseItem =registerDecoration("road_mast_pillar_base",RoadMastPillarBase);
        RoadMastPillarItem =registerDecoration("road_mast_pillar",RoadMastPillar);
        HorizontalStraightPillarThinItem =registerDecoration("horizontal_straight_pillar_thin",HorizontalStraightPillarThin);
        VerticalStraightPillarThinItem =registerDecoration("vertical_straight_pillar_thin",VerticalStraightPillarThin);
        VerticalCornerPillarThinItem =registerDecoration("vertical_corner_pillar_thin",VerticalCornerPillarThin);
        SmartPillarItem =registerDecoration("smart_pillar",SmartPillar);
        SmartPillarThinItem =registerDecoration("smart_pillar_thin",SmartPillarThin);

        SignIndicatorDirectionLeftItem =registerDecoration("sign_indicator_direction_left",SignIndicatorDirectionLeft);
        SignIndicatorDirectionRightItem =registerDecoration("sign_indicator_direction_right",SignIndicatorDirectionRight);
        SignIndicatorDirectionCarItem =registerDecoration("sign_indicator_direction_car",SignIndicatorDirectionCar);
        SignIndicatorDirectionBicycleItem =registerDecoration("sign_indicator_direction_bicycle",SignIndicatorDirectionBicycle);
        SignBanNoDriveItem =registerDecoration("sign_ban_no_drive",SignBanNoDrive);
        SignBanStopItem =registerDecoration("sign_ban_stop",SignBanStop);
        SignBanSpeedLimit05Item =registerDecoration("sign_ban_speed_limit_05",SignBanSpeedLimit05);
        SignBanSpeedLimit20Item =registerDecoration("sign_ban_speed_limit_20",SignBanSpeedLimit20);
        SignBanSpeedLimit30Item =registerDecoration("sign_ban_speed_limit_30",SignBanSpeedLimit30);
        SignBanSpeedLimit40Item =registerDecoration("sign_ban_speed_limit_40",SignBanSpeedLimit40);
        SignBanSpeedLimit50Item =registerDecoration("sign_ban_speed_limit_50",SignBanSpeedLimit50);
        SignBanSpeedLimit60Item =registerDecoration("sign_ban_speed_limit_60",SignBanSpeedLimit60);
        SignBanSpeedLimit70Item =registerDecoration("sign_ban_speed_limit_70",SignBanSpeedLimit70);
        SignBanSpeedLimit80Item =registerDecoration("sign_ban_speed_limit_80",SignBanSpeedLimit80);

        RubbishBinMetalItem =registerDecoration("rubbish_bin_metal",RubbishBinMetal);
        TrashBinGreenItem =registerDecoration("trash_bin_green",TrashBinGreen);
        RoadNameSignItem =registerDecoration("road_name_sign",RoadNameSign);

        AFRoads.LOGGER.info("AFRoads Items Initialized");

        ItemGroupEvents.modifyEntriesEvent(RoadStickers.get()).register(content -> {
            content.add(new ItemStack(LineStraightItem));
            content.add(new ItemStack(LineCornerItem));
            content.add(new ItemStack(LineTshapedItem));
            content.add(new ItemStack(LineCrossItem));
            content.add(new ItemStack(LineDiagonalItem));
            content.add(new ItemStack(LineLeftBendItem));
            content.add(new ItemStack(LineRightBendItem));
            content.add(new ItemStack(LineForkLeftItem));
            content.add(new ItemStack(LineForkRightItem));
            content.add(new ItemStack(LineStraightThickItem));
            content.add(new ItemStack(LineStraightDuoLineItem));
            content.add(new ItemStack(LineStraightDuoThickItem));
            content.add(new ItemStack(LineStraightDuoThickDashedItem));
            content.add(new ItemStack(LineDecelerateNoLineItem));
            content.add(new ItemStack(LineDecelerateNoLineFlipItem));
            content.add(new ItemStack(LineDecelerateWithLineItem));
            content.add(new ItemStack(LineDecelerateWithLineFlipItem));
            content.add(new ItemStack(LineDecelerateDoubleWL));
            content.add(new ItemStack(LineDecelerateDoubleNL));
            content.add(new ItemStack(LineReversibleLanesItem));
            content.add(new ItemStack(LineReversibleLanesFlipItem));
            content.add(new ItemStack(LineReversibleLanesDoubleItem));

            content.add(new ItemStack(ArrowForwardItem));
            content.add(new ItemStack(ArrowLeftItem));
            content.add(new ItemStack(ArrowRightItem));
            content.add(new ItemStack(ArrowForwardLeftItem));
            content.add(new ItemStack(ArrowForwardRightItem));
            content.add(new ItemStack(ArrowLeftRightItem));
            content.add(new ItemStack(ArrowBackItem));
            content.add(new ItemStack(ArrowBackLeftItem));
            content.add(new ItemStack(ArrowBackForwardItem));
            content.add(new ItemStack(ArrowConfluenceLeftItem));
            content.add(new ItemStack(ArrowConfluenceRightItem));

            content.add(new ItemStack(IconDecelerateStickerItem));
            content.add(new ItemStack(IconStopStickerItem));
            content.add(new ItemStack(IconGiveWayStickerItem));
        });

        ItemGroupEvents.modifyEntriesEvent(RoadDecoration.get()).register(content -> {
            content.add(new ItemStack(RailingsItem));
            content.add(new ItemStack(BarrierBarItem));
            content.add(new ItemStack(PavementRailingsItem));
            content.add(new ItemStack(ExpresswayRailingsBaseItem));
            content.add(new ItemStack(ExpresswayIronRailingsItem));
            content.add(new ItemStack(ExpresswayIronRailings2Item));
            content.add(new ItemStack(ExpresswayRailingsItem));
            content.add(new ItemStack(ExpresswayRailingsType2Item));
            content.add(new ItemStack(InsulationPanelsRailingsItem));
            content.add(new ItemStack(InsulationPanelsGrayPart1Item));
            content.add(new ItemStack(InsulationPanelsGrayPart2Item));
            content.add(new ItemStack(InsulationPanelsGrayPart3Item));
            content.add(new ItemStack(InsulationPanelsGrayPart4Item));
            content.add(new ItemStack(InsulationPanelsGrayPart5Item));
            content.add(new ItemStack(InsulationPanelsGrayPart6Item));
            content.add(new ItemStack(TrafficLightsControlBoxItem));
            content.add(new ItemStack(TrafficLightItem));
            content.add(new ItemStack(TrafficLightLeftTurnItem));
            content.add(new ItemStack(TrafficLightPavementItem));
            content.add(new ItemStack(RoadLightItem));
            content.add(new ItemStack(PillarBaseItem));
            content.add(new ItemStack(HorizontalStraightPillarItem));
            content.add(new ItemStack(VerticalStraightPillarItem));
            content.add(new ItemStack(HorizontalCornerPillarItem));
            content.add(new ItemStack(VerticalCornerPillarItem));
            content.add(new ItemStack(HorizontalTshapedPillarItem));
            content.add(new ItemStack(VerticalTshapedPillarItem));
            content.add(new ItemStack(VerticalTshapedPillarLargeItem));
            content.add(new ItemStack(VerticalTshapedPillarType2Item));
            content.add(new ItemStack(HorizontalStraightPillarThinItem));
            content.add(new ItemStack(VerticalStraightPillarThinItem));
            content.add(new ItemStack(VerticalCornerPillarThinItem));
            content.add(new ItemStack(RoadMastPillarBaseItem));
            content.add(new ItemStack(RoadMastPillarItem));
            content.add(new ItemStack(SmartPillarItem));
            content.add(new ItemStack(SmartPillarThinItem));
            content.add(new ItemStack(SignIndicatorDirectionLeftItem));
            content.add(new ItemStack(SignIndicatorDirectionRightItem));
            content.add(new ItemStack(SignIndicatorDirectionCarItem));
            content.add(new ItemStack(SignIndicatorDirectionBicycleItem));
            content.add(new ItemStack(SignBanNoDriveItem));
            content.add(new ItemStack(SignBanStopItem));
            content.add(new ItemStack(SignBanSpeedLimit05Item));
            content.add(new ItemStack(SignBanSpeedLimit20Item));
            content.add(new ItemStack(SignBanSpeedLimit30Item));
            content.add(new ItemStack(SignBanSpeedLimit40Item));
            content.add(new ItemStack(SignBanSpeedLimit50Item));
            content.add(new ItemStack(SignBanSpeedLimit60Item));
            content.add(new ItemStack(SignBanSpeedLimit70Item));
            content.add(new ItemStack(SignBanSpeedLimit80Item));
            content.add(new ItemStack(RubbishBinMetalItem));
            content.add(new ItemStack(TrashBinGreenItem));
            content.add(new ItemStack(RoadNameSignItem));
        });

        ItemGroupEvents.modifyEntriesEvent(NormalRoadBlock.get()).register(content -> {
            content.add(new ItemStack(RoadBlockItem));
            content.add(new ItemStack(RoadBlockConcreteItem));
            content.add(new ItemStack(ManholeCoverItem));
            content.add(new ItemStack(ManholeCoverConcreteItem));
            content.add(new ItemStack(RoadSeamsBlockItem));
            content.add(new ItemStack(RoadSeamsBlockConcreteItem));
            content.add(new ItemStack(ConcreteSlabItem));
            content.add(new ItemStack(ConcreteStairsItem));
            content.add(new ItemStack(ConcreteStairsSmoothItem));
            content.add(new ItemStack(ConcreteColumnsCornerItem));
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.add(new ItemStack(RoadTool));
            content.add(new ItemStack(RoadToolAttribute));
            content.add(new ItemStack(RoadToolLinked));
        });
    }
}
