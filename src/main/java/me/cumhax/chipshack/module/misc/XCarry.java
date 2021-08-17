package me.cumhax.chipshack.module.misc;

import net.minecraft.network.play.client.CPacketCloseWindow;
import team.stiff.pomelo.impl.annotated.handler.annotation.Listener;
import me.cumhax.chipshack.event.EventPacketSend;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.module.Category;

public class XCarry extends Module {

    public XCarry() {
        super("XCarry", "", Category.MISC);
    }

	@Listener
	public void eventLister(EventPacketSend event) {
		if (event.getPacket() instanceof CPacketCloseWindow) {
			event.cancel();
		}
	}
}