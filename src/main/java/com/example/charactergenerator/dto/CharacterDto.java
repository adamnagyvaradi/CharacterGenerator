package com.example.charactergenerator.dto;

import com.example.charactergenerator.model.*;
import com.example.charactergenerator.model.Character;

import javax.persistence.*;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class CharacterDto {
    private long id;
    private String name;
    private byte strength;
    private byte dexterity;
    private byte constitution;
    private byte intelligence;
    private byte wisdom;
    private byte charisma;

    private byte armorClass;

    private short hitPoints;

    private byte speed;

    private byte challengeRating;

    Map<AttributeType, Byte> attributes = new EnumMap<>(AttributeType.class);

    private List<Skill> skills;

    private Armor armor;

    private CharacterType CharacterType;

    private boolean isCaster;

    private int[] slots;

    public CharacterDto() {
    }

    public CharacterDto(Character character){
        id = character.getId();
        name = character.getName();
        strength = character.getAttributeValue(AttributeType.STR);
        dexterity = character.getAttributeValue(AttributeType.DEX);
        constitution = character.getAttributeValue(AttributeType.CON);
        intelligence = character.getAttributeValue(AttributeType.INT);
        wisdom = character.getAttributeValue(AttributeType.WIS);
        charisma = character.getAttributeValue(AttributeType.CHA);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
