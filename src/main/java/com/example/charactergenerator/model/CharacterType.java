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

    private String name;

    CharacterType (String name){this.name = name;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  }
