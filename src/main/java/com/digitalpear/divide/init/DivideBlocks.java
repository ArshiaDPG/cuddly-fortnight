package com.digitalpear.divide.init;

import com.digitalpear.divide.Divide;
import com.digitalpear.divide.common.blocks.WetrackBlock;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

public class DivideBlocks {

	public static AbstractBlock.Settings createWetrackBlock(){
		return AbstractBlock.Settings.of(Material.STONE, MapColor.DARK_AQUA).strength(2.0f, 12.0f).requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK);
	}

	public static LeavesBlock createLeavesBlock(BlockSoundGroup soundGroup) {
		return new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2f).ticksRandomly().sounds(soundGroup).nonOpaque().allowsSpawning(DivideBlocks::canSpawnOnLeaves).suffocates(DivideBlocks::never).blockVision(DivideBlocks::never));
	}

	private static boolean never(BlockState state, net.minecraft.world.BlockView blockView, BlockPos blockPos) {
		return false;
	}

	private static boolean canSpawnOnLeaves(BlockState state, net.minecraft.world.BlockView blockView, BlockPos blockPos, EntityType<?> entityType) {
		return entityType == EntityType.OCELOT || entityType == EntityType.PARROT;
	}

	public static AbstractBlock.Settings createLogBlock(MapColor topMapColor, MapColor sideMapColor) {
		return AbstractBlock.Settings.of(Material.WOOD, state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor).strength(2.0f).sounds(BlockSoundGroup.WOOD);
	}

	public static BlockItem createBlockItem(String blockID, Block block, ItemGroup group){
		return Registry.register(Registry.ITEM, new Identifier(Divide.MOD_ID, blockID), new BlockItem(block, new Item.Settings().group(group)));
	}

	public static Block createBlockWithItem(String blockID, Block block, ItemGroup group){
		createBlockItem(blockID, block, group);
		return Registry.register(Registry.BLOCK, new Identifier(Divide.MOD_ID, blockID), block);
	}

	public static Block createBlockWithoutItem(String blockID, Block block){
		return Registry.register(Registry.BLOCK, new Identifier(Divide.MOD_ID, blockID), block);
	}


	public static final Block WETRACK = createBlockWithItem("wetrack", new WetrackBlock(createWetrackBlock()), ItemGroup.BUILDING_BLOCKS);
	public static final Block WETRACK_BRICKS = createBlockWithItem("wetrack_bricks", new WetrackBlock(createWetrackBlock()), ItemGroup.BUILDING_BLOCKS);

	//Muddy Wetrack?


	public static void init(){
		DivideData.registerUnwetting(WETRACK, Blocks.COBBLED_DEEPSLATE);
		DivideData.registerUnwetting(WETRACK_BRICKS, Blocks.DEEPSLATE_BRICKS);
	}

}
