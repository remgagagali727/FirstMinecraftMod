package net.remgagagali727.remmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.block.ModBlocks;
import net.remgagagali727.remmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExampleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.PINK_QUARTZ_ORE.get())
                .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PINK_QUARTZ_ORE.get(),
                        ModBlocks.PINK_QUARTZ_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(BlockTags.NEEDS_STONE_TOOL);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PINK_QUARTZ_BLOCK.get(),
                        ModBlocks.PINK_QUARTZ_ORE.get(),
                        ModBlocks.TOPAZ_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.LEMON_LOG.get(),
                        ModBlocks.LEMON_WOOD.get(),
                        ModBlocks.STRIPPED_LEMON_LOG.get(),
                        ModBlocks.STRIPPED_LEMON_WOOD.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.LEMON_LEAVES.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.PINK_QUARTZ_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.PINK_QUARTZ_FENCE_GATE.get());

        this.tag(BlockTags.DOORS)
                .add(ModBlocks.PINK_QUARTZ_DOOR.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.PINK_QUARTZ_WALL.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.LEMON_LOG.get())
                .add(ModBlocks.STRIPPED_LEMON_LOG.get())
                .add(ModBlocks.LEMON_WOOD.get())
                .add(ModBlocks.STRIPPED_LEMON_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.LEMON_PLANKS.get());

        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.LEMON_LEAVES.get());
    }
}
