package me.cumhax.chipshack.module.render;

import me.cumhax.chipshack.event.EventListener;
import me.cumhax.chipshack.event.EventHurtCam;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.module.Category;

public class NoHurtCam extends Module {
	
	public NoHurtCam() {
		super("NoHurtCam", "", Category.RENDER);
	}

	@EventListener(events = { EventHurtCam.class })
	private void runMethod(EventHurtCam eventHurtCam) {
		eventHurtCam.cancel();
	}

}
