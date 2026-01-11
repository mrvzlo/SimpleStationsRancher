package com.ave.simplestationsrancher.datagen;

import java.util.concurrent.CompletableFuture;

import com.ave.simplestationsrancher.SimpleStationsRancher;
import com.ave.simplestationsrancher.registrations.Registrations;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
            ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SimpleStationsRancher.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Registrations.BARN.getBlock())
                .add(Registrations.EMPTY_MODULE.getBlock())
                .add(Registrations.SHEARING_MODULE.getBlock())
                .add(Registrations.SLAUGHTERING_MODULE.getBlock())
                .add(Registrations.TANNING_MODULE.getBlock())
                .add(Registrations.HARVEST_MODULE.getBlock())
                .add(Registrations.FISHING_MODULE.getBlock());
    }
}