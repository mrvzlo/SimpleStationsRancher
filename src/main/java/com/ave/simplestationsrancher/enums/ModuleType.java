package com.ave.simplestationsrancher.enums;

import com.ave.simplestationscore.registrations.Station;
import com.ave.simplestationsrancher.registrations.Registrations;

import net.minecraft.world.item.Item;

public enum ModuleType {
    EMPTY(0, Registrations.EMPTY_MODULE),
    TANNING(1, Registrations.TANNING_MODULE),
    HARVEST(2, Registrations.HARVEST_MODULE),
    SHEARING(3, Registrations.SHEARING_MODULE),
    FISHING(4, Registrations.FISHING_MODULE),
    SLAUGHTERING(5, Registrations.SLAUGHTERING_MODULE);

    public final int id;
    public final Station<?, ?> station;

    ModuleType(int id, Station<?, ?> station) {
        this.id = id;
        this.station = station;
    }

    public static ModuleType fromId(int id) {
        for (ModuleType type : values())
            if (type.id == id)
                return type;

        return EMPTY;
    }

    public static ModuleType fromItem(Item item) {
        for (ModuleType type : values())
            if (type.station.getItem() == item)
                return type;

        return EMPTY;
    }
}
