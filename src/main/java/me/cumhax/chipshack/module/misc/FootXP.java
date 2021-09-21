package me.cumhax.chipshack.module.misc;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.event.PacketEvent;
import me.cumhax.chipshack.mixin.mixins.accessor.ICPacketPlayer;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FootXP extends Module
{
	public FootXP() 
	{
		super("FootXP", "", Category.MISC);
	}

	@SubscribeEvent
	public void onPacket(PacketEvent.Send event)
	{
		if (mc.player == null || mc.world == null) return;

		if (event.getPacket() instanceof CPacketPlayer && mc.player.getHeldItemMainhand().getItem() instanceof ItemExpBottle)
		{
			CPacketPlayer packet = (CPacketPlayer) event.getPacket();
			((ICPacketPlayer) packet).setPitch(90.0f);
		}
	}
}
