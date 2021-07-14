package me.cumhax.chipshack;

import me.cumhax.chipshack.event.EventHandler;
import me.cumhax.chipshack.command.CommandManager;
import me.cumhax.chipshack.gui.clickgui.ClickGUI;
import me.cumhax.chipshack.manager.FriendManager;
import me.cumhax.chipshack.module.ModuleManager;
import me.cumhax.chipshack.setting.SettingManager;
import me.cumhax.chipshack.util.font.CustomFontRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import me.cumhax.chipshack.manager.ConfigManager;

import java.awt.*;
import java.io.IOException;

@Mod(modid = "chipshack", name = "ChipsHack", version = "b3")
public class Client
{
	public static ModuleManager moduleManager;
	public static SettingManager settingManager;
	public static CustomFontRenderer customFontRenderer;
	public static ClickGUI clickGUI;
	public static CommandManager commandManager;
	public static FriendManager friendManager;

	@Mod.EventHandler
	public void initialize(FMLInitializationEvent event) throws IOException {
		commandManager = new CommandManager();
		settingManager = new SettingManager();
		moduleManager = new ModuleManager();
		friendManager = new FriendManager();
		customFontRenderer = new CustomFontRenderer(new Font("Verdana", Font.PLAIN, 19), true, false);
		clickGUI = new ClickGUI();

		ConfigManager.loadConfig();

		Runtime.getRuntime().addShutdownHook(new ConfigManager());
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	public static ModuleManager getModuleManager()
	{
		return moduleManager;
	}
	public static FriendManager getFriendManager()
	{
		return friendManager;
	}
}
