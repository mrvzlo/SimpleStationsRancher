package com.ave.simplestationsrancher.screen;

import com.ave.simplestationscore.mainblock.StationContainer;
import com.ave.simplestationscore.screen.BaseStationMenu;
import com.ave.simplestationsrancher.blockentity.modules.BaseModuleEntity;
import com.ave.simplestationsrancher.registrations.Registrations;
import com.ave.simplestationsrancher.uihelpers.UIBlocks;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;

public class ModuleMenu extends BaseStationMenu {

    public ModuleMenu(int containerId, Inventory inventory, FriendlyByteBuf data) {
        super(containerId, inventory, data, Registrations.MODULE_MENU.get());
    }

    public ModuleMenu(int containerId, Inventory inventory, StationContainer be) {
        super(containerId, inventory, be, Registrations.MODULE_MENU.get());
    }

    @Override
    public void addItemSlots() {
        addItemSlot(blockEntity.inventory, BaseModuleEntity.OUTPUT_SLOT, UIBlocks.OUTPUT);
    }

    @Override
    public boolean stillValid(Player player) {
        return blockEntity instanceof BaseModuleEntity && player.canInteractWithBlock(blockEntity.getBlockPos(), 4);
    }
}
