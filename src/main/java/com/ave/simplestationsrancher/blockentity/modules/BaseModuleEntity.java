package com.ave.simplestationsrancher.blockentity.modules;

import com.ave.simplestationscore.handlers.CommonItemHandler;
import com.ave.simplestationscore.mainblock.BaseStationBlockEntity;
import com.ave.simplestationscore.partblock.PartialEntity;
import com.ave.simplestationsrancher.Config;
import com.ave.simplestationsrancher.enums.ModuleType;
import com.ave.simplestationsrancher.registrations.Registrations;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BaseModuleEntity extends BaseStationBlockEntity implements PartialEntity {
    private BlockPos controllerPos;

    public BaseModuleEntity(BlockPos pos, BlockState state) {
        this(Registrations.EMPTY_MODULE.getEntity(), pos, state, ModuleType.EMPTY);
    }

    public BaseModuleEntity(BlockEntityType bet, BlockPos pos, BlockState state, ModuleType type) {
        super(bet, pos, state);
        this.type = type.id;

        inventory = new CommonItemHandler(2) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
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
    public AbstractContainerMenu createMenu(int arg0, Inventory arg1, Player arg2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createMenu'");
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
