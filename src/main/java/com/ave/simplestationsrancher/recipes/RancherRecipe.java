package com.ave.simplestationsrancher.recipes;

import java.util.List;
import java.util.Random;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record RancherRecipe(ItemStack module, ItemStack lure, int speed, List<StationRoll> rolls)
        implements Recipe<RancherRecipeInput> {

    @Override
    public boolean matches(RancherRecipeInput input, Level level) {
        if (level.isClientSide())
            return false;

        return module().equals(input.module()) && lure().equals(input.lure());
    }

    @Override
    public ItemStack assemble(RancherRecipeInput input, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public RecipeSerializer<? extends Recipe<RancherRecipeInput>> getSerializer() {
        return ModRecipes.SIFTER_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<RancherRecipeInput>> getType() {
        return ModRecipes.SIFTER_TYPE.get();
    }

    @Override
    public boolean canCraftInDimensions(int arg0, int arg1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(Provider arg0) {
        return ItemStack.EMPTY;
    }

    public ItemStack roll(Random random, boolean luck) {
        int roll = random.nextInt(100);
        if (luck)
            roll += (99 - roll) / 3;

        int acc = 0;
        for (var r : rolls) {
            acc += r.chance();
            if (roll < acc)
                return new ItemStack(r.output(), r.count());
        }
        return ItemStack.EMPTY;
    }
}
