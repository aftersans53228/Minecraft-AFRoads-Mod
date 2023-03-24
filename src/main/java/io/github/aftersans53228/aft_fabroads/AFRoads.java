package io.github.aftersans53228.aft_fabroads;


import io.github.aftersans53228.aft_fabroads.block.*;
import io.github.aftersans53228.aft_fabroads.block.arrowblock.*;
import io.github.aftersans53228.aft_fabroads.block.pillarBlock.*;
import io.github.aftersans53228.aft_fabroads.block.signBlock.*;
import io.github.aftersans53228.aft_fabroads.block.structureBlock.ConcreteColumnsCorner;
import io.github.aftersans53228.aft_fabroads.block.structureBlock.ConcreteSlab;
import io.github.aftersans53228.aft_fabroads.block.structureBlock.ConcreteStairs;
import io.github.aftersans53228.aft_fabroads.block.structureBlock.ConcreteStairsSmooth;
import io.github.aftersans53228.aft_fabroads.command.AftCommand;
import io.github.aftersans53228.aft_fabroads.item.NormalRoadBlock;
import io.github.aftersans53228.aft_fabroads.item.RoadDecoration;
import io.github.aftersans53228.aft_fabroads.item.RoadStickers;
import io.github.aftersans53228.aft_fabroads.item.RoadTool;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;


public class AFRoads implements ModInitializer {
	// 此记录器用于将文本写入控制台和日志文件。
	// 使用您的 mod id 作为记录器的名称被认为是最佳实践。
	// 这样一来，很清楚哪个 mod 写了信息、警告和错误。
	public static final Logger LOGGER = LogManager.getLogger("aft_fabroads");



	//交通灯计时器
	public static int traffic_lights_timer =0 ;

	//方块实体
	public static BlockEntityType<TrafficLightEntity> TRAFFIC_LIGHT_ENTITY;
	public static BlockEntityType<TrafficLightPavementEntity> TRAFFIC_LIGHT_PAVEMENT_ENTITY;
	public static BlockEntityType<RoadLightEntity>ROAD_LIGHT_ENTITY;
	public static BlockEntityType<RoadNameSignEntity>ROAD_NAME_SIGN_ENTITY;

