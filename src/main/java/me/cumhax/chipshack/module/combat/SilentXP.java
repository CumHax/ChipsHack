package me.cumhax.chipshack.module.combat;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.setting.Setting;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import org.lwjgl.input.Keyboard;

public class SilentXP extends Module implements mm {

    private final Setting hold = new Setting("Hold", this, false);
    private final Setting takeOffVal = new Setting("Armor HP", this, 15, 1, 90);
    private final Setting rotate = new Setting("Rotate", this, false);
    private final Setting rotate_back = new Setting("Rotate Back", this, false);
    private final Setting allowTakeOff = new Setting("Remove Armor", this, true);
    private final Setting lookPitch = new Setting("Pitch", this, 90, 10, 360);
    private final Setting delay = new Setting("Delay", this, 1, 0, 4);

    private int delay_count;
    int prvSlot;

    public SilentXP() {
        super("SilentXP", "", Category.COMBAT);
    }

    @Override
    public void enable (){
        delay_count = 0;
    }

    private int findExpInHotbar() {
        int slot = 0;
        for (int i = 0; i < 9; i++) {
            if (mc.player.inventory.getStackInSlot(i).getItem() == Items.EXPERIENCE_BOTTLE) {
                slot = i;
                break;
            }
        }
        return slot;
    }

    @Override
    public void update () {
      // if (Keyboard.isKeyDown(bind.get_bind(0)) || !hold.get_value(true)) {
            if (mc.currentScreen == null) {
                doXp();
            }
        }


    @Override
    public void doXp (){
        int oldPitch = (int)mc.player.rotationPitch;
        prvSlot = mc.player.inventory.currentItem; //TODO add better rotations
        mc.player.connection.sendPacket(new CPacketHeldItemChange(findExpInHotbar()));
        if (rotate.get_value(true)) {
            mc.player.rotationPitch = lookPitch.get_value(1);
            mc.player.connection.sendPacket(new CPacketPlayer.Rotation(mc.player.rotationYaw, lookPitch.get_value(1), mc.player.onGround));
        }
        mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
        mc.player.inventory.currentItem = prvSlot;
        mc.player.connection.sendPacket(new CPacketHeldItemChange(prvSlot));
        if (rotate.get_value(true) && rotate_back.get_value(true)) {
            mc.player.rotationPitch = oldPitch;
            mc.player.connection.sendPacket(new CPacketPlayer.Rotation(mc.player.rotationYaw, mc.player.rotationPitch, mc.player.onGround));
        }
        if (allowTakeOff.get_value(true)) {
            takeArmorOff(); //TODO add the ArmourMend take off thing
        }
    }

    private ItemStack getArmor(int first) {
        return mc.player.inventoryContainer.getInventory().get(first);
    }

    private void takeArmorOff() {
        int slot = 5;
        while (slot <= 8) {
            ItemStack item;
            item = getArmor(slot);
            double max_dam = item.getMaxDamage();
            double dam_left = item.getMaxDamage() - item.getItemDamage();
            double percent = (dam_left / max_dam) * 100;

            if (percent >= takeOffVal.get_value(1) && !item.equals(Items.AIR)) {
                if (!notInInv(Items.AIR)) {
                    return;
                }
                if (delay_count < delay.get_value(1)) {
                    delay_count++;
                    return;
                }
                delay_count = 0;

                mc.playerController.windowClick(0, slot, 0, ClickType.QUICK_MOVE, mc.player);

            }
            slot++;
        }
    }

    @Override
    public Boolean notInInv ( Item itemOfChoice ) {
        int n;
        n = 0;
        if (itemOfChoice == mc.player.getHeldItemOffhand().getItem()) return true;

        for (int i = 35; i >= 0; i--) {
            Item item = mc.player.inventory.getStackInSlot(i).getItem();
            if (item == itemOfChoice) {
                return true;

            } else {
                n++;
            }
        }
        return n < 35;
    }

    @Override
    public void update_always () {

    }

    //@Override
	//protected void disable() {
     //if(allowTakeOff.get_value(true)) {
		//	Ozark.get_module_manager().get_module_with_tag("AutoArmour").set_active(true);
	//	}
//	}

 //   @Override
   // public void update_always () {
     //   bind.set_shown(hold.get_value(true));
       // rotate_back.set_shown(rotate.get_value(true));
    }
