package net.remgagagali727.remmod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties URANIUM = new FoodProperties.Builder()
            .alwaysEat()
            .fast()
            .saturationMod(0.2f)
            .nutrition(6)
            .build();
}
