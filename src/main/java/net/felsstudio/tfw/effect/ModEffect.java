package net.felsstudio.tfw.effect;

import net.felsstudio.tfw.TheFelasWorld;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffect {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, TheFelasWorld.MOD_ID);

    public static final DeferredHolder<MobEffect, MobEffect> KILL_EFFECT = MOB_EFFECTS.register("kill",
            () -> new KillEffect(MobEffectCategory.BENEFICIAL, 0xf54545)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                            ResourceLocation.fromNamespaceAndPath(TheFelasWorld.MOD_ID, "kill"), -0x25f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static void register(IEventBus e){
        MOB_EFFECTS.register(e);
    }
}
