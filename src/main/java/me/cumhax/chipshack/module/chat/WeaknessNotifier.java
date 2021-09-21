package me.cumhax.chipshack.module.chat;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.util.LoggerUtil;
import net.minecraft.init.MobEffects;

public class WeaknessNotifier extends Module {
	
    public WeaknessNotifier() {
        super("WeaknessNotify", "", Category.CHAT);
    }
	
    private boolean hasAnnounced = false;

    public void update() {
            if (mc.player.isPotionActive(MobEffects.WEAKNESS) && !hasAnnounced) {
            hasAnnounced = true;
            LoggerUtil.sendMessage(ChatFormatting.GRAY + "" + ChatFormatting.BOLD + "nigga you just got weaknessed by nn's");
        }
            if (!mc.player.isPotionActive(MobEffects.WEAKNESS) && hasAnnounced) {
                hasAnnounced = false;
                LoggerUtil.sendMessage(ChatFormatting.GRAY + "" + ChatFormatting.BOLD + "You no longer have weakness");
        }
    }
}