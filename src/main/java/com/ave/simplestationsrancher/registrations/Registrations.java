package com.ave.simplestationsrancher.registrations;

import com.ave.simplestationscore.registrations.RegistrationManager;
import com.ave.simplestationscore.registrations.Station;
import com.ave.simplestationsrancher.SimpleStationsRancher;
import com.ave.simplestationsrancher.blockentity.BigBarnBlock;
import com.ave.simplestationsrancher.blockentity.BigBarnEntity;
import com.ave.simplestationsrancher.blockentity.modules.BaseModuleBlock;
import com.ave.simplestationsrancher.blockentity.modules.BaseModuleEntity;
import com.ave.simplestationsrancher.blockentity.modules.FishingModuleBlock;
import com.ave.simplestationsrancher.blockentity.modules.FishingModuleEntity;
import com.ave.simplestationsrancher.blockentity.modules.HarvestModuleBlock;
import com.ave.simplestationsrancher.blockentity.modules.HarvestModuleEntity;
import com.ave.simplestationsrancher.blockentity.modules.ShearingModuleBlock;
import com.ave.simplestationsrancher.blockentity.modules.ShearingModuleEntity;
import com.ave.simplestationsrancher.blockentity.modules.SlaughteringModuleBlock;
import com.ave.simplestationsrancher.blockentity.modules.SlaughteringModuleEntity;
import com.ave.simplestationsrancher.blockentity.modules.TanningModuleBlock;
import com.ave.simplestationsrancher.blockentity.modules.TanningModuleEntity;
import com.ave.simplestationsrancher.screen.BarnMenu;
import com.ave.simplestationsrancher.screen.ModuleMenu;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

public class Registrations {
        public static final RegistrationManager MANAGER = new RegistrationManager(SimpleStationsRancher.MODID);

        public static final Station<BigBarnEntity, BigBarnBlock> BARN = MANAGER.registerStation("barn",
                        (p) -> new BigBarnBlock(p), BigBarnEntity::new);

        public static final Station<BaseModuleEntity, BaseModuleBlock> EMPTY_MODULE = MANAGER.registerEmptyStation(
                        "module_empty", (p) -> new BaseModuleBlock(p), BaseModuleEntity::new);
        public static final Station<TanningModuleEntity, TanningModuleBlock> TANNING_MODULE = MANAGER.registerStation(
                        "module_tanning", (p) -> new TanningModuleBlock(p), TanningModuleEntity::new);
        public static final Station<HarvestModuleEntity, HarvestModuleBlock> HARVEST_MODULE = MANAGER.registerStation(
                        "module_harvest", (p) -> new HarvestModuleBlock(p), HarvestModuleEntity::new);
        public static final Station<FishingModuleEntity, FishingModuleBlock> FISHING_MODULE = MANAGER.registerStation(
                        "module_fishing", (p) -> new FishingModuleBlock(p), FishingModuleEntity::new);
        public static final Station<SlaughteringModuleEntity, SlaughteringModuleBlock> SLAUGHTERING_MODULE = MANAGER
                        .registerStation("module_slaughtering", (p) -> new SlaughteringModuleBlock(p),
                                        SlaughteringModuleEntity::new);
        public static final Station<ShearingModuleEntity, ShearingModuleBlock> SHEARING_MODULE = MANAGER
                        .registerStation("module_shearing", (p) -> new ShearingModuleBlock(p),
                                        ShearingModuleEntity::new);

        public static final DeferredItem<Item> COW_LURE = MANAGER.registerItem("lure_cow");
        public static final DeferredItem<Item> SHEEP_LURE = MANAGER.registerItem("lure_sheep");
        public static final DeferredItem<Item> PIG_LURE = MANAGER.registerItem("lure_pig");
        public static final DeferredItem<Item> CHICKEN_LURE = MANAGER.registerItem("lure_chicken");
        public static final DeferredItem<Item> FISH_LURE = MANAGER.registerItem("lure_fish");
        public static final DeferredItem<Item> RABBIT_LURE = MANAGER.registerItem("lure_rabbit");
        public static final DeferredItem<Item> SPIDER_LURE = MANAGER.registerItem("lure_spider");
        public static final DeferredItem<Item> BEE_LURE = MANAGER.registerItem("lure_bee");

        public static final DeferredHolder<MenuType<?>, MenuType<BarnMenu>> BARN_MENU = MANAGER
                        .registerMenuType("barn_menu", BarnMenu::new);
        public static final DeferredHolder<MenuType<?>, MenuType<ModuleMenu>> MODULE_MENU = MANAGER
                        .registerMenuType("module_menu", ModuleMenu::new);
}
