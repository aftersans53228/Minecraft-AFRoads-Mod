package net.aftersans53228.aft_fabroads.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.aftersans53228.aft_fabroads.FabroadsMod;
import net.aftersans53228.aft_fabroads.FabroadsClientMod;

import static net.minecraft.server.command.CommandManager.literal;

public class AftCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("aft")
                .then(literal("reset_timer")
                        .executes(context -> {
                            FabroadsMod.traffic_lights_timer =0;
                            ServerPlayerEntity player = context.getSource().getPlayer();
                            player.sendMessage(new LiteralText("§7 [aft_fabroads]:将traffic_lights_timer设置为 0"), false);
                            return 1;
                        })
                )
                .then(literal("help")
                        .executes(context -> {
                            ServerPlayerEntity player = context.getSource().getPlayer();
                            player.sendMessage(new LiteralText("§8§o aftersans53228's fabric roads"), false);
                            player.sendMessage(new LiteralText("aftersans53228制作"), false);
                            player.sendMessage(new LiteralText("本模组命名空间为aft_fabroads"), false);
                            player.sendMessage(new LiteralText("版本为1.0.1Beta-update1-build1"), false);
                            player.sendMessage(new LiteralText("此版本mod支持mc版本为1.18.1"), false);
                            player.sendMessage(new LiteralText("本模组命名空间为aft_fabroads"), false);
                            player.sendMessage(new LiteralText(""), false);
                            player.sendMessage(new LiteralText("一坨使这个模组"), false);
                            return 1;
                        })
                )
                .then(literal("tool-model")
                    .executes(context -> {
                        ServerPlayerEntity player = context.getSource().getPlayer();
                        FabroadsClientMod.is_logo_tool = !FabroadsClientMod.is_logo_tool;
                        assert player != null;
                        player.sendMessage(new LiteralText("道路工具模型已修改为"+FabroadsClientMod.is_logo_tool+"."), true);
                        return 1;
                    })
                )
            );
    };
}

