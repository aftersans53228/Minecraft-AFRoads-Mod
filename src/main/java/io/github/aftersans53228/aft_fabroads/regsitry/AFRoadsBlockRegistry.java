package io.github.aftersans53228.aft_fabroads.regsitry;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.AFRoadsStatics;
import io.github.aftersans53228.aft_fabroads.block.*;
import io.github.aftersans53228.aft_fabroads.block.blockentites.*;
import io.github.aftersans53228.aft_fabroads.block.pillarblock.*;
import io.github.aftersans53228.aft_fabroads.block.signblock.SignNormal;
import io.github.aftersans53228.aft_fabroads.block.stickerblock.ArrowBlocks;
import io.github.aftersans53228.aft_fabroads.block.stickerblock.IconBlocks;
import io.github.aftersans53228.aft_fabroads.block.stickerblock.LineBlocks;
import io.github.aftersans53228.aft_fabroads.block.structureblock.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.github.aftersans53228.aft_fabroads.block.voxelshapes.RailingsFacing.*;

public class AFRoadsBlockRegistry {
    
    private static Block register(String id, Block block) {
        return (Block)Registry.register(Registry.BLOCK, new Identifier(AFRoadsStatics.MOD_ID,id), block);
    }
    private static Block registerPillar(String id, Block block) {
        AFRoadsStatics.PILLAR_BLOCKS.add(block);
        return (Block)Registry.register(Registry.BLOCK, new Identifier(AFRoadsStatics.MOD_ID,id), block);
    }
    private static Block setPillarConnect(Block block){
        AFRoadsStatics.CAN_PILLAR_CONNECT.add(block);
        return block;
    }
    private static Block registerTrafficLight(String id, Block block){
        AFRoadsStatics.TRAFFIC_LIGHTS.add(block);
        return (Block)Registry.register(Registry.BLOCK, new Identifier(AFRoadsStatics.MOD_ID,id), block);
    }


    public static  Block RoadBlock;
    public static  Block RoadBlockConcrete;
    public static  Block ManholeCover;
    public static  Block ManholeCoverConcrete;
    public static  Block RoadSeamsBlock ;
    public static  Block RoadSeamsBlockConcrete ;
    public static  Block ConcreteSlab ;
    public static  Block ConcreteStairs;
    public static  Block ConcreteStairsSmooth ;
    public static  Block ConcreteColumnsCorner;
    //创建划线贴纸
    public static  Block LineStraight;
    public static  Block LineCorner ;
    public static  Block LineTshaped ;
    public static  Block LineCross ;
    public static  Block LineDiagonal ;
    public static  Block LineLeftBend ;
    public static  Block LineRightBend ;
    public static  Block LineForkLeft ;
    public static  Block LineForkRight ;
    public static  Block LineStraightThick;
    public static  Block LineStraightDuoLine;
    public static  Block LineStraightDuoThick;
    public static  Block LineStraightDuoThickDashed;
    public static  Block LineDecelerateWithLine ;
    public static  Block LineDecelerateWithLineFlip ;
    public static  Block LineDecelerateNoLine ;
    public static  Block LineDecelerateNoLineFlip ;
    public static  Block LineDecelerateDoubleNL ;
    public static  Block LineDecelerateDoubleWL ;
    public static  Block LineReversibleLanes  ;
    public static  Block LineReversibleLanesFlip  ;
    public static  Block LineReversibleLanesDouble ;
    //创建箭头贴纸
    public static  Block ArrowForward;
    public static  Block ArrowLeft ;
    public static  Block ArrowRight;
    public static  Block ArrowForwardLeft ;
    public static  Block ArrowForwardRight ;
    public static  Block ArrowBack ;
    public static  Block ArrowLeftRight ;
    public static  Block ArrowBackLeft ;
    public static  Block ArrowBackForward ;
    public static  Block ArrowConfluenceLeft ;
    public static  Block ArrowConfluenceRight ;
    //创建图标贴纸
    public static  Block IconDecelerateSticker;
    public static  Block IconStopSticker;
    public static  Block IconGiverWaySticker;
    //创建装饰方块
    public static  Block Railings ;
    public static  Block PavementRailings ;
    public static  Block ExpresswayRailingsBase ;
    public static  Block ExpresswayIronRailings;
    public static  Block ExpresswayIronRailings2;
    public static  Block ExpresswayRailings ;
    public static  Block ExpresswayRailingsType2 ;
    public static  Block InsulationPanelsRailings ;
    public static  Block InsulationPanelsGrayPart1 ;
    public static  Block InsulationPanelsGrayPart2;
    public static  Block InsulationPanelsGrayPart3 ;
    public static  Block InsulationPanelsGrayPart4;
    public static  Block InsulationPanelsGrayPart5;
    public static  Block InsulationPanelsGrayPart6 ;

