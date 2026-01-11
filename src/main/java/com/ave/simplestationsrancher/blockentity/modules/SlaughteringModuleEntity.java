package com.ave.simplestationsrancher.blockentity.modules;

import com.ave.simplestationsrancher.enums.ModuleType;
import com.ave.simplestationsrancher.registrations.Registrations;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class SlaughteringModuleEntity extends BaseModuleEntity {
    public SlaughteringModuleEntity(BlockPos pos, BlockState state) {
        super(Registrations.SLAUGHTERING_MODULE.getEntity(), pos, state, ModuleType.SLAUGHTERING);
    }

}
