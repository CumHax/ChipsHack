package me.cumhax.chipshack.module.hud;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class ArmorHud extends Module
{
    public ArmorHud() {
        super("ArmorHud", "", Category.HUD);
    }

	public boolean on;
	private final Minecraft mc = Minecraft.getMinecraft();

	
	 private static final RenderItem itemRender = Minecraft.getMinecraft().getRenderItem();

	 	@SubscribeEvent
		public void renderOverlay(RenderGameOverlayEvent event) {
			if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
		    GlStateManager.enableTexture2D();
		
		    ScaledResolution resolution = new ScaledResolution(mc);
		    int i = resolution.getScaledWidth() / 2;
		    int iteration = 0;
		    int y = resolution.getScaledHeight() - 55 - (mc.player.isInWater() ? 10 : 0);
		    for (ItemStack is : mc.player.inventory.armorInventory) {
		        iteration++;
		        if (is.isEmpty()) continue;
		        int x = i - 90 + (9 - iteration) * 24 - 25;
		        GlStateManager.enableDepth();
		        itemRender.zLevel = 200F;
		        itemRender.renderItemAndEffectIntoGUI(is, x, y);
		        itemRender.renderItemOverlayIntoGUI(mc.fontRenderer, is, x, y, "");
		        itemRender.zLevel = 0F;
		
		        GlStateManager.enableTexture2D();
		        GlStateManager.disableLighting();
		        GlStateManager.disableDepth();
		
		        String s = is.getCount() > 50 ? is.getCount() + "" : "";
		        mc.fontRenderer.drawStringWithShadow(s, x + 19 - 2 - mc.fontRenderer.getStringWidth(s), y + 9, 0xffffffff);
		        float green = ((float) is.getMaxDamage() - (float) is.getItemDamage()) / (float) is.getMaxDamage();
		        float red = 1 - green;
		        int dmg = 100 - (int) (red * 100);
		        //mc.fontRenderer.drawStringWithShadow(dmg + "", x + 8 - mc.fontRenderer.getStringWidth(dmg + "") / 2, y - 8, 0xffffffff);
		    }
		
		    GlStateManager.enableDepth();
		    GlStateManager.disableLighting();
			}
		}
	 	
	 	@Override
	 	public void onEnable() {
	 		MinecraftForge.EVENT_BUS.register(this);
	 	}
	 	
	 	@Override
	 	public void onDisable() {
	 		MinecraftForge.EVENT_BUS.unregister(this);
	 	}

}