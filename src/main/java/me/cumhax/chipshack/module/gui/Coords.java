package me.cumhax.chipshack.module.gui;

import java.awt.Color;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.util.font.FontUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Coords extends Module {
	public Coords() {
		super("Coords", "", Category.GUI);
	}

	@SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) 
	{
		if(nullCheck()) return;
		if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) 
		{
			final ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
			double scale = Math.pow(10, 1);
			String coords = "X: " + Math.round(mc.player.posX * scale) / scale  + " Y: " + Math.round(mc.player.posY * scale) / scale + " Z: " + Math.round(mc.player.posZ * scale) / scale;
			Gui.drawRect(0, sr.getScaledHeight(), FontUtil.getStringWidth(coords), sr.getScaledHeight() - 11, new Color(0,0,0,150).getRGB());			
			FontUtil.drawString(coords, 1, sr.getScaledHeight() - 8, new Color(255,255,255).getRGB());
		}
	}
}