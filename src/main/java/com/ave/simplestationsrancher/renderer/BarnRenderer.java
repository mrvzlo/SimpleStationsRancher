package com.ave.simplestationsrancher.renderer;

import com.ave.simplestationscore.partblock.PartBlockEntity;
import com.ave.simplestationsrancher.blockentity.BaseRancherBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.entity.EntityType;

public class BarnRenderer implements BlockEntityRenderer<PartBlockEntity> {
    public BarnRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(PartBlockEntity be, float pt, PoseStack pose, MultiBufferSource buf, int light, int overlay) {
        var parent = be.getController();
        if (!(parent instanceof BaseRancherBlockEntity))
            return;
        var typeCode = be.getStationType();

        if (!be.isEdge())
            return;
        var erd = Minecraft.getInstance().getEntityRenderDispatcher();
        var cow = EntityType.COW.create(be.getLevel());
        if (cow == null)
            return;

        var dz = be.getBlockPos().getZ() - parent.getBlockPos().getZ();
        var dx = be.getBlockPos().getX() - parent.getBlockPos().getX();
        pose.pushPose();
        pose.translate(0.5D - dx * 0.3, 0.0D, 0.5D - dz * 0.3);
        pose.scale(0.3f, 0.3f, 0.3f);
        pose.mulPose(Axis.YP.rotationDegrees(getRotation(dz, dx)));
        var pos = be.getBlockPos();
        cow.setPos(pos.getX(), pos.getY(), pos.getZ());
        erd.render(cow, 0.0D, 0.0D, 0.0D, 0.0F, 0, pose, buf, light);
        pose.popPose();
    }

    private int getRotation(int dz, int dx) {
        if (dz < 0)
            return 180;
        if (dz > 0)
            return 0;
        if (dx < 0)
            return 270;
        return 90;
    }
}
