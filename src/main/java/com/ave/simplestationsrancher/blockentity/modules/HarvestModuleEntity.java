package com.ave.simplestationsrancher.blockentity.modules;

import com.ave.simplestationsrancher.enums.ModuleType;
import com.ave.simplestationsrancher.registrations.Registrations;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class HarvestModuleEntity extends BaseModuleEntity {
    public HarvestModuleEntity(BlockPos pos, BlockState state) {
        super(Registrations.HARVEST_MODULE.getEntity(), pos, state, ModuleType.HARVEST);
    }

}
