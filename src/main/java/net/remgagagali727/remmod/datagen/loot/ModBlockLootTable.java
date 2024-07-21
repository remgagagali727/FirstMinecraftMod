package net.remgagagali727.remmod.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.block.ModBlocks;
import net.remgagagali727.remmod.block.custom.CornCropBlock;
import net.remgagagali727.remmod.block.custom.StrawberryCropBlock;
import net.remgagagali727.remmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTable extends BlockLootSubProvider {
    public ModBlockLootTable() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.PINK_QUARTZ_BLOCK.get());
        this.dropSelf(ModBlocks.TOPAZ_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.dropSelf(ModBlocks.PINK_QUARTZ_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PINK_QUARTZ_FENCE.get());
        this.dropSelf(ModBlocks.PINK_QUARTZ_WALL.get());
        this.dropSelf(ModBlocks.PINK_QUARTZ_BUTTON.get());
        this.dropSelf(ModBlocks.PINK_QUARTZ_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PINK_QUARTZ_STAIRS.get());
        this.dropSelf(ModBlocks.PINK_QUARTZ_TRAPDOOR.get());

        this.dropSelf(ModBlocks.CATMINT.get());
        this.add(ModBlocks.POTTED_CATMINT.get(), createPotFlowerItemTable(ModBlocks.CATMINT.get()));

        this.add(ModBlocks.PINK_QUARTZ_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PINK_QUARTZ_SLAB.get()));
        this.add(ModBlocks.PINK_QUARTZ_DOOR.get(),
                block -> createDoorTable(ModBlocks.PINK_QUARTZ_DOOR.get()));

        this.add(ModBlocks.PINK_QUARTZ_ORE.get(),
                block -> createDiamondLikeOreDrops(ModBlocks.PINK_QUARTZ_ORE.get(), ModItems.RAW_PINK_QUARTZ.get()));

        this.cropLootTable(ModBlocks.STRAWBERRY_CROP.get(), ModItems.STRAWBERRY_SEEDS.get(), ModItems.STRAWBERRY.get(),
                StrawberryCropBlock.AGE, StrawberryCropBlock.MAX_AGE);

        this.cropLootTable(ModBlocks.CORN_CROP.get(), ModItems.CORN_SEEDS.get(), ModItems.CORN.get(),
                CornCropBlock.AGE, CornCropBlock.MAX_AGE);

        this.add(ModBlocks.CHOCOLATE_CAKE.get(), noDrop());

        this.dropSelf(ModBlocks.COOKING_TABLE.get());
    }

    private void cropLootTable(Block crop, Item seeds, Item result, IntegerProperty ip, int maxAge) {
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(crop)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ip, maxAge));

        this.add(crop, createCropDrops(crop, result,
                seeds, lootitemcondition$builder));

    }

    protected LootTable.Builder createDiamondLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
