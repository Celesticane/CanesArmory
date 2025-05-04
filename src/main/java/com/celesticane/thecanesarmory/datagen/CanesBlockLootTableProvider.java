package com.celesticane.thecanesarmory.datagen;

import com.celesticane.thecanesarmory.block.CanesBlocks;
import com.celesticane.thecanesarmory.item.CanesItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class CanesBlockLootTableProvider extends BlockLootSubProvider {

    protected CanesBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(CanesBlocks.ENCORIUM_BLOCK.get());
        dropSelf(CanesBlocks.PREPOSTEROUS_BLOCK.get());
        dropSelf(CanesBlocks.PECULIAR_SCAFFOLDING.get());
        dropWhenSilkTouch(CanesBlocks.ENDER_GLASS.get());
        add(CanesBlocks.PECULIAR_ORE.get(),
                block -> createMultipleOreDrops(CanesBlocks.PECULIAR_ORE.get(), CanesItems.PECULIAR_SHARD.get(), 2, 5));

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CanesBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
