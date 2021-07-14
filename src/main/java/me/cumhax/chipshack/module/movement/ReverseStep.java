package me.cumhax.chipshack.module.movement;

import me.cumhax.chipshack.event.UpdateEvent;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ReverseStep extends Module 
{
	public ReverseStep() {
        super("ReverseStep", "", Category.MOVEMENT);
    }

    @SubscribeEvent
    public void onMoveEvent(UpdateEvent event) {
        if (mc.player.onGround && !(mc.player.isInLava() || mc.player.isInWater() || mc.player.isOnLadder())) {
            mc.player.motionY = -1;
        }
    }

}
