package net.remgagagali727.remmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
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
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> SANDWICH_BLOCKS_TAB = CREATIVE_MOD_TABS
            .register("sandwich_blocks_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModItems.PINK_QUARTZ_KNIFE.get()))
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

    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
