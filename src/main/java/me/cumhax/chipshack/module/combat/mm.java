package me.cumhax.chipshack.module.combat;

import net.minecraft.item.Item;

public interface mm {
    void enable ();

    void update ();

    void doXp ();

    Boolean notInInv ( Item itemOfChoice );

    void update_always ();
}
