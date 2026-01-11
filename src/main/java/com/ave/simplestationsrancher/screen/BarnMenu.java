package com.ave.simplestationsrancher.screen;

import com.ave.simplestationscore.mainblock.BaseStationBlockEntity;
import com.ave.simplestationscore.mainblock.StationContainer;
import com.ave.simplestationscore.screen.BaseStationMenu;
import com.ave.simplestationscore.screen.DataSlotHelper;
import com.ave.simplestationsrancher.blockentity.BaseRancherBlockEntity;
import com.ave.simplestationsrancher.registrations.Registrations;
import com.ave.simplestationsrancher.uihelpers.UIBlocks;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;

public class BarnMenu extends BaseStationMenu {
    public BarnMenu(int containerId, Inventory inventory, FriendlyByteBuf data) {
        super(containerId, inventory, data, Registrations.BARN_MENU.get());
    }

    public BarnMenu(int containerId, Inventory inventory, StationContainer be) {
        super(containerId, inventory, be, Registrations.BARN_MENU.get());
    }

    @Override
    public void addItemSlots() {
        addItemSlot(blockEntity.inventory, BaseRancherBlockEntity.FUEL_SLOT, UIBlocks.POWER_SLOT);
        addItemSlot(blockEntity.inventory, BaseRancherBlockEntity.OUTPUT_SLOT, UIBlocks.FOOD_SLOT);
        addItemSlot(blockEntity.inventory, BaseRancherBlockEntity.ANIMAL_SLOT, UIBlocks.FILTER_SLOT);
    }

    @Override
    public void addDataSlots(BaseStationBlockEntity station) {
        var barn = (BaseRancherBlockEntity) station;
        super.addDataSlots(station);
        var food = barn.resources.get(BaseRancherBlockEntity.FOOD_SLOT);
        var animal = barn.resources.get(BaseRancherBlockEntity.ANIMAL_SLOT);
        addDataSlot(DataSlotHelper.fromInt(() -> food.get(), x -> food.set(x)));
        addDataSlot(DataSlotHelper.fromInt(() -> animal.get(), x -> animal.set(x)));
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player,
                Registrations.BARN.getBlock());
    }
}
