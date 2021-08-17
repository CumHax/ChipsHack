package me.cumhax.chipshack.module.combat;

import me.cumhax.chipshack.event.autocrystal.UpdateEvent;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.event.Subscribe;
import me.cumhax.chipshack.event.EventType;
import net.minecraft.item.ItemBow;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.math.BlockPos;

public class FastBow extends Module
{
    public FastBow() {
        super("FastBow", "", Category.COMBAT);
    }

    @Subscribe
    public void onUpdatePre(UpdateEvent event) {
        if (event.getType() == EventType.PRE) {
            if(mc.player.inventory.getCurrentItem().getItem() instanceof ItemBow) {
                if(mc.player.isHandActive() && mc.player.getItemInUseMaxCount() >= 3) {
                    mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, mc.player.getHorizontalFacing()));
                    mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(mc.player.getActiveHand()));
                    mc.player.stopActiveHand();
                }
            }
        }
    }
}
