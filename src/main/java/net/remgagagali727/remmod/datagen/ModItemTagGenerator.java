package net.remgagagali727.remmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, ExampleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PINK_QUARTZ_HELMET.get(),
                        ModItems.PINK_QUARTZ_BOOTS.get(),
                        ModItems.PINK_QUARTZ_CHESTPLATE.get(),
                        ModItems.PINK_QUARTZ_LEGGINGS.get());

        this.tag(Tags.Items.TOOLS)
                .add(ModItems.URANIUM_SCYTHE.get());

        this.tag(ItemTags.SWORDS)
                .add(ModItems.URANIUM_SCYTHE.get());
    }
}
