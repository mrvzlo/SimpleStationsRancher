package com.ave.simplestationsrancher.datagen;

import java.util.concurrent.CompletableFuture;

import com.ave.simplestationsrancher.registrations.Registrations;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

public class ModRecipeProvider extends RecipeProvider {
        public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
                super(output, registries);
        }

        @Override
        protected void buildRecipes(RecipeOutput consumer) {
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registrations.COW_LURE.get())
                                .requires(Items.LEATHER)
                                .requires(Items.SHORT_GRASS)
                                .requires(Items.WHEAT, 2)
                                .unlockedBy("has_l", has(Items.LEATHER))
                                .save(consumer);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registrations.SHEEP_LURE.get())
                                .requires(Items.LEATHER)
                                .requires(Items.SHORT_GRASS, 2)
                                .requires(Items.WHEAT)
                                .unlockedBy("has_l", has(Items.LEATHER))
                                .save(consumer);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registrations.PIG_LURE.get())
                                .requires(Items.LEATHER)
                                .requires(Items.CARROT)
                                .requires(Items.APPLE)
                                .requires(Items.WHEAT)
                                .unlockedBy("has_l", has(Items.LEATHER))
                                .save(consumer);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registrations.RABBIT_LURE.get())
                                .requires(Items.LEATHER)
                                .requires(Items.CARROT)
                                .requires(ItemTags.SMALL_FLOWERS)
                                .requires(Items.WHEAT)
                                .unlockedBy("has_l", has(Items.LEATHER))
                                .save(consumer);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registrations.CHICKEN_LURE.get())
                                .requires(Items.LEATHER)
                                .requires(ItemTags.CHICKEN_FOOD)
                                .requires(ItemTags.CHICKEN_FOOD)
                                .requires(ItemTags.CHICKEN_FOOD)
                                .unlockedBy("has_l", has(Items.LEATHER))
                                .save(consumer);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registrations.FISH_LURE.get())
                                .requires(Items.LEATHER)
                                .requires(Items.ROTTEN_FLESH)
                                .requires(Items.KELP)
                                .requires(ItemTags.CHICKEN_FOOD)
                                .unlockedBy("has_l", has(Items.LEATHER))
                                .save(consumer);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registrations.SPIDER_LURE.get())
                                .requires(Items.LEATHER)
                                .requires(Items.ROTTEN_FLESH)
                                .requires(ItemTags.MEAT)
                                .requires(ItemTags.MEAT)
                                .unlockedBy("has_l", has(Items.LEATHER))
                                .save(consumer);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registrations.BEE_LURE.get())
                                .requires(Items.LEATHER)
                                .requires(ItemTags.SMALL_FLOWERS)
                                .requires(ItemTags.SMALL_FLOWERS)
                                .requires(ItemTags.SMALL_FLOWERS)
                                .unlockedBy("has_l", has(Items.LEATHER))
                                .save(consumer);
        }
}