package com.ave.simplestationsrancher.screen;

import java.util.Arrays;
import java.util.List;

import com.ave.simplestationscore.mainblock.BaseStationBlockEntity;
import com.ave.simplestationscore.screen.BaseStationMenu;
import com.ave.simplestationscore.screen.BaseStationScreen;
import com.ave.simplestationsrancher.SimpleStationsRancher;
import com.ave.simplestationsrancher.blockentity.BaseRancherBlockEntity;
import com.ave.simplestationsrancher.uihelpers.UIBlocks;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BarnScreen extends BaseStationScreen {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(SimpleStationsRancher.MODID,
            "textures/gui/station_gui.png");

    public BarnScreen(BaseStationMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    @Override
    public Component getTitle() {
        return Component.translatable("screen.simplestationsrancher.rancho");
    }

    public ResourceLocation getTexture() {
        return TEXTURE;
    }

    protected void renderMoreTooltips(GuiGraphics gfx, int mouseX, int mouseY, BaseStationBlockEntity station) {
        int x = getStartX();
        int y = getStartY();
        if (station.type < 0 && UIBlocks.FILTER_SLOT.isHovered(mouseX - x, mouseY - y)) {
            gfx.renderTooltip(font, Component.translatable("screen.simplestationsrancher.filter"), mouseX, mouseY);
        }

        renderPowerTooltip(gfx, UIBlocks.POWER_BAR, mouseX, mouseY, station);

        var food = station.resources.get(BaseRancherBlockEntity.FOOD_SLOT);
        var animal = station.resources.get(BaseRancherBlockEntity.ANIMAL_SLOT);
        if (UIBlocks.FOOD_BAR.isHovered(mouseX - x, mouseY - y)) {
            var foodPart = food.get() + " / " + food.getMax();
            List<Component> foodText = Arrays.asList(Component.translatable("screen.simplestationsrancher.food"),
                    Component.literal(foodPart));
            gfx.renderComponentTooltip(this.font, foodText, mouseX, mouseY);
        }
        if (UIBlocks.FILTER_BAR.isHovered(mouseX - x, mouseY - y)) {
            var animalPart = animal.get() + " / " + animal.getMax();
            List<Component> animalText = Arrays.asList(Component.translatable("screen.simplestationsrancher.animal"),
                    Component.literal(animalPart));
            gfx.renderComponentTooltip(this.font, animalText, mouseX, mouseY);
        }
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float tick, int mx, int my) {
        super.renderBg(graphics, tick, mx, my);
        if (!(menu.blockEntity instanceof BaseStationBlockEntity station))
            return;

        renderPowerBar(graphics, station, UIBlocks.POWER_BAR, UIBlocks.POWER_SLOT);

        var food = station.resources.get(BaseRancherBlockEntity.FOOD_SLOT);
        var animal = station.resources.get(BaseRancherBlockEntity.ANIMAL_SLOT);

        UIBlocks.FOOD_BAR.drawProgressToTop(graphics, getStartX(), getStartY(), food.getPercent(), 0xAA229922);
        if (!food.isEnough())
            UIBlocks.FOOD_SLOT.drawBorder(graphics, getStartX(), getStartY(), getWarningColor());

        UIBlocks.FILTER_BAR.drawProgressToTop(graphics, getStartX(), getStartY(), animal.getPercent(), 0xAAAA9922);
        if (station.type == -1)
            UIBlocks.FILTER_SLOT.drawBorder(graphics, getStartX(), getStartY(), getWarningColor());
    }
}
