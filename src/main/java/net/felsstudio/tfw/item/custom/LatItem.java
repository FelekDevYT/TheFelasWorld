package net.felsstudio.tfw.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class LatItem extends Item {
    public LatItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(!(context.getLevel().isClientSide)){
            BlockPos pos = context.getClickedPos();
            Player player = context.getPlayer();
            boolean fondBlock = false;

            for(int y = -64;y <= pos.getY()+64;y++){
                BlockState state = context.getLevel().getBlockState(pos.below(y));
                if(isValiableBlock(state)){
                    outputVariableCoordinater(pos.below(y),player,state.getBlock());
                    fondBlock = true;

                    break;
                }
            }

            if(!fondBlock) {
                player.sendSystemMessage(Component.literal("No blocks found!"));
            }
            player.getItemInHand(context.getHand()).hurtAndBreak(1,player,context.getItemInHand().getEquipmentSlot());
        }

        return InteractionResult.SUCCESS;
    }

    private void outputVariableCoordinater(BlockPos pos,Player player,Block block){
        player.sendSystemMessage(Component.literal("Found "+ I18n.get(block.getDescriptionId()) + "at" +
                "( "+pos.getX()+", "+pos.getY()+", "+pos.getZ()+" )"));
    }

    private boolean isValiableBlock(BlockState state){
        return state.is(Blocks.IRON_ORE) || state.is(Blocks.COAL_ORE) || state.is(Blocks.COPPER_ORE) ||
                state.is(Blocks.DEEPSLATE_IRON_ORE) || state.is(Blocks.DEEPSLATE_COAL_ORE) || state.is(Blocks.DEEPSLATE_COPPER_ORE);
    }
}
