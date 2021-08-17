package me.cumhax.chipshack.module.render;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;

public class NoBob extends Module {
	private boolean viewBobbing;

	public NoBob() {
		super("NoBob", "", Category.RENDER);
	}

	public void onEnable() {
		this.viewBobbing = mc.gameSettings.viewBobbing;
	}

	public void onDisable() {
		mc.gameSettings.viewBobbing = viewBobbing;
	}

	public void onUpdate() {
		if (nullCheck()) return;
		mc.gameSettings.viewBobbing = false;
	}
}