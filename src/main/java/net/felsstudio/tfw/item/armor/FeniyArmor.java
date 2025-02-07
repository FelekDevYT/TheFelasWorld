package net.felsstudio.tfw.item.armor;

import net.felsstudio.tfw.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.EnumMap;
import java.util.List;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class FeniyArmor extends ArmorItem {
    public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

    @SubscribeEvent
    public static void registerArmorMaterial(RegisterEvent event) {
        event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
            ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 9);
            }), 13, BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.EMPTY), () -> Ingredient.of(ModItems.FENIY), List.of(new ArmorMaterial.Layer(ResourceLocation.parse("tfw:feniy"))), 3f, 0.07f);
            registerHelper.register(ResourceLocation.parse("tfw:feniy_armor"), armorMaterial);
            ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
        });
    }

    public FeniyArmor(ArmorItem.Type type, Item.Properties prop){
        super(ARMOR_MATERIAL, type, prop);
    }

    public static class Helement extends FeniyArmor{
        public Helement(){
            super(Type.HELMET,new Item.Properties().durability(Type.HELMET.getDurability(15)));
        }
    }

    public static class Chestplate extends FeniyArmor {
        public Chestplate() {
            super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15)));
        }
    }

    public static class Leggings extends FeniyArmor {
        public Leggings() {
            super(ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15)));
        }
    }

    public static class Boots extends FeniyArmor {
        public Boots() {
            super(ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(15)));
        }
    }
}
