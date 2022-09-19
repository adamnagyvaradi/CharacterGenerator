package com.example.charactergenerator.model.armor;

public enum ArmorType {

    LIGHT ("Light Armor"),
    MEDIUM ("Medium Armor"),
    HEAVY ("Heavy Armor");

    public final String name;

    ArmorType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
