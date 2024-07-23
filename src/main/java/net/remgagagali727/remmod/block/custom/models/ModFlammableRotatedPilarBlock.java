package net.remgagagali727.remmod.block.custom.models;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class ModFlammableRotatedPilarBlock extends RotatedPillarBlock {
    public ModFlammableRotatedPilarBlock(Properties pProperties) {
        super(pProperties);
    }

    private final Map<RegistryObject<Block>, RegistryObject<Block>> STRIPPED_BLOCKS = Map.of(
            ModBlocks.LEMON_LOG, ModBlocks.STRIPPED_LEMON_LOG,
            ModBlocks.LEMON_WOOD, ModBlocks.STRIPPED_LEMON_WOOD
    );

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 20;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            Block block = state.getBlock();

            if (block == ModBlocks.LEMON_LOG.get()) {
                return ModBlocks.STRIPPED_LEMON_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            } else if (block == ModBlocks.LEMON_WOOD.get()) {
                return ModBlocks.STRIPPED_LEMON_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
