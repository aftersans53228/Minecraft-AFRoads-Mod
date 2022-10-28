package net.aftersans53228.aft_fabroads;


import net.aftersans53228.aft_fabroads.block.*;
import net.aftersans53228.aft_fabroads.block.arrowblock.*;
import net.aftersans53228.aft_fabroads.block.pillarBlock.*;
import net.aftersans53228.aft_fabroads.block.signBlock.SignIndicatorDirectionLeft;
import net.aftersans53228.aft_fabroads.block.signBlock.SignIndicatorDirectionRight;
import net.aftersans53228.aft_fabroads.command.AftCommand;
import net.aftersans53228.aft_fabroads.item.NormalRoadBlock;
import net.aftersans53228.aft_fabroads.item.RoadDecoration;
import net.aftersans53228.aft_fabroads.item.RoadStickers;
import net.aftersans53228.aft_fabroads.item.RoadTool;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.minecraft.server.command.CommandManager.literal;


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
	public static final Block SignIndicatorDirectionLeft = new SignIndicatorDirectionLeft();
	public static final Block SignIndicatorDirectionRight = new SignIndicatorDirectionRight();
	//创建物品组
	public static final ItemGroup NormalRoadBlockGROUP = NormalRoadBlock.get();
	public static final ItemGroup RoadStickersGROUP = RoadStickers.get();
	public static final ItemGroup RoadDecorationsGROUP = RoadDecoration.get();


    @Override
	public void onInitialize() {
		// 只要 Minecraft 处于 mod-load-ready 状态，此代码就会运行。
		// 但是，有些东西（比如资源）可能仍然未初始化。
		// 谨慎行事。

		LOGGER.info("aft's Fabroads Initializing...");

		//物品注册
		Registry.register(Registry.ITEM, new Identifier("aft_fabroads", "road_tool"),RoadTool);
		LOGGER.info("Item Initialized...");

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

		LOGGER.info("Normal blocks Initialized...");

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

		LOGGER.info("Line blocks Initialized...");

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
		LOGGER.info("Arrow blocks Initialized...");

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


		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","barrier_bar"), BarrierBar);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","barrier_bar"),new BlockItem(BarrierBar,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","traffic_light"), TrafficLight);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","traffic_light"),new BlockItem(TrafficLight,new Item.Settings().group(RoadDecorationsGROUP)));

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

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_indicator_direction_left"), SignIndicatorDirectionLeft);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_indicator_direction_left"),new BlockItem(SignIndicatorDirectionLeft,new Item.Settings().group(RoadDecorationsGROUP)));

		Registry.register(Registry.BLOCK,new Identifier("aft_fabroads","sign_indicator_direction_right"), SignIndicatorDirectionRight);
		Registry.register(Registry.ITEM,new Identifier("aft_fabroads","sign_indicator_direction_right"),new BlockItem(SignIndicatorDirectionRight,new Item.Settings().group(RoadDecorationsGROUP)));


		LOGGER.info("aft's Fabroads Initialized...");

		//注册某个方块实体
		TRAFFIC_LIGHT_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "aft_fabroads:traffic_light_entity", FabricBlockEntityTypeBuilder.create(TrafficLightEntity::new,TrafficLight).build(null));

		//command
		new AftCommand();
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> AftCommand.register(dispatcher));

		//红绿灯计时器逻辑
		ServerTickEvents.END_SERVER_TICK.register((server)->
		{
			traffic_lights_timer = traffic_lights_timer +1 ;
			if (traffic_lights_timer == 1200){
				traffic_lights_timer = 0;
			}
		});







	}

}
