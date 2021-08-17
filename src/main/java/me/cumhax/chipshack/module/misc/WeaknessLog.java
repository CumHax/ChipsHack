package me.cumhax.chipshack.module.misc;

import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.module.Category;
import net.minecraft.client.Minecraft;
import net.minecraft.init.MobEffects;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.util.text.TextComponentString;
import sun.audio.AudioPlayer;

public class WeaknessLog extends Module {

    private static Minecraft mc;

    public WeaknessLog() {
        super("WeaknessLog", "", Category.MISC);
    }

    public void onUpdate() {
        if (mc.player == null || mc.world == null) return;
        if (WeaknessLog.mc.player.isPotionActive ( MobEffects.WEAKNESS ) ) {
            WeaknessLog.mc.player.connection.sendPacket ( new SPacketDisconnect ( new TextComponentString ( "ewww weakness" ) ) );
            toggle();
        }
    }
}
