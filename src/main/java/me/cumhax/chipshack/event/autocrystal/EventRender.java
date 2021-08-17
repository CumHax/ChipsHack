
package me.cumhax.chipshack.event.autocrystal;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.gui.ScaledResolution;
import me.cumhax.chipshack.event.autocrystal.EventCancellable;

public class EventRender extends EventCancellable
{
    private final ScaledResolution res;
    private final Tessellator tessellator;
    private final Vec3d render_pos;
    
    public EventRender(final Tessellator tessellator, final Vec3d pos) {
        this.res = new ScaledResolution(Minecraft.getMinecraft());
        this.tessellator = tessellator;
        this.render_pos = pos;
    }
    
    public Tessellator get_tessellator() {
        return this.tessellator;
    }
    
    public Vec3d get_render_pos() {
        return this.render_pos;
    }
    
    public BufferBuilder get_buffer_build() {
        return this.tessellator.getBuffer();
    }
    
    public void set_translation(final Vec3d pos) {
        this.get_buffer_build().setTranslation(-pos.x, -pos.y, -pos.z);
    }
    
    public void reset_translation() {
        this.set_translation(this.render_pos);
    }
    
    public double get_screen_width() {
        return this.res.getScaledWidth_double();
    }
    
    public double get_screen_height() {
        return this.res.getScaledHeight_double();
    }
}
