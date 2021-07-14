package me.cumhax.chipshack.module.client;

import me.cumhax.chipshack.Client;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.setting.Setting;
import org.lwjgl.input.Keyboard;

import java.util.Arrays;


public class ClickGUI extends Module
{
	public ClickGUI() {
        super("ClickGUI", "", Category.CLIENT);
    }

	Setting color = new Setting("Color", this, Arrays.asList(
			"Purple"
	));

	public ClickGUI(String name, String description, Category category)
	{
		super(name, description, category);

		setBind(Keyboard.KEY_RSHIFT);
	}

	@Override
	public void onEnable()
	{
		mc.displayGuiScreen(Client.clickGUI);
	}
}