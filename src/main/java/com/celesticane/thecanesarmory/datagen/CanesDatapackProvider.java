package com.celesticane.thecanesarmory.datagen;

import com.celesticane.thecanesarmory.CanesArmory;
import com.celesticane.thecanesarmory.enchantment.CanesEnchantments;
import com.celesticane.thecanesarmory.trim.CanesTrimPatterns;
import com.celesticane.thecanesarmory.worldgen.CanesBiomeModifiers;
import com.celesticane.thecanesarmory.worldgen.CanesConfiguredFeatures;
import com.celesticane.thecanesarmory.worldgen.CanesPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CanesDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TRIM_PATTERN, CanesTrimPatterns::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, CanesConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, CanesPlacedFeatures::bootstrap)
            .add(Registries.ENCHANTMENT, CanesEnchantments::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, CanesBiomeModifiers::bootstrap);


    public CanesDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(CanesArmory.MODID));
    }
}
