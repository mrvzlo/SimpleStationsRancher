package com.ave.simplestationsrancher.registrations;

import com.ave.simplestationscore.registrations.RegistrationManager;
import com.ave.simplestationscore.registrations.Station;
import com.ave.simplestationsrancher.SimpleStationsRancher;
import com.ave.simplestationsrancher.blockentity.BarnBlock;
import com.ave.simplestationsrancher.blockentity.BarnEntity;
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

public class Registrations {
        public static final RegistrationManager MANAGER = new RegistrationManager(SimpleStationsRancher.MODID);

        public static final Station<BarnEntity, BarnBlock> BARN = MANAGER.registerStation("barn",
                        (p) -> new BarnBlock(p), BarnEntity::new);

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
}
