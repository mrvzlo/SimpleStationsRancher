package com.ave.simplestationsrancher.blockentity;

import com.ave.simplestationscore.resources.FluidResource;
import com.ave.simplestationsrancher.Config;
import com.ave.simplestationsrancher.blockentity.handlers.DarkFarmItemHandler;
import com.ave.simplestationsrancher.blockentity.handlers.OptionalEnergyResource;
import com.ave.simplestationsrancher.recipes.ModRecipes;
import com.ave.simplestationsrancher.registrations.Registrations;
import com.ave.simplestationsrancher.screen.DarkFarmStationMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class BarnEntity extends BaseRancherBlockEntity {
    public static final int LavaUsage = Config.WATER_PER_CYCLE.get() / 100;

    public BarnEntity(BlockPos pos, BlockState state) {
        super(Registrations.DARK_FARMER.getEntity(), pos, state);

        resources.put(FUEL_SLOT, new OptionalEnergyResource(3));
        resources.put(FLUID_SLOT, new FluidResource(Fluids.LAVA, Config.FLUID_MAX.get(), LavaUsage));

        inventory = new DarkFarmItemHandler(5) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }
        };
    }

    @Override
    public DarkFarmStationMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new DarkFarmStationMenu(containerId, inventory, this);
    }

    public SoundEvent getWorkSound() {
        return SoundEvents.WART_BLOCK_BREAK;
    }

    protected int getTypeBySeed(Item filter) {
        var type = ModRecipes.darkCropToInt.get(filter);
        return type == null ? -1 : type;
    }
}
