package net.rick.moreenchantments.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rick.moreenchantments.MoreEnchantments;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreEnchantments.MOD_ID);
    public static final RegistryObject<Item> MODDED_OBSIDIAN = ITEMS.register("modded_obsidian", () -> new BlockItem(BlockInit.MODDED_OBSIDIAN.get(), new Item.Properties()));
    public static final RegistryObject<Item> MODDED_CRYING_OBSIDIAN = ITEMS.register("modded_crying_obsidian", () -> new BlockItem(BlockInit.MODDED_CRYING_OBSIDIAN.get(), new Item.Properties()));
}