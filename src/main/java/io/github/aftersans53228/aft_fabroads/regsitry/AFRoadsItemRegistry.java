package io.github.aftersans53228.aft_fabroads.regsitry;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import io.github.aftersans53228.aft_fabroads.block.*;
import io.github.aftersans53228.aft_fabroads.block.pillarblock.*;
import io.github.aftersans53228.aft_fabroads.block.signblock.*;
import io.github.aftersans53228.aft_fabroads.block.stickerblock.ArrowBlocks;
import io.github.aftersans53228.aft_fabroads.block.stickerblock.LineBlocks;
import io.github.aftersans53228.aft_fabroads.block.structureblock.ConcreteColumnsCorner;
import io.github.aftersans53228.aft_fabroads.block.structureblock.ConcreteSlab;
import io.github.aftersans53228.aft_fabroads.block.structureblock.ConcreteStairs;
import io.github.aftersans53228.aft_fabroads.block.structureblock.ConcreteStairsSmooth;
import io.github.aftersans53228.aft_fabroads.item.RoadTool;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.github.aftersans53228.aft_fabroads.AFRoads.*;
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry.*;

public class AFRoadsItemRegistry {
    private static Item register(String id, Item item) {
        return (Item)Registry.register(Registry.ITEM, new Identifier(AFRoadsStatics.MOD_ID,id), item);
    }
    private static Item registerBlock(String id, Block block) {
        return (Item)Registry.register(Registry.ITEM, new Identifier(AFRoadsStatics.MOD_ID,id), new BlockItem(block,new Item.Settings().group(NormalRoadBlockGROUP)));
    }
    private static Item registerSticker(String id, Block block) {
        return (Item)Registry.register(Registry.ITEM, new Identifier(AFRoadsStatics.MOD_ID,id), new BlockItem(block,new Item.Settings().group(RoadStickersGROUP)));
    }
    private static Item registerDecoration(String id, Block block) {
        return (Item)Registry.register(Registry.ITEM, new Identifier(AFRoadsStatics.MOD_ID,id), new BlockItem(block,new Item.Settings().group(RoadDecorationsGROUP)));
    }
    
      public static final Item RoadTool;
      public static final Item TrafficLightBulbRed;
      public static final Item TrafficLightBulbGreen;
      public static final Item TrafficLightBulbYellow;
      public static final Item TrafficLightPavementBulbRed;
      public static final Item TrafficLightPavementBulbGreen;
      public static final Item RoadLightBulbCold;
      public static final Item RoadLightBulbWarm;

      public static final Item RoadBlockItem;
      public static final Item RoadBlockConcreteItem;
      public static final Item ManholeCoverItem;
      public static final Item ManholeCoverConcreteItem;
      public static final Item RoadSeamsBlockItem ;
      public static final Item RoadSeamsBlockConcreteItem ;
      public static final Item ConcreteSlabItem ;
      public static final Item ConcreteStairsItem;
      public static final Item ConcreteStairsSmoothItem ;
      public static final Item ConcreteColumnsCornerItem;
    //创建划线贴纸
      public static final Item LineStraightItem;
      public static final Item LineCornerItem ;
      public static final Item LineTshapedItem ;
      public static final Item LineCrossItem ;
      public static final Item LineDiagonalItem ;
      public static final Item LineLeftBendItem ;
      public static final Item LineRightBendItem ;
      public static final Item LineForkLeftItem ;
      public static final Item LineForkRightItem ;
      public static final Item LineStraightThickItem;
      public static final Item LineStraightDuoLineItem;
      public static final Item LineStraightDuoThickItem;
      public static final Item LineStraightDuoThickDashedItem;
      public static final Item LineDecelerateWithLineItem ;
      public static final Item LineDecelerateWithLineFlipItem ;
      public static final Item LineDecelerateNoLineItem ;
      public static final Item LineDecelerateNoLineFlipItem ;
    //创建箭头贴纸
      public static final Item ArrowForwardItem;
      public static final Item ArrowLeftItem ;
      public static final Item ArrowRightItem;
      public static final Item ArrowForwardLeftItem ;
      public static final Item ArrowForwardRightItem ;
      public static final Item ArrowBackItem ;
      public static final Item ArrowLeftRightItem ;
      public static final Item ArrowBackLeftItem ;
      public static final Item ArrowBackForwardItem ;
      public static final Item ArrowConfluenceLeftItem ;
      public static final Item ArrowConfluenceRightItem ;
    //创建装饰方块
      public static final Item RailingsItem ;
      public static final Item PavementRailingsItem ;
      public static final Item ExpresswayRailingsBaseItem ;
      public static final Item ExpresswayRailingsItem ;
      public static final Item ExpresswayRailingsType2Item ;
      public static final Item InsulationPanelsRailingsItem ;
      public static final Item InsulationPanelsGrayPart1Item ;
      public static final Item InsulationPanelsGrayPart2Item;
      public static final Item InsulationPanelsGrayPart3Item ;
      public static final Item InsulationPanelsGrayPart4Item;
      public static final Item InsulationPanelsGrayPart5Item;
      public static final Item InsulationPanelsGrayPart6Item ;

