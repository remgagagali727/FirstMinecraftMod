package net.remgagagali727.remmod.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.block.ModBlocks;
import net.remgagagali727.remmod.recipe.CookingTableRecipe;
import org.jetbrains.annotations.Nullable;

public class CookingTableCategory implements IRecipeCategory<CookingTableRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(ExampleMod.MOD_ID, "cooking_table");
    public static final ResourceLocation TEXTURE = new ResourceLocation(ExampleMod.MOD_ID, "" +
            "textures/gui/cooking_table.png");

    public static final RecipeType<CookingTableRecipe> COOKING_TABLE_TYPE =
            new RecipeType<>(UID, CookingTableRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public CookingTableCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.COOKING_TABLE.get()));
    }

    @Override
    public RecipeType<CookingTableRecipe> getRecipeType() {
        return COOKING_TABLE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.tutorialmod.cooking_table");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, CookingTableRecipe cookingTableRecipe, IFocusGroup iFocusGroup) {
        int maxIngredients = cookingTableRecipe.getIngredients().size();
        for(int i = 0;i < 20 && i < maxIngredients;i++) {
            iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 10 + 18 * (i / 4), 7 + 18 * (i % 4))
                    .addIngredients(cookingTableRecipe.getIngredients().get(i));
        }
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 144, 35).addItemStack(cookingTableRecipe.getResultItem(null));
    }
}
