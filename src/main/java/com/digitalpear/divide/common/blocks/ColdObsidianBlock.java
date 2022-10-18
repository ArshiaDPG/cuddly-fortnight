package com.digitalpear.divide.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ColdObsidianBlock extends Block {
	public ColdObsidianBlock(Settings settings) {
		super(settings);
	}

	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		if (world.getDimension().ultraWarm()) {
			world.setBlockState(pos, Blocks.CRYING_OBSIDIAN.getDefaultState(), 3);
			world.syncWorldEvent(2009, pos, 0);
			world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, (1.0F + world.getRandom().nextFloat() * 0.2F) * 0.7F);
		}
	}
}
