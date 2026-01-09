package com.ave.simplestationsrancher.jei;

import net.minecraft.world.item.ItemStack;

public class SimpleRecipe {
    public final ItemStack filter;
    public final ItemStack outputType;

    public SimpleRecipe(ItemStack stack, ItemStack out) {
        this.filter = stack;
        outputType = out;
    }
}
