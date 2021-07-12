package me.cumhax.chipshack.module.movement;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Sprint extends Module {
    public Sprint(String name, String description, Category category) {
        super(name, description, category);
    }

    @SubscribeEvent
    public void onUpdate(final TickEvent.ClientTickEvent event) {
        if (nullCheck()) return;

        if (mc.player.movementInput.moveForward == 0f && mc.player.movementInput.moveStrafe == 0f) return;

        if (!mc.player.isSprinting()) {
            mc.player.setSprinting(true);
        }
    }
}