package com.celesticane.thecanesarmory.datagen;

import com.celesticane.thecanesarmory.CanesArmory;
import com.celesticane.thecanesarmory.block.CanesBlocks;
import com.celesticane.thecanesarmory.util.CanesTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.internal.NeoForgeItemTagsProvider;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class CanesBlockTagProvider extends BlockTagsProvider {
    public CanesBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper efh) {
        super(output, lookupProvider, CanesArmory.MODID, efh);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.DRAGON_IMMUNE)
                .add(CanesBlocks.PECULIAR_ORE.get())
                .add(CanesBlocks.PREPOSTEROUS_BLOCK.get())
                .add(CanesBlocks.PECULIAR_SCAFFOLDING.get())
                .add(CanesBlocks.ENCORIUM_BLOCK.get());
        tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(CanesBlocks.ENCORIUM_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(CanesBlocks.ENCORIUM_BLOCK.get())
                .add(CanesBlocks.PECULIAR_ORE.get());
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(CanesBlocks.PREPOSTEROUS_BLOCK.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(CanesBlocks.ENCORIUM_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(CanesBlocks.PECULIAR_ORE.get());
        tag(BlockTags.CLIMBABLE)
                .add(CanesBlocks.PECULIAR_SCAFFOLDING.get());

        tag(CanesTags.Blocks.NEEDS_ENCORIUM_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

    }
}
