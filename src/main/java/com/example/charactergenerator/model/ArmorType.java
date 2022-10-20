package com.example.charactergenerator.model;

public enum ArmorType {
    LIGHT("Light"),
    MEDIUM("Medium"),
    HEAVY("Heavy");

    private final String name;

    ArmorType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