    public static  Block BarrierBar;
    public static  Block TrafficLightsControlBox;
    public static  Block TrafficLight ;
    public static  Block TrafficLightLeftTurn ;
    public static  Block TrafficLightPavement ;
    public static  Block RoadLight ;

    public static  Block PillarBase ;
    public static  Block HorizontalStraightPillar;
    public static  Block VerticalStraightPillar ;
    public static  Block HorizontalCornerPillar ;
    public static  Block VerticalCornerPillar ;
    public static  Block HorizontalTshapedPillar ;
    public static  Block VerticalTshapedPillar ;
    public static  Block VerticalTshapedPillarLarge ;
    public static  Block VerticalTshapedPillarType2 ;
    public static  Block RoadMastPillarBase ;
    public static  Block RoadMastPillar;
    public static  Block HorizontalStraightPillarThin ;
    public static  Block VerticalStraightPillarThin ;
    public static  Block VerticalCornerPillarThin;
    public static  Block SmartPillar;
    public static  Block SmartPillarThin;

    public static  Block SignIndicatorDirectionLeft ;
    public static  Block SignIndicatorDirectionRight;
    public static  Block SignIndicatorDirectionCar ;
    public static  Block SignIndicatorDirectionBicycle ;
    public static  Block SignBanNoDrive ;
    public static  Block SignBanStop;
    public static  Block SignBanSpeedLimit05 ;
    public static  Block SignBanSpeedLimit20 ;
    public static  Block SignBanSpeedLimit30 ;
    public static  Block SignBanSpeedLimit40 ;
    public static  Block SignBanSpeedLimit50 ;
    public static  Block SignBanSpeedLimit60 ;
    public static  Block SignBanSpeedLimit70 ;
    public static  Block SignBanSpeedLimit80 ;

    public static  Block RubbishBinMetal;
    public static  Block TrashBinGreen;
    public static  Block RoadNameSign ;

    //misc
    public static  Block LightSource;


    //方块实体
    public static BlockEntityType<TrafficLightEntity> TRAFFIC_LIGHT_ENTITY;
    public static BlockEntityType<TrafficLightLeftTurnEntity> TRAFFIC_LIGHT_LEFT_TURN_ENTITY;
    public static BlockEntityType<TrafficLightPavementEntity> TRAFFIC_LIGHT_PAVEMENT_ENTITY;
    public static BlockEntityType<RoadLightEntity>ROAD_LIGHT_ENTITY;
    public static BlockEntityType<RoadNameSignEntity>ROAD_NAME_SIGN_ENTITY;
    public static BlockEntityType<TrafficLightsControlEntity>TRAFFIC_LIGHTS_CONTROL_ENTITY;


