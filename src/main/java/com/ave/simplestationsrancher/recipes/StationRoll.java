package com.ave.simplestationsrancher.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

public record StationRoll(Item output, int count, int chance) {
        public static final Codec<StationRoll> CODEC = RecordCodecBuilder.create(inst -> inst.group(
                        BuiltInRegistries.ITEM.byNameCodec()
                                        .fieldOf("output")
                                        .forGetter(StationRoll::output),
                        Codec.INT.fieldOf("count")
                                        .forGetter(StationRoll::count),
                        Codec.INT.fieldOf("chance")
                                        .forGetter(StationRoll::chance))
                        .apply(inst, StationRoll::new));
}