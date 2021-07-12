package me.cumhax.chipshack.command;

import me.cumhax.chipshack.Client;
import me.cumhax.chipshack.command.Command;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.setting.Setting;
import me.cumhax.chipshack.util.LoggerUtil;

public class Set extends Command
{
    public Set(String name, String[] alias, String usage)
    {
        super(name, alias, usage);
    }


    @Override
    public void onTrigger(String arguments)
    {
        String[] args = arguments.split(" ");

        for (Module module : Client.moduleManager.getModules())
        {
            if (module.getName().equalsIgnoreCase(args[0]))
            {

                for (Setting setting : Client.settingManager.getSettings())
                {
                    if (setting.getModule().equals(module) && args[1].equalsIgnoreCase(setting.getName()))
                    {

                        if (setting.isInteger() && (setting.getMinIntegerValue() - 1) < Integer.parseInt(args[2].toLowerCase()) && (setting.getMaxIntegerValue() + 1) > Integer.parseInt(args[2].toLowerCase()))
                        {
                            setting.setIntegerValue(Integer.parseInt(args[2].toLowerCase()));
                            LoggerUtil.sendMessage("Set " + setting.getName() + " to " + setting.getIntegerValue());
                            return;
                        }
                        else if (setting.isBoolean())
                        {
                            setting.setBooleanValue(args[2].equalsIgnoreCase("on") || args[2].equalsIgnoreCase("true"));
                            LoggerUtil.sendMessage("Set " + setting.getName() + " to " + setting.getBooleanValue());
                            return;
                        }
                        else if (setting.isEnum())
                        {
                            for (String string : setting.getEnumValues())
                            {
                                if (args[2].equalsIgnoreCase(string)) setting.setEnumValue(string);
                            }
                            LoggerUtil.sendMessage("Set " + setting.getName() + " to " + setting.getEnumValue());
                            return;
                        }
                    }
                }
            }
        }

        printUsage();
    }
    @Override
    public void onRun(String arguments) {

    }
}