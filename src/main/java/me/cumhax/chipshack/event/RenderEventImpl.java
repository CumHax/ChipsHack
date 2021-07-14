package me.cumhax.chipshack.event;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.math.Vec3d;

public class RenderEventImpl extends RenderEvent {
    public RenderEventImpl(Tessellator tessellator, Vec3d renderPos, float ticks){
        super(tessellator, renderPos, ticks);
    }
}
