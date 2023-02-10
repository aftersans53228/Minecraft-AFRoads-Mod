package net.aftersans53228.aft_fabroads.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.aftersans53228.aft_fabroads.FabroadsMod;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;

import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;


public class AftCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("afroads")
                .then(literal("info")
                        .then(literal("zh_cn")
                                .executes(context -> {
                                    ServerPlayerEntity player = context.getSource().getPlayer();
                                    player.sendMessage(new LiteralText("§8§o aftersans53228's fabric roads"), false);
                                    player.sendMessage(new LiteralText("aftersans53228制作"), false);
                                    player.sendMessage(new LiteralText("本模组命名空间为aft_fabroads"), false);
                                    player.sendMessage(new LiteralText("版本为1.0.2Dev-Update1-Build1"), false);
                                    player.sendMessage(new LiteralText("此版本mod支持mc版本为1.17.x"), false);
                                    player.sendMessage(new LiteralText("mc百科:https://www.mcmod.cn/class/5636.html"), false);
                                    player.sendMessage(new LiteralText("modrinth:https://modrinth.com/mod/aftersans53228-fabric-road"), false);
                                    player.sendMessage(new LiteralText("code-github:https://github.com/aftersans53228/Minecraft-AFRoads-Mod"), false);
                                    player.sendMessage(new LiteralText("感谢"), false);
                                    return 1;
                                }))
                        .then(literal("en_world")
                                .executes(context -> {
                                    ServerPlayerEntity player = context.getSource().getPlayer();
                                    player.sendMessage(new LiteralText("§8§o aftersans53228's fabric roads"), false);
                                    player.sendMessage(new LiteralText("Made by Aftersans53228"), false);
                                    player.sendMessage(new LiteralText("modid: aft_fabroads"), false);
                                    player.sendMessage(new LiteralText("version: 1.0.2Dev-Update1-Build1"), false);
                                    player.sendMessage(new LiteralText("minecraft version: 1.17.x"), false);
                                    player.sendMessage(new LiteralText("modrinth:https://modrinth.com/mod/aftersans53228-fabric-road"), false);
                                    player.sendMessage(new LiteralText("code-github:https://github.com/aftersans53228/Minecraft-AFRoads-Mod"), false);
                                    player.sendMessage(new LiteralText("thanks"), false);
                                    return 1;
                                }))
                )
                .requires(source -> source.hasPermissionLevel(4))
                .then(literal("timer_control")
                        .then(literal("reset")
                                .executes(context -> {
                                    FabroadsMod.traffic_lights_timer =0;
                                    ServerPlayerEntity player = context.getSource().getPlayer();
                                    player.sendMessage(new LiteralText("§7 [aft_fabroads]:traffic_lights_timer reset."), false);
                                    FabroadsMod.LOGGER.info("Set [traffic_lights_timer] to:0");
                                    return 1;
                                }))
                        .then(literal("set_tick")
                                .then(argument("timer_set", integer(0,1200))
                                        .executes(context -> {
                                            FabroadsMod.traffic_lights_timer = context.getArgument("timer_set",Integer.class);
                                            ServerPlayerEntity player = context.getSource().getPlayer();
                                            player.sendMessage(new LiteralText("§7 [aft_fabroads]:Set traffic_lights_timer to:"+ FabroadsMod.traffic_lights_timer), false);
                                            FabroadsMod.LOGGER.info("Set [traffic_lights_timer] to:"+ FabroadsMod.traffic_lights_timer);
                                            return 1;
                                        }))
                        )
                )
        );
    }
}

