package com.ave.simplestationsrancher.blockentity;

import com.ave.simplestationscore.mainblock.BaseStationBlock;
import com.ave.simplestationscore.partblock.PartialEntity;
import com.ave.simplestationscore.registrations.CoreRegistrations;
import com.ave.simplestationsrancher.registrations.Registrations;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public abstract class BaseRancherBlock extends BaseStationBlock {
    public BaseRancherBlock(Properties props) {
        super(props);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean moving) {
        if (level.isClientSide)
            return;
        resetNeighboors(level, pos);
    }

    public static void resetNeighboors(Level level, BlockPos pos) {
        for (int dx = -1; dx <= 1; ++dx)
            for (int dz = -1; dz <= 1; ++dz) {
                if (dx == 0 && dz == 0)
                    continue;
                var neighboor = pos.offset(dx, 0, dz);
                if (level.getBlockEntity(neighboor) instanceof PartialEntity)
                    continue;
                var isEdge = dx == 0 || dz == 0;
                var block = (isEdge ? CoreRegistrations.PART : Registrations.EMPTY_MODULE)
                        .getBlock().defaultBlockState();
                level.setBlock(neighboor, block, 3);
                var be = level.getBlockEntity(neighboor);
                if (be instanceof PartialEntity partial)
                    partial.setControllerPos(pos);
            }
    }
}
