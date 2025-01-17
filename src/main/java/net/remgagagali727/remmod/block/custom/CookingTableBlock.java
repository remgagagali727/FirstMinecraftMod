package net.remgagagali727.remmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import net.remgagagali727.remmod.block.entity.ModBlockEntities;
import net.remgagagali727.remmod.block.entity.custom.CookingTableEntityBlock;
import org.jetbrains.annotations.Nullable;

public class CookingTableBlock extends BaseEntityBlock {

    public static final VoxelShape SHAPE = Shapes.or(
        Block.box(0, 0, 0, 16, 16, 16),
        Block.box(1, 16, 1, 15, 17,15),
        Block.box(4, 17, 4, 12, 20,12)
    ).optimize();

    public CookingTableBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof CookingTableEntityBlock) {
                ((CookingTableEntityBlock) blockEntity).drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof CookingTableEntityBlock) {
                NetworkHooks.openScreen(((ServerPlayer)pPlayer), (CookingTableEntityBlock)entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
            return InteractionResult.FAIL;
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide) return null;
        return createTickerHelper(pBlockEntityType, ModBlockEntities.COOKING_TABLE_BE.get(),
                (level, blockPos, blockState, cookingTableEntityBlock) -> cookingTableEntityBlock.tick(
                        level, blockPos, blockState));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CookingTableEntityBlock(blockPos, blockState);
    }
}
