package me.cumhax.chipshack.module.render;

import me.cumhax.chipshack.event.Render3DEvent;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.setting.Setting;
import me.cumhax.chipshack.util.RenderUtil;
import me.cumhax.chipshack.util.WorldUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import team.stiff.pomelo.impl.annotated.handler.annotation.Listener;

import java.awt.*;
import java.util.Arrays;

public final class FeetHighlight extends Module
{
    private final Setting red = new Setting("Red", this, 50, 0, 255);
    private final Setting mode = new Setting("Mode", this, Arrays.asList("OutHole", "InHole", "Always"));
    private final Setting green = new Setting("Green", this, 50, 0, 255);
    private final Setting self = new Setting("Self", this, false);
    private final Setting blue = new Setting("Blue", this, 50, 0, 255);
    private final Setting box = new Setting("Box", this, true);
    private final Setting alpha = new Setting("Alpha", this, 100, 0, 255);
    private final Setting outline = new Setting("Outline", this, true);

    public FeetHighlight()
    {
        super("FeetESP", Category.RENDER);
    }

    @Listener
    public void render(final Render3DEvent event)
    {
        for (final EntityPlayer player : mc.world.playerEntities)
        {
            //if (!this.self.getValue() && player.equals(mc.player)) continue;

            if (this.mode.is("InHole"))
            {
                if (WorldUtil.isInHole(player))
                    RenderUtil.drawBox(new BlockPos(player.posX, player.posY, player.posZ), new Color((int) this.red.getValue(), (int) this.green.getValue(), (int) this.blue.getValue(), (int) this.alpha.getValue()), this.box.getValue(), this.outline.getValue());
            }
            else if (this.mode.is("OutHole"))
            {
                if (!WorldUtil.isInHole(player))
                    RenderUtil.drawBox(new BlockPos(player.posX, player.posY, player.posZ), new Color((int) this.red.getValue(), (int) this.green.getValue(), (int) this.blue.getValue(), (int) this.alpha.getValue()), this.box.getValue(), this.outline.getValue());
            }
            else
            {
                RenderUtil.drawBox(new BlockPos(player.posX, player.posY, player.posZ), new Color((int) this.red.getValue(), (int) this.green.getValue(), (int) this.blue.getValue(), (int) this.alpha.getValue()), this.box.getValue(), this.outline.getValue());
            }
        }
    }
}
