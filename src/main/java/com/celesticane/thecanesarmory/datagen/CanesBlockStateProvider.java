package com.celesticane.thecanesarmory.datagen;

import com.celesticane.thecanesarmory.CanesArmory;
import com.celesticane.thecanesarmory.block.CanesBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class CanesBlockStateProvider extends BlockStateProvider {
    public CanesBlockStateProvider(PackOutput output, ExistingFileHelper efh) {
        super(output, CanesArmory.MODID, efh);
    }


    @Override
    protected void registerStatesAndModels() {
        blockWithItem(CanesBlocks.ENCORIUM_BLOCK);
        blockWithItem(CanesBlocks.PREPOSTEROUS_BLOCK);
        blockWithItem(CanesBlocks.PECULIAR_ORE);

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
