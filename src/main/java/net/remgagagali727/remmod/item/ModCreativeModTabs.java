package net.remgagagali727.remmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TRUE_MINERALS_TAB = CREATIVE_MOD_TABS
            .register("true_minerals_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.PINK_QUARTZ.get()))
                    .title(Component.translatable("creativetab.true_minerals_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_PINK_QUARTZ.get());
                        output.accept(ModItems.PINK_QUARTZ.get());
                        output.accept(ModBlocks.PINK_QUARTZ_ORE.get());
                        output.accept(ModBlocks.PINK_QUARTZ_BLOCK.get());
                        output.accept(ModItems.TOPAZ.get());
                        output.accept(ModBlocks.TOPAZ_BLOCK.get());
                        output.accept(ModItems.URANIUM.get());
                        output.accept(ModItems.PURIFIED_URANIUM.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> ARMOR_TAB = CREATIVE_MOD_TABS
            .register("armor_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModItems.PINK_QUARTZ_HELMET.get()))
                            .title(Component.translatable("creativetab.armor_tab"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModItems.PINK_QUARTZ_HELMET.get());
                                output.accept(ModItems.PINK_QUARTZ_CHESTPLATE.get());
                                output.accept(ModItems.PINK_QUARTZ_LEGGINGS.get());
                                output.accept(ModItems.PINK_QUARTZ_BOOTS.get());
                            })
                            .build());

    public static final RegistryObject<CreativeModeTab> EXTRA_TOOLS_TAB = CREATIVE_MOD_TABS
            .register("extra_tools_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.PINK_QUARTZ_KNIFE.get()))
                    .title(Component.translatable("creativetab.extra_tools_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PINK_QUARTZ_KNIFE.get());
                        output.accept(ModItems.METAL_DETECTOR.get());
                        output.accept(ModItems.URANIUM_SCYTHE.get());
                        output.accept(ModItems.CUP.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> SUPER_FOODS_TAB = CREATIVE_MOD_TABS
            .register("super_foods_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModItems.RAW_BEEF_BRISKET.get()))
                            .title(Component.translatable("creativetab.super_foods_tab"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModItems.RAW_PORK_LEG.get());
                                output.accept(ModItems.COOKED_PORK_LEG.get());
                                output.accept(ModItems.RAW_BEEF_BRISKET.get());
                                output.accept(ModItems.COOKED_BEEF_BRISKET.get());
                                output.accept(ModItems.STRAWBERRY_SEEDS.get());
                                output.accept(ModItems.STRAWBERRY.get());
                                output.accept(ModItems.BUTTER.get());
                                output.accept(ModItems.SALT.get());
                                output.accept(ModItems.CASTER_SUGAR.get());
                                output.accept(ModItems.FLOUR.get());
                                output.accept(ModItems.CORN.get());
                                output.accept(ModItems.CORN_SEEDS.get());
                                output.accept(ModItems.CHOCOLATE.get());
                                output.accept(ModItems.CHOCOLATE_MILK_CUP.get());
                            })
                            .build());

    public static final RegistryObject<CreativeModeTab> SANDWICH_BLOCKS_TAB = CREATIVE_MOD_TABS
            .register("sandwich_blocks_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModBlocks.PINK_QUARTZ_STAIRS.get()))
                            .title(Component.translatable("creativetab.sandwich_blocks_tab"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModBlocks.SOUND_BLOCK.get());
                                output.accept(ModBlocks.PINK_QUARTZ_BUTTON.get());
                                output.accept(ModBlocks.PINK_QUARTZ_PRESSURE_PLATE.get());
                                output.accept(ModBlocks.PINK_QUARTZ_SLAB.get());
                                output.accept(ModBlocks.PINK_QUARTZ_STAIRS.get());
                                output.accept(ModBlocks.PINK_QUARTZ_DOOR.get());
                                output.accept(ModBlocks.PINK_QUARTZ_TRAPDOOR.get());
                                output.accept(ModBlocks.PINK_QUARTZ_FENCE.get());
                                output.accept(ModBlocks.PINK_QUARTZ_FENCE_GATE.get());
                                output.accept(ModBlocks.PINK_QUARTZ_WALL.get());
                            })
                            .build());

    public static final RegistryObject<CreativeModeTab> SANDWICH_FLOWERS_TAB = CREATIVE_MOD_TABS
            .register("sandwich_flowers",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModBlocks.CATMINT.get()))
                            .title(Component.translatable("creativetab.sandwich_flowers_tab"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModBlocks.CATMINT.get());
                            })
                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
