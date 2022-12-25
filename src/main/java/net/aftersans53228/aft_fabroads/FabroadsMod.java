package net.aftersans53228.aft_fabroads;


import net.aftersans53228.aft_fabroads.block.*;
import net.aftersans53228.aft_fabroads.block.arrowblock.*;
import net.aftersans53228.aft_fabroads.block.pillarBlock.*;
import net.aftersans53228.aft_fabroads.block.signBlock.*;
import net.aftersans53228.aft_fabroads.command.AftCommand;
import net.aftersans53228.aft_fabroads.item.RoadTool;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FabroadsMod implements ModInitializer {
	// 此记录器用于将文本写入控制台和日志文件。
	// 使用您的 mod id 作为记录器的名称被认为是最佳实践。
	// 这样一来，很清楚哪个 mod 写了信息、警告和错误。
	public static final Logger LOGGER = LogManager.getLogger("aft_fabroads");


	// 如果有半透明纹理，可以将 RenderLayer.getCutout() 替换为 RenderLayer.getTranslucent()。

	//交通灯计时器
	public static int traffic_lights_timer =0 ;

	//方块实体
	public static BlockEntityType<TrafficLightEntity> TRAFFIC_LIGHT_ENTITY;

	//创建物品
	public static final Item RoadTool = new RoadTool();
	//创建普通道路方块
	public static final Block RoadBlock = new RoadBlock();
	public static final Block RoadBlockConcrete = new RoadBlockConcrete();
	public static final Block ManholeCover = new ManholeCover();
	public static final Block ManholeCoverConcrete = new ManholeCoverConcrete();
	public static final Block RoadSeamsBlock = new RoadSeamsBlock();
	public static final Block RoadSeamsBlockConcrete = new RoadSeamsBlockConcrete();
	//创建划线贴纸
	public static final Block LineStraight = new LineStraight();
	public static final Block LineCorner = new LineCorner();
	public static final Block LineTshaped = new LineTshaped();
	public static final Block LineCross = new LineCross();
	public static final Block LineDiagonal = new LineDiagonal();
	public static final Block LineLeftBend = new LineLeftBend();
	public static final Block LineRightBend = new LineRightBend();
	public static final Block LineForkLeft = new LineForkLeft();
	public static final Block LineForkRight = new LineForkRight();
	public static final Block LineStraightThick = new LineStraightThick();
	//创建箭头贴纸
	public static final Block ArrowForward = new ArrowForward();
	public static final Block ArrowLeft = new ArrowLeft();
	public static final Block ArrowRight = new ArrowRight();
	public static final Block ArrowForwardLeft = new ArrowForwardLeft();
	public static final Block ArrowForwardRight = new ArrowForwardRight();
	public static final Block ArrowBack = new ArrowBack();
	public static final Block ArrowLeftRight = new ArrowLeftRight();
	public static final Block ArrowBackLeft = new ArrowBackLeft();
	public static final Block ArrowBackForward = new ArrowBackForward();
	public static final Block ArrowConfluenceLeft = new ArrowConfluenceLeft();
	public static final Block ArrowConfluenceRight = new ArrowConfluenceRight();
	//创建装饰方块
	public static final Block Railings = new Railings();
	public static final Block PavementRailings = new PavementRailings();
	public static final Block ExpresswayRailingsBase = new ExpresswayRailingsBase();
	public static final Block ExpresswayRailings = new ExpresswayRailings();
	public static final Block ExpresswayRailingsType2 = new ExpresswayRailingsType2();
	public static final Block InsulationPanelsRailings = new InsulationPanelsRailings();
	public static final Block BarrierBar = new BarrierBar();
	public static final Block TrafficLight = new TrafficLight();
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



    @Override
	public void onInitialize() {
		// 只要 Minecraft 处于 mod-load-ready 状态，此代码就会运行。
		// 但是，有些东西（比如资源）可能仍然未初始化。
		// 谨慎行事。

		LOGGER.info("aft's Fabroads Initializing...");

		//物品注册
		Registry.register(Registries.ITEM, new Identifier("aft_fabroads", "road_tool"),RoadTool);
		LOGGER.info("Item Initialized...");

		//普通方块注册
		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","road_block"),RoadBlock);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","road_block"),new BlockItem(RoadBlock,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","road_block_concrete"),RoadBlockConcrete);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","road_block_concrete"),new BlockItem(RoadBlockConcrete,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","manhole_cover"),ManholeCover);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","manhole_cover"),new BlockItem(ManholeCover,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","manhole_cover_concrete"),ManholeCoverConcrete);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","manhole_cover_concrete"),new BlockItem(ManholeCoverConcrete,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","road_seams_block"),RoadSeamsBlock);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","road_seams_block"),new BlockItem(RoadSeamsBlock,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","road_seams_block_concrete"),RoadSeamsBlockConcrete);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","road_seams_block_concrete"),new BlockItem(RoadSeamsBlockConcrete,new FabricItemSettings()));

		LOGGER.info("Normal blocks Initialized...");

		//地面划线注册
		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","line_straight"),LineStraight);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","line_straight"),new BlockItem(LineStraight,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","line_corner"),LineCorner);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","line_corner"),new BlockItem(LineCorner,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","line_tshaped"),LineTshaped);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","line_tshaped"),new BlockItem(LineTshaped,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","line_cross"),LineCross);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","line_cross"),new BlockItem(LineCross,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","line_diagonal"),LineDiagonal);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","line_diagonal"),new BlockItem(LineDiagonal,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","line_left_bend"),LineLeftBend);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","line_left_bend"),new BlockItem(LineLeftBend,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","line_right_bend"),LineRightBend);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","line_right_bend"),new BlockItem(LineRightBend,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","line_fork_left"),LineForkLeft);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","line_fork_left"),new BlockItem(LineForkLeft,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","line_fork_right"),LineForkRight);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","line_fork_right"),new BlockItem(LineForkRight,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","thick_line_straight"),LineStraightThick);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","thick_line_straight"),new BlockItem(LineStraightThick,new FabricItemSettings()));

		LOGGER.info("Line blocks Initialized...");

		//地面箭头注册
		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","arrow_forward"),ArrowForward);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","arrow_forward"),new BlockItem(ArrowForward,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","arrow_left"),ArrowLeft);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","arrow_left"),new BlockItem(ArrowLeft,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","arrow_right"),ArrowRight);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","arrow_right"),new BlockItem(ArrowRight,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","arrow_forward_left"),ArrowForwardLeft);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","arrow_forward_left"),new BlockItem(ArrowForwardLeft,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","arrow_forward_right"),ArrowForwardRight);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","arrow_forward_right"),new BlockItem(ArrowForwardRight,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","arrow_back"),ArrowBack);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","arrow_back"),new BlockItem(ArrowBack,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","arrow_left_right"), ArrowLeftRight);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","arrow_left_right"),new BlockItem(ArrowLeftRight,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","arrow_back_left"), ArrowBackLeft);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","arrow_back_left"),new BlockItem(ArrowBackLeft,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","arrow_back_forward"), ArrowBackForward);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","arrow_back_forward"),new BlockItem(ArrowBackForward,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","arrow_confluence_left"), ArrowConfluenceLeft);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","arrow_confluence_left"),new BlockItem(ArrowConfluenceLeft,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","arrow_confluence_right"), ArrowConfluenceRight);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","arrow_confluence_right"),new BlockItem(ArrowConfluenceRight,new FabricItemSettings()));
		LOGGER.info("Arrow blocks Initialized...");

		//道路装饰注册
		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","railings"), Railings);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","railings"),new BlockItem(Railings,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","pavement_railings"), PavementRailings);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","pavement_railings"),new BlockItem(PavementRailings,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","expressway_railings_base"), ExpresswayRailingsBase);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","expressway_railings_base"),new BlockItem(ExpresswayRailingsBase,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","expressway_railings"), ExpresswayRailings);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","expressway_railings"),new BlockItem(ExpresswayRailings,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","expressway_railings_type2"), ExpresswayRailingsType2);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","expressway_railings_type2"),new BlockItem(ExpresswayRailingsType2,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","insulation_panels_railings"), InsulationPanelsRailings);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","insulation_panels_railings"),new BlockItem(InsulationPanelsRailings,new FabricItemSettings()));


		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","barrier_bar"), BarrierBar);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","barrier_bar"),new BlockItem(BarrierBar,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","traffic_light"), TrafficLight);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","traffic_light"),new BlockItem(TrafficLight,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","pillar_base"), PillarBase);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","pillar_base"),new BlockItem(PillarBase,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","horizontal_straight_pillar"), HorizontalStraightPillar);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","horizontal_straight_pillar"),new BlockItem(HorizontalStraightPillar,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","vertical_straight_pillar"), VerticalStraightPillar);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","vertical_straight_pillar"),new BlockItem(VerticalStraightPillar,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","horizontal_corner_pillar"), HorizontalCornerPillar);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","horizontal_corner_pillar"),new BlockItem(HorizontalCornerPillar,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","vertical_corner_pillar"), VerticalCornerPillar);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","vertical_corner_pillar"),new BlockItem(VerticalCornerPillar,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","horizontal_tshaped_pillar"), HorizontalTshapedPillar);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","horizontal_tshaped_pillar"),new BlockItem(HorizontalTshapedPillar,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","vertical_tshaped_pillar"), VerticalTshapedPillar);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","vertical_tshaped_pillar"),new BlockItem(VerticalTshapedPillar,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","vertical_tshaped_pillar_type2"), VerticalTshapedPillarType2);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","vertical_tshaped_pillar_type2"),new BlockItem(VerticalTshapedPillarType2,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","road_mast_pillar_base"), RoadMastPillarBase);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","road_mast_pillar_base"),new BlockItem(RoadMastPillarBase,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","road_mast_pillar"), RoadMastPillar);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","road_mast_pillar"),new BlockItem(RoadMastPillar,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","sign_indicator_direction_left"), SignIndicatorDirectionLeft);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","sign_indicator_direction_left"),new BlockItem(SignIndicatorDirectionLeft,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","sign_indicator_direction_right"), SignIndicatorDirectionRight);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","sign_indicator_direction_right"),new BlockItem(SignIndicatorDirectionRight,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","sign_indicator_direction_car"), SignIndicatorDirectionCar);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","sign_indicator_direction_car"),new BlockItem(SignIndicatorDirectionCar,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","sign_indicator_direction_bicycle"), SignIndicatorDirectionBicycle);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","sign_indicator_direction_bicycle"),new BlockItem(SignIndicatorDirectionBicycle,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","sign_ban_no_drive"), SignBanNoDrive);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","sign_ban_no_drive"),new BlockItem(SignBanNoDrive,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","sign_ban_stop"), SignBanStop);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","sign_ban_stop"),new BlockItem(SignBanStop,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_05"), SignBanSpeedLimit05);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_05"),new BlockItem(SignBanSpeedLimit05,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_20"), SignBanSpeedLimit20);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_20"),new BlockItem(SignBanSpeedLimit20,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_30"), SignBanSpeedLimit30);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_30"),new BlockItem(SignBanSpeedLimit30,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_40"), SignBanSpeedLimit40);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_40"),new BlockItem(SignBanSpeedLimit40,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_50"), SignBanSpeedLimit50);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_50"),new BlockItem(SignBanSpeedLimit50,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_60"), SignBanSpeedLimit60);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_60"),new BlockItem(SignBanSpeedLimit60,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_70"), SignBanSpeedLimit70);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_70"),new BlockItem(SignBanSpeedLimit70,new FabricItemSettings()));

		Registry.register(Registries.BLOCK,new Identifier("aft_fabroads","sign_ban_speed_limit_80"), SignBanSpeedLimit80);
		Registry.register(Registries.ITEM,new Identifier("aft_fabroads","sign_ban_speed_limit_80"),new BlockItem(SignBanSpeedLimit80,new FabricItemSettings()));

		//audio注册




		LOGGER.info("aft's Fabroads Initialized...");

		//注册某个方块实体
		TRAFFIC_LIGHT_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, "aft_fabroads:traffic_light_entity", FabricBlockEntityTypeBuilder.create(TrafficLightEntity::new,TrafficLight).build(null));

		//command
		new AftCommand();
		CommandRegistrationCallback.EVENT.register((dispatcher,  registryAccess, environment) -> AftCommand.register(dispatcher));

		//红绿灯计时器逻辑
		ServerTickEvents.END_SERVER_TICK.register((server)->
		{
			traffic_lights_timer = traffic_lights_timer +1 ;
			if (traffic_lights_timer == 1200){
				traffic_lights_timer = 0;
			}
		});

		//普通方块组添加
		ItemGroupEvents.modifyEntriesEvent(NormalRoadBlockGROUP).register(contect -> {
			contect.add(new ItemStack(FabroadsMod.RoadBlock));
			contect.add(new ItemStack(FabroadsMod.ManholeCover));
			contect.add(new ItemStack(FabroadsMod.ManholeCoverConcrete));
			contect.add(new ItemStack(FabroadsMod.RoadSeamsBlock));
			contect.add(new ItemStack(FabroadsMod.RoadSeamsBlockConcrete));
		});

		//指针方块组添加
		ItemGroupEvents.modifyEntriesEvent(RoadStickersGROUP).register(contect -> {
			contect.add(new ItemStack(FabroadsMod.LineStraight));
			contect.add(new ItemStack(FabroadsMod.LineCorner));
			contect.add(new ItemStack(FabroadsMod.LineTshaped));
			contect.add(new ItemStack(FabroadsMod.LineCross));
			contect.add(new ItemStack(FabroadsMod.LineDiagonal));
			contect.add(new ItemStack(FabroadsMod.LineLeftBend));
			contect.add(new ItemStack(FabroadsMod.LineRightBend));
			contect.add(new ItemStack(FabroadsMod.LineForkLeft));
			contect.add(new ItemStack(FabroadsMod.LineForkRight));
			contect.add(new ItemStack(FabroadsMod.LineStraightThick));

			contect.add(new ItemStack(FabroadsMod.ArrowForward));
			contect.add(new ItemStack(FabroadsMod.ArrowLeft));
			contect.add(new ItemStack(FabroadsMod.ArrowRight));
			contect.add(new ItemStack(FabroadsMod.ArrowForwardLeft));
			contect.add(new ItemStack(FabroadsMod.ArrowForwardRight));
			contect.add(new ItemStack(FabroadsMod.ArrowLeftRight));
			contect.add(new ItemStack(FabroadsMod.ArrowBack));
			contect.add(new ItemStack(FabroadsMod.ArrowBackLeft));
			contect.add(new ItemStack(FabroadsMod.ArrowBackForward));
			contect.add(new ItemStack(FabroadsMod.ArrowConfluenceLeft));
			contect.add(new ItemStack(FabroadsMod.ArrowConfluenceRight));
		});

		//物品方块组添加
		ItemGroupEvents.modifyEntriesEvent(RoadDecorationsGROUP).register(contect -> {
			contect.add(new ItemStack(FabroadsMod.Railings));
			contect.add(new ItemStack(FabroadsMod.BarrierBar));
			contect.add(new ItemStack(FabroadsMod.PavementRailings));
			contect.add(new ItemStack(FabroadsMod.ExpresswayRailingsBase));
			contect.add(new ItemStack(FabroadsMod.ExpresswayRailings));
			contect.add(new ItemStack(FabroadsMod.ExpresswayRailingsType2));
			contect.add(new ItemStack(FabroadsMod.InsulationPanelsRailings));
			contect.add(new ItemStack(FabroadsMod.TrafficLight));
			contect.add(new ItemStack(FabroadsMod.PillarBase));
			contect.add(new ItemStack(FabroadsMod.HorizontalStraightPillar));
			contect.add(new ItemStack(FabroadsMod.VerticalStraightPillar));
			contect.add(new ItemStack(FabroadsMod.HorizontalCornerPillar));
			contect.add(new ItemStack(FabroadsMod.VerticalCornerPillar));
			contect.add(new ItemStack(FabroadsMod.HorizontalTshapedPillar));
			contect.add(new ItemStack(FabroadsMod.VerticalTshapedPillar));
			contect.add(new ItemStack(FabroadsMod.VerticalTshapedPillarType2));
			contect.add(new ItemStack(FabroadsMod.RoadMastPillarBase));
			contect.add(new ItemStack(FabroadsMod.RoadMastPillar));
			contect.add(new ItemStack(FabroadsMod.SignIndicatorDirectionLeft));
			contect.add(new ItemStack(FabroadsMod.SignIndicatorDirectionRight));
			contect.add(new ItemStack(FabroadsMod.SignIndicatorDirectionCar));
			contect.add(new ItemStack(FabroadsMod.SignIndicatorDirectionBicycle));
			contect.add(new ItemStack(FabroadsMod.SignBanNoDrive));
			contect.add(new ItemStack(FabroadsMod.SignBanStop));
			contect.add(new ItemStack(FabroadsMod.SignBanSpeedLimit05));
			contect.add(new ItemStack(FabroadsMod.SignBanSpeedLimit20));
			contect.add(new ItemStack(FabroadsMod.SignBanSpeedLimit30));
			contect.add(new ItemStack(FabroadsMod.SignBanSpeedLimit40));
			contect.add(new ItemStack(FabroadsMod.SignBanSpeedLimit50));
			contect.add(new ItemStack(FabroadsMod.SignBanSpeedLimit60));
			contect.add(new ItemStack(FabroadsMod.SignBanSpeedLimit70));
			contect.add(new ItemStack(FabroadsMod.SignBanSpeedLimit80));
		});
	}

	//普通方块组注册
	public static final ItemGroup NormalRoadBlockGROUP = FabricItemGroup.builder(new Identifier("aft_fabroads", "normal_road_blocks"))
			.icon(() -> new ItemStack(FabroadsMod.RoadBlock))
			.build();

	//指针方块组注册
	public static final ItemGroup RoadStickersGROUP = FabricItemGroup.builder(new Identifier("aft_fabroads", "normal_road_blocks"))
			.icon(() -> new ItemStack(FabroadsMod.LineStraight))
			.build();

	//物品方块类注册
	public static final ItemGroup RoadDecorationsGROUP = FabricItemGroup.builder(new Identifier("aft_fabroads", "normal_road_blocks"))
			.icon(() -> new ItemStack(FabroadsMod.Railings))
			.build();
}
