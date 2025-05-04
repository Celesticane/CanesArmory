package com.celesticane.thecanesarmory.util;

import com.celesticane.thecanesarmory.CanesArmory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CanesTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_ENCORIUM_TOOL = createTag("needs_encorium_tool");
        public static final TagKey<Block> INCORRECT_FOR_ENCORIUM_TOOL = createTag("incorrect_for_encorium_tool");

        private static TagKey<Block> createTag (String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> createTag (String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID, name));
        }
    }
}
