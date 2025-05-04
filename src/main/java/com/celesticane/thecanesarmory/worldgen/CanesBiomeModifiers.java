package com.celesticane.thecanesarmory.worldgen;

import com.celesticane.thecanesarmory.CanesArmory;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.biome.EndBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class CanesBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_PECULIAR_ORE_L = registerKey("add_peculiar_ore_l");
    public static final ResourceKey<BiomeModifier> ADD_PECULIAR_ORE_M = registerKey("add_peculiar_ore_m");
    public static final ResourceKey<BiomeModifier> ADD_PECULIAR_ORE_S = registerKey("add_peculiar_ore_s");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_PECULIAR_ORE_L, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.END_HIGHLANDS), biomes.getOrThrow(Biomes.END_MIDLANDS), biomes.getOrThrow(Biomes.END_BARRENS)),
                HolderSet.direct(placedFeatures.getOrThrow(CanesPlacedFeatures.PECULIAR_ORE_PLACER_L)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_PECULIAR_ORE_M, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.THE_END), biomes.getOrThrow(Biomes.END_HIGHLANDS), biomes.getOrThrow(Biomes.END_MIDLANDS), biomes.getOrThrow(Biomes.END_BARRENS)),
                HolderSet.direct(placedFeatures.getOrThrow(CanesPlacedFeatures.PECULIAR_ORE_PLACER_M)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_PECULIAR_ORE_S, new BiomeModifiers.AddFeaturesBiomeModifier(
            biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(CanesPlacedFeatures.PECULIAR_ORE_PLACER_S)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID, name));
    }
}
