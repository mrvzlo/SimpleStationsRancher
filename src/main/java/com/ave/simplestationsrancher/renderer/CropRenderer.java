package com.ave.simplestationsrancher.renderer;

import com.ave.simplestationscore.partblock.PartBlockEntity;
import com.ave.simplestationsrancher.blockentity.BaseRancherBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class CropRenderer implements BlockEntityRenderer<PartBlockEntity> {
    public CropRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(PartBlockEntity be, float pt, PoseStack pose, MultiBufferSource buf, int light, int overlay) {
        var parent = be.getController();
        if (!(parent instanceof BaseRancherBlockEntity))
            return;
        var typeCode = be.getStationType();
        if (typeCode == -1)
            return;

        var dispatcher = Minecraft.getInstance().getBlockRenderer();

    }
}
