package me.cumhax.chipshack.module.hud;

import org.lwjgl.input.Keyboard;

import me.cumhax.chipshack.Client;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;

public class clickG extends Module
{
	public clickG()
	{
		super("ClickGUI2", "", Category.HUD);
		setBind(Keyboard.KEY_RSHIFT);
	}

	public void onEnable()
	{	
		mc.displayGuiScreen(Client.clickGUI2);
	}
}