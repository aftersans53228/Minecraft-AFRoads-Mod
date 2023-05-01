package io.github.aftersans53228.aft_fabroads.mixin;

import net.minecraft.network.ClientConnection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.aftersans53228.aft_fabroads.AFRoadsStatics.MOD_VERSION;

@Mixin(PlayerManager.class)
public abstract class AFRoadsMixin {
    @Shadow @Final private MinecraftServer server;
    @Inject(at = @At("TAIL"), method = "onPlayerConnect")
    private void onPlayerConnect(ClientConnection connection, ServerPlayerEntity player,CallbackInfo info) {
        player.sendMessage(new LiteralText(String.format("§8AFRoads Mod loaded.\n§fVersion:§c%s.\n§f§oMade by Aftersans53228.",MOD_VERSION)),false);
	}

}