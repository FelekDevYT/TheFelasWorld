package net.felsstudio.tfw.item;

import net.felsstudio.tfw.TheFelasWorld;
import net.felsstudio.tfw.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheFelasWorld.MOD_ID);

    public static final Supplier<CreativeModeTab> TFW_TAB =
            CREATIVE_MODE_TAB.register("tfw_mode_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FENIY.get()))
                            .title(Component.translatable("creativetab.tfw.tfw_tab"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModItems.FENIY);
                                output.accept(ModItems.RAW_FENIY);
                                output.accept(ModItems.LAT);
                                output.accept(ModItems.FENIY_SWORD);
                                output.accept(ModItems.FENIY_PICKAXE);
                                output.accept(ModItems.FENIY_SHOVEL);
                                output.accept(ModItems.FENIY_AXE);
                                output.accept(ModItems.FENIY_HOE);
                                output.accept(ModItems.FENIY_HELMENT);
                                output.accept(ModItems.FENIY_BOOTS);
                                output.accept(ModItems.FENIY_CHESTPLATE);
                                output.accept(ModItems.FENIY_LEGGINGS);
                                output.accept(ModBlocks.FENIY_BLOCK);
                                output.accept(ModBlocks.FENITY_ORE_BLOCK);
                                output.accept(ModBlocks.GARGIA_WOOD);
                                output.accept(ModBlocks.GARGIA_LOG);
                                output.accept(ModBlocks.GARGIA_PLANKS);
                                output.accept(ModBlocks.GARGIA_LEAVES);
                                output.accept(ModBlocks.GARGIA_STAIRS);
                                output.accept(ModBlocks.GARGIA_SLAB);
                                output.accept(ModBlocks.GARGIA_FENCE);
                                output.accept(ModBlocks.GARGIA_FENCE_GATE);
                                output.accept(ModBlocks.GARGIA_PRESSURE_PLATE);
                                output.accept(ModBlocks.GARGIA_BUTTON);
                            })
                            .build());
    public static void register(IEventBus e){
        CREATIVE_MODE_TAB.register(e);
    }
}