	//创建物品
	public static final Item RoadTool = new RoadTool();
	public static final Item TrafficLightBulbRed = new Item(new FabricItemSettings());
	public static final Item TrafficLightBulbGreen = new Item(new FabricItemSettings());
	public static final Item TrafficLightBulbYellow = new Item(new FabricItemSettings());
	public static final Item TrafficLightPavementBulbRed = new Item(new FabricItemSettings());
	public static final Item TrafficLightPavementBulbGreen = new Item(new FabricItemSettings());
	public static final Item RoadLightBulbCold = new Item(new FabricItemSettings());
	public static final Item RoadLightBulbWarm = new Item(new FabricItemSettings());
	//创建普通道路方块
	public static final Block RoadBlock = new RoadBlock();
	public static final Block RoadBlockConcrete = new RoadBlockConcrete();
	public static final Block ManholeCover = new ManholeCover();
	public static final Block ManholeCoverConcrete = new ManholeCoverConcrete();
	public static final Block RoadSeamsBlock = new RoadSeamsBlock();
	public static final Block RoadSeamsBlockConcrete = new RoadSeamsBlockConcrete();
	public static final Block ConcreteSlab = new ConcreteSlab();
	public static final Block ConcreteStairs = new ConcreteStairs();
	public static final Block ConcreteStairsSmooth = new ConcreteStairsSmooth();
	public static final Block ConcreteColumnsCorner = new ConcreteColumnsCorner();
	//创建划线贴纸
	public static final Block LineStraight = new LineBlocks();
	public static final Block LineCorner = new LineBlocks();
	public static final Block LineTshaped = new LineBlocks();
	public static final Block LineCross = new LineBlocks();
	public static final Block LineDiagonal = new LineBlocks();
	public static final Block LineLeftBend = new LineBlocks();
	public static final Block LineRightBend = new LineBlocks();
	public static final Block LineForkLeft = new LineBlocks();
	public static final Block LineForkRight = new LineBlocks();
	public static final Block LineStraightThick = new LineBlocks();
	//创建箭头贴纸
	public static final Block ArrowForward = new ArrowBlocks();
	public static final Block ArrowLeft = new ArrowBlocks();
	public static final Block ArrowRight = new ArrowBlocks();
	public static final Block ArrowForwardLeft = new ArrowBlocks();
	public static final Block ArrowForwardRight = new ArrowBlocks();
	public static final Block ArrowBack = new ArrowBlocks();
	public static final Block ArrowLeftRight = new ArrowBlocks();
	public static final Block ArrowBackLeft = new ArrowBlocks();
	public static final Block ArrowBackForward = new ArrowBlocks();
	public static final Block ArrowConfluenceLeft = new ArrowBlocks();
	public static final Block ArrowConfluenceRight = new ArrowBlocks();
	//创建装饰方块
	public static final Block Railings = new Railings();
	public static final Block PavementRailings = new PavementRailings();
	public static final Block ExpresswayRailingsBase = new ExpresswayRailingsBase();
	public static final Block ExpresswayRailings = new ExpresswayRailings();
	public static final Block ExpresswayRailingsType2 = new ExpresswayRailingsType2();
	public static final Block InsulationPanelsRailings = new InsulationPanelsRailings();
	public static final Block InsulationPanelsGrayPart1 = new InsulationPanelsGrayPart1();
	public static final Block InsulationPanelsGrayPart2 = new InsulationPanelsGrayPart2();
	public static final Block InsulationPanelsGrayPart3 = new InsulationPanelsGrayPart3();
	public static final Block InsulationPanelsGrayPart4 = new InsulationPanelsGrayPart4();
	public static final Block InsulationPanelsGrayPart5 = new InsulationPanelsGrayPart5();
	public static final Block InsulationPanelsGrayPart6 = new InsulationPanelsGrayPart6();

	public static final Block BarrierBar = new BarrierBar();
	public static final Block TrafficLight = new TrafficLight();
	public static final Block TrafficLightPavement = new TrafficLightPavement();
	public static final Block RoadLight = new RoadLight();

	public static final Block PillarBase = new PillarBase();
	public static final Block HorizontalStraightPillar = new HorizontalStraightPillar();
	public static final Block VerticalStraightPillar = new VerticalStraightPillar();
	public static final Block HorizontalCornerPillar = new HorizontalCornerPillar();
	public static final Block VerticalCornerPillar = new VerticalCornerPillar();
	public static final Block HorizontalTshapedPillar = new HorizontalTshapedPillar();
	public static final Block VerticalTshapedPillar = new VerticalTshapedPillar();
	public static final Block VerticalTshapedPillarType2 = new VerticalTshapedPillarType2();
	public static final Block RoadMastPillarBase = new RoadMastPillarBase();
	public static final Block RoadMastPillar = new RoadMastPillar();
	public static final Block HorizontalStraightPillarThin = new HorizontalStraightPillarThin();
	public static final Block VerticalStraightPillarThin = new VerticalStraightPillarThin();
	public static final Block VerticalCornerPillarThin = new VerticalCornerPillarThin();

	public static final Block SignIndicatorDirectionLeft = new SignIndicatorDirectionLeft();
	public static final Block SignIndicatorDirectionRight = new SignIndicatorDirectionRight();
	public static final Block SignIndicatorDirectionCar = new SignIndicatorDirectionCar();
	public static final Block SignIndicatorDirectionBicycle = new SignIndicatorDirectionBicycle();
	public static final Block SignBanNoDrive = new SignBanNoDrive();
	public static final Block SignBanStop = new SignBanStop();
	public static final Block SignBanSpeedLimit05 = new SignBanSpeedLimit05();
	public static final Block SignBanSpeedLimit20 = new SignBanSpeedLimit20();
	public static final Block SignBanSpeedLimit30 = new SignBanSpeedLimit30();
	public static final Block SignBanSpeedLimit40 = new SignBanSpeedLimit40();
	public static final Block SignBanSpeedLimit50 = new SignBanSpeedLimit50();
	public static final Block SignBanSpeedLimit60 = new SignBanSpeedLimit60();
	public static final Block SignBanSpeedLimit70 = new SignBanSpeedLimit70();
	public static final Block SignBanSpeedLimit80 = new SignBanSpeedLimit80();

