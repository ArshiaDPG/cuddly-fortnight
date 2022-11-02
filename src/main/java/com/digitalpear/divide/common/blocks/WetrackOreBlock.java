package com.digitalpear.divide.common.blocks;

import com.digitalpear.divide.init.DivideData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WetrackOreBlock extends ExperienceDroppingBlock {

	private final IntProvider experienceProvider;
	public WetrackOreBlock(Settings settings, IntProvider intProvider) {
		super(settings);
		this.experienceProvider = intProvider;
	}
	public WetrackOreBlock(Settings settings) {
		this(settings, ConstantIntProvider.create(0));
	}


	public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack, boolean dropExperience) {
		super.onStacksDropped(state, world, pos, stack, dropExperience);
		if (dropExperience) {
			this.dropConditionalExperience(world, pos, stack, this.experienceProvider);
		}

	}
}
