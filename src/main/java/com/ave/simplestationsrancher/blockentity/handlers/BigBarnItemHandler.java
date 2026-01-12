package com.ave.simplestationsrancher.blockentity.handlers;

import com.ave.simplestationscore.handlers.CommonItemHandler;
import com.ave.simplestationsrancher.blockentity.BaseRancherBlockEntity;
import com.ave.simplestationsrancher.datagen.ModTags;
import com.ave.simplestationsrancher.registrations.Registrations;

import net.minecraft.world.item.ItemStack;

public class BigBarnItemHandler extends CommonItemHandler {

    public BigBarnItemHandler(int size) {
        super(size);
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
        if (slot == BaseRancherBlockEntity.ANIMAL_SLOT)
            return stack.is(Registrations.COW_LURE) || stack.is(Registrations.SHEEP_LURE)
                    || stack.is(Registrations.PIG_LURE);
        if (slot == BaseRancherBlockEntity.FOOD_SLOT)
            return stack.is(ModTags.BIG_BARN_FOOD);
        return super.isItemValid(slot, stack);
    }

    @Override
    public int getSlotLimit(int slot) {
        if (slot == BaseRancherBlockEntity.ANIMAL_SLOT)
            return 1;
        return super.getSlotLimit(slot);
    }
}