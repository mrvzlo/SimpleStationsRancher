package com.ave.simplestationsrancher.enums;

import com.ave.simplestationsrancher.registrations.Registrations;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

public enum AnimalType {
    COW(0, EntityType.COW, RancherType.BARN, Registrations.COW_LURE.get()),
    SHEEP(1, EntityType.SHEEP, RancherType.BARN, Registrations.SHEEP_LURE.get()),
    PIG(2, EntityType.PIG, RancherType.BARN, Registrations.PIG_LURE.get()),
    CHICKEN(3, EntityType.CHICKEN, RancherType.SMALL_BARN, Registrations.CHICKEN_LURE.get()),
    RABBIT(4, EntityType.RABBIT, RancherType.SMALL_BARN, Registrations.RABBIT_LURE.get()),
    BEES(5, EntityType.BEE, RancherType.APIARY, Registrations.BEE_LURE.get()),
    SPIDER(6, EntityType.SPIDER, RancherType.TERRARIUM, Registrations.SPIDER_LURE.get()),
    FISH(7, EntityType.SALMON, RancherType.FISHING_POND, Registrations.FISH_LURE.get());

    public final int id;
    public final EntityType<?> entity;
    public final RancherType station;
    public final Item lure;

    AnimalType(int id, EntityType<?> entity, RancherType station, Item lure) {
        this.id = id;
        this.station = station;
        this.entity = entity;
        this.lure = lure;
    }

    public static AnimalType fromId(int id) {
        for (AnimalType type : values())
            if (type.id == id)
                return type;

        return null;
    }

    public static AnimalType fromLure(Item lure) {
        for (AnimalType type : values())
            if (type.lure == lure)
                return type;

        return null;
    }
}
