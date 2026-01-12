package com.ave.simplestationsrancher.screen;

import com.ave.simplestationscore.mainblock.BaseStationBlockEntity;
import com.ave.simplestationscore.screen.BaseStationMenu;
import com.ave.simplestationscore.screen.BaseStationScreen;
import com.ave.simplestationsrancher.SimpleStationsRancher;
import com.ave.simplestationsrancher.blockentity.modules.BaseModuleEntity;
import com.ave.simplestationsrancher.uihelpers.UIBlocks;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ModuleScreen extends BaseStationScreen {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(SimpleStationsRancher.MODID,
            "textures/gui/module_gui.png");

    public ModuleScreen(BaseStationMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    @Override
    public Component getTitle() {
        return ((BaseModuleEntity) menu.blockEntity).getTitle();
    }

    public ResourceLocation getTexture() {
        return TEXTURE;
    }

    protected void renderMoreTooltips(GuiGraphics gfx, int mouseX, int mouseY, BaseStationBlockEntity station) {
        renderProgressTooltip(gfx, UIBlocks.PROGRESS_BAR, mouseX, mouseY, station);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float tick, int mx, int my) {
        super.renderBg(graphics, tick, mx, my);
        if ((menu.blockEntity instanceof BaseStationBlockEntity station))
            renderProgressBar(graphics, station, UIBlocks.PROGRESS_BAR);
    }
}
