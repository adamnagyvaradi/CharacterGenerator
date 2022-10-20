package com.example.charactergenerator.model;

public enum AttributeType {
    STR("Strength"),
    DEX("Dexterity"),
    CON("Constitution"),
    INT("Intelligence"),
    WIS("Wisdom"),
    CHA("Charisma");

    private final String name;

    AttributeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public byte getBonus(int modifierValue) {
        return (byte) (modifierValue - 10 < 0 ? (modifierValue - 11) / 2 : (modifierValue - 10) / 2);
    }
}
