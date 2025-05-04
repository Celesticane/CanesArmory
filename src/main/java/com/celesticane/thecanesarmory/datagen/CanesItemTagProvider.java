package com.celesticane.thecanesarmory.datagen;

import com.celesticane.thecanesarmory.CanesArmory;
import com.celesticane.thecanesarmory.item.CanesItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.minecraft.world.level.block.Block;


import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class CanesItemTagProvider extends ItemTagsProvider {
    public CanesItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper efh) {
     super(output, lookupProvider, blockTags, CanesArmory.MODID, efh);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(CanesItems.ENCORIUM_INGOT.get());
        tag(ItemTags.SWORDS)
                .add(CanesItems.OBSIDIAN_SWORD.get())
                .add(CanesItems.ENCORIUM_SWORD.get());
        tag(ItemTags.SHOVELS)
                .add(CanesItems.ENCORIUM_SHOVEL.get());
        tag(ItemTags.PICKAXES)
                .add(CanesItems.ENCORIUM_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(CanesItems.ENCORIUM_AXE.get());
        tag(ItemTags.HOES)
                .add(CanesItems.ENCORIUM_HOE.get());
        tag(ItemTags.HEAD_ARMOR)
                .add(CanesItems.ENCORIUM_HELMET.get());
        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(CanesItems.ENCORIUM_HELMET.get());
        tag(ItemTags.CHEST_ARMOR)
                .add(CanesItems.ENCORIUM_CHESTPLATE.get());
        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(CanesItems.ENCORIUM_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR)
                .add(CanesItems.ENCORIUM_LEGGINGS.get());
        tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(CanesItems.ENCORIUM_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR)
                .add(CanesItems.ENCORIUM_BOOTS.get());
        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(CanesItems.ENCORIUM_BOOTS.get());


        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(CanesItems.ENCORIUM_HELMET.get())
                .add(CanesItems.ENCORIUM_CHESTPLATE.get())
                .add(CanesItems.ENCORIUM_LEGGINGS.get())
                .add(CanesItems.ENCORIUM_BOOTS.get());

        this.tag(ItemTags.TRIM_TEMPLATES)
                .add(CanesItems.CURIOUS_SMITHING_TEMPLATE.get());
    }
}
