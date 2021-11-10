package com.masterquentus.mythiccraft.entities.vampire;

public enum VampireTypes {
    EVOKER("vampire_evoker"),
    PILLAGER("vampire_pillager"),
    PIGLIN("vampire_piglin"),
    VINDICATOR("vampire_vindicator");

    private String name;

    VampireTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}