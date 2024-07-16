package net.remgagagali727.remmod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier URANIUM = TierSortingRegistry.registerTier(
            new ForgeTier(
                    5,
                    2500,
                    10f,
                    4f,
                    17,
                    ModTags.Blocks.NEEDS_URANIUM_TOOL,
                    () -> Ingredient.of(ModItems.URANIUM.get())),
            new ResourceLocation(ExampleMod.MOD_ID, "uranium"),
            List.of(Tiers.NETHERITE),
            List.of()
    );
}
