package net.aftersans53228.aft_fabroads.mixin;

import net.aftersans53228.aft_fabroads.FabroadsMod;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class FabroadsMixin {/*
	1@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		FabroadsMod.LOGGER.info("aft's fabroads running...");
	}
	*/
}
/*
是的现在如你所见
我他妈根本就没用mixin字节码
这玩意我也懒得删
写这一段注释纯属糊弄
也没用到
fabric模组示例自带（认真
 */