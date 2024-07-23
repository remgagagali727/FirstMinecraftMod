package net.remgagagali727.remmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.block.ModBlocks;
import net.remgagagali727.remmod.item.ModItems;
import net.remgagagali727.remmod.recipe.CookingTableRecipeBuilder;
import net.remgagagali727.remmod.util.ModTags;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> PINK_QUARTZ_SMELTABLES = List.of(ModItems.RAW_PINK_QUARTZ.get(),
            ModBlocks.PINK_QUARTZ_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        //Wood Basics
        woodBasics(pWriter, ModBlocks.LEMON_LOG, ModBlocks.STRIPPED_LEMON_LOG, ModBlocks.LEMON_WOOD, ModBlocks.STRIPPED_LEMON_WOOD,
                ModBlocks.LEMON_PLANKS);

        //COOKING AND SMELTING

        blasting(pWriter, PINK_QUARTZ_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_QUARTZ.get(), 0.3f, 100, "pink_quartz");
        smelting(pWriter, PINK_QUARTZ_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_QUARTZ.get(), 0.3f, 201, "pink_quartz");

        //Recetas de cocina (Smoker)

        simpleFoodCooking(pWriter, 201, ModItems.RAW_PORK_LEG, ModItems.COOKED_PORK_LEG, 0.35f);
        simpleFoodCooking(pWriter, 201, ModItems.RAW_BEEF_BRISKET, ModItems.COOKED_BEEF_BRISKET, 0.35f);


        //CLASSIC CRAFTING

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURIFIED_URANIUM.get())
                .pattern("PUP")
                .pattern("DED")
                .pattern("PUP")
                .define('E', Items.ENDER_EYE)
                .define('D', Items.DIAMOND)
                .define('P', ModItems.PINK_QUARTZ.get())
                .define('U', ModItems.URANIUM.get())
                .unlockedBy(getHasName(ModItems.URANIUM.get()), has(ModItems.URANIUM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.PINK_QUARTZ_KNIFE.get())
                .pattern(" P")
                .pattern("S ")
                .define('S', Items.STICK)
                .define('P', ModItems.PINK_QUARTZ.get())
                .unlockedBy(getHasName(ModItems.PINK_QUARTZ.get()), has(ModItems.PINK_QUARTZ.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINK_QUARTZ_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.PINK_QUARTZ.get())
                .unlockedBy(getHasName(ModItems.PINK_QUARTZ.get()), has(ModItems.PINK_QUARTZ.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PINK_QUARTZ.get(), 9)
                .requires(ModBlocks.PINK_QUARTZ_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.PINK_QUARTZ_BLOCK.get()), has(ModBlocks.PINK_QUARTZ_BLOCK.get()))
                .save(pWriter);

        //Recetas del Cooking _ Table

        createCookingTableRecipe(pWriter, new Item[]{
                ModItems.SALT.get(),
                Items.MILK_BUCKET
        }, ModItems.BUTTER.get(), "butter");

        createCookingTableRecipe(pWriter, new Item[]{
                Items.SUGAR
        }, ModItems.CASTER_SUGAR.get(), "caster_sugar");

        createCookingTableRecipe(pWriter, new Item[]{
                Items.COCOA_BEANS,
                Items.SUGAR
        }, ModItems.CHOCOLATE.get(), "chocolate");

        createCookingTableRecipe(pWriter, new Item[]{
                ModItems.CHOCOLATE.get(),
                Items.SUGAR,
                ModItems.CUP.get()
        }, ModItems.CHOCOLATE_MILK_CUP.get(), "chocolate_milk_cup");

        createCookingTableRecipe(pWriter, new Item[]{
                Items.WHEAT,
                Items.WATER_BUCKET
        }, ModItems.FLOUR.get(), "flour");



    }

    private void woodBasics(Consumer<FinishedRecipe> pWriter, RegistryObject<Block> log, RegistryObject<Block> sLog, RegistryObject<Block> wood, RegistryObject<Block> sWood, RegistryObject<Block> planks) {
        // Receta para convertir Logs en Planks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks.get(), 4)
                .requires(ModTags.Items.CAN_CRAFT_LEMON_PLANKS)
                .unlockedBy(getHasName(log.get()), has(log.get()))
                .unlockedBy(getHasName(sLog.get()), has(sLog.get()))
                .unlockedBy(getHasName(wood.get()), has(wood.get()))
                .unlockedBy(getHasName(sWood.get()), has(sWood.get()))
                .save(pWriter);

        // Receta para convertir Logs en Wood
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, wood.get(), 1)
                .requires(log.get())
                .unlockedBy(getHasName(log.get()), has(log.get()))
                .save(pWriter);

        // Receta para convertir Stripped Logs en Stripped Wood
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, sWood.get(), 1)
                .requires(sLog.get())
                .unlockedBy(getHasName(sLog.get()), has(sLog.get()))
                .save(pWriter);
    }


    private void simpleFoodCooking(Consumer<FinishedRecipe> pWriter, int pCookingTime, RegistryObject<Item> pIngredient, RegistryObject<Item> pResult, float pExperience) {
           simpleCookingRecipe(pWriter, "campfire", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, pCookingTime, pIngredient.get(), pResult.get(), pExperience);
           simpleCookingRecipe(pWriter, "smoking", RecipeSerializer.SMOKING_RECIPE, pCookingTime / 2, pIngredient.get(), pResult.get(), pExperience);
           simpleCookingRecipe(pWriter, "furnace", RecipeSerializer.SMELTING_RECIPE, pCookingTime, pIngredient.get(), pResult.get(), pExperience);
    }

    protected static void smelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void blasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}),
                    pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer,
                            ExampleMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    private void createCookingTableRecipe(Consumer<FinishedRecipe> consumer, Item[] ingredients, Item output, String recipeName) {
        ResourceLocation recipeId = new ResourceLocation("tutorialmod", recipeName + "_cooking_recipe");
        CookingTableRecipeBuilder.recipe(recipeId, ingredients, output)
                .save(consumer);
    }

}
