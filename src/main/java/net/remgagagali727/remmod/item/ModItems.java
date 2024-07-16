package net.remgagagali727.remmod.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.item.custom.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz",
            () -> new Item(new Properties()));

    public static final RegistryObject<Item> URANIUM = ITEMS.register("uranium",
            () -> new UraniumItem(new Properties().food(ModFoods.URANIUM), 4000));

    public static final RegistryObject<Item> RAW_PORK_LEG = ITEMS.register("raw_pork_leg",
            () -> new Item(new Properties().food(ModFoods.RAW_PORK_LEG)));

    public static final RegistryObject<Item> COOKED_PORK_LEG = ITEMS.register("cooked_pork_leg",
            () -> new Item(new Properties().food(ModFoods.COOKED_PORK_LEG)));

    public static final RegistryObject<Item> PURIFIED_URANIUM = ITEMS.register("purified_uranium",
            () -> new FuelItem(new Properties(), 6000));

    public static final RegistryObject<Item> PINK_QUARTZ = ITEMS.register("pink_quartz",
            () -> new Item(new Properties()));

    public static final RegistryObject<Item> RAW_PINK_QUARTZ = ITEMS.register("raw_pink_quartz",
            () -> new Item(new Properties()));

    public static final RegistryObject<Item> PINK_QUARTZ_KNIFE = ITEMS.register("pink_quartz_knife",
            () -> new PinkQuartzKnifeItem(new Item.Properties()
                    .durability(128)));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties()
                    .stacksTo(1)
                    .durability(50)));

    public static final RegistryObject<Item> URANIUM_SCYTHE = ITEMS.register("uranium_scythe",
            () -> new UraniumScytheItem(5 - 5, 1.9f - 4f, new Item.Properties()
                    .stacksTo(1)));

    public static final RegistryObject<Item> PINK_QUARTZ_HELMET = ITEMS.register("pink_quartz_helmet",
            () -> new ModArmorItem(ModArmorMaterials.PINK_QUARTZ, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> PINK_QUARTZ_CHESTPLATE = ITEMS.register("pink_quartz_chestplate",
            () -> new ArmorItem(ModArmorMaterials.PINK_QUARTZ, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> PINK_QUARTZ_BOOTS = ITEMS.register("pink_quartz_boots",
            () -> new ArmorItem(ModArmorMaterials.PINK_QUARTZ, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> PINK_QUARTZ_LEGGINGS = ITEMS.register("pink_quartz_leggings",
            () -> new ArmorItem(ModArmorMaterials.PINK_QUARTZ, ArmorItem.Type.LEGGINGS, new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}