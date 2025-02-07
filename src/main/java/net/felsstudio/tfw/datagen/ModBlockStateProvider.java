package net.felsstudio.tfw.datagen;

import net.felsstudio.tfw.TheFelasWorld;
import net.felsstudio.tfw.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TheFelasWorld.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.FENIY_BLOCK);

        blockWithItem(ModBlocks.FENITY_ORE_BLOCK);

        blockWithItem(ModBlocks.GARGIA_BUTTON);
        blockWithItem(ModBlocks.GARGIA_FENCE);
        blockWithItem(ModBlocks.GARGIA_FENCE_GATE);
        blockWithItem(ModBlocks.GARGIA_LEAVES);
        blockWithItem(ModBlocks.GARGIA_LOG);
        blockWithItem(ModBlocks.GARGIA_PLANKS);
        blockWithItem(ModBlocks.GARGIA_PRESSURE_PLATE);
        blockWithItem(ModBlocks.GARGIA_SAPLING);
        blockWithItem(ModBlocks.GARGIA_SLAB);
        blockWithItem(ModBlocks.GARGIA_STAIRS);
        blockWithItem(ModBlocks.GARGIA_STAIRS);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}