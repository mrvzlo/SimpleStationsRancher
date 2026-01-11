package com.ave.simplestationsrancher.blockentity.modules;

import com.ave.simplestationsrancher.enums.ModuleType;
import com.ave.simplestationsrancher.registrations.Registrations;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TanningModuleEntity extends BaseModuleEntity {
    public TanningModuleEntity(BlockPos pos, BlockState state) {
        super(Registrations.TANNING_MODULE.getEntity(), pos, state, ModuleType.TANNING);
    }

}
