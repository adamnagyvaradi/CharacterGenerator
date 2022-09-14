package com.example.charactergenerator.model;


public class Skill {

    private String name;

    private boolean proficiency;

    private AttributeType modifier; // (Str, Dex...)

    private int bonus;
    public Skill() {

    }

    public Skill(String name, AttributeType modifier) {
        this.name = name;
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public boolean isProficiency() {
        return proficiency;
    }

    public void setProficiency(boolean proficiency) {
        this.proficiency = proficiency;
    }

    public AttributeType getModifier() {
        return modifier;
    }

    public void setBonus(int bonus){
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}
