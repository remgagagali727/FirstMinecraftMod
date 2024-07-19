package net.remgagagali727.remmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.block.ModBlocks;
import net.remgagagali727.remmod.block.custom.CornCropBlock;
import net.remgagagali727.remmod.block.custom.ICropBasics;
import net.remgagagali727.remmod.block.custom.StrawberryCropBlock;

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
    }

    public <T extends CropBlock & ICropBasics> void makeCrop(CropBlock block, String name, Class<T> tClass) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, name, tClass);
        getVariantBuilder(block).forAllStates(function);
    }

    public <T extends CropBlock & ICropBasics> ConfiguredModel[] states(BlockState state, CropBlock block, String name, Class<T> tClass) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(name + state.getValue(((T) block).getIntegerProperty()),
                new ResourceLocation(ExampleMod.MOD_ID, "block/" + name + state.getValue(((T) block).getIntegerProperty()))).renderType("cutout"));
        return models;
    }

    public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                new ResourceLocation(ExampleMod.MOD_ID, "block/" + textureName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}