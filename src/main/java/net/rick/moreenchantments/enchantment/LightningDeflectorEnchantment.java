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
            System.out.println("say Damage source is lightning");
            if (level == 1) {
                int protection = (int) 33.3F;
                System.out.println("Protection level 1: " + protection + "%");
                return protection;
            } else if (level == 2) {
                int protection = (int) 77.7F;
                System.out.println("Protection level 2: " + protection + "%");
                return protection;
            } else if (level == 3) {
                int protection = (int) 199.9F;
                System.out.println("Protection level 3: " + protection + "%");
                return protection;
            }
        }

        return (int) 0.0F;
    }
}

