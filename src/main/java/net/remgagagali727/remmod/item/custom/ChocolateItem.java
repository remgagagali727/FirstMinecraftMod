package net.remgagagali727.remmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.remgagagali727.remmod.effects.ModEffects;

public class ChocolateItem extends Item {
    public ChocolateItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity.getType().equals(EntityType.COW)) {
            LivingEntity cow = ((LivingEntity) entity);
            cow.addEffect(new MobEffectInstance(ModEffects.CHOCOLATED.get(), 600, 1,
                    false, false));
            stack.setCount(stack.getCount() - 1);
            return true;
        }
        return false;
    }

}
