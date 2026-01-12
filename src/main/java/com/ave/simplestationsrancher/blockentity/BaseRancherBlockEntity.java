package com.ave.simplestationsrancher.blockentity;

import com.ave.simplestationscore.mainblock.BaseStationBlockEntity;
import com.ave.simplestationscore.resources.EnergyResource;
import com.ave.simplestationscore.resources.FluidItemResource;
import com.ave.simplestationsrancher.Config;
import com.ave.simplestationsrancher.screen.BarnMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class BaseRancherBlockEntity extends BaseStationBlockEntity {
    public static final int FOOD_SLOT = 1;
    public static final int ANIMAL_SLOT = 2;

    public BaseRancherBlockEntity(BlockEntityType entity, BlockPos pos, BlockState state) {
        super(entity, pos, state);
        resources.put(FUEL_SLOT, new EnergyResource(Config.POWER_MAX.get(), 64, Config.FUEL_PER_COAL.get()));
        resources.put(FOOD_SLOT, new FluidItemResource(Config.MAX_FOOD.getAsInt(), 1, 200, "food"));
        resources.put(ANIMAL_SLOT, new FluidItemResource(Config.MAX_ANIMAL.get(), 1, 1, "animal"));
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

    @Override
    public BarnMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new BarnMenu(containerId, inventory, this);
    }
}
