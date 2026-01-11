package com.ave.simplestationsrancher.enums;

import net.minecraft.world.entity.EntityType;

public enum AnimalType {
    COW(0, EntityType.COW, RancherType.BARN),
    SHEEP(1, EntityType.SHEEP, RancherType.BARN),
    PIG(2, EntityType.PIG, RancherType.BARN),
    CHICKEN(3, EntityType.CHICKEN, RancherType.SMALL_BARN),
    RABBIT(4, EntityType.RABBIT, RancherType.SMALL_BARN),
    BEES(5, EntityType.BEE, RancherType.APIARY),
    SPIDER(6, EntityType.SPIDER, RancherType.TERRARIUM),
    FISH(7, EntityType.SALMON, RancherType.FISHING_POND);

    public final int id;
    public final EntityType<?> entity;
    public final RancherType station;

    AnimalType(int id, EntityType<?> entity, RancherType station) {
        this.id = id;
        this.station = station;
        this.entity = entity;
    }

    public static AnimalType fromId(int id) {
        for (AnimalType type : values())
            if (type.id == id)
                return type;

        return null;
    }
}
