package me.cumhax.chipshack.module.render;


import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.setting.Setting;
import me.cumhax.chipshack.util.font.FontUtil;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraft.client.gui.ScaledResolution;

import java.awt.*;
import java.util.Arrays;

public class Watermark extends Module
{
    private final Setting Position = new Setting("Mode", this, Arrays.asList(
            "Right Top",
            "Right Bottom",
            "Left Top",
            "Left Bottom"
    ));
    public Watermark(String name, String description, Category category)
    {
        super(name, description, category);
    }



    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event)
    {
        ScaledResolution screen = new ScaledResolution(mc);
        if (nullCheck() || !event.getType().equals(RenderGameOverlayEvent.ElementType.TEXT)) return;

        if(Position.getEnumValue().equalsIgnoreCase("Right Top")) {
            FontUtil.drawStringWithShadow("ChipsHack b1", screen.getScaledWidth_double() - FontUtil.getStringWidth("ChipsHack-b1") - 4, 2.0D , new Color(255, 255, 255, 232).getRGB() ); }

        if(Position.getEnumValue().equalsIgnoreCase("Right Bottom")) {
            FontUtil.drawStringWithShadow("ChipsHack b1", screen.getScaledWidth_double() - FontUtil.getStringWidth("ChipsHack-b1") - 4, screen.getScaledHeight_double() - FontUtil.getFontHeight() + 1 , new Color(255, 255, 255, 232).getRGB() ); }

        if(Position.getEnumValue().equalsIgnoreCase("Left Top")) {
            FontUtil.drawStringWithShadow("ChipsHack b1", 2.0D, 2.0D , new Color(255, 255, 255, 232).getRGB() ); }

        if(Position.getEnumValue().equalsIgnoreCase("Left Bottom")) {
            FontUtil.drawStringWithShadow("ChipsHack b1", 2.0D,  screen.getScaledHeight_double() - FontUtil.getFontHeight() - 2, new Color(255, 255, 255, 232).getRGB() ); }
    }

}
