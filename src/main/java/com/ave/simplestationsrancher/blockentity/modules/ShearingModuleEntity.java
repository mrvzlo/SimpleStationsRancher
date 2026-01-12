package com.ave.simplestationsrancher.blockentity.modules;

import com.ave.simplestationsrancher.enums.ModuleType;
import com.ave.simplestationsrancher.registrations.Registrations;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class ShearingModuleEntity extends BaseModuleEntity {
    public ShearingModuleEntity(BlockPos pos, BlockState state) {
        super(Registrations.SHEARING_MODULE, pos, state, ModuleType.SHEARING);
    }
}
