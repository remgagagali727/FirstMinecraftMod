package net.remgagagali727.remmod.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.function.Supplier;

public class AddItemModifier extends LootModifier {

    public static final Supplier<Codec<AddItemModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.create(inst ->
                    codecStart(inst)
                            .and(ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(m -> m.item))
                            .and(Codec.INT.fieldOf("minCount").forGetter(m -> m.minCount))
                            .and(Codec.INT.fieldOf("maxCount").forGetter(m -> m.maxCount))
                            .apply(inst, AddItemModifier::new)
    ));

    private final Item item;
    private final int minCount;
    private final int maxCount;

    public AddItemModifier(LootItemCondition[] conditionsIn, Item item, int minCount, int maxCount) {
        super(conditionsIn);
        this.item = item;
        this.minCount = minCount;
        this.maxCount = maxCount;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext lootContext) {
        Random random = new Random();
        int count = minCount + random.nextInt(maxCount - minCount + 1);
        generatedLoot.add(new ItemStack(item, count));
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
