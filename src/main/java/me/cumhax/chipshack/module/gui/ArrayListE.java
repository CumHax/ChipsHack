package me.cumhax.chipshack.module.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import me.cumhax.chipshack.Client;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.util.font.FontUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ArrayListE extends Module
{
	public ArrayListE() 
	{
		super("ArrayList", "", Category.GUI);
	}

	@SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) 
	{
		if(nullCheck()) return;
		if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) 
		{
			final ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
	        int y = 2;
	        final ArrayList<String> list = new ArrayList<String>();
	        for (final Module mod : Client.moduleManager.getModules()) {
	            if (mod.isEnabled()) {
	            	if(mod.getCategory() != Category.GUI && mod.getName() != "ClickGUI") {
	            		list.add(mod.getName());
	            	}
	            }
	            list.sort((s1, s2) -> Client.customFontRenderer.getStringWidth(s1) - Client.customFontRenderer.getStringWidth(s2));
	            Collections.reverse(list);
	        }
	        for (final String name : list) {
	        	Gui.drawRect((int)(sr.getScaledWidth() - Client.customFontRenderer.getStringWidth(name) - 8), y - 2, (int)(sr.getScaledWidth()), y + 12, new Color(24,14,60, 205).getRGB());
	        	Gui.drawRect((int)(sr.getScaledWidth() - Client.customFontRenderer.getStringWidth(name) - 8), y - 2, (int)(sr.getScaledWidth() - Client.customFontRenderer.getStringWidth(name) - 7), y + 12, new Color(124,9,77, 255).getRGB());
	        	//RenderUtil.drawGradientSideways((int)(sr.getScaledWidth() - Client.customFontRenderer.getStringWidth(name) - 7), y + 9, (int)(sr.getScaledWidth()), y + 10, new Color(124,9,77,255).getRGB(), new Color(64,41,213, 255).getRGB());
	        	FontUtil.drawStringWithShadow(name, (float)(sr.getScaledWidth() - FontUtil.getStringWidth(name)) - 0.5, y + 2, new Color(255,255,255, 255).getRGB());
	        	y += 14;
	        }	
		}
	}
}
