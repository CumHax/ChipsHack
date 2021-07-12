package me.cumhax.chipshack.module.movement;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.setting.Setting;
import me.cumhax.chipshack.event.MoveEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Jesus extends Module {

    Setting zeroGravity = new Setting("ZeroGravity", this, false);

    public Jesus(String name, String description, Category category) {
        super(name, description, category);
    }

    @SubscribeEvent
    public void onPlayerMove(MoveEvent event) {
        // TODO hover jesus
        if(zeroGravity.getBooleanValue() &&
                mc.player.isInWater() &&
                !mc.player.movementInput.sneak &&
                !mc.player.movementInput.jump) {
            event.setY(0);
        }
    }
}
