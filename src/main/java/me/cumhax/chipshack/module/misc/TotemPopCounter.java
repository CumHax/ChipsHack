package me.cumhax.chipshack.module.misc;

import me.cumhax.chipshack.value.Value;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;

public class TotemPopCounter extends Module 
{
	public TotemPopCounter() {
        super("TotemPopCounter", "", Category.MISC);
    }

    public final Value<Boolean> resetOnOwn = new Value<>("ResetOnOwn", true);

    public static TotemPopCounter INSTANCE;

    {
        INSTANCE = this;
    }

}
