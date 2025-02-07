package net.felsstudio.tfw.block;

import net.felsstudio.tfw.TheFelasWorld;
import net.felsstudio.tfw.block.gargia.*;
import net.felsstudio.tfw.item.ModItems;
import net.felsstudio.tfw.worldgen.tree.ModTreeGrover;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TheFelasWorld.MOD_ID);

    public static final DeferredBlock<Block> FENIY_BLOCK =
            registerBlock("feniy_block",
                    () -> new Block(BlockBehaviour.Properties.of()
                            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> FENITY_ORE_BLOCK =
            registerBlock("feniy_ore",
                    () -> new Block(BlockBehaviour.Properties.of()
                            .strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE)));

    public static final DeferredBlock<Block> GARGIA_WOOD = registerBlock("gargia_wood", GargiaWoodBlock::new);
    public static final DeferredBlock<Block> GARGIA_LOG = registerBlock("gargia_log", GargiaLogBlock::new);
    public static final DeferredBlock<Block> GARGIA_PLANKS = registerBlock("gargia_planks", GargiaPlanksBlock::new);
    public static final DeferredBlock<Block> GARGIA_LEAVES = registerBlock("gargia_leaves", GargiaLeavesBlock::new);
    public static final DeferredBlock<Block> GARGIA_STAIRS = registerBlock("gargia_stairs", GargiaStairsBlock::new);
    public static final DeferredBlock<Block> GARGIA_SLAB = registerBlock("gargia_slab", GargiaSlabBlock::new);
    public static final DeferredBlock<Block> GARGIA_FENCE = registerBlock("gargia_fence", GargiaFenceBlock::new);
    public static final DeferredBlock<Block> GARGIA_FENCE_GATE = registerBlock("gargia_fence_gate", GargiaFenceGateBlock::new);
    public static final DeferredBlock<Block> GARGIA_PRESSURE_PLATE = registerBlock("gargia_pressure_plate", GargiaPressurePlateBlock::new);
    public static final DeferredBlock<Block> GARGIA_BUTTON = registerBlock("gargia_button", GargiaButtonBlock::new);
    //public static final DeferredBlock<Block> GARGIA_SAPLING = registerBlock("gargia_sapling",GargiaSapling::new);
    public static final DeferredBlock<Block> GARGIA_SAPLING = registerBlock("gargia_sapling",
            () -> new SaplingBlock(ModTreeGrover.GARGIA,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name,
                                                                    Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name,
                                                            DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus e){
        BLOCKS.register(e);
    }
}
