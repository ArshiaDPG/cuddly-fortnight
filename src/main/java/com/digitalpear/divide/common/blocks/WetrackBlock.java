package com.digitalpear.divide.common.blocks;

import com.digitalpear.divide.init.DivideData;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WetrackBlock extends Block {


	public WetrackBlock(Settings settings) {
		super(settings);
	}


	public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
		super.afterBreak(world, player, pos, state, blockEntity, stack);
		if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
			if (world.getDimension().ultraWarm()) {
				world.removeBlock(pos, false);
				return;
			}
			world.setBlockState(pos, Blocks.WATER.getDefaultState().with(Properties.LEVEL_1_8, 5));

		}
	}
}
