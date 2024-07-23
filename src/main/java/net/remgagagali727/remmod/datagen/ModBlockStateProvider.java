package net.remgagagali727.remmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.block.ModBlocks;
import net.remgagagali727.remmod.block.custom.CornCropBlock;
import net.remgagagali727.remmod.block.custom.models.ICropBasics;
import net.remgagagali727.remmod.block.custom.StrawberryCropBlock;

import java.util.List;
import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ExampleMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PINK_QUARTZ_BLOCK);
        blockWithItem(ModBlocks.PINK_QUARTZ_ORE);
        blockWithItem(ModBlocks.TOPAZ_BLOCK);
        simpleBlock(ModBlocks.COOKING_TABLE.get(),
                new ModelFile.UncheckedModelFile(modLoc(
                        "block/cooking_table")));



        blockWithItem(ModBlocks.SOUND_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.PINK_QUARTZ_STAIRS.get()), blockTexture(ModBlocks.PINK_QUARTZ_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.PINK_QUARTZ_SLAB.get()), blockTexture(ModBlocks.PINK_QUARTZ_BLOCK.get()), blockTexture(ModBlocks.PINK_QUARTZ_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.PINK_QUARTZ_BUTTON.get()), blockTexture(ModBlocks.PINK_QUARTZ_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.PINK_QUARTZ_PRESSURE_PLATE.get()), blockTexture(ModBlocks.PINK_QUARTZ_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.PINK_QUARTZ_FENCE.get()), blockTexture(ModBlocks.PINK_QUARTZ_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.PINK_QUARTZ_FENCE_GATE.get()), blockTexture(ModBlocks.PINK_QUARTZ_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.PINK_QUARTZ_WALL.get()), blockTexture(ModBlocks.PINK_QUARTZ_BLOCK.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.PINK_QUARTZ_DOOR.get(), modLoc("block/pink_quartz_door_bottom"), modLoc("block/pink_quartz_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.PINK_QUARTZ_TRAPDOOR.get(), modLoc("block/pink_quartz_trapdoor"), true, "cutout");

        makeCrop((CropBlock) ModBlocks.STRAWBERRY_CROP.get(), "strawberry_stage", StrawberryCropBlock.class);
        makeCrop((CropBlock) ModBlocks.CORN_CROP.get(), "corn_stage", CornCropBlock.class);

        simpleBlockWithItem(ModBlocks.CATMINT.get(), models().cross(blockTexture(ModBlocks.CATMINT.get()).getPath(),
                blockTexture(ModBlocks.CATMINT.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_CATMINT.get(), models().singleTexture("potted_catmint",
                new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.CATMINT.get())).renderType("cutout"));

        makeCake(ModBlocks.CHOCOLATE_CAKE);

        logBlock(((RotatedPillarBlock) ModBlocks.LEMON_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.LEMON_WOOD.get()), blockTexture(ModBlocks.LEMON_LOG.get()), blockTexture(ModBlocks.LEMON_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_LEMON_LOG.get()), blockTexture(ModBlocks.STRIPPED_LEMON_LOG.get()),
                new ResourceLocation(ExampleMod.MOD_ID, "block/stripped_lemon_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_LEMON_WOOD.get()), blockTexture(ModBlocks.STRIPPED_LEMON_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_LEMON_LOG.get()));

        blockItem(ModBlocks.LEMON_LOG);
        blockItem(ModBlocks.LEMON_WOOD);
        blockItem(ModBlocks.STRIPPED_LEMON_LOG);
        blockItem(ModBlocks.STRIPPED_LEMON_WOOD);

        blockWithItem(ModBlocks.LEMON_PLANKS);

        leavesBlock(ModBlocks.LEMON_LEAVES);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(ExampleMod.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void makeCake(RegistryObject<Block> block) {
        String name = block.getId().getPath();
        CakeBlock cakeBlock = ((CakeBlock) block.get());
        List<String> extra = List.of(
                "", "_slice1", "_slice2", "_slice3", "_slice4", "_slice5", "_slice6"
        );
        Function<BlockState, ConfiguredModel[]> function = state -> cakeStates(state, name);
        getVariantBuilder(cakeBlock).forAllStates(function);
    }

    private ConfiguredModel[] cakeStates(BlockState state, String path) {
        BlockModelBuilder BMB = models().withExistingParent(path + state.getValue(CakeBlock.BITES),
                new ResourceLocation(ExampleMod.MOD_ID + ":block/cake_template" + state.getValue(CakeBlock.BITES)))
                    .texture("particle", new ResourceLocation(ExampleMod.MOD_ID + ":block/" + path + "_top"))
                    .texture("bottom", new ResourceLocation(ExampleMod.MOD_ID + ":block/" + path + "_bottom"))
                    .texture("top", new ResourceLocation(ExampleMod.MOD_ID + ":block/" + path + "_top"))
                    .texture("side", new ResourceLocation(ExampleMod.MOD_ID + ":block/" + path + "_side"))
                    .texture("inside", new ResourceLocation(ExampleMod.MOD_ID + ":block/" + path + "_inner"));
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = ConfiguredModel.builder()
                .modelFile(BMB)
                .buildLast();
        return models;
    }

    public <T extends CropBlock & ICropBasics> void makeCrop(CropBlock block, String name, Class<T> tClass) {
        Function<BlockState, ConfiguredModel[]> function = state -> cropStates(state, block, name, tClass);
        getVariantBuilder(block).forAllStates(function);
    }

    public <T extends CropBlock & ICropBasics> ConfiguredModel[] cropStates(BlockState state, CropBlock block, String name, Class<T> tClass) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(name + state.getValue(((T) block).getIntegerProperty()),
                new ResourceLocation(ExampleMod.MOD_ID, "block/" + name + state.getValue(((T) block).getIntegerProperty()))).renderType("cutout"));
        return models;
    }

    public void simpleBlockWithItem(RegistryObject<Block> block) {
        String path = ExampleMod.MOD_ID + ":block/" + block.getId().getPath();
        simpleBlockWithItem(block.get(), new ModelFile.UncheckedModelFile(path));
    }
}