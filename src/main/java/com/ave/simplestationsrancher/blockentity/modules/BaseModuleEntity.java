package com.ave.simplestationsrancher.blockentity.modules;

import com.ave.simplestationscore.handlers.CommonItemHandler;
import com.ave.simplestationscore.mainblock.BaseStationBlockEntity;
import com.ave.simplestationscore.partblock.PartialEntity;
import com.ave.simplestationscore.registrations.Station;
import com.ave.simplestationsrancher.Config;
import com.ave.simplestationsrancher.enums.ModuleType;
import com.ave.simplestationsrancher.registrations.Registrations;
import com.ave.simplestationsrancher.screen.ModuleMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class BaseModuleEntity extends BaseStationBlockEntity implements PartialEntity {
    private BlockPos controllerPos;
    public static final int OUTPUT_SLOT = 0;
    private final Station<?, ?> station;

    public BaseModuleEntity(BlockPos pos, BlockState state) {
        this(Registrations.EMPTY_MODULE, pos, state, ModuleType.EMPTY);
    }

    public BaseModuleEntity(Station<?, ?> station, BlockPos pos, BlockState state, ModuleType type) {
        super(station.getEntity(), pos, state);
        this.type = type.id;
        this.station = station;

        inventory = new CommonItemHandler(1) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, ItemStack stack) {
                return false;
            }
        };
    }

    public void setControllerPos(BlockPos pos) {
        controllerPos = pos;
        setChanged();
    }

    public BlockPos getControllerPos() {
        return controllerPos;
    }

    @Override
    public ModuleMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new ModuleMenu(containerId, inventory, this);
    }

    @Override
    protected int getCurrentType() {
        return type;
    }

    @Override
    public int getMaxProgress() {
        return Config.MAX_PROGRESS.getAsInt();
    }

    @Override
    public ItemStack getProduct(boolean __) {
        // TODO Auto-generated method stub

        throw new UnsupportedOperationException("Unimplemented method 'getProduct'");
    }

    @Override
    public SoundEvent getWorkSound() {
        return null;
    }

    public Component getTitle() {
        return this.station.getBlock().getName();
    }

    @Override
    protected void saveAll(CompoundTag tag) {
        super.saveAll(tag);
        if (controllerPos != null)
            tag.putLong("Controller", controllerPos.asLong());
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        controllerPos = BlockPos.of(tag.getLong("Controller"));
    }
}
