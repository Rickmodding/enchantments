package net.rick.moreenchantments.enchantment;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LightningDeflectorEnchantment extends Enchantment {
    public LightningDeflectorEnchantment(Rarity pRarity) {
        super(pRarity, EnchantmentCategory.ARMOR_HEAD, new EquipmentSlot[] {EquipmentSlot.HEAD});
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isTradeable() {
        return super.isTradeable();
    }

    @Override
    public boolean isAllowedOnBooks() {
        return super.isAllowedOnBooks();
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return super.canApplyAtEnchantingTable(stack);
    }

    @Override
    public boolean canEnchant(ItemStack p_44689_) {
        return super.canEnchant(p_44689_);
    }

    @Override
    public int getDamageProtection(int level, DamageSource source) {
        if (source.is(DamageTypeTags.IS_LIGHTNING)) {
            if (level == 1) {
                int protection = (int) 33.3F;
                return protection;
            } else if (level == 2) {
                int protection = (int) 77.7F;
                return protection;
            } else if (level == 3) {
                int protection = (int) 9999.9F;
                return protection;
            }
        }

        return (int) 0.0F;
    }
}

