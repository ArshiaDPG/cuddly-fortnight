package com.digitalpear.divide.init;

import com.digitalpear.divide.Divide;
import com.digitalpear.divide.common.blocks.*;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class DivideBlocks {
	public static MapColor WETRACK_COLOR = MapColor.PALE_PURPLE;

	public static MapColor AMALGAE_COLOR = MapColor.PALE_YELLOW;

	public static AbstractBlock.Settings createWetrackBlock(){
		return AbstractBlock.Settings.of(Material.STONE, WETRACK_COLOR).strength(Blocks.DEEPSLATE.getHardness() - 0.1f, Blocks.DEEPSLATE.getBlastResistance() + 12f).requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK);
	}
	public static AbstractBlock.Settings createWetrackBlock(Block base) {
		return AbstractBlock.Settings.of(Material.STONE, WETRACK_COLOR).strength(base.getHardness() - 0.1f, base.getBlastResistance() + 12f).requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK);
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


	public static final Block WETRACK = createBlockWithItem("wetrack", new Block(createWetrackBlock()), ItemGroup.BUILDING_BLOCKS);
	public static final Block WETRACK_BRICKS = createBlockWithItem("wetrack_bricks", new Block(createWetrackBlock()), ItemGroup.BUILDING_BLOCKS);



	public static final Block AMALGAE_BLOCK = createBlockWithItem("amalgae_block", new AmalgaeBlock(AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK).mapColor(AMALGAE_COLOR).sounds(BlockSoundGroup.CROP)), ItemGroup.BUILDING_BLOCKS);
	public static final Block AMALGAE_BUSH = createBlockWithItem("amalgae_bush", new AmalgaeBushBlock(AbstractBlock.Settings.copy(Blocks.GRASS).mapColor(AMALGAE_COLOR).sounds(BlockSoundGroup.CROP)), ItemGroup.DECORATIONS);
	public static final Block AMALGAE_ROOTS = createBlockWithItem("amalgae_roots", new AmalgaeRootsBlock(AbstractBlock.Settings.copy(Blocks.GLOW_LICHEN).mapColor(AMALGAE_COLOR)), ItemGroup.BUILDING_BLOCKS);


	public static final Block WETRACK_LAPIS_ORE = createBlockWithItem("wetrack_lapis_ore",
			new ExperienceDroppingBlock(createWetrackBlock(Blocks.DEEPSLATE_LAPIS_ORE),
					UniformIntProvider.create(2, 5)), ItemGroup.BUILDING_BLOCKS);
	public static final Block WETRACK_IRON_ORE = createBlockWithItem("wetrack_iron_ore",
			new ExperienceDroppingBlock(createWetrackBlock(Blocks.DEEPSLATE_IRON_ORE),
					UniformIntProvider.create(0, 3)), ItemGroup.BUILDING_BLOCKS);


	public static final Block WETRACK_BUTTON = createBlockWithItem("wetrack_button",
			new StoneButtonBlock(AbstractBlock.Settings.of(Material.STONE).noCollision().strength(1.0F).mapColor(WETRACK_COLOR).sounds(BlockSoundGroup.DRIPSTONE_BLOCK)), ItemGroup.REDSTONE);
	public static final Block WETRACK_PRESSURE_PLATE = createBlockWithItem("wetrack_pressure_plate",
			new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS,
					AbstractBlock.Settings.of(Material.STONE).requiresTool().noCollision().strength(1.0F).mapColor(WETRACK_COLOR).sounds(BlockSoundGroup.DRIPSTONE_BLOCK)), ItemGroup.REDSTONE);


	public static final Block ENDER_CLEFT = createBlockWithItem("ender_cleft", new EnderCleftBlock(AbstractBlock.Settings.of(Material.METAL, MapColor.CYAN)
			.strength(12f, 200f).sounds(BlockSoundGroup.COPPER).requiresTool().nonOpaque().luminance(state -> 9)), ItemGroup.DECORATIONS);


	public static final Block FREEZER = createBlockWithItem("freezer",
			new FreezerBlock(AbstractBlock.Settings.of(Material.METAL).strength(2.0f, 7.0f)
					.mapColor(MapColor.GRAY).sounds(BlockSoundGroup.METAL).requiresTool()), ItemGroup.DECORATIONS);


	public static final Block COLD_OBSIDIAN = createBlockWithItem("cold_obsidian", new ColdObsidianBlock(AbstractBlock.Settings.copy(Blocks.OBSIDIAN)
			.slipperiness(0.989F).mapColor(MapColor.LIGHT_BLUE)), ItemGroup.BUILDING_BLOCKS);





	public static void init(){

	}

}
