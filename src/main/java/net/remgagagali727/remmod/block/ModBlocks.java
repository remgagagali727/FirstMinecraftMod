package net.remgagagali727.remmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.block.custom.*;
import net.remgagagali727.remmod.block.custom.models.ModFlammableRotatedPilarBlock;
import net.remgagagali727.remmod.block.custom.models.ModLeavesBlock;
import net.remgagagali727.remmod.block.custom.models.ModPlankBlock;
import net.remgagagali727.remmod.effects.ModEffects;
import net.remgagagali727.remmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);

    //Crops
    public static final RegistryObject<Block> STRAWBERRY_CROP = BLOCKS.register("strawberry_crop",
            () -> new StrawberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)
                    .noCollission()
                    .noOcclusion()));

    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CornCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)
                    .noCollission()
                    .noOcclusion()));

    public static final RegistryObject<Block> TOPAZ_BLOCK = registryBlock("topaz_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> COOKING_TABLE = registryBlock("cooking_table",
            () -> new CookingTableBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));

    public static final RegistryObject<Block> CATMINT = registryBlock("catmint",
            () -> new FlowerBlock(() -> ModEffects.RADIATION.get(), 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                            .noCollission()
                            .noCollission()));

    public static final RegistryObject<Block> POTTED_CATMINT = BLOCKS.register("potted_catmint",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.CATMINT,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> PINK_QUARTZ_BLOCK = registryBlock("pink_quartz_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CHOCOLATE_CAKE = registryBlock("chocolate_cake",
            () -> new CakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));

    public static final RegistryObject<Block> PINK_QUARTZ_STAIRS = registryBlock("pink_quartz_stairs",
            () -> new StairBlock(() -> ModBlocks.PINK_QUARTZ_BLOCK.get().defaultBlockState()
                    ,BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> PINK_QUARTZ_SLAB = registryBlock("pink_quartz_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> PINK_QUARTZ_BUTTON = registryBlock("pink_quartz_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 15, true));
    public static final RegistryObject<Block> PINK_QUARTZ_PRESSURE_PLATE = registryBlock("pink_quartz_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS,BlockBehaviour.Properties.copy(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE),
                    BlockSetType.IRON));

    public static final RegistryObject<Block> PINK_QUARTZ_FENCE = registryBlock("pink_quartz_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_FENCE)));
    public static final RegistryObject<Block> PINK_QUARTZ_FENCE_GATE = registryBlock("pink_quartz_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN,  SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> PINK_QUARTZ_WALL = registryBlock("pink_quartz_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> PINK_QUARTZ_DOOR = registryBlock("pink_quartz_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_DOOR), BlockSetType.ACACIA));
    public static final RegistryObject<Block> PINK_QUARTZ_TRAPDOOR = registryBlock("pink_quartz_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_TRAPDOOR), BlockSetType.ACACIA));

    public static final RegistryObject<Block> PINK_QUARTZ_ORE = registryBlock("pink_quartz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3.2f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(5,8)));

    public static final RegistryObject<Block> SOUND_BLOCK = registryBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> LEMON_LOG = registryBlock("lemon_log",
            () -> new ModFlammableRotatedPilarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> LEMON_WOOD = registryBlock("lemon_wood",
            () -> new ModFlammableRotatedPilarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_LEMON_LOG = registryBlock("stripped_lemon_log",
            () -> new ModFlammableRotatedPilarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_LEMON_WOOD = registryBlock("stripped_lemon_wood",
            () -> new ModFlammableRotatedPilarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final RegistryObject<Block> LEMON_PLANKS = registryBlock("lemon_planks",
            () -> new ModPlankBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(3f)));
    public static final RegistryObject<Block> LEMON_LEAVES = registryBlock("lemon_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).strength(0.5f).noOcclusion()));


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
