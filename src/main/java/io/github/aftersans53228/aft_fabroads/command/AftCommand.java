package io.github.aftersans53228.aft_fabroads.command;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;

import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static io.github.aftersans53228.aft_fabroads.AFRoadsStatics.*;
import static net.minecraft.server.command.CommandManager.literal;


/**
 * @author aftersans53228
 */
public class AftCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("afroads")
                .then(literal("info")
                        .then(literal("zh_cn")
                                .executes(context -> {
                                    ServerPlayerEntity player = context.getSource().getPlayer();
                                    player.sendMessage(new LiteralText("§8§o aftersans53228's fabric roads"), false);
                                    player.sendMessage(new LiteralText("aftersans53228制作"), false);
                                    player.sendMessage(new LiteralText(String.format("本模组命名空间为%s",MOD_ID )), false);
                                    player.sendMessage(new LiteralText(String.format("版本为%s", MOD_VERSION)), false);
                                    player.sendMessage(new LiteralText(String.format("此版本mod支持mc版本为%s",MINECRAFT_VERSION )), false);
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
                                    player.sendMessage(new LiteralText(String.format("modid:%s",MOD_ID)), false);
                                    player.sendMessage(new LiteralText(String.format("version: %s", MOD_VERSION)), false);
                                    player.sendMessage(new LiteralText(String.format("minecraft version: %s",MINECRAFT_VERSION)), false);
                                    player.sendMessage(new LiteralText("modrinth:https://modrinth.com/mod/aftersans53228-fabric-road"), false);
                                    player.sendMessage(new LiteralText("code-github:https://github.com/aftersans53228/Minecraft-AFRoads-Mod"), false);
                                    player.sendMessage(new LiteralText("thanks"), false);
                                    return 1;
                                }))
                )
                .requires(source -> source.hasPermissionLevel(4))
                .then (literal("server-client")
                        .then(literal("disconnection_games")
                                .executes(context ->{
                                    ServerPlayerEntity player = context.getSource().getPlayer();
                                    ServerPlayNetworking.send(player,new Identifier(MOD_ID,"disconnect_self"),PacketByteBufs.empty());
                                    return 1;
                                })
                        )
                        .then(literal("server_version")
                                .executes(context ->{
                                    ServerPlayerEntity player = context.getSource().getPlayer();
                                    player.sendMessage(new LiteralText(MOD_VERSION),false);
                                    return 1;
                                })
                        )
                )
        );

    }
}

