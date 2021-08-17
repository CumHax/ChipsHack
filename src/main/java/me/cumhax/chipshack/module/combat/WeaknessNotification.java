package me.cumhax.chipshack.module.combat;

import me.cumhax.chipshack.util.printMsg;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import net.minecraft.init.MobEffects;

public class WeaknessNotification extends Module {
	
	public WeaknessNotification() {
        super("WeaknessNotification", "", Category.COMBAT);
    }

	public void onEnable() {
		if (mc.player.isPotionActive(MobEffects.WEAKNESS)) {
			printMsg.printMsg("\u00A74[ChipsHack] I have weakness! :<");
		}
	}
}
