package net.remgagagali727.remmod.util;

import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.remgagagali727.remmod.ExampleMod;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");

        public static final TagKey<Block> NEEDS_URANIUM_TOOL = tag("needs_uranium_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ExampleMod.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> CAN_CRAFT_LEMON_PLANKS = tag("can_craft_lemon_planks");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ExampleMod.MOD_ID, name));
        }
    }

}
