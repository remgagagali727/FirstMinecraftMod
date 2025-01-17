package net.remgagagali727.remmod.datagen;

import net.minecraft.advancements.critereon.EntityFlagsPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.item.ModItems;
import net.remgagagali727.remmod.loot.AddItemModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, ExampleMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("raw_pork_leg", new AddItemModifier(new LootItemCondition[]{
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().of(EntityType.PIG)).build(),
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().of(EntityType.PIG).flags(
                                EntityFlagsPredicate.Builder.flags().setOnFire(false).build()))
                        .build()
        }, ModItems.RAW_PORK_LEG.get(), 1, 3));

        add("strawberry_seeds_from_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.025f).build()
        }, ModItems.STRAWBERRY_SEEDS.get()));

        add("strawberry_seeds_from_tall_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.025f).build()
        }, ModItems.STRAWBERRY_SEEDS.get()));

        add("cooked_pork_leg", new AddItemModifier(new LootItemCondition[]{
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().of(EntityType.PIG)).build(),
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().of(EntityType.PIG).flags(
                                EntityFlagsPredicate.Builder.flags().setOnFire(true).build()))
                        .build()
        }, ModItems.COOKED_PORK_LEG.get(), 1, 3));

        add("raw_beef_brisket", new AddItemModifier(new LootItemCondition[]{
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().of(EntityType.COW)).build(),
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().of(EntityType.COW).flags(
                                EntityFlagsPredicate.Builder.flags().setOnFire(false).build()))
                        .build()
        }, ModItems.RAW_BEEF_BRISKET.get(), 0, 2));

        add("cooked_beef_brisket", new AddItemModifier(new LootItemCondition[]{
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().of(EntityType.COW)).build(),
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().of(EntityType.COW).flags(
                                EntityFlagsPredicate.Builder.flags().setOnFire(true).build()))
                        .build()
        }, ModItems.COOKED_BEEF_BRISKET.get(), 0, 2));

    }
}
