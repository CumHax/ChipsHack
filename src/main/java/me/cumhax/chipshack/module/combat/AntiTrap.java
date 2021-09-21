package me.cumhax.chipshack.module.combat;

import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.setting.Setting;
import me.cumhax.chipshack.util.PlaceUtil;
import me.cumhax.chipshack.util.RenderUtil;

import net.minecraft.block.Block;
import net.minecraft.block.BlockObsidian;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AntiTrap extends Module
{
	private final Setting disable = new Setting("Disable", this, true);
	private final Setting speed = new Setting("Speed", this, 1, 3, 30);
	private final Setting mode = new Setting("Mode", this, (Arrays.asList("Single", "Double")));
	private final ArrayList<BlockPos> renderBlocks = new ArrayList<>();
	private int ticksOn;


    public AntiTrap() 
	{
        super("AntiTrap", "", Category.COMBAT);
	}

	@Override
	public void onEnable()
	{
		ticksOn = 0;
	}

	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event)
	{
		if (mc.player == null || mc.world == null) return;

		List<BlockPos> blocks = mode.getEnumValue().equalsIgnoreCase("Single") ? new ArrayList<>(Arrays.asList(
				(new BlockPos(mc.player.getPositionVector())).add(2, 0, 0),
				(new BlockPos(mc.player.getPositionVector())).add(-2, 0, 0),
				(new BlockPos(mc.player.getPositionVector())).add(0, 0, 2),
				(new BlockPos(mc.player.getPositionVector())).add(0, 0, -2),
				(new BlockPos(mc.player.getPositionVector())).add(1, 0, 1),
				(new BlockPos(mc.player.getPositionVector())).add(-1, 0, 1),
				(new BlockPos(mc.player.getPositionVector())).add(1, 0, -1),
				(new BlockPos(mc.player.getPositionVector())).add(-1, 0, -1)
		)) : new ArrayList<>(Arrays.asList(
				(new BlockPos(mc.player.getPositionVector())).add(2, 0, 0),
				(new BlockPos(mc.player.getPositionVector())).add(-2, 0, 0),
				(new BlockPos(mc.player.getPositionVector())).add(0, 0, 2),
				(new BlockPos(mc.player.getPositionVector())).add(0, 0, -2),
				(new BlockPos(mc.player.getPositionVector())).add(1, 0, 1),
				(new BlockPos(mc.player.getPositionVector())).add(-1, 0, 1),
				(new BlockPos(mc.player.getPositionVector())).add(1, 0, -1),
				(new BlockPos(mc.player.getPositionVector())).add(-1, 0, -1),
				(new BlockPos(mc.player.getPositionVector())).add(2, 0, 0),
				(new BlockPos(mc.player.getPositionVector())).add(2, 0, 0),
				(new BlockPos(mc.player.getPositionVector())).add(2, 0, 0),
				(new BlockPos(mc.player.getPositionVector())).add(2, 0, 0)
		));

		renderBlocks.clear();

		for (Object bP : new ArrayList<>(blocks))
		{
			BlockPos block = (BlockPos) bP;

			blocks.add(0, block.down());
			if (mode.getEnumValue().equals("Double")) blocks.add(block.up());

			if (mc.world.getBlockState(block).getBlock().equals(Blocks.AIR)) renderBlocks.add(block);

		}


		int slot = getObsidianSlot();

		if (slot != -1)
		{

			if (disable.getBoolValue()) ticksOn++;

			int i = 0;

			int hand = mc.player.inventory.currentItem;

			for (BlockPos blockPos : blocks)
			{

				if (PlaceUtil.placeBlock(blockPos, slot, true, false))
				{
					i++;
				}

				int BPT = Math.round(speed.getIntValue() / 10f) + 1;

				if (i >= BPT)
				{
					break;
				}

			}

			mc.player.inventory.currentItem = hand;

			if (ticksOn > 23)
			{

				if (disable.getBoolValue()) disable();
				renderBlocks.clear();

			}

		}
		else
		{

			if (disable.getBoolValue()) disable();
			renderBlocks.clear();

		}

	}

	public int getObsidianSlot()
	{

		int slot = -1;

		for (int i = 0; i < 9; i++)
		{

			ItemStack stack = mc.player.inventory.getStackInSlot(i);

			if (stack == ItemStack.EMPTY || !(stack.getItem() instanceof ItemBlock))
			{
				continue;
			}

			Block block = ((ItemBlock) stack.getItem()).getBlock();

			if (block instanceof BlockObsidian)
			{

				slot = i;
				break;

			}

		}

		return slot;

	}


	@SubscribeEvent
	public void onWorldRender(RenderWorldLastEvent event)
	{
		if (mc.player == null || mc.world == null) return;

		for (BlockPos renderBlock : renderBlocks)
		{

			RenderUtil.drawBoxFromBlockpos(renderBlock, 0.50f, 0.00f, 0.00f, 0.30f);
        }
	}
}
