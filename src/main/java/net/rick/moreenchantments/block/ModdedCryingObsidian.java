package net.rick.moreenchantments.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.AGE_1;

public class ModdedCryingObsidian extends Block {

    public ModdedCryingObsidian() {
        super(Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(50.0f, 1200.0f).lightLevel((p_235435_0_) -> 10));
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE_1, Integer.valueOf(1)));
    }

    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource random) {
        if ((random.nextInt(3) == 0 && this.slightlyMelt(blockState, serverLevel, blockPos))) {

        } else {
            serverLevel.scheduleTick(blockPos, this, Mth.nextInt(random, 20, 40));
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE_1);
    }

    private boolean slightlyMelt(BlockState blockState, ServerLevel level, BlockPos blockPos) {
        int i = blockState.getValue(AGE_1);
        if (i < 1) {
            level.setBlock(blockPos, blockState.setValue(AGE_1, Integer.valueOf(i + 1)), 2);
            return false;
        } else {
            this.melt(blockState, level, blockPos);
            return true;
        }
    }

    private void melt(BlockState blockState, ServerLevel level, BlockPos blockPos) {
        level.setBlockAndUpdate(blockPos, Blocks.LAVA.defaultBlockState());
    }

}