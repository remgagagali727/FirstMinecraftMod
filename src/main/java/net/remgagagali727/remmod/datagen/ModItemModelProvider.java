package net.remgagagali727.remmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.block.ModBlocks;
import net.remgagagali727.remmod.effects.ModEffects;
import net.remgagagali727.remmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ExampleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.PINK_QUARTZ);
        simpleItem(ModItems.PINK_QUARTZ_KNIFE);
        simpleItem(ModItems.TOPAZ);
        simpleItem(ModItems.URANIUM);
        simpleItem(ModItems.RAW_PINK_QUARTZ);

        swordItem(ModItems.URANIUM_SCYTHE);

        //FULL SET DE BLOQUES NO BLOQUES

        simpleBlockItem(ModBlocks.PINK_QUARTZ_DOOR);

        fenceItem(ModBlocks.PINK_QUARTZ_FENCE, ModBlocks.PINK_QUARTZ_BLOCK);
        buttonItem(ModBlocks.PINK_QUARTZ_BUTTON, ModBlocks.PINK_QUARTZ_BLOCK);
        wallItem(ModBlocks.PINK_QUARTZ_WALL, ModBlocks.PINK_QUARTZ_BLOCK);

        evenSimplerBlockItem(ModBlocks.PINK_QUARTZ_STAIRS);
        evenSimplerBlockItem(ModBlocks.PINK_QUARTZ_SLAB);
        evenSimplerBlockItem(ModBlocks.PINK_QUARTZ_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.PINK_QUARTZ_FENCE_GATE);

        trapdoorItem(ModBlocks.PINK_QUARTZ_TRAPDOOR);

        registerCustomEffectIcon(ModEffects.RADIATION);
    }

    private void swordItem(RegistryObject<Item> swordItem) {
        String swordName = swordItem.getId().getPath();
        this.withExistingParent(swordName,
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(ExampleMod.MOD_ID, "item/" + swordName));
    }

    private void registerCustomEffectIcon(RegistryObject<MobEffect> effectRegistryObject) {
        String effectName = effectRegistryObject.getId().getPath();
        this.withExistingParent(effectName,
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(ExampleMod.MOD_ID, "mob_effect/" + effectName));
    }



    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ExampleMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(ExampleMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                //modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
                modLoc("block/pink_quartz_block"));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ExampleMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(ExampleMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(ExampleMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(ExampleMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ExampleMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
