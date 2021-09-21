package me.cumhax.chipshack.module.misc;

import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.module.Category;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class LogoutCoords extends Module {

	public LogoutCoords() {
		super("LogoutCoords", "", Category.MISC);
	}

    @SubscribeEvent
    public void onPlayerLeaveEvent(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
        if (!mc.isSingleplayer()) {
            if (!mc.getCurrentServerData().serverIP.equalsIgnoreCase("2b2tpvp.net") && mc.player.dimension != 1) {

                int x = (int) mc.player.posX;
                int y = (int) mc.player.posY;
                int z = (int) mc.player.posZ;
                String coords = "Logout Coords: X:" + x + " Y:" + y + " Z:" + z;

                StringSelection data = new StringSelection(coords);
                Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                cb.setContents(data, data);

            }
        }
    }
}
