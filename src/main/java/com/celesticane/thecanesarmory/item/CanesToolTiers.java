package com.celesticane.thecanesarmory.item;

import com.celesticane.thecanesarmory.util.CanesTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.SimpleTier;

public class CanesToolTiers {
    public static final Tier ENCORIUM = new SimpleTier(CanesTags.Blocks.INCORRECT_FOR_ENCORIUM_TOOL, 2551, 10.0F, 6.0F, 18,
    () -> Ingredient.of(CanesItems.ENCORIUM_INGOT));

    public static final Tier OBSIDIAN = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 16, 8.0F, 5.0F, 12,
            () -> Ingredient.of(Blocks.OBSIDIAN));
}
