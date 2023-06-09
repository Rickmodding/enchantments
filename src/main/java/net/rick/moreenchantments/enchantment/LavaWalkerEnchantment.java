package net.rick.moreenchantments.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.rick.moreenchantments.init.BlockInit;

public class LavaWalkerEnchantment extends Enchantment {
    public LavaWalkerEnchantment(Enchantment.Rarity p_45013_, EquipmentSlot... p_45014_) {
        super(p_45013_, EnchantmentCategory.ARMOR_FEET, p_45014_);
    }

    public int getMinCost(int p_45017_) {
        return p_45017_ * 10;
    }

    public int getMaxCost(int p_45027_) {
        return this.getMinCost(p_45027_) + 15;
    }

    public boolean isTreasureOnly() {
        return true;
    }

    public int getMaxLevel() {
        return 2;
    }

    public static void onEntityMoved(LivingEntity livingEntity, Level level, BlockPos blockPos, int enchantmentLevel) {
        if (livingEntity.isOnGround()) {
            BlockState blockstate = BlockInit.MODDED_OBSIDIAN.get().defaultBlockState();
            float f = 2 + enchantmentLevel;
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            for (BlockPos blockpos : BlockPos.betweenClosed(blockPos.offset((int) -f, (int) -1.0D, (int) -f), blockPos.offset((int) f, (int) -1.0D, (int) f))) {
                if (blockpos.closerToCenterThan(livingEntity.position(), (double) f)) {
                    blockpos$mutableblockpos.set(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
                    BlockState blockstate1 = level.getBlockState(blockpos$mutableblockpos);
                    if (blockstate1.isAir()) {
                        BlockState blockstate2 = level.getBlockState(blockpos);
                        boolean isFull = blockstate2.getBlock() == Blocks.LAVA && blockstate2.getValue(LiquidBlock.LEVEL) == 0;
                        if (blockstate2.getMaterial() == Material.LAVA && isFull && blockstate.canSurvive(level, blockpos) && level.isUnobstructed(blockstate, blockpos, CollisionContext.empty()) && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(livingEntity, net.minecraftforge.common.util.BlockSnapshot.create(level.dimension(), level, blockpos), net.minecraft.core.Direction.UP)) {
                            level.setBlockAndUpdate(blockpos, blockstate);
                            level.scheduleTick(blockpos, BlockInit.MODDED_OBSIDIAN.get(), Mth.nextInt(level.getRandom(), 20, 40));
                        }
                    }
                }
            }

        }
    }
}

