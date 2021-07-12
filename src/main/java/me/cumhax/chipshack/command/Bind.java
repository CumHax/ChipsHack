package me.cumhax.chipshack.command;

import me.cumhax.chipshack.Client;
import me.cumhax.chipshack.command.Command;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.util.LoggerUtil;
import org.lwjgl.input.Keyboard;

public class Bind extends Command
{
    public Bind(String name, String[] alias, String usage) {
        super(name, alias, usage);
    }

    @Override
    public void onTrigger(String arguments)
    {
        String[] split = arguments.split(" " );

        Module module = Client.getModuleManager().getModule(split[0]);

        if (module != null)
        {
            try
            {
                module.setBind(Keyboard.getKeyIndex(split[1].toUpperCase()));
                LoggerUtil.sendMessage(String.format("Bound %s to %s", module.getName(), split[1].toUpperCase()));
                return;
            }
            catch (Exception ignored)
            {
            }
        }

        printUsage();
    }

    public void onRun(String arguments) {

    }

}