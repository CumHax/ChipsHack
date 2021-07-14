package me.cumhax.chipshack.module.combat;

import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.module.Category;
import net.minecraft.init.Items;
import net.minecraftforge.client.MinecraftForgeClient;


public class EXPFast extends Module {

    public EXPFast() {
        super("EXPFast", "EXPFast", Category.COMBAT);
    }

    public void onUpdate() {
        if (mc.player.getHeldItemMainhand().getItem() == Items.EXPERIENCE_BOTTLE || mc.player.getHeldItemOffhand().getItem() == Items.EXPERIENCE_BOTTLE)
            mc.debug = String.valueOf(0);
    }
}
