package me.cumhax.chipshack.module.chat;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import com.mojang.realmsclient.gui.ChatFormatting;
import me.cumhax.chipshack.util.LoggerUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Module

public class BurrowAnnouncer extends Module {
	
    public BurrowAnnouncer() {
        super("BurrowAnnouncer", "", Category.CHAT);
    }

    List<Entity> knownPlayers = new ArrayList<>();
    List<Entity> burrowedPlayers = new ArrayList<>();

    public void update() {
            for (Entity entity : mc.world.loadedEntityList.stream().filter(e -> e instanceof EntityPlayer).collect(Collectors.toList())) {
                if (!(entity instanceof EntityPlayer)){
                    continue;
                }

                if (!burrowedPlayers.contains(entity) && isBurrowed(entity)) {
                    burrowedPlayers.add(entity);
                    LoggerUtil.sendMessage(ChatFormatting.DARK_PURPLE + "" + ChatFormatting.BOLD + "Burrow Announcer " + ChatFormatting.DARK_AQUA + " > " + ChatFormatting.RESET + entity.getName() + " burrowed!");
                }
                else if (burrowedPlayers.contains(entity) && !isBurrowed(entity)) {
                    burrowedPlayers.remove(entity);
                    LoggerUtil.sendMessage(ChatFormatting.DARK_PURPLE + "" + ChatFormatting.BOLD + "Burrow Announcer " + ChatFormatting.DARK_AQUA + " > " + ChatFormatting.RESET + entity.getName() + " unburrowed!");
            }}} 
    
    private boolean isBurrowed(Entity entity) {
        BlockPos entityPos = new BlockPos((entity.posX), entity.posY, (entity.posZ));

        if (mc.world.getBlockState(entityPos).getBlock() == Blocks.OBSIDIAN || mc.world.getBlockState(entityPos).getBlock() == Blocks.ENDER_CHEST || mc.world.getBlockState(entityPos).getBlock() == Blocks.SKULL) {
            return true;
        }

        return false;
    }
}