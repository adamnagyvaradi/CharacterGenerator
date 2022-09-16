package com.example.charactergenerator.model;


public class Skill {
    private SkillType skillType;
    private boolean proficiency;
    private Character character;
    public Skill() {

    }

    public Skill(SkillType skillType, Character character) {
        this.skillType = skillType;
        this.character = character;
    }

    public String getName() {
        return skillType.getName();
    }

    public boolean isProficiency() {
        return proficiency;
    }

    public void setProficiency(boolean proficiency) {
        this.proficiency = proficiency;
    }

    public AttributeType getModifier() {
        return skillType.getModifier();
    }

    public byte getBonus() {
        return character.getAttributeBonus(getModifier());
    }

    public String getBonusSign(){
        return getBonus() > 0 ? "+" : "";
    }
}
