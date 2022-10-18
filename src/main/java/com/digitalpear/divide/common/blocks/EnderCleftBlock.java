package com.digitalpear.divide.common.blocks;

import com.digitalpear.divide.Divide;
import com.digitalpear.divide.common.worldgen.DivideDimensions;
import com.digitalpear.divide.init.DivideBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class EnderCleftBlock extends Block {
	protected static final VoxelShape SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D));

	public EnderCleftBlock(Settings settings) {
		super(settings);
	}

//	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//
//		//Crashes the game right now
//		if (world instanceof ServerWorld) {
//			MinecraftServer minecraftServer = world.getServer();
//			RegistryKey<World> registryKey = world.getRegistryKey() == DivideDimensions.DIVIDE_KEY ? World.OVERWORLD : DivideDimensions.DIVIDE_KEY;
//			ServerWorld serverWorld2 = minecraftServer.getWorld(registryKey);
//			if (serverWorld2 != null && minecraftServer.isNetherAllowed() && !player.hasVehicle()) {
//				player.resetNetherPortalCooldown();
//				player.moveToWorld(serverWorld2);
//				player.world.getProfiler().pop();
//			}
//		}
//
//		Divide.LOGGER.info("Destination is not null.");
//		return ActionResult.SUCCESS;
//	}

	@Override
	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		if (!world.getBlockState(pos.up()).isOf(Blocks.AIR) && !world.getBlockState(pos.up(2)).isOf(Blocks.AIR)) {
			world.setBlockState(pos.up(), DivideBlocks.DIVIDE_PORTAL.getDefaultState(), 2);
			world.setBlockState(pos.up(2), DivideBlocks.DIVIDE_PORTAL.getDefaultState(), 2);
		}
	}

	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}
}
