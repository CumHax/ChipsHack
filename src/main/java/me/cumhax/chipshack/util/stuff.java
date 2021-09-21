package me.cumhax.chipshack.util;

import net.minecraft.block.Block;

public interface stuff {
    void enable ();

    void update ();

    void disable ();

    void setBlock ( Block b );

    Block getBlock ();
}
