package net.remgagagali727.remmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.remgagagali727.remmod.effects.ModEffects;
import net.remgagagali727.remmod.item.ModToolTiers;

public class UraniumScytheItem extends SwordItem {

    public UraniumScytheItem(int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(ModToolTiers.URANIUM, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.addEffect(new MobEffectInstance(ModEffects.RADIATION.get(), 200, 3));
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
}
