package net.remgagagali727.remmod.item.custom;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.remgagagali727.remmod.item.ModArmorMaterials;

import java.util.List;
import java.util.UUID;

public class ModArmorEffects {

    private final UUID PINK_QUARTZ_HEALTH_MODIFICATOR_ID = UUID.fromString("d4e0a9d0-9a1d-4b5e-8c2e-3c47bff9e4d8");

    private final List<AttributeModifier> attributeModifiers = List.of(new AttributeModifier(PINK_QUARTZ_HEALTH_MODIFICATOR_ID, "Pink Quartz Health Boost", 4d, AttributeModifier.Operation.ADDITION));

    public void effects(ArmorMaterial mapArmorMaterial, Player player) {
        if (mapArmorMaterial.equals(ModArmorMaterials.PINK_QUARTZ)) {
            AttributeModifier attributeModifierHealth = attributeModifiers.get(0);
            if (!player.getAttribute(Attributes.MAX_HEALTH).hasModifier(attributeModifierHealth)) {
                player.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(attributeModifierHealth);
            }
        }
    }

    public void removeEffects(Player player) {
        attributeModifiers.forEach(A ->{
            if (player.getAttribute(Attributes.MAX_HEALTH).hasModifier(A)) {
                player.getAttribute(Attributes.MAX_HEALTH).removeModifier(A);
            }
        });
        if(player.getMaxHealth() < player.getHealth()) {
            player.setHealth(player.getMaxHealth());
        }
    }
}
