package net.remgagagali727.remmod.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.recipe.CookingTableRecipe;
import net.remgagagali727.remmod.screen.CookingTableScreen;

import java.util.List;

@JeiPlugin
public class JEITutorialModPlugin implements IModPlugin{
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ExampleMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CookingTableCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<CookingTableRecipe> cookingTableRecipes = recipeManager.getAllRecipesFor(CookingTableRecipe.Type.INSTANCE);
        registration.addRecipes(CookingTableCategory.COOKING_TABLE_TYPE, cookingTableRecipes);

    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(CookingTableScreen.class, 105, 36, 28, 12,
                CookingTableCategory.COOKING_TABLE_TYPE);
    }
}
