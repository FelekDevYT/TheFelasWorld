package net.felsstudio.tfw.item;

import net.felsstudio.tfw.TheFelasWorld;
import net.felsstudio.tfw.item.armor.FeniyArmor;
import net.felsstudio.tfw.item.custom.LatItem;
import net.felsstudio.tfw.item.items.*;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TheFelasWorld.MOD_ID);

    public static final DeferredItem<Item> FENIY = ITEMS.register("feniy",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_FENIY = ITEMS.register("raw_feniy",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LAT = ITEMS.register("lat",
            () -> new LatItem(new Item.Properties().durability(128)));

    public static final DeferredItem<Item> FENIY_SWORD = ITEMS.register("feniy_sword", FeniySword::new);
    public static final DeferredItem<Item> FENIY_PICKAXE = ITEMS.register("feniy_pickaxe", FeniyPixkaxe::new);
    public static final DeferredItem<Item> FENIY_SHOVEL = ITEMS.register("feniy_shovel", FeniyShovel::new);
    public static final DeferredItem<Item> FENIY_AXE = ITEMS.register("feniy_axe", FeniyAxe::new);
    public static final DeferredItem<Item> FENIY_HOE = ITEMS.register("feniy_hoe", FeniyHoe::new);

    public static final DeferredItem<Item> FENIY_HELMENT = ITEMS.register("feniy_helment", FeniyArmor.Helement::new);
    public static final DeferredItem<Item> FENIY_BOOTS = ITEMS.register("feniy_boots", FeniyArmor.Boots::new);
    public static final DeferredItem<Item> FENIY_CHESTPLATE = ITEMS.register("feniy_chestplate", FeniyArmor.Chestplate::new);
    public static final DeferredItem<Item> FENIY_LEGGINGS = ITEMS.register("feniy_leggings", FeniyArmor.Leggings::new);

    public static void register(IEventBus e){
        ITEMS.register(e);
    }

}
