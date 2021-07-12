package me.cumhax.chipshack.command;

import me.cumhax.chipshack.Client;
import me.cumhax.chipshack.command.Command;
import me.cumhax.chipshack.util.LoggerUtil;
import me.cumhax.chipshack.util.font.CustomFontRenderer;
import me.cumhax.chipshack.util.font.FontUtil;


public class Font extends Command
{
	public Font(String name, String[] alias, String usage)
	{
		super(name, alias, usage);
	}

	@Override
	public void onTrigger(String arguments)
	{
		if (arguments.equals(""))
		{
			printUsage();
			return;
		}

		if (FontUtil.validateFont(arguments))
		{
			try
			{
				Client.customFontRenderer = new CustomFontRenderer(new java.awt.Font(arguments, java.awt.Font.PLAIN, 19), true, false);
				LoggerUtil.sendMessage("New font set to " + arguments);
			}
			catch (Exception e)
			{
				LoggerUtil.sendMessage("Failed to set font");
			}
		}
		else
		{
			LoggerUtil.sendMessage("Invalid font");
		}
	}

	public void onRun(String arguments) {

	}
}