    public static void RegisterBlock(){
        RoadBlock =register("road_block",new RandomFullBlock("road_block"));
        RoadBlockConcrete =register("road_block_concrete",new RandomFullBlock("road_block"));
        ManholeCover =register("manhole_cover",new RoadFullBlock("road_manhole_cover"));
        ManholeCoverConcrete =register("manhole_cover_concrete",new RoadFullBlock("road_manhole_cover"));
        RoadSeamsBlock =register("road_seams_block",new RoadFullBlock("road_seam"));
        RoadSeamsBlockConcrete =register("road_seams_block_concrete",new RoadFullBlock("road_seam"));
        ConcreteSlab =register("concrete_slab",new ConcreteSlab());
        ConcreteStairs =register("concrete_stairs",new ConcreteStairs());
        ConcreteStairsSmooth =register("concrete_stairs_smooth",new ConcreteStairs());
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
        LineDecelerateDoubleWL =register("line_decelerate_d_w_l",new LineBlocks());
        LineDecelerateDoubleNL =register("line_decelerate_d_n_l",new LineBlocks());
        LineReversibleLanes=register("line_reversible_lanes",new LineBlocks());
        LineReversibleLanesFlip=register("line_reversible_lanes_flip",new LineBlocks());
        LineReversibleLanesDouble = register("line_reversible_lanes_double",new LineBlocks());
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
        //创建图标贴纸
        IconDecelerateSticker =register("icon_decelerate_sticker",new IconBlocks());
        IconStopSticker =register("icon_stop_sticker",new IconBlocks());
        IconGiverWaySticker =register("icon_give_way_sticker",new IconBlocks());
        //创建装饰方块
        Railings =register("railings",new HorizontalRailings().setVoxelShapes(getRoad()));
        PavementRailings =register("pavement_railings",new HorizontalRailings().setVoxelShapes(getPavement()));
        ExpresswayRailingsBase =register("expressway_railings_base",new HorizontalRailings().setVoxelShapes(getExpresswayBase()));
        ExpresswayIronRailings =register("expressway_iron_railings",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsCorner1()).setTipsMode(false));
        ExpresswayIronRailings2 =register("expressway_iron_railings2",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsCorner1()).setTipsMode(false));
        ExpresswayRailings =register("expressway_railings",new HorizontalRailings().setVoxelShapes(getExpresswayRailings()));
        ExpresswayRailingsType2 =register("expressway_railings_type2",new HorizontalRailings().setVoxelShapes(getExpresswayRailings()));
        InsulationPanelsRailings =register("insulation_panels_railings",new HorizontalRailings().setVoxelShapes(getExpresswayGreenPanels()));
        InsulationPanelsGrayPart1 =register("insulation_panels_gray_part1",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsVertical()));
        InsulationPanelsGrayPart2 =register("insulation_panels_gray_part2",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsVertical()));
        InsulationPanelsGrayPart3 =register("insulation_panels_gray_part3",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsCorner1()));
        InsulationPanelsGrayPart4 =register("insulation_panels_gray_part4",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsCorner2()));
        InsulationPanelsGrayPart5 =register("insulation_panels_gray_part5",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsHorizontal()));
        InsulationPanelsGrayPart6 =register("insulation_panels_gray_part6",new InsulationPanelsGray().setVoxelShapes(getGrayPanelsHorizontal()));

        BarrierBar =register("barrier_bar",new BarrierBar());
        TrafficLightsControlBox =register("traffic_lights_control_box",new TrafficLightsControlBox());
        TrafficLight =setPillarConnect(registerTrafficLight("traffic_light",new TrafficLight()));
        TrafficLightLeftTurn =setPillarConnect(registerTrafficLight("traffic_light_left_turn",new TrafficLightLeftTurn()));
        TrafficLightPavement =setPillarConnect(registerTrafficLight("traffic_light_pavement",new TrafficLightPavement()));
        RoadLight =setPillarConnect(register("road_light",new RoadLight()));

        PillarBase =registerPillar("pillar_base",new PillarBase());
        HorizontalStraightPillar =registerPillar("horizontal_straight_pillar",new HorizontalStraightPillar());
        VerticalStraightPillar =registerPillar("vertical_straight_pillar",new VerticalStraightPillar());
        HorizontalCornerPillar =registerPillar("horizontal_corner_pillar",new HorizontalCornerPillar());
        VerticalCornerPillar =registerPillar("vertical_corner_pillar",new VerticalCornerPillar());
        HorizontalTshapedPillar =registerPillar("horizontal_tshaped_pillar",new HorizontalTshapedPillar());
        VerticalTshapedPillar =registerPillar("vertical_tshaped_pillar",new VerticalTshapedPillar());
        VerticalTshapedPillarLarge =registerPillar("vertical_tshaped_pillar_large",new VerticalTshapedPillar());
        VerticalTshapedPillarType2 =registerPillar("vertical_tshaped_pillar_type2",new VerticalTshapedPillarType2());
        RoadMastPillarBase =registerPillar("road_mast_pillar_base",new RoadMastPillarBase());
        RoadMastPillar =registerPillar("road_mast_pillar",new RoadMastPillar());
        HorizontalStraightPillarThin =registerPillar("horizontal_straight_pillar_thin",new HorizontalStraightPillarThin());
        VerticalStraightPillarThin =registerPillar("vertical_straight_pillar_thin",new VerticalStraightPillarThin());
        VerticalCornerPillarThin =registerPillar("vertical_corner_pillar_thin",new VerticalCornerPillarThin());
        SmartPillar =registerPillar("smart_pillar",new SmartPillar());
        SmartPillarThin =registerPillar("smart_pillar_thin",new SmartPillar());

        SignIndicatorDirectionLeft =setPillarConnect(register("sign_indicator_direction_left",new SignNormal()));
        SignIndicatorDirectionRight =setPillarConnect(register("sign_indicator_direction_right",new SignNormal()));
        SignIndicatorDirectionCar =setPillarConnect(register("sign_indicator_direction_car",new SignNormal()));
        SignIndicatorDirectionBicycle =setPillarConnect(register("sign_indicator_direction_bicycle",new SignNormal()));
        SignBanNoDrive =setPillarConnect(register("sign_ban_no_drive",new SignNormal()));
        SignBanStop =setPillarConnect(register("sign_ban_stop",new SignNormal()));
        SignBanSpeedLimit05 =setPillarConnect(register("sign_ban_speed_limit_05",new SignNormal()));
        SignBanSpeedLimit20 =setPillarConnect(register("sign_ban_speed_limit_20",new SignNormal()));
        SignBanSpeedLimit30 =setPillarConnect(register("sign_ban_speed_limit_30",new SignNormal()));
        SignBanSpeedLimit40 =setPillarConnect(register("sign_ban_speed_limit_40",new SignNormal()));
        SignBanSpeedLimit50 =setPillarConnect(register("sign_ban_speed_limit_50",new SignNormal()));
        SignBanSpeedLimit60 =setPillarConnect(register("sign_ban_speed_limit_60",new SignNormal()));
        SignBanSpeedLimit70 =setPillarConnect(register("sign_ban_speed_limit_70",new SignNormal()));
        SignBanSpeedLimit80 =setPillarConnect(register("sign_ban_speed_limit_80",new SignNormal()));

        RubbishBinMetal =register("rubbish_bin_metal",new RubbishBinMetal());
        TrashBinGreen =register("trash_bin_green",new TrashBinGreen());
        RoadNameSign =setPillarConnect(register("road_name_sign",new RoadNameSign()));
        //misc
        //LightSource =register("light_source",new Block(FabricBlockSettings.of(Material.AIR).hardness(0.5f).luminance(15).noCollision().nonOpaque()));

        //注册方块实体
        TRAFFIC_LIGHT_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,new Identifier ("aft_fabroads:traffic_light_entity"), FabricBlockEntityTypeBuilder.create(TrafficLightEntity::new,TrafficLight).build(null));
        TRAFFIC_LIGHT_LEFT_TURN_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,new Identifier ("aft_fabroads:traffic_light_left_turn_entity"), FabricBlockEntityTypeBuilder.create(TrafficLightLeftTurnEntity::new,TrafficLightLeftTurn).build(null));
        TRAFFIC_LIGHT_PAVEMENT_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("aft_fabroads:traffic_light_pavement_entity"), FabricBlockEntityTypeBuilder.create(TrafficLightPavementEntity::new,TrafficLightPavement).build(null));
        ROAD_LIGHT_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("aft_fabroads:road_light_entity"), FabricBlockEntityTypeBuilder.create(RoadLightEntity::new,RoadLight).build(null));
        ROAD_NAME_SIGN_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("aft_fabroads:road_name_sign_entity"), FabricBlockEntityTypeBuilder.create(RoadNameSignEntity::new,RoadNameSign).build(null));
        TRAFFIC_LIGHTS_CONTROL_ENTITY=Registry.register(Registry.BLOCK_ENTITY_TYPE,new Identifier("aft_fabroads:traffic_lights_control_entity"),FabricBlockEntityTypeBuilder.create(TrafficLightsControlEntity::new,TrafficLightsControlBox).build(null));

        AFRoads.LOGGER.info("AFRoads Blocks Initialized");
    }
}
