package com.example.charactergenerator.model;

import java.util.Arrays;
import java.util.List;

public enum SkillType {
    ACROBATICS("Acrobatics", AttributeType.DEX),
    ANIMAL_HANDLING("Animal handling", AttributeType.WIS),
    ARCANA("Arcana", AttributeType.INT),
    ATHLETICS("Athletics", AttributeType.STR),
    DECEPTION("Deception", AttributeType.CHA),
    HISTORY("History", AttributeType.INT),
    INSIGHT("Insight", AttributeType.WIS),
    INTIMIDATION("Intimidation", AttributeType.CHA),
    INVESTIGATION("Investigation", AttributeType.INT),
    MEDICINE("Medicine", AttributeType.WIS),
    NATURE("Nature", AttributeType.INT),
    PERCEPTION("Perception", AttributeType.WIS),
    PERFORMANCE("Performance", AttributeType.CHA),
    PERSUASION("Persuasion", AttributeType.CHA),
    RELIGION("Religion", AttributeType.INT),
    SLEIGHT_OF_HAND("Sleight of Hand", AttributeType.DEX),
    STEALTH("Stealth", AttributeType.DEX),
    SURVIVAL("Survival", AttributeType.WIS);

    private final String name;
    private final AttributeType modifier;

    SkillType(String name, AttributeType modifier){
        this.name = name;
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public AttributeType getModifier() {
        return modifier;
    }

    public static List<Skill> getSkillList(Character character){
        return Arrays.stream(values()).map(skillType -> new Skill(skillType,character)).toList();
    }
}
