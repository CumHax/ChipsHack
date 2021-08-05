package me.cumhax.chipshack.util;

import net.minecraft.client.Minecraft;
import java.util.Objects;

import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class printMsg {
    public static final Minecraft mc = Minecraft.getMinecraft();
    public static void printMsg(String message) {
        printMsg(message, "white");
    }

    public static void printMsg(String message, String color) {
        try {
            printMsg(Objects.requireNonNull(ITextComponent.Serializer.jsonToComponent((String) ("{\"text\":\"" + message + "\",\"color\":\"" + color + "\"}"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printMsg(ITextComponent message) {
        try {
            printMsg.mc.ingameGUI.addChatMessage(ChatType.SYSTEM, new TextComponentString(" ").appendSibling(message));
          //  MinecraftForge.EVENT_BUS.post((Event)new ChatEvent(message));
        } catch (Exception e) {
            e.printStackTrace();
        }

        }
    }