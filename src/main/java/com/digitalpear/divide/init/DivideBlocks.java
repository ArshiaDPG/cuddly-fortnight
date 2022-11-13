package com.digitalpear.divide.init;

import com.digitalpear.divide.Divide;
import com.digitalpear.divide.common.blocks.*;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

public class DivideBlocks {
	public static MapColor WETRACK_COLOR = MapColor.PALE_PURPLE;

	public static MapColor AMALGAE_COLOR = MapColor.LIGHT_BLUE;

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

	public static Block createLogBlock(MapColor topMapColor, MapColor sideMapColor) {
		return new PillarBlock(AbstractBlock.Settings.of(Material.WOOD, state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
				.strength(2.0f).sounds(BlockSoundGroup.BAMBOO));
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
	public static final Block WETRACK_STAIRS = createBlockWithItem("wetrack_stairs", new StairsBlock(WETRACK.getDefaultState(), createWetrackBlock()), ItemGroup.BUILDING_BLOCKS);
	public static final Block WETRACK_SLAB = createBlockWithItem("wetrack_slab", new SlabBlock(createWetrackBlock()), ItemGroup.BUILDING_BLOCKS);
	public static final Block WETRACK_WALL = createBlockWithItem("wetrack_wall", new WallBlock(createWetrackBlock()), ItemGroup.DECORATIONS);
	public static final Block WETRACK_BUTTON = createBlockWithItem("wetrack_button",
			new StoneButtonBlock(createWetrackBlock(Blocks.STONE_BUTTON).strength(Blocks.DEEPSLATE.getHardness() - 0.1f, Blocks.DEEPSLATE.getBlastResistance() + 12f)), ItemGroup.REDSTONE);
	public static final Block WETRACK_PRESSURE_PLATE = createBlockWithItem("wetrack_pressure_plate",
			new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS,
					createWetrackBlock(Blocks.STONE_PRESSURE_PLATE).strength(Blocks.DEEPSLATE.getHardness() - 0.1f, Blocks.DEEPSLATE.getBlastResistance() + 12f)), ItemGroup.REDSTONE);


	public static final Block WETRACK_BRICKS = createBlockWithItem("wetrack_bricks", new Block(createWetrackBlock()), ItemGroup.BUILDING_BLOCKS);
	public static final Block WETRACK_BRICK_STAIRS = createBlockWithItem("wetrack_brick_stairs", new StairsBlock(WETRACK_BRICKS.getDefaultState(),createWetrackBlock()), ItemGroup.BUILDING_BLOCKS);
	public static final Block WETRACK_BRICK_SLAB = createBlockWithItem("wetrack_brick_slab", new SlabBlock(createWetrackBlock()), ItemGroup.BUILDING_BLOCKS);
	public static final Block WETRACK_BRICK_WALL = createBlockWithItem("wetrack_brick_wall", new WallBlock(createWetrackBlock()), ItemGroup.DECORATIONS);



	public static final Block AMALGAE_BLOCK = createBlockWithItem("amalgae_block", new AmalgaeBlock(AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK).sounds(BlockSoundGroup.CROP).mapColor(AMALGAE_COLOR)), ItemGroup.BUILDING_BLOCKS);
	public static final Block AMALGAE_BUSH = createBlockWithItem("amalgae_bush", new AmalgaeBushBlock(AbstractBlock.Settings.copy(Blocks.GRASS).sounds(BlockSoundGroup.CROP).mapColor(AMALGAE_COLOR).luminance(state -> state.getFluidState().isIn(FluidTags.WATER) ? 3 : 6)), ItemGroup.DECORATIONS);
	public static final Block AMALGAE_ROOTS = createBlockWithItem("amalgae_roots", new AmalgaeRootsBlock(AbstractBlock.Settings.copy(Blocks.GLOW_LICHEN).sounds(BlockSoundGroup.CROP).luminance(state -> 0).mapColor(AMALGAE_COLOR)), ItemGroup.DECORATIONS);

