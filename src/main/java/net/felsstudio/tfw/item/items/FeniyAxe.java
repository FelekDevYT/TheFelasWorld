package net.felsstudio.tfw.item.items;

import net.felsstudio.tfw.item.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public class FeniyAxe extends AxeItem {
    private static final Tier TOOL_TIER = new Tier() {
        @Override
        public int getUses() {
            return 1024;
        }

        @Override
        public float getSpeed() {
            return 7f;
        }

        @Override
        public float getAttackDamageBonus() {
            return 1f;
        }

        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
        }

        @Override
        public int getEnchantmentValue() {
            return 13;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(ModItems.FENIY);
        }
    };

    public FeniyAxe(){
        super(TOOL_TIER,new Item.Properties().attributes(AxeItem.createAttributes(TOOL_TIER,1f,1.6f)));
    }
}
