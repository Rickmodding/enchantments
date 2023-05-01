package net.rick.moreenchantments.enchantment;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LightningDeflectorEnchantment extends Enchantment {
    public LightningDeflectorEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, new EquipmentSlot[] {EquipmentSlot.HEAD});
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getDamageProtection(int level, DamageSource source) {
        if (source.is(DamageTypeTags.IS_LIGHTNING)) {
            if (level == 1) {
                return (int) 0.25F;
            } else if (level == 2) {
                return (int) 0.5F;
            } else if (level == 3) {
                return (int) 1.0F;
            }
        }
        return (int) 0.0F;
    }
}