      public static final Item BarrierBarItem;
      public static final Item TrafficLightItem ;
      public static final Item TrafficLightPavementItem ;
      public static final Item RoadLightItem ;

      public static final Item PillarBaseItem ;
      public static final Item HorizontalStraightPillarItem;
      public static final Item VerticalStraightPillarItem ;
      public static final Item HorizontalCornerPillarItem ;
      public static final Item VerticalCornerPillarItem ;
      public static final Item HorizontalTshapedPillarItem ;
      public static final Item VerticalTshapedPillarItem ;
      public static final Item VerticalTshapedPillarType2Item ;
      public static final Item RoadMastPillarBaseItem ;
      public static final Item RoadMastPillarItem;
      public static final Item HorizontalStraightPillarThinItem ;
      public static final Item VerticalStraightPillarThinItem ;
      public static final Item VerticalCornerPillarThinItem;
      public static final Item SmartPillarItem;
      public static final Item SmartPillarThinItem;

      public static final Item SignIndicatorDirectionLeftItem ;
      public static final Item SignIndicatorDirectionRightItem;
      public static final Item SignIndicatorDirectionCarItem ;
      public static final Item SignIndicatorDirectionBicycleItem ;
      public static final Item SignBanNoDriveItem ;
      public static final Item SignBanStopItem;
      public static final Item SignBanSpeedLimit05Item ;
      public static final Item SignBanSpeedLimit20Item ;
      public static final Item SignBanSpeedLimit30Item ;
      public static final Item SignBanSpeedLimit40Item ;
      public static final Item SignBanSpeedLimit50Item ;
      public static final Item SignBanSpeedLimit60Item ;
      public static final Item SignBanSpeedLimit70Item ;
      public static final Item SignBanSpeedLimit80Item ;

      public static final Item RubbishBinMetalItem;
      public static final Item TrashBinGreenItem;
      public static final Item RoadNameSignItem ;
    
    
    static{
        //Items
        RoadTool=register("road_tool",new RoadTool());
        TrafficLightBulbRed=register("traffic_light_green_bulb", new Item(new FabricItemSettings()));
        TrafficLightBulbGreen=register("traffic_light_red_bulb", new Item(new FabricItemSettings()));
        TrafficLightBulbYellow=register("traffic_light_yellow_bulb", new Item(new FabricItemSettings()));
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
        //创建装饰方块
         RailingsItem =registerDecoration("railings",Railings);
         PavementRailingsItem =registerDecoration("pavement_railings",PavementRailings);
         ExpresswayRailingsBaseItem =registerDecoration("expressway_railings_base",ExpresswayRailingsBase);
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
         TrafficLightItem =registerDecoration("traffic_light",TrafficLight);
         TrafficLightPavementItem =registerDecoration("traffic_light_pavement",TrafficLightPavement);
         RoadLightItem =registerDecoration("road_light",RoadLight);

         PillarBaseItem =registerDecoration("pillar_base",PillarBase);
         HorizontalStraightPillarItem =registerDecoration("horizontal_straight_pillar",HorizontalStraightPillar);
         VerticalStraightPillarItem =registerDecoration("vertical_straight_pillar",VerticalStraightPillar);
         HorizontalCornerPillarItem =registerDecoration("horizontal_corner_pillar",HorizontalCornerPillar);
         VerticalCornerPillarItem =registerDecoration("vertical_corner_pillar",VerticalCornerPillar);
         HorizontalTshapedPillarItem =registerDecoration("horizontal_tshaped_pillar",HorizontalTshapedPillar);
         VerticalTshapedPillarItem =registerDecoration("vertical_tshaped_pillar",VerticalTshapedPillar);
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
    }
}
