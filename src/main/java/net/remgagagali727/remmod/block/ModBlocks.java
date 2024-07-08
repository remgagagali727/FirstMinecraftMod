package net.remgagagali727.remmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);

    public static final RegistryObject<Block> TOPAZ_BLOCK = registryBlock("topaz_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> PINK_QUARTZ_BLOCK = registryBlock("pink_quartz_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> PINK_QUARTZ_ORE = registryBlock("pink_quartz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3.5f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(5,8)));

    private static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
