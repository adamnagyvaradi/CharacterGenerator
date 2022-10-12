package com.example.charactergenerator.dto;

import com.example.charactergenerator.model.AttributeType;
import com.example.charactergenerator.model.Character;

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
    private String armor;
    private String meleeWeapon;
    private String rangedWeapon;

    //private CharacterType CharacterType;

    //private boolean isCaster;

    public CharacterDto() {
    }

    public CharacterDto(Character character) {
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

    public byte getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(byte armorClass) {
        this.armorClass = armorClass;
    }

    public short getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(short hitPoints) {
        this.hitPoints = hitPoints;
    }

    public byte getSpeed() {
        return speed;
    }

    public void setSpeed(byte speed) {
        this.speed = speed;
    }

    public byte getChallengeRating() {
        return challengeRating;
    }

    public void setChallengeRating(byte challengeRating) {
        this.challengeRating = challengeRating;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getMeleeWeapon() {
        return meleeWeapon;
    }

    public void setMeleeWeapon(String meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }

    public String getRangedWeapon() {
        return rangedWeapon;
    }

    public void setRangedWeapon(String rangedWeapon) {
        this.rangedWeapon = rangedWeapon;
    }
}
