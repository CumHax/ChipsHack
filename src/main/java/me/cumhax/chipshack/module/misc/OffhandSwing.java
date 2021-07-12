package me.cumhax.chipshack.module.misc;

import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.module.Category;
import net.minecraft.util.EnumHand;

public class OffhandSwing extends Module {
	
    public OffhandSwing() {
        super("OffhandSwing", "", Category.MISC);
    }
	
	    public void update() {

        mc.player.swingingHand = EnumHand.OFF_HAND;

       }

}
