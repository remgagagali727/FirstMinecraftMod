package net.remgagagali727.remmod.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.block.ModBlocks;

import java.rmi.registry.Registry;

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


    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}