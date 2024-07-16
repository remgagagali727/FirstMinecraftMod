package net.remgagagali727.remmod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
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
}
