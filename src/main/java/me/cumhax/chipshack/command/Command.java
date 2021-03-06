package me.cumhax.chipshack.command;

import me.cumhax.chipshack.Client;
import me.cumhax.chipshack.util.LoggerUtil;


public abstract class Command
{
	private String name;
	private String[] alias;
	private String usage;

	public Command(String name, String[] alias, String usage)
	{
		setName(name);
		setAlias(alias);
		setUsage(usage);
	}

	public void onTrigger(String arguments) {}

	public void printUsage()
	{
		LoggerUtil.sendMessage("Usage: " + Client.commandManager.getPrefix() + usage);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String[] getAlias()
	{
		return alias;
	}

	public void setAlias(String[] alias)
	{
		this.alias = alias;
	}

	public String getUsage()
	{
		return usage;
	}

	public void setUsage(String usage)
	{
		this.usage = usage;
	}

    public abstract void onRun(String arguments);
}
