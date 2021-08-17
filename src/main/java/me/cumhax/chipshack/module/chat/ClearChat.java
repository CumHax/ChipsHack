package me.cumhax.chipshack.module.chat;

import me.cumhax.chipshack.event.RenderChatBackgroundEvent;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.event.Subscribe;

public class ClearChat extends Module {

	public ClearChat() {
		super("ClearChat", "", Category.CHAT);
	}

    @Subscribe
    public void onChatRender(RenderChatBackgroundEvent event) {
        event.setCancelled(true);
    }

}
