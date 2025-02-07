package net.felsstudio.tfw.datagen;

import net.felsstudio.tfw.block.ModBlocks;
import net.felsstudio.tfw.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.FENIY_BLOCK.get());
        // dropSelf(ModBlocks.MAGIC_BLOCK.get());

        add(ModBlocks.FENITY_ORE_BLOCK.get(),
                block -> createOreDrop(ModBlocks.FENITY_ORE_BLOCK.get(), ModItems.RAW_FENIY.get()));

        dropSelf(ModBlocks.GARGIA_BUTTON.get());
        dropSelf(ModBlocks.GARGIA_FENCE.get());
        dropSelf(ModBlocks.GARGIA_FENCE_GATE.get());
        dropSelf(ModBlocks.GARGIA_LEAVES.get());
        dropSelf(ModBlocks.GARGIA_LOG.get());
        dropSelf(ModBlocks.GARGIA_PLANKS.get());
        dropSelf(ModBlocks.GARGIA_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.GARGIA_SAPLING.get());
        dropSelf(ModBlocks.GARGIA_SLAB.get());
        dropSelf(ModBlocks.GARGIA_STAIRS.get());
        dropSelf(ModBlocks.GARGIA_WOOD.get());
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}