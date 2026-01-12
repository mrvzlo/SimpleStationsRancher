package com.ave.simplestationsrancher.blockentity.modules;

import com.ave.simplestationsrancher.enums.ModuleType;
import com.ave.simplestationsrancher.registrations.Registrations;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class FishingModuleEntity extends BaseModuleEntity {
    public FishingModuleEntity(BlockPos pos, BlockState state) {
        super(Registrations.FISHING_MODULE, pos, state, ModuleType.FISHING);
    }
}
