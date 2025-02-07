package net.felsstudio.tfw.block.gargia;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class GargiaLeavesBlock extends LeavesBlock {
    public GargiaLeavesBlock() {
        super(BlockBehaviour.Properties.of().ignitedByLava().sound(SoundType.GRASS).strength(0.4f).noOcclusion());
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 1;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }
}
