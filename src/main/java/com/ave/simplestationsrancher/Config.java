package com.ave.simplestationsrancher;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@SuppressWarnings("removal")
@EventBusSubscriber(modid = SimpleStationsRancher.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
        private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
        static ModConfigSpec SPEC;

        public static ModConfigSpec.IntValue MAX_PROGRESS; // 24000
        public static ModConfigSpec.IntValue WATER_PER_CYCLE; // 1000

        static {
                setupGenerationConfig();
                SPEC = BUILDER.build();
        }

        private static void setupGenerationConfig() {
                MAX_PROGRESS = BUILDER
                                .comment("Base working time in ticks\n Default: 24000")
                                .defineInRange("work_time", 24000, 1, 100000);
                WATER_PER_CYCLE = BUILDER
                                .comment("How much water to consume per tick\n Default: 1")
                                .defineInRange("water_per_cycle", 1, 1, 1000);
        }

        @SubscribeEvent
        static void onLoad(final ModConfigEvent event) {

        }

}
