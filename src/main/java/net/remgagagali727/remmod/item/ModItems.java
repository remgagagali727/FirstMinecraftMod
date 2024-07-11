package net.remgagagali727.remmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.item.custom.MetalDetectorItem;
import net.remgagagali727.remmod.item.custom.PinkQuartzKnifeItem;
import net.remgagagali727.remmod.item.custom.UraniumItem;
import net.remgagagali727.remmod.item.custom.UraniumScytheItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz",
            () -> new Item(new Properties()));

    public static final RegistryObject<Item> URANIUM = ITEMS.register("uranium",
            () -> new UraniumItem(new Properties().food(ModFoods.URANIUM), 2000));

    public static final RegistryObject<Item> PINK_QUARTZ = ITEMS.register("pink_quartz",
            () -> new Item(new Properties()));

    public static final RegistryObject<Item> RAW_PINK_QUARTZ = ITEMS.register("raw_pink_quartz",
            () -> new Item(new Properties()));

    public static final RegistryObject<Item> PINK_QUARTZ_KNIFE = ITEMS.register("pink_quartz_knife",
            () -> new PinkQuartzKnifeItem(new Item.Properties()
                    .durability(128)));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties()
                    .durability(50)));

    public static final RegistryObject<Item> URANIUM_SCYTHE = ITEMS.register("uranium_scythe",
            () -> new UraniumScytheItem(5, 1.9f, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}