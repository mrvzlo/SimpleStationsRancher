package com.ave.simplestationsrancher.enums;

import com.ave.simplestationscore.registrations.Station;
import com.ave.simplestationsrancher.registrations.Registrations;

public enum RancherType {
    BARN(0, Registrations.BARN),
    SMALL_BARN(1, Registrations.BARN),
    APIARY(2, Registrations.BARN),
    FISHING_POND(3, Registrations.BARN),
    TERRARIUM(4, Registrations.BARN);

    public final int id;
    public final Station<?, ?> station;

    RancherType(int id, Station<?, ?> station) {
        this.id = id;
        this.station = station;
    }

    public static RancherType fromId(int id) {
        for (RancherType type : values())
            if (type.id == id)
                return type;

        return null;
    }
}
