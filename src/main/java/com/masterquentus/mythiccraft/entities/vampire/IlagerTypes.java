package com.masterquentus.mythiccraft.entities.vampire;

public enum IlagerTypes {
    EVOKER("vampire_evoker"),
    PILLAGER("vampire_pillager"),
    VINDICATOR("vampire_vindicator");

    private String name;

    IlagerTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}