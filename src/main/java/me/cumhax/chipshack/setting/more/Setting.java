package me.cumhax.chipshack.setting.more;

import java.util.List;

import me.cumhax.chipshack.module.Module;

public class Setting
{
	private final String name;
	private final Module module;
	private final SettingType type;
	private boolean booleanValue;
	private int integerValue;
	private int minIntegerValue;
	private int maxIntegerValue;
	private String enumValue;
	private List<String> enumValues;
	
	public Setting(String name, Module module, int intValue, int intMinValue, int intMaxValue)
	{
		this.name = name;
		this.module = module;
		this.integerValue = intValue;
		this.minIntegerValue = intMinValue;
		this.maxIntegerValue = intMaxValue;
		this.type = SettingType.INTEGER;
	}

	public Setting(String name, Module module, boolean boolValue)
	{
		this.name = name;
		this.module = module;
		this.booleanValue = boolValue;
		this.type = SettingType.BOOLEAN;
	}

	public Setting(String name, Module module, List<String> enumValues)
	{
		this.name = name;
		this.module = module;
		this.enumValue = enumValues.get(0);
		this.enumValues = enumValues;
		this.type = SettingType.ENUM;
	}

	public String getName()
	{
		return name;
	}

	public Module getModule()
	{
		return module;
	}

	public SettingType getType()
	{
		return type;
	}

	public boolean getBooleanValue()
	{
		return booleanValue;
	}

	public void setBooleanValue(boolean booleanValue)
	{
		this.booleanValue = booleanValue;
	}

	public int getIntegerValue()
	{
		return integerValue;
	}

	public void setIntegerValue(int integerValue)
	{
		this.integerValue = integerValue;
	}

	public int getMinIntegerValue()
	{
		return minIntegerValue;
	}

	public int getMaxIntegerValue()
	{
		return maxIntegerValue;
	}

	public String getEnumValue()
	{
		return enumValue;
	}

	public void setEnumValue(String enumValue)
	{
		this.enumValue = enumValues.contains(enumValue) ? enumValue : this.enumValue;
	}

	public List<String> getEnumValues()
	{
		return enumValues;
	}
}
