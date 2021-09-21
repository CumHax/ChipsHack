package me.cumhax.chipshack.module.misc;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;

public class MultiTask extends Module implements stuff {

    public MultiTask() {
        super("MultiTask", "", Category.MISC);
    }

    @Override
    public void addSubscription ()
    {
        EVENT_BUS.subscribe(this);
    }

    @Override
    public void removeSubscription ()
    {
     //   Client.EVENT_BUS.unsubscribe(this);
    }

    private static class EVENT_BUS {
        public static void subscribe ( MultiTask multiTask ) {

        }
    }
}
