package net.felsstudio.tfw.datagen;

import net.felsstudio.tfw.TheFelasWorld;
import net.felsstudio.tfw.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheFelasWorld.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.FENIY.get());
        basicItem(ModItems.RAW_FENIY.get());

        basicItem(ModItems.FENIY_AXE.get());
        basicItem(ModItems.FENIY_HOE.get());
        basicItem(ModItems.FENIY_PICKAXE.get());
        basicItem(ModItems.FENIY_SWORD.get());
        basicItem(ModItems.FENIY_BOOTS.get());
        basicItem(ModItems.FENIY_LEGGINGS.get());
        basicItem(ModItems.FENIY_CHESTPLATE.get());
        basicItem(ModItems.FENIY_HELMENT.get());
        basicItem(ModItems.LAT.get());
    }
}