package me.cumhax.chipshack.module.combat;

import com.mojang.realmsclient.gui.ChatFormatting;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.util.PlayerUtil;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockObsidian;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class InstantBurrow extends Module 
{
    private PlayerUtil BurrowUtil;

    public InstantBurrow() {
        super("InstantBurrow", "", Category.COMBAT);
    }
	
	private BlockPos originalPos;
    private int oldSlot = -1;
	
    
    public void onEnable() 
    {
    	originalPos = new BlockPos(mc.player.posX, mc.player.posY, mc.player.posZ);
    	if (mc.world.getBlockState(new BlockPos(mc.player.posX, mc.player.posY, mc.player.posZ)).getBlock().equals(Blocks.OBSIDIAN) || intersectsWithEntity(this.originalPos))
    	{
            disable();
            return;
        }
        oldSlot = mc.player.inventory.currentItem;
    }
    
    @SubscribeEvent
    public void onUpdate(final TickEvent.ClientTickEvent event) 
    {
    	if(nullCheck()) return;
    	if (BurrowUtil.findHotbarBlock() == -1 && BurrowUtil.findHotbarBlock(BlockEnderChest.class) == -1)
    	{
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString(ChatFormatting.DARK_GRAY + "[ChipsHack] " + ChatFormatting.WHITE + "<Burrow> " + ChatFormatting.GOLD +  "Can't find obsidian or echest in hotbar!"));
            disable();
            return;
        }
    	if(BurrowUtil.findHotbarBlock(BlockEnderChest.class) > 1) 
    	{
    		BurrowUtil.switchToSlot(BurrowUtil.findHotbarBlock(BlockEnderChest.class));
    	}
    	else 
    	{
    		BurrowUtil.switchToSlot(BurrowUtil.findHotbarBlock());
    	}
        mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.41999998688698D, mc.player.posZ, true));
        mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.7531999805211997D, mc.player.posZ, true));
        mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.00133597911214D, mc.player.posZ, true));
        mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.16610926093821D, mc.player.posZ, true));
        BurrowUtil.placeBlock(originalPos, EnumHand.MAIN_HAND, true, true, false);
        mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 7.0F, mc.player.posZ, false));
        BurrowUtil.switchToSlot(oldSlot);
        mc.player.connection.sendPacket(new CPacketEntityAction(mc.player, CPacketEntityAction.Action.START_SNEAKING));
        mc.player.connection.sendPacket(new CPacketEntityAction(mc.player, CPacketEntityAction.Action.STOP_SNEAKING));
        disable();
    }
    
    private boolean intersectsWithEntity(final BlockPos pos) 
    {
        for (final Entity entity : mc.world.loadedEntityList) 
        {
            if (entity.equals(mc.player)) continue;
            if (entity instanceof EntityItem) continue;
            if (new AxisAlignedBB(pos).intersects(entity.getEntityBoundingBox())) return true;
        }
        return false;
    }
    
}