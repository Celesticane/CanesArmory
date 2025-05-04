package com.celesticane.thecanesarmory.block.custom;

import com.celesticane.thecanesarmory.block.CanesBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ScaffoldingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Iterator;

public class PecScaffoldingBlock extends ScaffoldingBlock {

    public PecScaffoldingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        Level level = context.getLevel();
        int i = getDist2(level, blockpos);
        return (BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue(WATERLOGGED, level.getFluidState(blockpos).getType() == Fluids.WATER)).setValue(DISTANCE, i)).setValue(BOTTOM, this.isBottom(level, blockpos, i));
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int i = getDist2(level, pos);
        BlockState blockstate = (BlockState)((BlockState)state.setValue(DISTANCE, i)).setValue(BOTTOM, this.isBottom(level, pos, i));
        if ((Integer)blockstate.getValue(DISTANCE) == 7) {
            if ((Integer)state.getValue(DISTANCE) == 7) {
                FallingBlockEntity.fall(level, pos, blockstate);
            } else {
                level.destroyBlock(pos, true);
            }
        } else if (state != blockstate) {
            level.setBlock(pos, blockstate, 3);
        }

    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return getDist2(level, pos) < 7;
    }

    private boolean isBottom(BlockGetter level, BlockPos pos, int distance) {
        return distance > 0 && !level.getBlockState(pos.below()).is(this);
    }

    public static int getDist2(BlockGetter level, BlockPos pos) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable().move(Direction.DOWN);
        BlockState blockstate = level.getBlockState(blockpos$mutableblockpos);
        int i = 7;
        if (blockstate.is(CanesBlocks.PECULIAR_SCAFFOLDING.get())) {
            i = (Integer) blockstate.getValue(DISTANCE);
        } else if (blockstate.isFaceSturdy(level, blockpos$mutableblockpos, Direction.UP)) {
            return 0;
        }

        Iterator var5 = Direction.Plane.HORIZONTAL.iterator();

        while (var5.hasNext()) {
            Direction direction = (Direction) var5.next();
            BlockState blockstate1 = level.getBlockState(blockpos$mutableblockpos.setWithOffset(pos, direction));
            if (blockstate1.is(CanesBlocks.PECULIAR_SCAFFOLDING.get())) {
                i = Math.min(i, (Integer) blockstate1.getValue(DISTANCE) + 1);
                if (i == 1) {
                    break;
                }
            }
        }

        return i;
    }


}
