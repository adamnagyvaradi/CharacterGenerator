package com.example.charactergenerator.model.armor;

import com.example.charactergenerator.model.AttributeType;

public enum ArmorType {
    LIGHT ("Light Armor", AttributeType.DEX),
    MEDIUM ("Medium Armor", AttributeType.DEX),
    HEAVY ("Heavy Armor", AttributeType.DEX);

    public final String name;

    private final AttributeType modifier;

    ArmorType(String name, AttributeType modifier) {
        this.name = name;
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public AttributeType getModifier() {
        return modifier;
    }
}
