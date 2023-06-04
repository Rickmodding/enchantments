package net.rick.moreenchantments.init;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rick.moreenchantments.MoreEnchantments;
import net.rick.moreenchantments.enchantment.LavaWalkerEnchantment;

public class EnchantmentInit {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MoreEnchantments.MOD_ID);
    public static final RegistryObject<Enchantment> LAVA_WALKER = ENCHANTMENTS.register("lava_walker", () -> new LavaWalkerEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.FEET));
}