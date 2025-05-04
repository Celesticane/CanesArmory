package com.celesticane.thecanesarmory.enchantment;

import com.celesticane.thecanesarmory.CanesArmory;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.Enchantments;

public class CanesEnchantments {
    public static final ResourceKey<Enchantment> SCULK_HARVEST = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID, "sculk_harvest"));

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        register(context, SCULK_HARVEST,Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(ItemTags.HOES),
                1,
                4,
                Enchantment.dynamicCost(3, 4),
                Enchantment.dynamicCost(19, 4),
                3,
                EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.MINING_EXCLUSIVE)));
    }

    public static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key, Enchantment.Builder builder) {

    }
}
