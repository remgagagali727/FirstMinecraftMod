package net.remgagagali727.remmod.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.remgagagali727.remmod.ExampleMod;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class CookingTableRecipeBuilder {
    private final ResourceLocation id;
    private final Ingredient[] ingredients;
    private final Item output;

    private CookingTableRecipeBuilder(ResourceLocation id, Ingredient[] ingredients, Item output) {
        this.id = id;
        this.ingredients = ingredients;
        this.output = output;
    }

    public static CookingTableRecipeBuilder recipe(ResourceLocation id, Item[] inputItems, Item output) {
        Ingredient[] ingredients = new Ingredient[inputItems.length];
        for (int i = 0; i < inputItems.length; i++) {
            ingredients[i] = Ingredient.of(inputItems[i]);
        }
        return new CookingTableRecipeBuilder(id, ingredients, output);
    }

    public void save(Consumer<FinishedRecipe> consumer) {
        consumer.accept(new Result(id, ingredients, output));
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Ingredient[] ingredients;
        private final ItemLike output;

        public Result(ResourceLocation id, Ingredient[] ingredients, Item output) {
            this.id = id;
            this.ingredients = ingredients;
            this.output = output;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonArray ingredientsArray = new JsonArray();
            for (Ingredient ingredient : ingredients) {
                ingredientsArray.add(ingredient.toJson());
            }
            json.add("ingredients", ingredientsArray);

            JsonObject outputObject = new JsonObject();
            outputObject.addProperty("item", ExampleMod.MOD_ID + ":" + output);
            json.add("output", outputObject);
        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return CookingTableRecipe.Serializer.INSTANCE;
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
