package me.cumhax.chipshack.module.hud;

import java.awt.Color;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.setting.Setting;
import me.cumhax.chipshack.util.watermark.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Inventory extends Module
{
	private final ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
	
    private final Setting x = new Setting ("X", this, 1, 1, sr.getScaledWidth() * 2);
	private final Setting y = new Setting ("Y", this, 1, 1, sr.getScaledHeight() * 2);
	
	public Inventory()
	{
		super("Inventory", "", Category.HUD);
	}

	@SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) 
	{
		if(nullCheck()) return;
		if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) 
		{ 
			GlStateManager.pushMatrix();
			RenderHelper.enableGUIStandardItemLighting();
			Gui.drawRect(x.getIntegerValue() - 2, y.getIntegerValue() - 2, x.getIntegerValue() - 1, y.getIntegerValue() + 58, new Color(64,41,213).getRGB());
			Gui.drawRect(x.getIntegerValue() + 177, y.getIntegerValue() - 1, x.getIntegerValue() + 178, y.getIntegerValue()+ 57, new Color(64,41,213, 255).getRGB());
			Gui.drawRect(x.getIntegerValue() + 177, y.getIntegerValue() - 2, x.getIntegerValue() + 178, y.getIntegerValue() + 58, new Color(124,9,77, 255).getRGB());
			RenderUtil.drawGradientSideways(x.getIntegerValue() -2, y.getIntegerValue() - 3, x.getIntegerValue() + 178, y.getIntegerValue() - 2, new Color(64,41,213,255).getRGB(), new Color(124,9,77, 255).getRGB());
			RenderUtil.drawGradientSideways(x.getIntegerValue() - 1, y.getIntegerValue() + 57, x.getIntegerValue() + 177, y.getIntegerValue() + 58, new Color(64,41,213,255).getRGB(), new Color(124,9,77, 255).getRGB());
			RenderUtil.drawGradientSideways(x.getIntegerValue() - 1, y.getIntegerValue() - 2, x.getIntegerValue() + 177, y.getIntegerValue() + 57, new Color(10,10,10,155).getRGB(), new Color(10,10,10,55).getRGB());
			for (int i = 0; i < 27; i++) 
			{
				ItemStack item_stack = mc.player.inventory.mainInventory.get(i + 9);
				int item_position_x = (int) x.getIntegerValue() + (i % 9) * 20;
				int item_position_y = (int) y.getIntegerValue() + (i / 9) * 20;
				mc.getRenderItem().renderItemAndEffectIntoGUI(item_stack, item_position_x, item_position_y);
				mc.getRenderItem().renderItemOverlayIntoGUI(mc.fontRenderer, item_stack, item_position_x, item_position_y, null);
			}
			mc.getRenderItem().zLevel = - 5.0f;
			RenderHelper.disableStandardItemLighting();			
			GlStateManager.popMatrix();
		}
	}
}
