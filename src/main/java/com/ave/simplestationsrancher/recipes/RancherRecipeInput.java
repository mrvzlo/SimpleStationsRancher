package com.ave.simplestationsrancher.recipes;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record RancherRecipeInput(Item module, Item lure) implements RecipeInput {
    @Override
    public ItemStack getItem(int i) {
        return new ItemStack(i == 0 ? module : lure);
    }

    @Override
    public int size() {
        return 1;
    }
}
