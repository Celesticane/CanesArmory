package com.celesticane.thecanesarmory.block;

import com.celesticane.thecanesarmory.CanesArmory;
import com.celesticane.thecanesarmory.block.custom.PecScaffoldingBlock;
import com.celesticane.thecanesarmory.item.CanesItems;
import com.celesticane.thecanesarmory.item.custom.PecScaffoldingBlockItem;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CanesBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CanesArmory.MODID);

    public static final DeferredBlock<Block> PECULIAR_ORE = registerBlock("peculiar_ore", () -> new DropExperienceBlock(UniformInt.of(2,5), BlockBehaviour.Properties.of().lightLevel(blockState -> 2).requiresCorrectToolForDrops().strength(5, 9)), false);
    public static final DeferredBlock<Block> PREPOSTEROUS_BLOCK = registerBlock("preposterous_block", () -> new Block(BlockBehaviour.Properties.of().lightLevel(blockState -> 2).sound(SoundType.HONEY_BLOCK).friction(0.88F).strength(3.2F)), false, 89);
    public static final DeferredBlock<Block> ENCORIUM_BLOCK = registerBlock("encorium_block", () -> new Block(BlockBehaviour.Properties.of().strength(65, 1500).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)), true, Rarity.UNCOMMON);
    public static final DeferredBlock<Block> PECULIAR_SCAFFOLDING = registerPecScaffoldingBlock("peculiar_scaffolding", () -> new PecScaffoldingBlock(BlockBehaviour.Properties.of().strength(0).sound(SoundType.SCAFFOLDING).noCollission().dynamicShape().isValidSpawn(Blocks::never).pushReaction(PushReaction.DESTROY)), false, 89);
    public static final DeferredBlock<Block> ENDER_GLASS = registerBlock("ender_glass", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)), false);

    //The original draft of this segment of code was graciously offered by ZestyBlaze from the Mystic Modding community
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, Boolean fireproof, Rarity rarity) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        if(fireproof) {
            registerFireproofBlockItem(name, toReturn, 64, rarity);
        } else {
            registerBlockItem(name, toReturn, 64, rarity);
        }
        return toReturn;
    }
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, Boolean fireproof, int stackSize, Rarity rarity) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        if (fireproof) {
            registerFireproofBlockItem(name, toReturn, stackSize, rarity);
        } else {
            registerBlockItem(name, toReturn, stackSize, rarity);
        }
        return toReturn;
    }
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, Boolean fireproof, int stackSize) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        if (fireproof) {
            registerFireproofBlockItem(name, toReturn, stackSize, Rarity.COMMON);
        } else {
            registerBlockItem(name, toReturn, stackSize, Rarity.COMMON);
        }
        return toReturn;
    }
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, Boolean fireproof) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        if (fireproof) {
            registerFireproofBlockItem(name, toReturn, 64, Rarity.COMMON);
        } else {
            registerBlockItem(name, toReturn, 64, Rarity.COMMON);
        }
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> registerPecScaffoldingBlock(String name, Supplier<T> block, Boolean fireproof, int stackSize) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerScaffoldingItem(name, toReturn, stackSize, Rarity.COMMON);
        return toReturn;
    }

    private static <T extends Block> void registerFireproofBlockItem(String name, DeferredBlock<T> block, int stackSize, Rarity rarity) {
        CanesItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(stackSize).fireResistant().rarity(rarity)));
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, int stackSize, Rarity rarity) {
        CanesItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(stackSize).rarity(rarity)));
    }

    private static <T extends Block> void registerScaffoldingItem(String name, DeferredBlock<T> block, int stackSize, Rarity rarity) {
        CanesItems.ITEMS.register(name, () -> new PecScaffoldingBlockItem(block.get(), new Item.Properties().stacksTo(stackSize).rarity(rarity)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
