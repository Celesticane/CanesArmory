package com.celesticane.thecanesarmory.worldgen;

import com.celesticane.thecanesarmory.CanesArmory;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class CanesPlacedFeatures {
    public static final ResourceKey<PlacedFeature> PECULIAR_ORE_PLACER_L = registerKey("peculiar_placer_l");
    public static final ResourceKey<PlacedFeature> PECULIAR_ORE_PLACER_M = registerKey("peculiar_placer_m");
    public static final ResourceKey<PlacedFeature> PECULIAR_ORE_PLACER_S = registerKey("peculiar_placer_s");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, PECULIAR_ORE_PLACER_L, configuredFeatures.getOrThrow(CanesConfiguredFeatures.PECULIAR_ORE_KEY_L),
                CanesOrePlacement.commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.absolute(3), VerticalAnchor.absolute(89))));
        register(context, PECULIAR_ORE_PLACER_M, configuredFeatures.getOrThrow(CanesConfiguredFeatures.PECULIAR_ORE_KEY_M),
                CanesOrePlacement.commonOrePlacement(17, HeightRangePlacement.triangle(VerticalAnchor.absolute(3), VerticalAnchor.absolute(89))));
        register(context, PECULIAR_ORE_PLACER_S, configuredFeatures.getOrThrow(CanesConfiguredFeatures.PECULIAR_ORE_KEY_S),
                CanesOrePlacement.commonOrePlacement(189, HeightRangePlacement.uniform(VerticalAnchor.absolute(3), VerticalAnchor.absolute(89))));
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
    List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
