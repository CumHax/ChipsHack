package me.cumhax.chipshack.module.render;

import me.cumhax.chipshack.module.ModuleManager;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.setting.Setting;
import me.cumhax.chipshack.util.LoggerUtil;
import me.cumhax.chipshack.util.font.FontUtil;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraft.client.gui.ScaledResolution;

import java.util.logging.Logger;

public class ArrayList extends Module {

    public ArrayList(String name, String description, Category category)
    {
        super(name, description, category);
    }


    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event){

        }
    }
