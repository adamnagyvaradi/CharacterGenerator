package com.example.charactergenerator.model;


import java.util.List;

public class Skill {
    private String name;
    private boolean proficiency;
    private AttributeType modifier; // (Str, Dex...)
    private Character character;
    public Skill() {

    }

    public Skill(String name, AttributeType modifier, Character character) {
        this.name = name;
        this.modifier = modifier;
        this.character = character;
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

    public byte getBonus() {
        return character.getAttributeBonus(modifier);
    }

    /*public List<Skill> getSkills() {
        if (skills == null){
            generateSkills();
            setSkills();
        }

        return skills;
    }*/

}
