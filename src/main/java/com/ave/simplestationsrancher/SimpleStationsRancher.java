package com.ave.simplestationsrancher;

import org.slf4j.Logger;

import com.ave.simplestationscore.registrations.CoreRegistrations;
import com.ave.simplestationsrancher.registrations.Registrations;
import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(SimpleStationsRancher.MODID)
public class SimpleStationsRancher {
        public static final String MODID = "simplestationsrancher";
        public static final Logger LOGGER = LogUtils.getLogger();

        public SimpleStationsRancher(IEventBus modEventBus, ModContainer modContainer) {
                modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
                Registrations.MANAGER.register(modEventBus);
                modEventBus.addListener(this::addCreative);
        }

        private void addCreative(BuildCreativeModeTabContentsEvent event) {
                if (!event.getTab().equals(CoreRegistrations.CREATIVE_TAB.get()))
                        return;

                event.accept(Registrations.BARN.getItem());
                event.accept(Registrations.FISHING_MODULE.getItem());
                event.accept(Registrations.SHEARING_MODULE.getItem());
                event.accept(Registrations.SLAUGHTERING_MODULE.getItem());
                event.accept(Registrations.TANNING_MODULE.getItem());
                event.accept(Registrations.HARVEST_MODULE.getItem());
        }
}