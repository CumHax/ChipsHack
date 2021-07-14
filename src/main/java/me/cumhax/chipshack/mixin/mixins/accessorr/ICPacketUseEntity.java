package me.cumhax.chipshack.mixin.mixins.accessorr;

import net.minecraft.network.play.client.CPacketUseEntity.Action;

public interface ICPacketUseEntity {
    void setEntityId(int var1);

    void setAction(Action var1);
}