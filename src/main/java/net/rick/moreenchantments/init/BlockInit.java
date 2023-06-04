package net.rick.moreenchantments.init;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rick.moreenchantments.MoreEnchantments;
import net.rick.moreenchantments.block.ModdedCryingObsidian;
import net.rick.moreenchantments.block.ModdedObsidian;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreEnchantments.MOD_ID);
    public static final RegistryObject<Block> MODDED_OBSIDIAN = BLOCKS.register("modded_obsidian", ModdedObsidian::new);
    public static final RegistryObject<Block> MODDED_CRYING_OBSIDIAN = BLOCKS.register("modded_crying_obsidian", ModdedCryingObsidian::new);
}