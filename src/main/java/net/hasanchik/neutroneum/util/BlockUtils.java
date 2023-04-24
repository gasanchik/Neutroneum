package net.hasanchik.neutroneum.util;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class BlockUtils {

    public static BlockPos divideBlockPos( BlockPos position, int divisor) {
        return new BlockPos(position.getX()/divisor, position.getY()/divisor, position.getZ()/divisor);
    }

    public static BlockPos floorBlockPos( BlockPos position) {
        return new BlockPos(Mth.floor(position.getX()), Mth.floor(position.getY()), Mth.floor(position.getZ()));
    }

    public static BlockPos ceilBlockPos( BlockPos position) {
        return new BlockPos(Mth.ceil(position.getX()), Mth.ceil(position.getY()), Mth.ceil(position.getZ()));
    }

    public static BlockPos roundBlockPos( BlockPos position) {
        return new BlockPos(Mth.roundToward(position.getX(), 1), Mth.roundToward(position.getY(),1), Mth.roundToward(position.getZ(), 1));
    }

    public static BlockState[] getAllBlocksInRectangle(BlockPos position, BlockPos size, Boolean centered, Level level) {
        BlockPos startingPosition = position;
        if (centered) {
            startingPosition.subtract(divideBlockPos(size, 2));
        }
        BlockState[] blockList = new BlockState[size.getX()*size.getY()*size.getY()];
        int i = 0;
        for (int x = 0; x < size.getX(); x++) {
            for (int y = 0; y < size.getY(); y++) {
                for (int z = 0; z < size.getZ(); z++) {
                    BlockPos blockPosition = new BlockPos(x, y, z).offset(position);
                    //Prevent unnecessary chunk loading
                    if (level.isLoaded(blockPosition)) {
                        blockList[i] = level.getBlockState(blockPosition);
                    } else {
                        blockList[i] = Blocks.VOID_AIR.defaultBlockState();
                    }
                    i++;
                }
            }
        }

        return blockList;
    }
    public static BlockState[] getAllBlocksInBox(BlockPos position, int size, Boolean centered, Level level) {
        return getAllBlocksInRectangle(position, new BlockPos(size, size, size), centered, level);
    }
}