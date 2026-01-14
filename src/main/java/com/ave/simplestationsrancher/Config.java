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
        public static ModConfigSpec.IntValue MAX_FOOD; // 1000
        public static ModConfigSpec.IntValue MAX_ANIMAL; // 10

        static {
                setupGenerationConfig();
                SPEC = BUILDER.build();
        }

        private static void setupGenerationConfig() {
                MAX_PROGRESS = BUILDER
                                .comment("Base working time in ticks\n Default: 24000")
                                .defineInRange("work_time", 24000, 1, 100000);
                MAX_FOOD = BUILDER
                                .comment("How much food station can store\n Default: 1000")
                                .defineInRange("max_food", 1000, 1, 100000);
                MAX_ANIMAL = BUILDER
                                .comment("How many animals station can store\n Default: 10")
                                .defineInRange("max_animal", 10, 1, 1000);
        }

        @SubscribeEvent
        static void onLoad(final ModConfigEvent event) {

        }

}
