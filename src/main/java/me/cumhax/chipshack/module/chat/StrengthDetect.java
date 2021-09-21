package me.cumhax.chipshack.module.chat;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.util.LoggerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class StrengthDetect extends Module
{
    public static final Minecraft mc = Minecraft.getMinecraft();
    private final Set<EntityPlayer> str = Collections.newSetFromMap(new WeakHashMap());

    public StrengthDetect() {
        super("StrengthDetect", "", Category.CHAT);
    }

    public void onUpdate()
    {
        for (EntityPlayer player : mc.world.playerEntities)
        {
            if (player.isPotionActive(MobEffects.STRENGTH) && !this.str.contains(player))
            {
                LoggerUtil.sendMessage(String.format("&7%s drank strength.", player.getDisplayNameString()));
                this.str.add(player);
            }
            if (!this.str.contains(player) || player.isPotionActive(MobEffects.STRENGTH)) continue;
            LoggerUtil.sendMessage(String.format("&7%s ran out of strength.", player.getDisplayNameString()));
            this.str.remove(player);
        }
    }
}
