package me.cumhax.chipshack.event;

import me.cumhax.chipshack.event.stuff.EventStage;

public class RenderItemEvent extends EventStage {
    Object mainX;
    Object mainY;
    Object mainZ;
    Object offX;
    Object offY;
    Object offZ;
    double mainRAngel;
    double mainRx;
    double mainRy;
    double mainRz;
    Object offRAngel;
    Object offRx;
    Object offRy;
    double offRz;
    double mainHandScaleX;
    double mainHandScaleY;
    double mainHandScaleZ;
    double offHandScaleX;
    double offHandScaleY;
    double offHandScaleZ;


    public RenderItemEvent(double mainX, double mainY, double mainZ,
                           double offX, double offY, double offZ,
                           double mainRAngel, double mainRx, double mainRy, double mainRz,
                           double offRAngel, double offRx, double offRy, double offRz,
                           double mainHandScaleX, double mainHandScaleY, double mainHandScaleZ,
                           double offHandScaleX, double offHandScaleY, double offHandScaleZ) {
        this.mainX = mainX;
        this.mainY = mainY;
        this.mainZ = mainZ;
        this.offX = offX;
        this.offY = offY;
        this.offZ = offZ;
        this.mainRAngel = mainRAngel;
        this.mainRx = mainRx;
        this.mainRy = mainRy;
        this.mainRz = mainRz;
        this.offRAngel = offRAngel;
        this.offRx = offRx;
        this.offRy = offRy;
        this.offRz = offRz;
        this.mainHandScaleX = mainHandScaleX;
        this.mainHandScaleY = mainHandScaleY;
        this.mainHandScaleZ = mainHandScaleZ;
        this.offHandScaleX = offHandScaleX;
        this.offHandScaleY = offHandScaleY;
        this.offHandScaleZ = offHandScaleZ;
    }

    public void setMainX( Object v) {
        this.mainX = v;
    }

    public void setMainY( Object v) {
        this.mainY = v;
    }

    public void setMainZ( Object v) {
        this.mainZ = v;
    }

    public void setOffX( Object v) {
        this.offX = v;
    }

    public void setOffY( Object v) {
        this.offY = v;
    }

    public void setOffZ( Object v) {
        this.offZ = v;
    }

    public void setOffRAngel( Object v) {
        this.offRAngel = v;
    }

    public void setOffRx( Object v) {
        this.offRx = v;
    }

    public void setOffRy( Object v) {
        this.offRy = v;
    }

    public void setOffRz( Object v) {
        this.offRz =(double) v;
    }

    public void setMainRAngel( Object v) {
        this.mainRAngel =(double) v;
    }

    public void setMainRx( Object v) {
        this.mainRx =(double) v;
    }

    public void setMainRy( Object v) {
        this.mainRy =(double) v;
    }

    public void setMainRz( Object v) {
        this.mainRz =(double) v;
    }

    public void setMainHandScaleX( Object v) {
        this.mainHandScaleX =(double) v;
    }

    public void setMainHandScaleY( Object v) {
        this.mainHandScaleY =(double) v;
    }

    public void setMainHandScaleZ( Object v) {
        this.mainHandScaleZ =(double) v;
    }

    public void setOffHandScaleX( Object v) {
        this.offHandScaleX =(double) v;
    }

    public void setOffHandScaleY( Object v) {
        this.offHandScaleY =(double) v;
    }

    public void setOffHandScaleZ( Object v) {
        this.offHandScaleZ =(double) v;
    }


    public double getMainX() {
        return (double) mainX;
    }

    public double getMainY() {
        return (double) mainY;
    }

    public double getMainZ() {
        return (double) mainZ;
    }

    public double getOffX() {
        return (double) offX;
    }

    public double getOffY() {
        return (double) offY;
    }

    public double getOffZ() {
        return (double) offZ;
    }

    public double getMainRAngel() {
        return mainRAngel;
    }

    public double getMainRx() {
        return mainRx;
    }

    public double getMainRy() {
        return mainRy;
    }

    public double getMainRz() {
        return mainRz;
    }

    public double getOffRAngel() {
        return (double) offRAngel;
    }

    public double getOffRx() {
        return (double) offRx;
    }

    public double getOffRy() {
        return (double) offRy;
    }

    public double getOffRz() {
        return offRz;
    }

    public double getMainHandScaleX() {
        return mainHandScaleX;
    }

    public double getMainHandScaleY() {
        return mainHandScaleY;
    }

    public double getMainHandScaleZ() {
        return mainHandScaleZ;
    }

    public double getOffHandScaleX() {
        return offHandScaleX;
    }

    public double getOffHandScaleY() {
        return offHandScaleY;
    }

    public double getOffHandScaleZ() {
        return offHandScaleZ;
    }
}
