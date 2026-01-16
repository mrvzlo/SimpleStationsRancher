package com.ave.simplestationsrancher.recipes;

import com.ave.simplestationsrancher.SimpleStationsRancher;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister
            .create(Registries.RECIPE_SERIALIZER, SimpleStationsRancher.MODID);
    public static final DeferredRegister<RecipeType<?>> TYPES = DeferredRegister.create(Registries.RECIPE_TYPE,
            SimpleStationsRancher.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<RancherRecipe>> SIFTER_SERIALIZER = SERIALIZERS
            .register("rancher", RancherSerializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<RancherRecipe>> SIFTER_TYPE = TYPES
            .register("rancher", () -> new RecipeType<RancherRecipe>() {
                @Override
                public String toString() {
                    return "rancher";
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
