package net.remgagagali727.remmod.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.remgagagali727.remmod.ExampleMod;
import net.remgagagali727.remmod.effects.custom.ChocolatedEffect;
import net.remgagagali727.remmod.effects.custom.RadiationEffect;

public class ModEffects {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ExampleMod.MOD_ID);

    public static final RegistryObject<MobEffect> RADIATION = EFFECTS.register("radiation",
            () -> new RadiationEffect(MobEffectCategory.HARMFUL));

    public static final RegistryObject<MobEffect> CHOCOLATED = EFFECTS.register("chocolated",
            () -> new ChocolatedEffect(MobEffectCategory.NEUTRAL));

    public static void register(IEventBus modEventBus) {
        EFFECTS.register(modEventBus);
    }
}
