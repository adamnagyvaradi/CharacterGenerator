package com.example.charactergenerator.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Character {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private short hitPoints; // hit dice

    private byte proficiencyBonus;

    private byte strength;

    private byte dexterity;

    private byte constitution;


    private byte intelligence;

    private byte wisdom;

    private byte charisma;

    @Transient
    private List<Skill> skills;

    /* private byte speed;

    private byte armor;

    private String characterClass; // List<String> features

    private String race;

    private String background;

    private List<String> equipment;*/

    public Character() {
    }

    public Character(String name, byte proficiencyBonus, byte strength, byte dexterity, byte constitution, byte intelligence, byte wisdom, byte charisma) {
        this.name = name;
        this.proficiencyBonus = proficiencyBonus;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        generateSkills();
        setSkills();

    }

    public Character(String name, byte proficiencyBonus, byte strength, byte dexterity, byte constitution, byte intelligence, byte wisdom, byte charisma, short hp) {
        this(name, proficiencyBonus, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.hitPoints = hp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(short hitPoints) {
        this.hitPoints = hitPoints;
    }

    public byte getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(byte proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public byte getStrength() {
        return strength;
    }

    public void setStrength(byte strength) {
        this.strength = strength;
    }

    public byte getDexterity() {
        return dexterity;
    }

    public void setDexterity(byte dexterity) {
        this.dexterity = dexterity;
    }

    public byte getConstitution() {
        return constitution;
    }

    public void setConstitution(byte constitution) {
        this.constitution = constitution;
    }

    public byte getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(byte intelligence) {
        this.intelligence = intelligence;
    }

    public byte getWisdom() {
        return wisdom;
    }

    public void setWisdom(byte wisdom) {
        this.wisdom = wisdom;
    }

    public byte getCharisma() {
        return charisma;
    }

    public void setCharisma(byte charisma) {
        this.charisma = charisma;
    }

    private void generateSkills(){
        this.skills = new ArrayList<>(Arrays.asList(
                    new Skill("Acrobatics", "Dexterity"),
                    new Skill("Animal Handling", "Wisdom"),
                    new Skill("Arcana", "Intelligence"),
                    new Skill("Athletics", "Strength"),
                    new Skill("Deception", "Charisma"),
                    new Skill("History", "Intelligence"),
                    new Skill("Insight", "Wisdom"),
                    new Skill("Intimidation", "Charisma"),
                    new Skill("Investigation", "Intelligence"),
                    new Skill("Medicine", "Wisdom"),
                    new Skill("Nature", "Intelligence"),
                    new Skill("Perception", "Wisdom"),
                    new Skill("Performance", "Charisma"),
                    new Skill("Persuasion", "Charisma"),
                    new Skill("Religion", "Intelligence"),
                    new Skill("Sleight of Hand", "Dexterity"),
                    new Skill("Stealth", "Dexterity"),
                    new Skill("Survival", "Wisdom")
            ));

        }

    public List<Skill> getSkills() {
        return skills;
    }

    private void setSkills() {
        for (Skill skill: skills) {
            switch (skill.getModifier()) {
                case "Dexterity" -> skill.setBonus(dexterity);
                case "Wisdom" -> skill.setBonus(wisdom);
                case "Intelligence" -> skill.setBonus(intelligence);
                case "Charisma" -> skill.setBonus(charisma);
                case "Constitution" -> skill.setBonus(constitution);
                case "Strength" -> skill.setBonus(strength);
            }
        }
    }
}
