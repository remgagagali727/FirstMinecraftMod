package net.remgagagali727.remmod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import net.remgagagali727.remmod.util.ModTags;

public class ModFoods {

    public static final FoodProperties CHOCOLATE_MILK_CUP = new FoodProperties.Builder()
            .saturationMod(0.1f)
            .nutrition(7)
            .build();

    public static final FoodProperties URANIUM = new FoodProperties.Builder()
            .alwaysEat()
            .fast()
            .saturationMod(0.2f)
            .nutrition(6)
            .build();

    public static final FoodProperties RAW_PORK_LEG = new FoodProperties.Builder()
            .saturationMod(0.3f)
            .meat()
            .nutrition(4)
            .build();

    public static final FoodProperties COOKED_PORK_LEG = new FoodProperties.Builder()
            .saturationMod(0.5f)
            .meat()
            .nutrition(7)
            .build();

    public static final FoodProperties RAW_BEEF_BRISKET = new FoodProperties.Builder()
            .saturationMod(0.3f)
            .meat()
            .nutrition(5)
            .build();

    public static final FoodProperties COOKED_BEEF_BRISKET = new FoodProperties.Builder()
            .saturationMod(0.5f)
            .meat()
            .nutrition(8)
            .build();

    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
            .saturationMod(0.2f)
            .nutrition(3)
            .build();

    public static final FoodProperties CORN = new FoodProperties.Builder()
            .saturationMod(0.15f)
            .nutrition(2)
            .build();

    public static final FoodProperties CHOCOLATE = new FoodProperties.Builder()
            .saturationMod(0.3f)
            .nutrition(5)
            .build();
}
