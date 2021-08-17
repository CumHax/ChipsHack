package me.cumhax.chipshack.module.misc;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.util.SwingUtil;
import net.minecraft.util.EnumHand;

public class OffhandSwing extends Module {

	public OffhandSwing() {
		super("OffhandSwing", "", Category.MISC);
	}

    public void update() {
        if (SwingUtil.mc.world == null) {
            return;
        }
        SwingUtil.getPlayer().swingingHand = EnumHand.OFF_HAND;
    }
}