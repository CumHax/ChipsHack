package me.cumhax.chipshack.module.combat;

import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.setting.Setting;
import me.cumhax.chipshack.module.Category;

public class Reach extends Module
{
	public Reach() {
		super ( "Reach", "", Category.COMBAT );
	}

		private final Setting distance = new Setting("Distance", this, 3, 5, 10);
	}