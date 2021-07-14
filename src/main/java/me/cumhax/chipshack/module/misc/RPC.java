package me.cumhax.chipshack.module.misc;

import me.cumhax.chipshack.discord.Discord;
import me.cumhax.chipshack.discord.RPCBuilder;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;

public class RPC extends Module {

    public RPC(String name, String description, Category category)
    {
        super(name, description, category);
    }

    public static Discord discordRPC = new RPCBuilder("862318235717861376").withDetails("A Swag Client By CumHax").withState("").withLargeImageKey("lol").withLargeImageText("https://discord.gg/RbaYTnqSfD").build();

    @Override
    public void onEnable()
    {
        discordRPC.start();
    }

    @Override
    public void onDisable()
    {
        discordRPC.stop();
    }

}
