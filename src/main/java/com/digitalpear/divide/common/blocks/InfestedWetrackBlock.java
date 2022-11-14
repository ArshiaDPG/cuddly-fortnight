package com.digitalpear.divide.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.EndermiteEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;

public class InfestedWetrackBlock extends Block {
	private final Block regularBlock;

	public InfestedWetrackBlock(Block block, Settings settings) {
		super(settings.hardness(block.getHardness() / 2.0F).resistance(0.75F));
		this.regularBlock = block;
	}

	public Block getRegularBlock() {
		return this.regularBlock;
	}

	private void spawnEndermite(ServerWorld world, BlockPos pos) {
		EndermiteEntity silverfishEntity = EntityType.ENDERMITE.create(world);
		silverfishEntity.refreshPositionAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
		world.spawnEntity(silverfishEntity);
		silverfishEntity.playSpawnEffects();
	}

	public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack, boolean dropExperience) {
		super.onStacksDropped(state, world, pos, stack, dropExperience);
		if (world.getGameRules().getBoolean(GameRules.DO_TILE_DROPS) && EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
			this.spawnEndermite(world, pos);
		}

	}

	private static BlockState copyProperties(Map<BlockState, BlockState> stateMap, BlockState fromState, Supplier<BlockState> toStateSupplier) {
		return (BlockState)stateMap.computeIfAbsent(fromState, (infestedState) -> {
			BlockState blockState = (BlockState)toStateSupplier.get();

			Property property;
			for(Iterator var3 = infestedState.getProperties().iterator(); var3.hasNext(); blockState = blockState.contains(property) ? (BlockState)blockState.with(property, infestedState.get(property)) : blockState) {
				property = (Property)var3.next();
			}

			return blockState;
		});
	}
}
