package com.digitalpear.divide.init;

import com.digitalpear.divide.Divide;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.recipe.api.RecipeManagerHelper;
import org.quiltmc.qsl.recipe.api.builder.VanillaRecipeBuilders;

public class DivideRecipes {

	public static void init(){
		brickRecipe(DivideBlocks.WETRACK.asItem(), DivideBlocks.WETRACK_BRICKS.asItem());

		RecipeManagerHelper.registerStaticRecipe(
				VanillaRecipeBuilders.shapelessRecipe(new ItemStack(DivideBlocks.AMALGAE_WETRACK_BRICKS))
						.ingredient(new ItemStack(DivideBlocks.WETRACK_BRICKS))
						.ingredient(new ItemStack(DivideBlocks.AMALGAE_BLOCK))
						.build(new Identifier(Divide.MOD_ID, "amalgae_wetrack_bricks"), "")
		);
	}

	public static void brickRecipe(Item input, Item output){
		ItemStack bracc = new ItemStack(output);
		bracc.setCount(4);
		RecipeManagerHelper.registerStaticRecipe(
				VanillaRecipeBuilders.shapedRecipe("AA", "AA")
						.output(bracc)
						.ingredient('A', input)
						.build(new Identifier(Divide.MOD_ID, input.getTranslationKey().split("\\.")[2]), "")
		);
	}
}
