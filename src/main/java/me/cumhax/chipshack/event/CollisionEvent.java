package me.cumhax.chipshack.event;

import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class CollisionEvent extends Event {

    public Type type;

    public CollisionEvent(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        ENTITY,
        BLOCK // We could use this for phase or something similar later
    }
}
