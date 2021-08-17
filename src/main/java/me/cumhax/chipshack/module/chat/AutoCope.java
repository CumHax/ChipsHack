package me.cumhax.chipshack.module.chat;

import java.util.Random;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;

public class AutoCope extends Module {
    int diedTime = 0;

	public AutoCope() {
		super("AutoCope", "", Category.CHAT);
	}
	
    public void update() {
        if (this.diedTime > 0) {
            --this.diedTime;
        }

        if (mc.player.isDead) {
            this.diedTime = 500;
        }

        if (!mc.player.isDead && this.diedTime > 0) {
            Random rand = new Random();
            int randomNum = rand.nextInt(12) + 1;
            if (randomNum == 1) {
                mc.player.sendChatMessage("your ping is so good :(((( why are you targeting me");
            }

            if (randomNum == 2) {
                mc.player.sendChatMessage("i was in my inventoryyyyyyy");
            }

            if (randomNum == 3) {
                mc.player.sendChatMessage("i was configuring my settings bro im not ez i promise");
            }

            if (randomNum == 4) {
                mc.player.sendChatMessage("I was tabbed out of minecraft dude");
            }

            if (randomNum == 5) {
                mc.player.sendChatMessage("i was was deSynced :(");
            }

            if (randomNum == 6) {
                mc.player.sendChatMessage("youre hacking bro not cool :/");
            }

            if (randomNum == 7) {
                mc.player.sendChatMessage("imagine killing a client tester :rofl: cringe");
            }

            if (randomNum == 8) {
                mc.player.sendChatMessage("ping player be like");
            }

            if (randomNum == 9) {
                mc.player.sendChatMessage("wow, cool, you killed me!");
            }

            if (randomNum == 10) {
                mc.player.sendChatMessage("i got desynced :(");
            }

            if (randomNum == 11) {
                mc.player.sendChatMessage("lagg");
            }

            if (randomNum == 12) {
                mc.player.sendChatMessage("i didn't expecting you");
            }

            this.diedTime = 0;
        }
    }
}
