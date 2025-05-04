package com.celesticane.thecanesarmory.item.custom;

import com.celesticane.thecanesarmory.item.CanesItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import javax.annotation.Nullable;

public class CompoundItem extends Item {
    public CompoundItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        @Nullable Player player = context.getPlayer();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(clickedBlock == Blocks.CRIMSON_NYLIUM) {
            if(!level.isClientSide) {
                level.setBlockAndUpdate(context.getClickedPos(), Blocks.WARPED_NYLIUM.defaultBlockState());
                if(!player.getAbilities().instabuild) {
                    context.getItemInHand().shrink(1);
                }
                level.playSound(null, context.getClickedPos(), SoundEvents.WART_BLOCK_PLACE, SoundSource.BLOCKS);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
}
