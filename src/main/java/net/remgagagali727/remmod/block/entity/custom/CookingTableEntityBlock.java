package net.remgagagali727.remmod.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.remgagagali727.remmod.recipe.CookingTableRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.remgagagali727.remmod.block.entity.ModBlockEntities;
import net.remgagagali727.remmod.screen.CookingTableMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class CookingTableEntityBlock extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemStackHandler = new ItemStackHandler(22) {

    };

    private static final int INPUT_SLOTS[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                                            10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    private static final int FUEL_SLOT = 20;
    private static final int OUTPUT_SLOT = 21;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;

    private int fuel = 0;
    private int maxFuel = 1;

    public CookingTableEntityBlock(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.COOKING_TABLE_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> CookingTableEntityBlock.this.progress;
                    case 1 -> CookingTableEntityBlock.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> CookingTableEntityBlock.this.progress = pValue;
                    case 1 -> CookingTableEntityBlock.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemStackHandler.getSlots());
        for(int i = 0; i < itemStackHandler.getSlots(); i++ ){
            inventory.setItem(i, itemStackHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.tutorialmod.cooking_table");
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemStackHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory inventory, Player player) {
        return new CookingTableMenu(pContainerId, inventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemStackHandler.serializeNBT());
        pTag.putInt("cooking_table.progress", progress);
        pTag.putInt("cooking_table.maxfuel", maxFuel);
        pTag.putInt("cooking_table.fuel", fuel);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemStackHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("cooking_table.progress");
        maxFuel = pTag.getInt("cooking_table.maxfuel");
        fuel = pTag.getInt("cooking_table.fuel");
    }


    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        if(hasRecipe()) {
            if(!hasFuel()) {
                if(!canRechargeFuel()) {
                    return;
                }
                rechargeFuel();
            }
            decreseFuel();
            increaseCraftingProgress();
            setChanged(level, blockPos, blockState);
            if(hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void rechargeFuel() {
        ItemStack fuelItem = itemStackHandler.getStackInSlot(FUEL_SLOT);
        fuel = maxFuel = fuelItem.getBurnTime(null);
        itemStackHandler.extractItem(FUEL_SLOT, 1, false);
    }

    private boolean canRechargeFuel() {
        ItemStack itemStack = itemStackHandler.getStackInSlot(FUEL_SLOT);
        if(itemStack.getCount() == 0) return false;
        int burnTime = itemStack.getBurnTime(null);
        return burnTime > 0;
    }

    private void decreseFuel() {
        fuel--;
    }

    private boolean hasFuel() {
        return fuel > 0;
    }

    private void resetProgress() {
        progress = 0;
    }

    private void craftItem() {
        Optional<CookingTableRecipe> recipe = getCurrentRecipe();
        ItemStack result = recipe.get().getResultItem(null);

        for(int input_slot : INPUT_SLOTS) {
            if(oneInSlot(input_slot))
                this.itemStackHandler.setStackInSlot(input_slot,
                    this.itemStackHandler.getStackInSlot(input_slot).getCraftingRemainingItem());
            else
                this.itemStackHandler.setStackInSlot(input_slot, new ItemStack(
                    this.itemStackHandler.getStackInSlot(input_slot).getItem(),
                    this.itemStackHandler.getStackInSlot(input_slot).getCount() - 1));
        }
        this.itemStackHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
        this.itemStackHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private boolean oneInSlot(int inputSlot) {
        return this.itemStackHandler.getStackInSlot(inputSlot).getCount() == 1;
    }

    private boolean hasRecipe() {
        Optional<CookingTableRecipe> recipe = getCurrentRecipe();

        if(recipe.isEmpty()) {
            return false;
        }
        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private Optional<CookingTableRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemStackHandler.getSlots());
        for(int i = 0; i < itemStackHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemStackHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(CookingTableRecipe.Type.INSTANCE, inventory, level);
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemStackHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ||
                this.itemStackHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemStackHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <=
                this.itemStackHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }
}