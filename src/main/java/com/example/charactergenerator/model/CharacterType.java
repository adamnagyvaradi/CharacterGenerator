package com.example.charactergenerator.model;

public enum CharacterType {

    ABERRATION("Aberration"),
    BEAST("Beats"),
    CELESTIAL("Celestial"),
    CONSTRUCT("Construct"),
    DRAGON("Dragon"),
    ELEMENTAL("Elemental"),
    FEY("Fey"),
    FIEND("Fiend"),
    GIANT("Giant"),
    HUMANOID("Humanoid"),
    MONSTROSITY("Monstrosity"),
    OOZE("Ooze"),
    PLANT("Plant"),
    UNDEAD("Undead");

    private String characterType;

    CharacterType (String characterType){this.characterType= characterType;}

    public String getCharacterType() {
        return characterType;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }
}
