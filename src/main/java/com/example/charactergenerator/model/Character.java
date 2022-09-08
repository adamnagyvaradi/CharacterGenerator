package com.example.charactergenerator.model;

import javax.persistence.*;
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

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
