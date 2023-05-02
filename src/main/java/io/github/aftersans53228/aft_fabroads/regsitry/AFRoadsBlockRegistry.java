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
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AFRoadsBlockRegistry {
    
    private static Block register(String id, Block block) {
        return (Block)Registry.register(Registry.BLOCK, new Identifier(AFRoadsStatics.MOD_ID,id), block);
    }
    private static Block registerPillar(String id, Block block) {
        AFRoadsStatics.PILLAR_BLOCKS.add(block);
        return (Block)Registry.register(Registry.BLOCK, new Identifier(AFRoadsStatics.MOD_ID,id), block);
    }

    public static final Block RoadBlock;
    public static final Block RoadBlockConcrete;
    public static final Block ManholeCover;
    public static final Block ManholeCoverConcrete;
    public static final Block RoadSeamsBlock ;
    public static final Block RoadSeamsBlockConcrete ;
    public static final Block ConcreteSlab ;
    public static final Block ConcreteStairs;
    public static final Block ConcreteStairsSmooth ;
    public static final Block ConcreteColumnsCorner;
    //创建划线贴纸
    public static final Block LineStraight;
    public static final Block LineCorner ;
    public static final Block LineTshaped ;
    public static final Block LineCross ;
    public static final Block LineDiagonal ;
    public static final Block LineLeftBend ;
    public static final Block LineRightBend ;
    public static final Block LineForkLeft ;
    public static final Block LineForkRight ;
    public static final Block LineStraightThick;
    public static final Block LineStraightDuoLine;
    public static final Block LineStraightDuoThick;
    public static final Block LineStraightDuoThickDashed;
    public static final Block LineDecelerateWithLine ;
    public static final Block LineDecelerateWithLineFlip ;
    public static final Block LineDecelerateNoLine ;
    public static final Block LineDecelerateNoLineFlip ;
    //创建箭头贴纸
    public static final Block ArrowForward;
    public static final Block ArrowLeft ;
    public static final Block ArrowRight;
    public static final Block ArrowForwardLeft ;
    public static final Block ArrowForwardRight ;
    public static final Block ArrowBack ;
    public static final Block ArrowLeftRight ;
    public static final Block ArrowBackLeft ;
    public static final Block ArrowBackForward ;
    public static final Block ArrowConfluenceLeft ;
    public static final Block ArrowConfluenceRight ;
    //创建装饰方块
    public static final Block Railings ;
    public static final Block PavementRailings ;
    public static final Block ExpresswayRailingsBase ;
    public static final Block ExpresswayRailings ;
    public static final Block ExpresswayRailingsType2 ;
    public static final Block InsulationPanelsRailings ;
    public static final Block InsulationPanelsGrayPart1 ;
    public static final Block InsulationPanelsGrayPart2;
    public static final Block InsulationPanelsGrayPart3 ;
    public static final Block InsulationPanelsGrayPart4;
    public static final Block InsulationPanelsGrayPart5;
    public static final Block InsulationPanelsGrayPart6 ;

    public static final Block BarrierBar;
    public static final Block TrafficLight ;
    public static final Block TrafficLightPavement ;
    public static final Block RoadLight ;

    public static final Block PillarBase ;
    public static final Block HorizontalStraightPillar;
    public static final Block VerticalStraightPillar ;
    public static final Block HorizontalCornerPillar ;
    public static final Block VerticalCornerPillar ;
    public static final Block HorizontalTshapedPillar ;
    public static final Block VerticalTshapedPillar ;
    public static final Block VerticalTshapedPillarType2 ;
    public static final Block RoadMastPillarBase ;
    public static final Block RoadMastPillar;
    public static final Block HorizontalStraightPillarThin ;
    public static final Block VerticalStraightPillarThin ;
    public static final Block VerticalCornerPillarThin;
    public static final Block SmartPillar;
    public static final Block SmartPillarThin;

    public static final Block SignIndicatorDirectionLeft ;
    public static final Block SignIndicatorDirectionRight;
    public static final Block SignIndicatorDirectionCar ;
    public static final Block SignIndicatorDirectionBicycle ;
    public static final Block SignBanNoDrive ;
    public static final Block SignBanStop;
    public static final Block SignBanSpeedLimit05 ;
    public static final Block SignBanSpeedLimit20 ;
    public static final Block SignBanSpeedLimit30 ;
    public static final Block SignBanSpeedLimit40 ;
    public static final Block SignBanSpeedLimit50 ;
    public static final Block SignBanSpeedLimit60 ;
    public static final Block SignBanSpeedLimit70 ;
    public static final Block SignBanSpeedLimit80 ;

    public static final Block RubbishBinMetal;
    public static final Block TrashBinGreen;
    public static final Block RoadNameSign ;
    
    
    static{
         RoadBlock =register("road_block",new RoadBlock());
         RoadBlockConcrete =register("road_block_concrete",new RoadBlockConcrete());
         ManholeCover =register("manhole_cover",new ManholeCover());
         ManholeCoverConcrete =register("manhole_cover_concrete",new ManholeCoverConcrete());
         RoadSeamsBlock =register("road_seams_block",new RoadSeamsBlock());
         RoadSeamsBlockConcrete =register("road_seams_block_concrete",new RoadSeamsBlockConcrete());
         ConcreteSlab =register("concrete_slab",new ConcreteSlab());
         ConcreteStairs =register("concrete_stairs",new ConcreteStairs());
         ConcreteStairsSmooth =register("concrete_stairs_smooth",new ConcreteStairsSmooth());
         ConcreteColumnsCorner =register("concrete_columns_corner",new ConcreteColumnsCorner());
        //创建划线贴纸
         LineStraight =register("line_straight",new LineBlocks());
         LineCorner =register("line_corner",new LineBlocks());
         LineTshaped =register("line_tshaped",new LineBlocks());
         LineCross =register("line_cross",new LineBlocks());
         LineDiagonal =register("line_diagonal",new LineBlocks());
         LineLeftBend =register("line_left_bend",new LineBlocks());
         LineRightBend =register("line_right_bend",new LineBlocks());
         LineForkLeft =register("line_fork_left",new LineBlocks());
         LineForkRight =register("line_fork_right",new LineBlocks());
         LineStraightThick =register("thick_line_straight",new LineBlocks());
         LineStraightDuoLine =register("line_duo_straight",new LineBlocks());
         LineStraightDuoThick =register("thick_line_duo_straight",new LineBlocks());
         LineStraightDuoThickDashed =register("thick_line_duo_straight_dashed",new LineBlocks());
         LineDecelerateWithLine =register("line_decelerate_w_line",new LineBlocks());
         LineDecelerateWithLineFlip =register("line_decelerate_w_line_flip",new LineBlocks());
         LineDecelerateNoLine =register("line_decelerate",new LineBlocks());
         LineDecelerateNoLineFlip =register("line_decelerate_flip",new LineBlocks());
        //创建箭头贴纸
         ArrowForward =register("arrow_forward",new ArrowBlocks());
         ArrowLeft =register("arrow_left",new ArrowBlocks());
         ArrowRight =register("arrow_right",new ArrowBlocks());
         ArrowForwardLeft =register("arrow_forward_left",new ArrowBlocks());
         ArrowForwardRight =register("arrow_forward_right",new ArrowBlocks());
         ArrowBack =register("arrow_back",new ArrowBlocks());
         ArrowLeftRight =register("arrow_left_right",new ArrowBlocks());
         ArrowBackLeft =register("arrow_back_left",new ArrowBlocks());
         ArrowBackForward =register("arrow_back_forward",new ArrowBlocks());
         ArrowConfluenceLeft =register("arrow_confluence_left",new ArrowBlocks());
         ArrowConfluenceRight =register("arrow_confluence_right",new ArrowBlocks());
        //创建装饰方块
         Railings =register("railings",new Railings());
         PavementRailings =register("pavement_railings",new PavementRailings());
         ExpresswayRailingsBase =register("expressway_railings_base",new ExpresswayRailingsBase());
         ExpresswayRailings =register("expressway_railings",new ExpresswayRailings());
         ExpresswayRailingsType2 =register("expressway_railings_type2",new ExpresswayRailingsType2());
         InsulationPanelsRailings =register("insulation_panels_railings",new InsulationPanelsRailings());
         InsulationPanelsGrayPart1 =register("insulation_panels_gray_part1",new InsulationPanelsGrayPart1());
         InsulationPanelsGrayPart2 =register("insulation_panels_gray_part2",new InsulationPanelsGrayPart2());
         InsulationPanelsGrayPart3 =register("insulation_panels_gray_part3",new InsulationPanelsGrayPart3());
         InsulationPanelsGrayPart4 =register("insulation_panels_gray_part4",new InsulationPanelsGrayPart4());
         InsulationPanelsGrayPart5 =register("insulation_panels_gray_part5",new InsulationPanelsGrayPart5());
         InsulationPanelsGrayPart6 =register("insulation_panels_gray_part6",new InsulationPanelsGrayPart6());

         BarrierBar =register("barrier_bar",new BarrierBar());
         TrafficLight =register("traffic_light",new TrafficLight());
         TrafficLightPavement =register("traffic_light_pavement",new TrafficLightPavement());
         RoadLight =register("road_light",new RoadLight());

         PillarBase =registerPillar("pillar_base",new PillarBase());
         HorizontalStraightPillar =registerPillar("horizontal_straight_pillar",new HorizontalStraightPillar());
         VerticalStraightPillar =registerPillar("vertical_straight_pillar",new VerticalStraightPillar());
         HorizontalCornerPillar =registerPillar("horizontal_corner_pillar",new HorizontalCornerPillar());
         VerticalCornerPillar =registerPillar("vertical_corner_pillar",new VerticalCornerPillar());
         HorizontalTshapedPillar =registerPillar("horizontal_tshaped_pillar",new HorizontalTshapedPillar());
         VerticalTshapedPillar =registerPillar("vertical_tshaped_pillar",new VerticalTshapedPillar());
         VerticalTshapedPillarType2 =registerPillar("vertical_tshaped_pillar_type2",new VerticalTshapedPillarType2());
         RoadMastPillarBase =registerPillar("road_mast_pillar_base",new RoadMastPillarBase());
         RoadMastPillar =registerPillar("road_mast_pillar",new RoadMastPillar());
         HorizontalStraightPillarThin =registerPillar("horizontal_straight_pillar_thin",new HorizontalStraightPillarThin());
         VerticalStraightPillarThin =registerPillar("vertical_straight_pillar_thin",new VerticalStraightPillarThin());
         VerticalCornerPillarThin =registerPillar("vertical_corner_pillar_thin",new VerticalCornerPillarThin());
         SmartPillar =registerPillar("smart_pillar",new SmartPillar());
        SmartPillarThin =registerPillar("smart_pillar_thin",new SmartPillar());

         SignIndicatorDirectionLeft =register("sign_indicator_direction_left",new SignIndicatorDirectionLeft());
         SignIndicatorDirectionRight =register("sign_indicator_direction_right",new SignIndicatorDirectionRight());
         SignIndicatorDirectionCar =register("sign_indicator_direction_car",new SignIndicatorDirectionCar());
         SignIndicatorDirectionBicycle =register("sign_indicator_direction_bicycle",new SignIndicatorDirectionBicycle());
         SignBanNoDrive =register("sign_ban_no_drive",new SignBanNoDrive());
         SignBanStop =register("sign_ban_stop",new SignBanStop());
         SignBanSpeedLimit05 =register("sign_ban_speed_limit_05",new SignBanSpeedLimit05());
         SignBanSpeedLimit20 =register("sign_ban_speed_limit_20",new SignBanSpeedLimit20());
         SignBanSpeedLimit30 =register("sign_ban_speed_limit_30",new SignBanSpeedLimit30());
         SignBanSpeedLimit40 =register("sign_ban_speed_limit_40",new SignBanSpeedLimit40());
         SignBanSpeedLimit50 =register("sign_ban_speed_limit_50",new SignBanSpeedLimit50());
         SignBanSpeedLimit60 =register("sign_ban_speed_limit_60",new SignBanSpeedLimit60());
         SignBanSpeedLimit70 =register("sign_ban_speed_limit_70",new SignBanSpeedLimit70());
         SignBanSpeedLimit80 =register("sign_ban_speed_limit_80",new SignBanSpeedLimit80());

         RubbishBinMetal =register("rubbish_bin_metal",new RubbishBinMetal());
         TrashBinGreen =register("trash_bin_green",new TrashBinGreen());
         RoadNameSign =register("road_name_sign",new RoadNameSign());


        AFRoads.LOGGER.info("AFRoads Blocks Initialized");
    }
}
