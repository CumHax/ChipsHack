package me.cumhax.chipshack.module.chat;

import me.cumhax.chipshack.Client;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.util.LoggerUtil;

public class TotemPopCounter extends Module implements stuuffff {

    public TotemPopCounter()
    {
        super("TotemPopCounter", "", Category.CHAT);
    }

    @Override
    public void onUpdate () {
        if (nullCheck()) return;
        if (!Client.popManager.toAnnouce.isEmpty()) {
            try {
                for (String string : Client.popManager.toAnnouce) {
                    LoggerUtil.sendOverwriteClientMessage(string);
                }
                Client.popManager.toAnnouce.clear();
            } catch (Exception e) {
                //empty catchblock goo brrrrrrrrr
            }
        }
    }
}
