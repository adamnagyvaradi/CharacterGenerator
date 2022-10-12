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
        if (character.getProficiency().contains(skillType)) {
            proficiency = true;
        }
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
        byte bonus = character.getAttributeBonus(getModifier());
        return proficiency ? (byte) (bonus + character.getProficiencyBonus()) : bonus;
    }

    public String getBonusSign() {
        return getBonus() > 0 ? "+" : "";
    }

    public String getRollDefinition() {
        if (getBonus() < 0) {
            return "d20" + getBonus();
        } else if (getBonus() > 0) {
            return "d20+" + getBonus();
        } else {
            return "d20";
        }
    }
}
