package net.remgagagali727.remmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.block.ModBlocks;
import net.remgagagali727.remmod.effects.ModEffects;
import net.remgagagali727.remmod.item.ModItems;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

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
        simpleItem(ModItems.PURIFIED_URANIUM);
        simpleItem(ModItems.RAW_PINK_QUARTZ);

        //Comida
        simpleItem(ModItems.RAW_PORK_LEG);
        simpleItem(ModItems.COOKED_PORK_LEG);
        simpleItem(ModItems.RAW_BEEF_BRISKET);
        simpleItem(ModItems.COOKED_BEEF_BRISKET);


        simpleItem(ModItems.STRAWBERRY_SEEDS);
        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.CHOCOLATE_MILK_CUP);
        simpleItem(ModItems.CUP);
        simpleItem(ModItems.BUTTER);
        simpleItem(ModItems.SALT);
        simpleItem(ModItems.CASTER_SUGAR);
        simpleItem(ModItems.FLOUR);
        simpleItem(ModItems.CORN);
        simpleItem(ModItems.CORN_SEEDS);
        simpleItem(ModItems.CHOCOLATE);
        simpleBlockItem(ModBlocks.CHOCOLATE_CAKE);
        simpleBlockItem(ModBlocks.PEPERONI_PIZZA);

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

        trimmedArmorItem(ModItems.PINK_QUARTZ_HELMET);
        trimmedArmorItem(ModItems.PINK_QUARTZ_CHESTPLATE);
        trimmedArmorItem(ModItems.PINK_QUARTZ_LEGGINGS);
        trimmedArmorItem(ModItems.PINK_QUARTZ_BOOTS);

        simpleBlockItemBlockTexture(ModBlocks.CATMINT);

        //Custom Entity Blocks

        simpleBlockItem(ModBlocks.COOKING_TABLE);
    }

    private void handHeldItem(RegistryObject<Item> swordItem) {
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
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
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

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ExampleMod.MOD_ID,"block/" + item.getId().getPath()));
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = ExampleMod.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
}
