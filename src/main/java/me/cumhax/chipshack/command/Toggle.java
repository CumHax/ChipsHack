package me.cumhax.chipshack.command;

import me.cumhax.chipshack.Client;
import me.cumhax.chipshack.command.Command;
import me.cumhax.chipshack.module.Module;

public class Toggle extends Command
{
    public Toggle(String name, String[] alias, String usage)
    {
        super(name, alias, usage);
    }


    @Override
    public void onTrigger(String arguments)
    {

        Module m = Client.moduleManager.getModule(arguments);
        if (m != null)
        {
            m.toggle();
            return;
        }

        printUsage();

    }

    @Override
    public void onRun(String arguments) {

    }
}