	public static final Block RubbishBinMetal = new RubbishBinMetal();
	public static final Block TrashBinGreen = new TrashBinGreen();
	public static final Block RoadNameSign = new RoadNameSign();


	//创建物品组
	public static final ItemGroup NormalRoadBlockGROUP = NormalRoadBlock.get();
	public static final ItemGroup RoadStickersGROUP = RoadStickers.get();
	public static final ItemGroup RoadDecorationsGROUP = RoadDecoration.get();





    @Override
	public void onInitialize() {
		// 只要 Minecraft 处于 mod-load-ready 状态，此代码就会运行。
		// 但是，有些东西（比如资源）可能仍然未初始化。
		// 谨慎行事。



		//物品注册
		Registry.register(Registry.ITEM, new Identifier("aft_fabroads", "road_tool"),RoadTool);
		Registry.register(Registry.ITEM, new Identifier("aft_fabroads", "traffic_light_green_bulb"),TrafficLightBulbGreen);
		Registry.register(Registry.ITEM, new Identifier("aft_fabroads", "traffic_light_red_bulb"),TrafficLightBulbRed);
		Registry.register(Registry.ITEM, new Identifier("aft_fabroads", "traffic_light_yellow_bulb"),TrafficLightBulbYellow);
		Registry.register(Registry.ITEM, new Identifier("aft_fabroads", "traffic_light_pavement_red_bulb"),TrafficLightPavementBulbRed);
		Registry.register(Registry.ITEM, new Identifier("aft_fabroads", "traffic_light_pavement_green_bulb"),TrafficLightPavementBulbGreen);
		Registry.register(Registry.ITEM, new Identifier("aft_fabroads", "road_light_bulb_cold"),RoadLightBulbCold);
		Registry.register(Registry.ITEM, new Identifier("aft_fabroads", "road_light_bulb_warm"),RoadLightBulbWarm);

		//普通方块注册
		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","road_block"),RoadBlock);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","road_block"),new BlockItem(RoadBlock,new Item.Settings().group(NormalRoadBlockGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","road_block_concrete"),RoadBlockConcrete);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","road_block_concrete"),new BlockItem(RoadBlockConcrete,new Item.Settings().group(NormalRoadBlockGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","manhole_cover"),ManholeCover);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","manhole_cover"),new BlockItem(ManholeCover,new Item.Settings().group(NormalRoadBlockGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","manhole_cover_concrete"),ManholeCoverConcrete);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","manhole_cover_concrete"),new BlockItem(ManholeCoverConcrete,new Item.Settings().group(NormalRoadBlockGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","road_seams_block"),RoadSeamsBlock);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","road_seams_block"),new BlockItem(RoadSeamsBlock,new Item.Settings().group(NormalRoadBlockGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","road_seams_block_concrete"),RoadSeamsBlockConcrete);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","road_seams_block_concrete"),new BlockItem(RoadSeamsBlockConcrete,new Item.Settings().group(NormalRoadBlockGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","concrete_slab"),ConcreteSlab);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","concrete_slab"),new BlockItem(ConcreteSlab,new Item.Settings().group(NormalRoadBlockGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","concrete_stairs"),ConcreteStairs);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","concrete_stairs"),new BlockItem(ConcreteStairs,new Item.Settings().group(NormalRoadBlockGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","concrete_stairs_smooth"),ConcreteStairsSmooth);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","concrete_stairs_smooth"),new BlockItem(ConcreteStairsSmooth,new Item.Settings().group(NormalRoadBlockGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","concrete_columns_corner"), ConcreteColumnsCorner);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","concrete_columns_corner"),new BlockItem(ConcreteColumnsCorner,new Item.Settings().group(NormalRoadBlockGROUP)));



		//地面划线注册
		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","line_straight"),LineStraight);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","line_straight"),new BlockItem(LineStraight,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","line_corner"),LineCorner);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","line_corner"),new BlockItem(LineCorner,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","line_tshaped"),LineTshaped);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","line_tshaped"),new BlockItem(LineTshaped,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","line_cross"),LineCross);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","line_cross"),new BlockItem(LineCross,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","line_diagonal"),LineDiagonal);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","line_diagonal"),new BlockItem(LineDiagonal,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","line_left_bend"),LineLeftBend);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","line_left_bend"),new BlockItem(LineLeftBend,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","line_right_bend"),LineRightBend);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","line_right_bend"),new BlockItem(LineRightBend,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","line_fork_left"),LineForkLeft);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","line_fork_left"),new BlockItem(LineForkLeft,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","line_fork_right"),LineForkRight);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","line_fork_right"),new BlockItem(LineForkRight,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","thick_line_straight"),LineStraightThick);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","thick_line_straight"),new BlockItem(LineStraightThick,new Item.Settings().group(RoadStickersGROUP)));



		//地面箭头注册
		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","arrow_forward"),ArrowForward);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","arrow_forward"),new BlockItem(ArrowForward,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","arrow_left"),ArrowLeft);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","arrow_left"),new BlockItem(ArrowLeft,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","arrow_right"),ArrowRight);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","arrow_right"),new BlockItem(ArrowRight,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","arrow_forward_left"),ArrowForwardLeft);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","arrow_forward_left"),new BlockItem(ArrowForwardLeft,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","arrow_forward_right"),ArrowForwardRight);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","arrow_forward_right"),new BlockItem(ArrowForwardRight,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","arrow_back"),ArrowBack);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","arrow_back"),new BlockItem(ArrowBack,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","arrow_left_right"), ArrowLeftRight);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","arrow_left_right"),new BlockItem(ArrowLeftRight,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","arrow_back_left"), ArrowBackLeft);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","arrow_back_left"),new BlockItem(ArrowBackLeft,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","arrow_back_forward"), ArrowBackForward);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","arrow_back_forward"),new BlockItem(ArrowBackForward,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","arrow_confluence_left"), ArrowConfluenceLeft);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","arrow_confluence_left"),new BlockItem(ArrowConfluenceLeft,new Item.Settings().group(RoadStickersGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","arrow_confluence_right"), ArrowConfluenceRight);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","arrow_confluence_right"),new BlockItem(ArrowConfluenceRight,new Item.Settings().group(RoadStickersGROUP)));

		//道路装饰注册
		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","railings"), Railings);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","railings"),new BlockItem(Railings,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","pavement_railings"), PavementRailings);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","pavement_railings"),new BlockItem(PavementRailings,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","expressway_railings_base"), ExpresswayRailingsBase);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","expressway_railings_base"),new BlockItem(ExpresswayRailingsBase,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","expressway_railings"), ExpresswayRailings);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","expressway_railings"),new BlockItem(ExpresswayRailings,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","expressway_railings_type2"), ExpresswayRailingsType2);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","expressway_railings_type2"),new BlockItem(ExpresswayRailingsType2,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","insulation_panels_railings"), InsulationPanelsRailings);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","insulation_panels_railings"),new BlockItem(InsulationPanelsRailings,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","insulation_panels_gray_part1"), InsulationPanelsGrayPart1);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","insulation_panels_gray_part1"),new BlockItem(InsulationPanelsGrayPart1,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","insulation_panels_gray_part2"), InsulationPanelsGrayPart2);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","insulation_panels_gray_part2"),new BlockItem(InsulationPanelsGrayPart2,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","insulation_panels_gray_part3"), InsulationPanelsGrayPart3);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","insulation_panels_gray_part3"),new BlockItem(InsulationPanelsGrayPart3,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","insulation_panels_gray_part4"), InsulationPanelsGrayPart4);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","insulation_panels_gray_part4"),new BlockItem(InsulationPanelsGrayPart4,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","insulation_panels_gray_part5"), InsulationPanelsGrayPart5);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","insulation_panels_gray_part5"),new BlockItem(InsulationPanelsGrayPart5,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","insulation_panels_gray_part6"), InsulationPanelsGrayPart6);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","insulation_panels_gray_part6"),new BlockItem(InsulationPanelsGrayPart6,new Item.Settings().group(RoadDecorationsGROUP)));


		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","barrier_bar"), BarrierBar);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","barrier_bar"),new BlockItem(BarrierBar,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","traffic_light"), TrafficLight);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","traffic_light"),new BlockItem(TrafficLight,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","traffic_light_pavement"), TrafficLightPavement);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","traffic_light_pavement"),new BlockItem(TrafficLightPavement,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","road_light"), RoadLight);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","road_light"),new BlockItem(RoadLight,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","pillar_base"), PillarBase);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","pillar_base"),new BlockItem(PillarBase,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","horizontal_straight_pillar"), HorizontalStraightPillar);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","horizontal_straight_pillar"),new BlockItem(HorizontalStraightPillar,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","vertical_straight_pillar"), VerticalStraightPillar);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","vertical_straight_pillar"),new BlockItem(VerticalStraightPillar,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","horizontal_corner_pillar"), HorizontalCornerPillar);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","horizontal_corner_pillar"),new BlockItem(HorizontalCornerPillar,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","vertical_corner_pillar"), VerticalCornerPillar);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","vertical_corner_pillar"),new BlockItem(VerticalCornerPillar,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","horizontal_tshaped_pillar"), HorizontalTshapedPillar);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","horizontal_tshaped_pillar"),new BlockItem(HorizontalTshapedPillar,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","vertical_tshaped_pillar"), VerticalTshapedPillar);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","vertical_tshaped_pillar"),new BlockItem(VerticalTshapedPillar,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","vertical_tshaped_pillar_type2"), VerticalTshapedPillarType2);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","vertical_tshaped_pillar_type2"),new BlockItem(VerticalTshapedPillarType2,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","horizontal_straight_pillar_thin"), HorizontalStraightPillarThin);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","horizontal_straight_pillar_thin"),new BlockItem(HorizontalStraightPillarThin,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","vertical_straight_pillar_thin"), VerticalStraightPillarThin);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","vertical_straight_pillar_thin"),new BlockItem(VerticalStraightPillarThin,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","vertical_corner_pillar_thin"), VerticalCornerPillarThin);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","vertical_corner_pillar_thin"),new BlockItem(VerticalCornerPillarThin,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","road_mast_pillar_base"), RoadMastPillarBase);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","road_mast_pillar_base"),new BlockItem(RoadMastPillarBase,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","road_mast_pillar"), RoadMastPillar);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","road_mast_pillar"),new BlockItem(RoadMastPillar,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_indicator_direction_left"), SignIndicatorDirectionLeft);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_indicator_direction_left"),new BlockItem(SignIndicatorDirectionLeft,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_indicator_direction_right"), SignIndicatorDirectionRight);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_indicator_direction_right"),new BlockItem(SignIndicatorDirectionRight,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_indicator_direction_car"), SignIndicatorDirectionCar);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_indicator_direction_car"),new BlockItem(SignIndicatorDirectionCar,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_indicator_direction_bicycle"), SignIndicatorDirectionBicycle);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_indicator_direction_bicycle"),new BlockItem(SignIndicatorDirectionBicycle,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_ban_no_drive"), SignBanNoDrive);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_ban_no_drive"),new BlockItem(SignBanNoDrive,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_ban_stop"), SignBanStop);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_ban_stop"),new BlockItem(SignBanStop,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_05"), SignBanSpeedLimit05);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_05"),new BlockItem(SignBanSpeedLimit05,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_20"), SignBanSpeedLimit20);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_20"),new BlockItem(SignBanSpeedLimit20,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_30"), SignBanSpeedLimit30);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_30"),new BlockItem(SignBanSpeedLimit30,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_40"), SignBanSpeedLimit40);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_40"),new BlockItem(SignBanSpeedLimit40,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_50"), SignBanSpeedLimit50);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_50"),new BlockItem(SignBanSpeedLimit50,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_60"), SignBanSpeedLimit60);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_60"),new BlockItem(SignBanSpeedLimit60,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_70"), SignBanSpeedLimit70);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_70"),new BlockItem(SignBanSpeedLimit70,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_80"), SignBanSpeedLimit80);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_80"),new BlockItem(SignBanSpeedLimit80,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","rubbish_bin_metal"),RubbishBinMetal);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","rubbish_bin_metal"),new BlockItem(RubbishBinMetal,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","trash_bin_green"),TrashBinGreen);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","trash_bin_green"),new BlockItem(TrashBinGreen,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","road_name_sign"),RoadNameSign);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","road_name_sign"),new BlockItem(RoadNameSign,new Item.Settings().group(RoadDecorationsGROUP)));






		LOGGER.info("AFRoads Blocks Initialized");

		//注册方块实体
		TRAFFIC_LIGHT_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "aft_fabroads:traffic_light_entity", FabricBlockEntityTypeBuilder.create(TrafficLightEntity::new,TrafficLight).build(null));
		TRAFFIC_LIGHT_PAVEMENT_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "aft_fabroads:traffic_light_pavement_entity", FabricBlockEntityTypeBuilder.create(TrafficLightPavementEntity::new,TrafficLightPavement).build(null));
		ROAD_LIGHT_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "aft_fabroads:road_light_entity", FabricBlockEntityTypeBuilder.create(RoadLightEntity::new,RoadLight).build(null));
		ROAD_NAME_SIGN_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "aft_fabroads:road_name_sign_entity", FabricBlockEntityTypeBuilder.create(RoadNameSignEntity::new,RoadNameSign).build(null));

		//command
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> AftCommand.register(dispatcher));

		//红绿灯计时器逻辑
		ServerTickEvents.END_SERVER_TICK.register((server)->
		{
			traffic_lights_timer = traffic_lights_timer +1 ;
			if (traffic_lights_timer == 1200){
				traffic_lights_timer = 0;
			}
		});

		//服务端接包
		ServerPlayNetworking.registerGlobalReceiver(new Identifier("aft_fabroads:road_name_sign_gui_close"), (server, player, handler, buf, responseSender)->{
			BlockPos signPos =buf.readBlockPos();//坐标
			String roadName = buf.readString();//路名
			String roadName2rd = buf.readString();//路名2
			NbtCompound roadNames = new NbtCompound();
			roadNames.putString("road_names",roadName);
			roadNames.putString("road_name2rd",roadName2rd);
			boolean dirLeft =buf.readBoolean();//左边
			boolean dirRight =buf.readBoolean();//右边
			AFRoads.LOGGER.info(Boolean.toString(dirLeft)+ dirRight);

			server.execute(()->{
				BlockEntity blockEntity_ = (player.getEntityWorld().getBlockEntity(signPos));
				if (blockEntity_ != null && blockEntity_.getType() == ROAD_NAME_SIGN_ENTITY) {
					NbtCompound nbt = blockEntity_.writeNbt(roadNames);
					blockEntity_.setCachedState(blockEntity_.getCachedState().with(BooleanProperty.of("dir_left"), dirLeft));
					blockEntity_.setCachedState(blockEntity_.getCachedState().with(BooleanProperty.of("dir_right"), dirRight));
					blockEntity_.markDirty();

					AFRoads.LOGGER.info("Set Sign Name Sign "+roadNames+" "+roadName2rd+ " " + blockEntity_.getCachedState());
				} else if (blockEntity_ == null) {
					AFRoads.LOGGER.info("Invalid Block Entity");
				}
			});
		});





		LOGGER.info("AFRoads Misc Initialized");







	}

}
