package me.cumhax.chipshack.module.movement;


import me.cumhax.chipshack.event.autocrystal.UpdateEvent;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.event.Subscribe;

public class AutoJump extends Module
{
    public AutoJump() {
        super("AutoJump", "", Category.MOVEMENT);
    }


@Subscribe
public void onUpdate(UpdateEvent event) {
        if (mc.player.isInWater() || mc.player.isInLava()) mc.player.motionY = 0.1;
        else if (mc.player.onGround) mc.player.jump();
        }
        }
