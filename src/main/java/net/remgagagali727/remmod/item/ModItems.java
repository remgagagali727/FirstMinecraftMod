package net.remgagagali727.remmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.ExampleMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz",
            () -> new Item(new Properties()));

    public static final RegistryObject<Item> PINK_QUARTZ = ITEMS.register("pink_quartz",
            () -> new Item(new Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}