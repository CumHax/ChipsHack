package me.cumhax.chipshack.module.render;

import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.module.Category;

import java.util.ArrayList;

public class Xray extends Module{

	public Xray() {
		super("Xray", "", Category.RENDER);
	}

    public static ArrayList<String> xrayBlocks;

    public void onEnable() {
        mc.renderGlobal.loadRenderers();
    }

    public void onUpdate() {
    }

    public void onDisable() {
        mc.renderGlobal.loadRenderers();
    }
}
