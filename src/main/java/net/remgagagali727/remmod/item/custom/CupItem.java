package net.remgagagali727.remmod.item.custom;

import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.remgagagali727.remmod.effects.ModEffects;
import net.remgagagali727.remmod.item.ModItems;

import java.util.Map;

public class CupItem extends Item {

    private Map<MobEffect, Item> relaciones = Map.of(
            ModEffects.CHOCOLATED.get(), ModItems.CHOCOLATE_MILK_CUP.get()
    );

    public CupItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity.getType().equals(EntityType.COW)) {
            LivingEntity livingEntity = ((LivingEntity) entity);
            for (Map.Entry<MobEffect, Item> entry : relaciones.entrySet()) {
                MobEffect effect = entry.getKey();
                Item item = entry.getValue();
                if(livingEntity.hasEffect(effect)) {
                    stack.setCount(stack.getCount() - 1);
                    if(!player.addItem(new ItemStack(item))) {
                        player.drop(new ItemStack(item), false);
                    }
                }
            }
            return true;
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
}
