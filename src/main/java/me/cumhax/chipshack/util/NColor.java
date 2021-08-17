package me.cumhax.chipshack.util;

import java.awt.Color;

public class NColor {

    private int red;
    private int green;
    private int blue;
    private int alpha;

    public NColor(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public NColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = 255;
    }

    public NColor(Color color) {
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
        this.alpha = color.getAlpha();
    }

    public int getRed() {
        return this.red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return this.green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return this.blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public int getRGB() {
        return (this.alpha & 255) << 24 | (this.red & 255) << 16 | (this.green & 255) << 8 | this.blue & 255;
    }

    public Color getAsColor() {
        return new Color(this.red, this.green, this.blue, this.alpha);
    }
}
