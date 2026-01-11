package com.ave.simplestationsrancher.blockentity.modules;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SlaughteringModuleBlock extends BaseModuleBlock {
    public SlaughteringModuleBlock(Properties props) {
        super(props);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SlaughteringModuleEntity(pos, state);
    }
}
