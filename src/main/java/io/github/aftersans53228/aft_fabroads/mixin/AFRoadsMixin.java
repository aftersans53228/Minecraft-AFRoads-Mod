/*
* 这个Mixin类仅做测试使用，在客户端进入世界时播送消息。
* 未来可能会移除或改写该类，但该模组使用Mixin可能的用途尚不明确。
* This Mixin class is for testing only ，it broadcasts a message when the client enters the world.
* This CLASS may be removed or rewritten in the future, but it is unclear what the mod might do , with Mixin.
*/
package io.github.aftersans53228.aft_fabroads.mixin;

import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.aftersans53228.aft_fabroads.AFRoadsStatics.MOD_VERSION;

/**
 * @author aftersans53228
 * Mixin Test
 */
@Mixin(PlayerManager.class)
public abstract class AFRoadsMixin {
    @Inject(at = @At("TAIL"), method = "onPlayerConnect")
    private void onPlayerConnect(ClientConnection connection, ServerPlayerEntity player,CallbackInfo info) {
        player.sendMessage(
                new LiteralText(
                    String.format("§8AFRoads Mod loaded.\n§fVersion:§c%s.", MOD_VERSION)
                )
                ,false);
	}

}