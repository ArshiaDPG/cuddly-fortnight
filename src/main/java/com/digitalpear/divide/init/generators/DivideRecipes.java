package com.digitalpear.divide.init.generators;

import com.digitalpear.divide.Divide;
import com.digitalpear.divide.init.DivideBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.recipe.api.RecipeManagerHelper;
import org.quiltmc.qsl.recipe.api.builder.VanillaRecipeBuilders;

public class DivideRecipes {

	public static void init(){
		brickRecipe(DivideBlocks.WETRACK.asItem(), DivideBlocks.WETRACK_BRICKS.asItem());
		smeltOre(DivideBlocks.WETRACK_IRON_ORE.asItem(), Items.IRON_INGOT, 0.7f, 200, "iron_ingot");
		smeltOre(DivideBlocks.WETRACK_LAPIS_ORE.asItem(), Items.LAPIS_LAZULI, 0.2f, 200, "lapis_lazuli");
		pressurePlateRecipe(DivideBlocks.WETRACK.asItem(), DivideBlocks.WETRACK_PRESSURE_PLATE.asItem());


		RecipeManagerHelper.registerStaticRecipe(
				VanillaRecipeBuilders.shapelessRecipe(new ItemStack(DivideBlocks.WETRACK_BUTTON))
						.ingredient(new ItemStack(DivideBlocks.WETRACK))
						.build(new Identifier(Divide.MOD_ID, "wetrack_button"), "")
		);
	}

	public static void brickRecipe(Item input, Item output){
		ItemStack bracc = new ItemStack(output);
		bracc.setCount(4);
		RecipeManagerHelper.registerStaticRecipe(
				VanillaRecipeBuilders.shapedRecipe("AA", "AA")
						.output(bracc)
						.ingredient('A', input)
						.build(new Identifier(Divide.MOD_ID, output.getTranslationKey().split("\\.")[2]), "")
		);
	}
	public static void pressurePlateRecipe(Item input, Item output){
		ItemStack butt = new ItemStack(output);
		RecipeManagerHelper.registerStaticRecipe(
				VanillaRecipeBuilders.shapedRecipe("AA")
						.output(butt)
						.ingredient('A', input)
						.build(new Identifier(Divide.MOD_ID, output.getTranslationKey().split("\\.")[2]), "")
		);
	}

	public static void smeltOre(Item input, Item output, float xp, int time, String group){
		RecipeManagerHelper.registerStaticRecipe(VanillaRecipeBuilders.smeltingRecipe(
				new Identifier(Divide.MOD_ID, input.getTranslationKey().split("\\.")[2] + "_smelting"), group,
				Ingredient.ofItems(input), new ItemStack(output), xp, time));

		RecipeManagerHelper.registerStaticRecipe(VanillaRecipeBuilders.blastingRecipe(
				new Identifier(Divide.MOD_ID, input.getTranslationKey().split("\\.")[2] + "_blasting"), group,
				Ingredient.ofItems(input), new ItemStack(output), xp, time/2));
	}
	public static void smeltOre(Item input, Item output, float xp, int time){
		RecipeManagerHelper.registerStaticRecipe(VanillaRecipeBuilders.smeltingRecipe(
				new Identifier(Divide.MOD_ID, input.getTranslationKey().split("\\.")[2] + "_smelting"), "",
				Ingredient.ofItems(input), new ItemStack(output), xp, time));

		RecipeManagerHelper.registerStaticRecipe(VanillaRecipeBuilders.blastingRecipe(
				new Identifier(Divide.MOD_ID, input.getTranslationKey().split("\\.")[2] + "_blasting"), "",
				Ingredient.ofItems(input), new ItemStack(output), xp, time/2));
	}
}
