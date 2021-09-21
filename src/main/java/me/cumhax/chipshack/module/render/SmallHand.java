package me.cumhax.chipshack.module.render;

import me.cumhax.chipshack.setting.Setting;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;

public class SmallHand extends Module {

    public SmallHand() 
	{	
        super("SmallHand", "", Category.RENDER);
    }

    //Module Settings
    private final Setting multiplier = new Setting("Multiplier", this, 90, 0, 360);

    public void update() {
        mc.player.renderArmPitch = multiplier.get_value(1);
    }


}
