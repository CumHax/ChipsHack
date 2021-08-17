package me.cumhax.chipshack.module.render;

import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.setting.Setting;

import java.util.Arrays;

public class BurrowESP extends Module {
    public BurrowESP () {
        super ( "BurrowESP", "", Category.RENDER );
    }
    private final Setting Range = new Setting("Range", this, 5, 1, 10);
    private final Setting color = new Setting("Color", this, Arrays.asList(
            "Static",
            "Rainbow"
    ));
    private final Setting red = new Setting("Red", this, 255, 0, 255);
    private final Setting green = new Setting("Green", this, 20, 0, 255);
    private final Setting blue = new Setting("Blue", this, 20, 0, 255);
    private final Setting alpha = new Setting("Alpha", this, 100, 0, 255);
    private final Setting rainbowSpeed = new Setting("RainbowSpeed", this, 5, 0, 10);
}