package me.cumhax.chipshack.module.combat;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.util.LoggerUtil;
import me.cumhax.chipshack.setting.Setting;

import java.util.ArrayList;
import java.util.Arrays;

public class HoleFiller extends Module
{
	private final Setting range = new Setting("Range", this, 1, 5, 10);
	private final Setting disable = new Setting("Disable", this, true);
	private final me.cumhax.chipshack.setting.Setting blockMode = new Setting("BlockMode", this, Arrays.asList(
	            "Obsidian",
	            "Web"
	             ));
	private final Setting self = new Setting("Self", this, false);

    public HoleFiller() 
	{
        super("HoleFiller", "", Category.COMBAT);
	}
	   public void onEnable() {
      LoggerUtil.sendMessage("HoleFiller Toggled ON!");
   }

   public void onDisable() {
      LoggerUtil.sendMessage("HoleFiller Toggled OFF");
   }
}