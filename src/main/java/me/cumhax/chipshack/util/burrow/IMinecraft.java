package me.cumhax.chipshack.util.burrow;

import net.minecraft.util.Timer;

public interface IMinecraft
{
	Timer getTimer();
	
	void setRightClickDelayTimer(final int p0);
}