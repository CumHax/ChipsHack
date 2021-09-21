package me.cumhax.chipshack.module.misc;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.event.Subscribe;
import net.minecraft.potion.Potion;

public class NoWeakness extends Module {

        public NoWeakness() {
                super("NoWeakness", "", Category.MISC);
        }

        @Subscribe
        public void onUpdate() {
        if (mc.player.isPotionActive(Potion.getPotionFromResourceLocation("weakness"))) {
        mc.player.removeActivePotionEffect(Potion.getPotionFromResourceLocation("weakness"));
        }
        }
        }
