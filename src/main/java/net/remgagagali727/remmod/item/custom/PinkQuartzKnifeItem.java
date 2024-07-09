package net.remgagagali727.remmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.swing.text.html.parser.Entity;
import java.util.Random;

public class PinkQuartzKnifeItem extends Item {
    public PinkQuartzKnifeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack newItemStack = itemStack.copy();
        newItemStack.hurt(1, null, null);
        int damage = newItemStack.getDamageValue();
        int maxDamage = newItemStack.getMaxDamage();
        return maxDamage - damage < 0 ? ItemStack.EMPTY : newItemStack;
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
}
