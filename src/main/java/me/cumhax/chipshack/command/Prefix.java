package me.cumhax.chipshack.command;

import me.cumhax.chipshack.Client;
import me.cumhax.chipshack.command.Command;
import me.cumhax.chipshack.util.LoggerUtil;


public class Prefix extends Command
{
	public Prefix(String name, String[] alias, String usage)
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

		Client.commandManager.setPrefix(arguments);
		LoggerUtil.sendMessage("Prefix set to " + arguments);
	}

	public void onRun(String arguments) {

	}
}
