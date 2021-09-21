package me.cumhax.chipshack.module.chat;

import java.util.Random;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;

public class AutoExcuse extends Module {
    int diedTime;
    
    public AutoExcuse() 
	{	
        super("AutoCope", "", Category.CHAT);
    }

    public void update() {
        if (this.diedTime > 0) {
            --this.diedTime;
        }
        if (AutoExcuse.mc.player.isDead) {
            this.diedTime = 500;
        }
        if (!AutoExcuse.mc.player.isDead && this.diedTime > 0) {
            final Random rand = new Random();
            final int randomNum = rand.nextInt(6) + 1;
            if (randomNum == 1) {
                AutoExcuse.mc.player.sendChatMessage("you won because you are a pingplayer :((");
            }
            if (randomNum == 2) {
                AutoExcuse.mc.player.sendChatMessage("i was in my hentai file :(");
            }
            if (randomNum == 3) {
                AutoExcuse.mc.player.sendChatMessage("bro im good i was testing configs :((");
            }
            if (randomNum == 5) {
                AutoExcuse.mc.player.sendChatMessage("im desync :(");
            }
            if (randomNum == 6) {
                AutoExcuse.mc.player.sendChatMessage("youre a cheater :(");
            }
            this.diedTime = 0;
        }
    }
}
