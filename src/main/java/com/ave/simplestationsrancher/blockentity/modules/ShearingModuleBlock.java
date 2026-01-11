package com.ave.simplestationsrancher.blockentity.modules;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ShearingModuleBlock extends BaseModuleBlock {
    public ShearingModuleBlock(Properties props) {
        super(props);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ShearingModuleEntity(pos, state);
    }
}
