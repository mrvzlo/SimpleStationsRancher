package com.ave.simplestationsrancher.datagen;

import com.ave.simplestationsrancher.SimpleStationsRancher;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static final TagKey<Item> FISH_FOOD = ItemTags.CHICKEN_FOOD;
    public static final TagKey<Item> SPIDER_FOOD = ItemTags.MEAT;
    public static final TagKey<Item> BIG_BARN_FOOD = TagKey.create(Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(SimpleStationsRancher.MODID, "big_barn_food"));

    public static final TagKey<Item> SMALL_BARN_FOOD = TagKey.create(Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(SimpleStationsRancher.MODID, "small_barn_food"));
}