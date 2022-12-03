package net.aftersans53228.aft_fabroads.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;

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
我根本就没用mixin字节码(划
这玩意我也懒得删
短期也用不到
fabric模组示例自带（认真
 */