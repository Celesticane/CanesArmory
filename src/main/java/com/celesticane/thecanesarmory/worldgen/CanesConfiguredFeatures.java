package com.celesticane.thecanesarmory.worldgen;

import com.celesticane.thecanesarmory.CanesArmory;
import com.celesticane.thecanesarmory.block.CanesBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.neoforged.neoforge.common.Tags;

public class CanesConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<? ,?>> PECULIAR_ORE_KEY_L = registerKey("peculiar_ore_l");
    public static final ResourceKey<ConfiguredFeature<? ,?>> PECULIAR_ORE_KEY_M = registerKey("peculiar_ore_m");
    public static final ResourceKey<ConfiguredFeature<? ,?>> PECULIAR_ORE_KEY_S = registerKey("peculiar_ore_s");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest endStoneReplaceables = new TagMatchTest(Tags.Blocks.END_STONES);

        register(context, PECULIAR_ORE_KEY_L, Feature.ORE, new OreConfiguration(endStoneReplaceables,
                CanesBlocks.PECULIAR_ORE.get().defaultBlockState(), 17, 0.95F));
        register(context, PECULIAR_ORE_KEY_M, Feature.ORE, new OreConfiguration(endStoneReplaceables,
                CanesBlocks.PECULIAR_ORE.get().defaultBlockState(), 7));
        register(context, PECULIAR_ORE_KEY_S, Feature.ORE, new OreConfiguration(endStoneReplaceables,
                CanesBlocks.PECULIAR_ORE.get().defaultBlockState(), 2));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
