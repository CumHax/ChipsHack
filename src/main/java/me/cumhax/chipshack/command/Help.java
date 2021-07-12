package me.cumhax.chipshack.command;

import me.cumhax.chipshack.Client;
import me.cumhax.chipshack.command.Command;
import me.cumhax.chipshack.util.LoggerUtil;

public class Help extends Command
{
	public Help(String name, String[] alias, String usage)
	{
		super(name, alias, usage);
	}

	@Override
	public void onTrigger(String arguments)
	{
		LoggerUtil.sendMessage("ChipsHack");

		for (Command command : Client.commandManager.getCommands())
		{
			LoggerUtil.sendMessage(command.getName() + " - " + command.getUsage());
		}
	}

	public void onRun(String arguments) {

	}

}
