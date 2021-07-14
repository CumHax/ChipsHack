package me.cumhax.chipshack.module;

import me.cumhax.chipshack.Client;
import me.cumhax.chipshack.setting.Setting;
import me.cumhax.chipshack.module.combat.*;
import me.cumhax.chipshack.module.misc.*;
import me.cumhax.chipshack.module.movement.*;
import me.cumhax.chipshack.module.render.*;
import me.cumhax.chipshack.module.chat.*;
import me.cumhax.chipshack.module.client.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ModuleManager
{
	private final ArrayList<Module> modules = new ArrayList<>();

	public ModuleManager()
	{
		// Render Category
		modules.add(new HoleESP( "HoleESP", "Renders safe holes from Crystals", Category.RENDER));
		modules.add(new BlockHighlight( "BlockHighlight", "Highlights the block you're looking at", Category.RENDER));
		modules.add(new NameTags());
		modules.add(new Tracers("Tracers", "Tracers to stuff", Category.RENDER));
		modules.add(new AntiWeather());
		modules.add(new Fullbright());
		modules.add(new ViewmodelChanger());
		
		// Combat Category
		modules.add(new Aura());
		modules.add(new Auto32K("Auto32K", "Automatically handles 32ks for you in combat", Category.COMBAT));
		modules.add(new AutoArmor());
		modules.add(new AutoCrystal2b2t("AutoCrystal2b2t", "Automatically attack other players with Crystals", Category.COMBAT));
		modules.add(new AutoLog("AutoLog", "Automatically logs out when your health is low", Category.COMBAT));
		modules.add(new AutoTrap("AutoTrap", "Traps players", Category.COMBAT));
		modules.add(new InstantBurrow());
		modules.add(new Criticals("Criticals", "Deal critical hits without jumping", Category.COMBAT));
		modules.add(new EXPFast());
		modules.add(new Offhand());
		modules.add(new Surround("Surround", "Places blocks around you", Category.COMBAT));

		// Movement Category
		modules.add(new Speed("Speed", "Allows you to move faster", Category.MOVEMENT));
		modules.add(new Sprint("Sprint", "Automatically toggles sprint for you", Category.MOVEMENT));
		modules.add(new AutoHole("Anchor", "Automatically goes into holes for you", Category.MOVEMENT));
		modules.add(new LongJump("LongJump", "Jumps far", Category.MOVEMENT));
		modules.add(new Jesus("Jesus", "Walk on water", Category.MOVEMENT));
		modules.add(new ReverseStep());
		modules.add(new Step("Step", "Go up blocks automatically", Category.MOVEMENT));
		modules.add(new NoSlow());
		modules.add(new Velocity());

		// Chat Category
		modules.add(new ChatSuffix("ChatSuffix", "Adds a suffix to your chat messages", Category.CHAT));
		modules.add(new Shrug("Shrug", "Adds the shrug emoji when used", Category.CHAT));
		modules.add(new AutoEZ("AutoEZ", "Automatically announces in chat when you get a kill", Category.CHAT));
		modules.add(new BetterChat("BetterChat", "Modifies the look of your ingame chat", Category.CHAT));

		// Misc Category
		modules.add(new RPC("DiscordRPC", "Shares your game status in Discord", Category.MISC));
		modules.add(new AutoDupe("AutoDupe", "Automatically performs the SalC1 TreeMC dupe", Category.MISC));
		modules.add(new PacketMine("PacketMine", "Mine blocks with packets", Category.MISC));
		modules.add(new TotemPopCounter());
		modules.add(new Timer("Timer", "Speeds up your game", Category.MISC));
		modules.add(new Blink("Blink", "Fake lag", Category.MISC));
		modules.add(new FakePlayer());
		modules.add(new OffhandSwing());

        // Client Category
		modules.add(new ArrayListE());
		modules.add(new ClickGUI("ClickGUI", "Toggle modules by clicking on them", Category.CLIENT));
		modules.add(new Coords());
		modules.add(new CustomFont());
		modules.add(new Watermark());
		
		for (Module module : modules) {
			for (Field declaredField : module.getClass().getDeclaredFields()) {
				declaredField.setAccessible(true);
				if (declaredField.getType() == Setting.class) {
					try {
						Client.settingManager.addSetting((Setting) declaredField.get(module));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public ArrayList<Module> getModules()
	{
		return modules;
	}

	public Module getModule(String name)
	{
		for (Module module : modules)
		{
			if (module.getName().equalsIgnoreCase(name)) return module;
		}

		return null;
	}

	public ArrayList<Module> getModules(Category category)
	{
		ArrayList<Module> mods = new ArrayList<>();

		for (Module module : modules)
		{
			if (module.getCategory().equals(category)) mods.add(module);
		}

		return mods;
	}

	public ArrayList<Module> getEnabledModules()
	{
		return modules.stream().filter(Module::isEnabled).collect(Collectors.toCollection(ArrayList::new));
	}
}
