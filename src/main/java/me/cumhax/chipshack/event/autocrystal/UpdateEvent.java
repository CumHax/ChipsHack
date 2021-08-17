package me.cumhax.chipshack.event.autocrystal;

import me.cumhax.chipshack.event.Event;
import me.cumhax.chipshack.event.EventType;
import net.minecraft.client.entity.EntityPlayerSP;

public class UpdateEvent extends Event {
    private EventType type;
    private EntityPlayerSP player;
    private float yaw,pitch;
    private double x,y,z;
    private boolean onGround;
    public UpdateEvent(EventType type, EntityPlayerSP player, float yaw,float pitch, double x,double y,double z,boolean onGround) {
        this.type = type;
        this.player = player;
        this.yaw = yaw;
        this.pitch = pitch;
        this.x = x;
        this.y = y;
        this.z = z;
        this.onGround = onGround;
    }

    public UpdateEvent() {
        type = EventType.POST;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public void setPlayer(EntityPlayerSP player) {
        this.player = player;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public EventType getType() {
        return type;
    }

    public EntityPlayerSP getPlayer() {
        return player;
    }
}