	/*
		Amalgae mushroom
	 */
	public static final Block AMALGAE_MUSHROOM = createBlockWithItem("amalgae_mushroom",
			new MushroomPlantBlock(AbstractBlock.Settings.copy(Blocks.BROWN_MUSHROOM).mapColor(AMALGAE_COLOR),
					() -> DivideConfiguredFeatures.HUGE_AMALGAE_MUSHROOM), ItemGroup.DECORATIONS);
	public static final Block POTTED_AMALGAE_MUSHROOM = createBlockWithoutItem("potted_amalgae_mushroom", new FlowerPotBlock(AMALGAE_MUSHROOM, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque()));
	public static final Block AMALGAE_MUSHROOM_BLOCK = createBlockWithItem("amalgae_mushroom_block",
			new MushroomBlock(AbstractBlock.Settings.of(Material.WOOD, AMALGAE_COLOR).strength(0.2F).sounds(BlockSoundGroup.WOOD).luminance(state -> 10)), ItemGroup.DECORATIONS);

	/*
		Amalgae Woodset
	 */

//	public static final Block AMALGAE_STEM = createBlockWithItem("amalgae_stem", new AmalgaeStemBlock(AbstractBlock.Settings.copy(Blocks.BAMBOO).mapColor(AMALGAE_COLOR)), ItemGroup.BUILDING_BLOCKS);
//	public static final Block AMALGAE_LOG = createBlockWithItem("amalgae_log", createLogBlock(AMALGAE_COLOR, MapColor.CYAN), ItemGroup.BUILDING_BLOCKS);
//	public static final Block STRIPPED_AMALGAE_LOG = createBlockWithItem("stripped_amalgae_log", createLogBlock(AMALGAE_COLOR, MapColor.CYAN), ItemGroup.BUILDING_BLOCKS);
//	public static final Block AMALGAE_PLANKS = createBlockWithItem("amalgae_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(AMALGAE_COLOR)), ItemGroup.BUILDING_BLOCKS);
//	public static final Block AMALGAE_MOSAIC = createBlockWithItem("amalgae_mosaic", new Block(AbstractBlock.Settings.copy(AMALGAE_PLANKS)), ItemGroup.BUILDING_BLOCKS);
//	public static final Block AMALGAE_STAIRS = createBlockWithItem("amalgae_stairs", new StairsBlock(AMALGAE_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).mapColor(AMALGAE_COLOR)), ItemGroup.BUILDING_BLOCKS);
//	public static final Block AMALGAE_SLAB = createBlockWithItem("amalgae_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB).mapColor(AMALGAE_COLOR)), ItemGroup.BUILDING_BLOCKS);
//	public static final Block AMALGAE_FENCE = createBlockWithItem("amalgae_fence", new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE).mapColor(AMALGAE_COLOR)), ItemGroup.DECORATIONS);
//	public static final Block AMALGAE_FENCE_GATE = createBlockWithItem("amalgae_fence_gate", new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(AMALGAE_COLOR)), ItemGroup.REDSTONE);
//	public static final Block AMALGAE_BUTTON = createBlockWithItem("amalgae_button", new WoodenButtonBlock(AbstractBlock.Settings.copy(Blocks.OAK_BUTTON).mapColor(AMALGAE_COLOR)), ItemGroup.REDSTONE);
//	public static final Block AMALGAE_PRESSURE_PLATE = createBlockWithItem("amalgae_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(AMALGAE_COLOR)), ItemGroup.REDSTONE);
//	public static final Block AMALGAE_DOOR = createBlockWithItem("amalgae_door", new DoorBlock(AbstractBlock.Settings.copy(Blocks.OAK_DOOR).mapColor(AMALGAE_COLOR)), ItemGroup.REDSTONE);
//	public static final Block AMALGAE_TRAPDOOR = createBlockWithItem("amalgae_trapdoor", new TrapdoorBlock(AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR).mapColor(AMALGAE_COLOR)), ItemGroup.REDSTONE);




	public static final Block WETRACK_LAPIS_ORE = createBlockWithItem("wetrack_lapis_ore",
			new ExperienceDroppingBlock(createWetrackBlock(Blocks.DEEPSLATE_LAPIS_ORE),
					UniformIntProvider.create(2, 5)), ItemGroup.BUILDING_BLOCKS);
	public static final Block WETRACK_IRON_ORE = createBlockWithItem("wetrack_iron_ore",
			new ExperienceDroppingBlock(createWetrackBlock(Blocks.DEEPSLATE_IRON_ORE),
					UniformIntProvider.create(0, 3)), ItemGroup.BUILDING_BLOCKS);




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
