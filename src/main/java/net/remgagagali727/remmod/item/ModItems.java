package net.remgagagali727.remmod.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.block.ModBlocks;
import net.remgagagali727.remmod.item.custom.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    //Semillas
    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_CROP.get(), new Properties()));

    public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register("corn_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CORN_CROP.get(), new Properties()));

    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz",
            () -> new Item(new Properties()));

    public static final RegistryObject<Item> URANIUM = ITEMS.register("uranium",
            () -> new UraniumItem(new Properties().food(ModFoods.URANIUM), 4000));

    //Ingredientes de comidas
    public static final RegistryObject<Item> BUTTER = ITEMS.register("butter",
            () -> new Item(new Properties()));

    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Properties()));

    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour",
            () -> new Item(new Properties()));

    public static final RegistryObject<Item> CASTER_SUGAR = ITEMS.register("caster_sugar",
            () -> new Item(new Properties()));

    //Comidas
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Properties().food(ModFoods.STRAWBERRY)));

    public static final RegistryObject<Item> CHOCOLATE_MILK_CUP = ITEMS.register("chocolate_milk_cup",
            () -> new Item(new Properties().food(ModFoods.CHOCOLATE_MILK_CUP)
                    .stacksTo(16)));

    public static final RegistryObject<Item> CHOCOLATE = ITEMS.register("chocolate",
            () -> new ChocolateItem(new Properties().food(ModFoods.CHOCOLATE)));

    public static final RegistryObject<Item> CORN = ITEMS.register("corn",
            () -> new Item(new Properties().food(ModFoods.CORN)));

    public static final RegistryObject<Item> RAW_PORK_LEG = ITEMS.register("raw_pork_leg",
            () -> new Item(new Properties().food(ModFoods.RAW_PORK_LEG)));

    public static final RegistryObject<Item> COOKED_PORK_LEG = ITEMS.register("cooked_pork_leg",
            () -> new Item(new Properties().food(ModFoods.COOKED_PORK_LEG)));

    public static final RegistryObject<Item> RAW_BEEF_BRISKET = ITEMS.register("raw_beef_brisket",
            () -> new Item(new Properties().food(ModFoods.RAW_BEEF_BRISKET)));

    public static final RegistryObject<Item> COOKED_BEEF_BRISKET = ITEMS.register("cooked_beef_brisket",
            () -> new Item(new Properties().food(ModFoods.COOKED_BEEF_BRISKET)));

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

    //Herramientas
    public static final RegistryObject<Item> CUP = ITEMS.register("cup",
            () -> new CupItem(new Properties()
                    .stacksTo(16)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}