package com.celesticane.thecanesarmory.trim;

import com.celesticane.thecanesarmory.CanesArmory;
import com.celesticane.thecanesarmory.item.CanesItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.neoforged.neoforge.registries.DeferredItem;

public class CanesTrimPatterns {
    public static final ResourceKey<TrimPattern> CURIOUS = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID, "curious"));

    public static void bootstrap(BootstrapContext<TrimPattern> context) {
        register(context, CanesItems.CURIOUS_SMITHING_TEMPLATE, CURIOUS);
    }

    private static void register(BootstrapContext<TrimPattern> context, DeferredItem<Item> item, ResourceKey<TrimPattern> key) {
        TrimPattern trimPattern = new TrimPattern(key.location(), item.getDelegate(),
                Component.translatable(Util.makeDescriptionId("trim_pattern", key.location())), false);
        context.register(key, trimPattern);
    }
}
