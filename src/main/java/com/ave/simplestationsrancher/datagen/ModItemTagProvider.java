package com.ave.simplestationsrancher.datagen;

import java.util.concurrent.CompletableFuture;

import com.ave.simplestationsrancher.SimpleStationsRancher;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
            BlockTagsProvider blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags.contentsGetter(), SimpleStationsRancher.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.BIG_BARN_FOOD)
                .add(Items.WHEAT)
                .add(Items.CARROT)
                .add(Items.SHORT_GRASS);

        tag(ModTags.SMALL_BARN_FOOD)
                .addTag(ItemTags.CHICKEN_FOOD)
                .add(Items.CARROT)
                .add(Items.WHEAT);
    }
}