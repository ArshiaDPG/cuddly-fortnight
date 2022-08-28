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


	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (player.getMainHandStack().isOf(Items.BUCKET) && DivideData.UNWETTING_MAP.containsKey(state.getBlock())){
			unwetBlock(state, world, pos, player, hand);
			return ActionResult.SUCCESS;
		}
		return ActionResult.FAIL;
	}

	public static void unwetBlock(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand){
		player.swingHand(hand);
		if (!player.isCreative()){
			player.getMainHandStack().decrement(1);
		}
		player.giveItemStack(Items.WATER_BUCKET.getDefaultStack());
		world.playSound(player, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, (1.0F + world.getRandom().nextFloat() * 0.2F) * 0.7F);
		world.setBlockState(pos, DivideData.UNWETTING_MAP.get(state.getBlock()).getStateWithProperties(state));
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
