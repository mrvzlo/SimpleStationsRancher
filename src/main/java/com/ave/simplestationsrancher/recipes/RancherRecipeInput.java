package com.ave.simplestationsrancher.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record RancherRecipeInput(ItemStack module, ItemStack lure) implements RecipeInput {
    @Override
    public ItemStack getItem(int i) {
        return i == 0 ? module : lure;
    }

    @Override
    public int size() {
        return 1;
    }
}
