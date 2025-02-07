package net.felsstudio.tfw.potion;

import net.felsstudio.tfw.TheFelasWorld;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, TheFelasWorld.MOD_ID);

    //public static final Holder<Potion> SPIDER_POTION =

    public static void register(IEventBus e){
        POTIONS.register(e);
    }
}
