package me.cumhax.chipshack.util;

import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;

public class SwingUtil {
    public static final Minecraft mc = Minecraft.getMinecraft();

    @Nullable
    public static EntityPlayerSP getPlayer() {
        return SwingUtil.mc.player;
    }

    @Nullable
    public static WorldClient getWorld() {
        return SwingUtil.mc.world;
    }

    public static FontRenderer getFontRenderer() {
        return SwingUtil.mc.fontRenderer;
    }
}