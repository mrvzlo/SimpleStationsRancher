package com.ave.simplestationsrancher.blockentity;

import com.ave.simplestationscore.mainblock.BaseStationBlock;
import com.ave.simplestationscore.partblock.PartialEntity;
import com.ave.simplestationscore.registrations.CoreRegistrations;
import com.ave.simplestationsrancher.blockentity.modules.BaseModuleBlock;
import com.ave.simplestationsrancher.blockentity.modules.BaseModuleEntity;
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
        for (int dx = -1; dx <= 1; ++dx)
            for (int dz = -1; dz <= 1; ++dz) {
                var p = pos.offset(dx, 0, dz);
                if (p.equals(pos))
                    continue;
                var isEdge = dx == 0 || dz == 0;
                var block = (isEdge ? CoreRegistrations.PART : Registrations.EMPTY_MODULE).getBlock()
                        .defaultBlockState();
                level.setBlock(p, block, 3);
                var be = level.getBlockEntity(p);
                if (be instanceof PartialEntity partial)
                    partial.setControllerPos(pos);
            }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (level.isClientSide)
            return;
        for (int dx = -1; dx <= 1; ++dx)
            for (int dz = -1; dz <= 1; ++dz) {
                if (dx == 0 || dz == 0)
                    continue;
                var p = pos.offset(dx, 0, dz);
                if (level.getBlockEntity(p) instanceof BaseModuleEntity partial)
                    BaseModuleBlock.dropModule(level, partial);
            }
        super.onRemove(state, level, pos, newState, isMoving);
    }
}
