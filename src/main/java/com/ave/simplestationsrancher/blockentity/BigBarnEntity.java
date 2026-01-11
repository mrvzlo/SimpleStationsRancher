package com.ave.simplestationsrancher.blockentity;

import com.ave.simplestationsrancher.blockentity.handlers.BigBarnItemHandler;
import com.ave.simplestationsrancher.registrations.Registrations;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;

public class BigBarnEntity extends BaseRancherBlockEntity {

    public BigBarnEntity(BlockPos pos, BlockState state) {
        super(Registrations.BARN.getEntity(), pos, state);

        inventory = new BigBarnItemHandler(3) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }
        };
    }

    public SoundEvent getWorkSound() {
        return SoundEvents.COW_AMBIENT;
    }

    @Override
    protected int getTypeBySeed(Item item) {
        return -1;
    }
}
