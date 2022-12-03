package net.aftersans53228.aft_fabroads.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.aftersans53228.aft_fabroads.FabroadsMod;
import net.aftersans53228.aft_fabroads.FabroadsClientMod;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public class AftCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("aft")
                .then(literal("reset_timer")
                        .executes(context -> {
                            FabroadsMod.traffic_lights_timer =0;
                            ServerPlayerEntity player = context.getSource().getPlayer();
                            assert player != null;
                            player.sendMessage(Text.literal("§7 [aft_fabroads]:将traffic_lights_timer设置为 0"), false);
                            return 1;
                        })
                )
                .then(literal("help")
                        .executes(context -> {
                            ServerPlayerEntity player = context.getSource().getPlayer();
                            player.sendMessage(Text.literal("§8§o aftersans53228's fabric roads"), false);
                            player.sendMessage(Text.literal("aftersans53228制作"), false);
                            player.sendMessage(Text.literal("本模组命名空间为aft_fabroads"), false);
                            player.sendMessage(Text.literal("版本为1.0.1Release"), false);
                            player.sendMessage(Text.literal("此版本mod支持mc版本为1.19.x"), false);
                            player.sendMessage(Text.literal("mc百科:https://www.mcmod.cn/class/5636.html"), false);
                            player.sendMessage(Text.literal("modrinth:https://modrinth.com/mod/aftersans53228-fabric-road"), false);
                            player.sendMessage(Text.literal("code-github:https://github.com/aftersans53228/Minecraft-AFRoads-Mod"), false);
                            player.sendMessage(Text.literal(""), false);
                            player.sendMessage(Text.literal("一坨使这个模组"), false);
                            return 1;
                        })
                )
                .then(literal("tool-model")
                        .executes(context -> {
                            ServerPlayerEntity player = context.getSource().getPlayer();
                            FabroadsClientMod.is_logo_tool = !FabroadsClientMod.is_logo_tool;
                            player.sendMessage(Text.literal("道路工具模型已修改为"+FabroadsClientMod.is_logo_tool+"."), true);
                            return 1;
                        })
                )
            );
    }
}

