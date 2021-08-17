
package me.cumhax.chipshack.event.autocrystal;

import net.minecraft.client.Minecraft;
import me.cumhax.chipshack.event.autocrystal.Cancellable;

public class EventCancellable extends Cancellable
{
    private final Era era_switch;
    private final float partial_ticks;
    
    public EventCancellable() {
        this.era_switch = Era.EVENT_PRE;
        this.partial_ticks = Minecraft.getMinecraft().getRenderPartialTicks();
    }
    
    public Era get_era() {
        return this.era_switch;
    }
    
    public float get_partial_ticks() {
        return this.partial_ticks;
    }
    
    public enum Era
    {
        EVENT_PRE, 
        EVENT_PERI, 
        EVENT_POST;
    }
}
