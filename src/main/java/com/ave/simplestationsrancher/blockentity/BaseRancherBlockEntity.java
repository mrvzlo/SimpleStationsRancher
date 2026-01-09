package com.ave.simplestationsrancher.blockentity;

import com.ave.simplestationscore.mainblock.BaseStationBlockEntity;
import com.ave.simplestationscore.resources.FluidResource;
import com.ave.simplestationscore.resources.StationResource;
import com.ave.simplestationsrancher.Config;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class BaseRancherBlockEntity extends BaseStationBlockEntity {
    public static final int OUTPUT_COUNT = 4;
    public static final int MODULE_SLOT = OUTPUT_COUNT + OUTPUT_SLOT;
    public static final int MODULE_COUNT = 4;
    public static final int FOOD_SLOT = MODULE_SLOT + MODULE_COUNT;

    public BaseRancherBlockEntity(BlockEntityType entity, BlockPos pos, BlockState state) {
        super(entity, pos, state);
    }

    public int getMaxProgress() {
        return Config.MAX_PROGRESS.getAsInt();
    }

    protected int getCurrentType() {
        return -1;
    }

    @Override
    public ItemStack getProduct(boolean check) {
        var type = getCurrentType();

        return ItemStack.EMPTY;
    }

    protected abstract int getTypeBySeed(Item item);
}
