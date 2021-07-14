package me.cumhax.chipshack.module;

public enum Category
{
	COMBAT("Combat"),
	RENDER("Render"),
	MOVEMENT("Movement"),
	CHAT("Chat"),
	MISC("Miscellaneous"),
	//COMPONENT("Component"),
	HIDDEN("Hidden"),
	GUI("Gui");

	private String name;

	Category(String name)
	{
		setName(name);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
