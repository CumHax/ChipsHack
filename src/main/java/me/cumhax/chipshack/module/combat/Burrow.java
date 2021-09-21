package me.cumhax.chipshack.module.combat;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.setting.Setting;
import me.cumhax.chipshack.util.LoggerUtil;
import me.cumhax.chipshack.util.BlockInteractionHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;
import org.jline.utils.Log;

import java.util.logging.Logger;


public class Burrow extends Module {


    Setting rotate = new Setting ("Head Rotate", this, false);
    Setting silent = new Setting ("Silent Switch", this, true);
    Setting enderchest = new Setting ( "EnderChest", this, true);
    Setting height = new Setting ("Fake Jump Height", this, 2, -30, 30);
    private float oldTickLength;

    public Burrow() {
        super("Burrow", "", Category.COMBAT);
    }

    //  float oldTickLength = mc.timer.tickLength;

    @Override
    public void enable() {
        if (mc.player == null || mc.world == null) return;

        final int oldSlot = mc.player.inventory.currentItem;
       // float oldTickLength=mc.timer.tickLength;
        BlockPos originalPos = new BlockPos(mc.player.posX, mc.player.posY, mc.player.posZ);

        if (mc.world.getBlockState(new BlockPos(mc.player.posX, mc.player.posY, mc.player.posZ)).getBlock().equals(Blocks.OBSIDIAN) || mc.world.getBlockState(new BlockPos(mc.player.posX, mc.player.posY, mc.player.posZ)).getBlock().equals(Blocks.ENDER_CHEST)) {
            LoggerUtil.sendMessage ("Bro ur already gay enough in burrow already.");
            set_disable();
            return;
        } else if (BlockInteractionHelper.isInterceptedByOther(originalPos)) {
            LoggerUtil.sendMessage ("Ur intercepting with another creature :0 (Sussy).");
            set_disable();
            return;
        } else if (getHotbarSlot(Blocks.OBSIDIAN) == -1 && getHotbarSlot(Blocks.ENDER_CHEST) == -1) {
            LoggerUtil.sendMessage ("U need echest or obsidian bro monke.");
            set_disable();
            return;
        } else if (!mc.world.getBlockState(originalPos.add(0, 1, 0)).getBlock().equals(Blocks.AIR) || !mc.world.getBlockState(originalPos.add(0, 2, 0)).getBlock().equals(Blocks.AIR) || !mc.world.getBlockState(originalPos.add(0, 3, 0)).getBlock().equals(Blocks.AIR)) {
            LoggerUtil.sendMessage ("Tight af all up in these boys need some space!");
            this.set_disable();
            return;
        } else if (mc.isSingleplayer()) {
            LoggerUtil.sendMessage ("Why tf are u trying this in singleplayer? Ur prob listed.");
            set_disable();
            return;
        }

     //   if (silent.get_value(true)) mc.timer.tickLength = 1f;

        mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.41999998688698D, mc.player.posZ, true));
        mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.7531999805211997D, mc.player.posZ, true));
        mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.00133597911214D, mc.player.posZ, true));
        mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.16610926093821D, mc.player.posZ, true));
        mc.player.setPosition(mc.player.posX, mc.player.posY + 1.16610926093821D, mc.player.posZ);

        if (enderchest.get_value(true) && getHotbarSlot(Blocks.ENDER_CHEST) != -1) {
            mc.player.inventory.currentItem = getHotbarSlot(Blocks.ENDER_CHEST);
        } else if (getHotbarSlot(Blocks.OBSIDIAN) != -1) {
            mc.player.inventory.currentItem = getHotbarSlot(Blocks.OBSIDIAN);
        } else {
            mc.player.inventory.currentItem = getHotbarSlot(Blocks.ENDER_CHEST);
        }

        BlockInteractionHelper.placeBlock(originalPos, rotate.get_value(true), true, false, true, false);
        mc.player.inventory.currentItem = oldSlot;
        mc.player.setPosition(mc.player.posX, mc.player.posY - 1.16610926093821D, mc.player.posZ);

        mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + height.get_value(1), mc.player.posZ, true));

     //   mc.timer.tickLength = oldTickLength;
        set_disable();


    }

    private void set_disable () {

    }


    public static int getHotbarSlot(final Block block) {
        for (int i = 0; i < 9; i++) {
            final Item item = mc.player.inventory.getStackInSlot(i).getItem();
            if (item instanceof ItemBlock && ((ItemBlock) item).getBlock().equals(block)) return i;
        }
        return -1;
    }

}
