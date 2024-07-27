package net.remgagagali727.remmod.block.custom.models;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PizzaBlock extends Block {
    public static final int MAX_BITES = 7;
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 7);
    public static final VoxelShape[] SHAPE_BY_BITE = new VoxelShape[]{
            Block.box(1.0, 0.0, 1.0, 15.0, 3.0, 15.0),
            Block.box(1.0, 0.0, 1.0, 15.0, 3.0, 15.0),
            Shapes.or(
                Block.box(1.0, 0.0, 1.0, 8.0, 3.0, 15.0),
                Block.box(8.0, 0.0, 8.0, 15.0, 3.0, 15.0)
            ).optimize(),
            Shapes.or(
                    Block.box(1.0, 0.0, 1.0, 8.0, 3.0, 15.0),
                    Block.box(8.0, 0.0, 8.0, 15.0, 3.0, 15.0)
            ).optimize(),
            Block.box(1.0, 0.0, 1.0, 8.0, 3.0, 15.0),
            Block.box(1.0, 0.0, 1.0, 8.0, 3.0, 15.0),
            Block.box(1.0, 0.0, 1.0, 8.0, 3.0, 8.0),
            Block.box(1.0, 0.0, 1.0, 8.0, 3.0, 8.0)};

    public PizzaBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((this.stateDefinition.any()).setValue(BITES, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BITES);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_BY_BITE[pState.getValue(BITES)];
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            if (eat(pLevel, pPos, pState, pPlayer).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (pPlayer.getItemInHand(pHand).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }
        return eat(pLevel, pPos, pState, pPlayer);
    }

    protected static InteractionResult eat(LevelAccessor pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pPlayer.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            pPlayer.awardStat(Stats.EAT_CAKE_SLICE);
            pPlayer.getFoodData().eat(4, 0.2F);
            int $$4 = pState.getValue(BITES);
            pLevel.gameEvent(pPlayer, GameEvent.EAT, pPos);
            if ($$4 < MAX_BITES) {
                pLevel.setBlock(pPos, pState.setValue(BITES, $$4 + 1), 3);
            } else {
                pLevel.removeBlock(pPos, false);
                pLevel.gameEvent(pPlayer, GameEvent.BLOCK_DESTROY, pPos);
            }

            return InteractionResult.SUCCESS;
        }
    }
}
