package com.ave.simplestationsrancher.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class RancherSerializer implements RecipeSerializer<RancherRecipe> {
    public static final MapCodec<RancherRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            ItemStack.CODEC.fieldOf("module").forGetter(RancherRecipe::module),
            ItemStack.CODEC.fieldOf("lure").forGetter(RancherRecipe::lure),
            Codec.INT.fieldOf("speed").forGetter(RancherRecipe::speed),
            StationRoll.CODEC.listOf().fieldOf("rolls").forGetter(RancherRecipe::rolls))
            .apply(inst, RancherRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, StationRoll> ROLL_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.registry(Registries.ITEM), StationRoll::output,
            ByteBufCodecs.INT, StationRoll::count,
            ByteBufCodecs.INT, StationRoll::chance,
            StationRoll::new);

    public static final StreamCodec<RegistryFriendlyByteBuf, RancherRecipe> STREAM_CODEC = StreamCodec.composite(
            ItemStack.STREAM_CODEC, RancherRecipe::module,
            ItemStack.STREAM_CODEC, RancherRecipe::lure,
            ByteBufCodecs.INT, RancherRecipe::speed,
            ROLL_STREAM_CODEC.apply(ByteBufCodecs.list()), RancherRecipe::rolls,
            RancherRecipe::new);

    @Override
    public MapCodec<RancherRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, RancherRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
