package com.ave.simplestationsrancher.blockentity;

import com.ave.simplestationsrancher.blockentity.handlers.BarnItemHandler;
import com.ave.simplestationsrancher.registrations.Registrations;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;

public class BarnEntity extends BaseRancherBlockEntity {

    public BarnEntity(BlockPos pos, BlockState state) {
        super(Registrations.BARN.getEntity(), pos, state);

        inventory = new BarnItemHandler(2) {
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
    public AbstractContainerMenu createMenu(int arg0, Inventory arg1, Player arg2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createMenu'");
    }

    @Override
    protected int getTypeBySeed(Item item) {
        return -1;
    }
}
