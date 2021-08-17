package me.cumhax.chipshack.module.misc;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;

public class Australia extends Module {
	
    public Australia() {
        super("Australia", "", Category.MISC);
    }

    public void onUpdate() {
        if (OpenGlHelper.shadersSupported && mc.getRenderViewEntity() instanceof EntityPlayer) {
            if (mc.entityRenderer.getShaderGroup() != null) {
                mc.entityRenderer.getShaderGroup().deleteShaderGroup();
            }
            try {
                mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/flip.json"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (mc.entityRenderer.getShaderGroup() != null && mc.currentScreen == null) {
                mc.entityRenderer.getShaderGroup().deleteShaderGroup();
            }
        }
        mc.player.setFire(1);
    }
}
