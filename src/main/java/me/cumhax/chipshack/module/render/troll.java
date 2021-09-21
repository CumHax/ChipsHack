package me.cumhax.chipshack.module.render;

import me.cumhax.chipshack.event.EventRender;
import net.minecraft.entity.player.EntityPlayer;

public interface troll {
    void enable ();

    void render ( EventRender event );

    void esp ( EntityPlayer player, double x, double y, double z );

    String array_detail ();
}
