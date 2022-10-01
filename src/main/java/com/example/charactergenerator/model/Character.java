package com.example.charactergenerator.model;

import javax.persistence.*;
import java.util.*;

@Entity(name = "characters")
public class Character {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private byte armorClass;
    private short hitPoints; // hit dice
    private byte speed;
    private byte challengeRating;

    @ManyToOne
    @JoinColumn (name = "armor_id")
    private Armor armor;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "characters_attributes",
            joinColumns = {@JoinColumn(name = "character_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "modifier")
    Map<AttributeType, Byte> attributes = new EnumMap<>(AttributeType.class);
    @Transient
    private List<Skill> skills;

    @Enumerated(EnumType.STRING)
    private CharacterType characterType;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "characters_proficiencies",
        joinColumns = {@JoinColumn(name = "character_id",referencedColumnName = "id")})
    private List<SkillType> proficiencies = new ArrayList<>();

    private boolean isCaster;

    @Transient
    private int[] slots;

    public Character() {

    }

    public Character(String name, int armorClass, int hitPoints, int speed, int challengeRating, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, CharacterType characterType, List<SkillType> proficiencies){
        this(name, (byte)armorClass, (short)hitPoints,(byte)speed, (byte)challengeRating,(byte)strength,(byte)dexterity,(byte)constitution,(byte)intelligence, (byte)wisdom,(byte)charisma, characterType,proficiencies);
    }

    public Character(String name, byte armorClass, short hitPoints, byte speed, byte challengeRating, byte strength, byte dexterity, byte constitution, byte intelligence, byte wisdom, byte charisma, CharacterType characterType, List<SkillType> proficiencies) {
        this.name = name;
        this.armorClass = armorClass;
        this.hitPoints = hitPoints;
        this.speed = speed;
        this.challengeRating = challengeRating;
        this.characterType = characterType;
        attributes.put(AttributeType.STR, strength);
        attributes.put(AttributeType.DEX, dexterity);
        attributes.put(AttributeType.CON, constitution);
        attributes.put(AttributeType.INT, intelligence);
        attributes.put(AttributeType.WIS, wisdom);
        attributes.put(AttributeType.CHA, charisma);
        this.proficiencies = proficiencies;
    }



    public byte getAttributeBonus(AttributeType attributeType){
        byte attributeValue = getAttributeValue(attributeType);
        return attributeType.getBonus(attributeValue);
    }

    public byte getAttributeBonus(String attributeName){
        return getAttributeBonus(AttributeType.valueOf(attributeName));
    }

    public byte getAttributeValue(AttributeType attributeType){
        return attributes.get(attributeType);
    }

    public byte getAttributeValue(String attributeName){
        return getAttributeValue(AttributeType.valueOf(attributeName));
    }

    public void setAttributeValue(AttributeType attributeType, byte value){
        attributes.put(attributeType,value);
    }

    public String getAttributeBonusRollDescription(String attributeName){
        String rollDesciption = "d20";
        int bonus = getAttributeBonus(attributeName);
        if (bonus > 0){
            rollDesciption += "+" + bonus;
        }else if (bonus < 0){
            rollDesciption += bonus;
        }

        return rollDesciption;
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

    public byte getArmorClass() {
        if (armor == null){
            return armorClass;
        }
        return armor.getArmorClass(getAttributeBonus(AttributeType.DEX));
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

    public byte getProficiencyBonus() {
        return switch (challengeRating) {
            case 0, 1, 2, 3, 4 -> 2;
            case 5, 6, 7, 8 -> 3;
            case 9, 10, 11, 12 -> 4;
            case 13, 14, 15, 16 -> 5;
            case 17, 18, 19, 20 -> 6;
            case 21, 22, 23, 24 -> 7;
            case 25, 26, 27, 28 -> 8;
            case 29, 30 -> 9;
            default -> throw new IllegalStateException("Unexpected value: " + challengeRating);
        };
    }


    public Map<AttributeType, Byte> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<AttributeType, Byte> attributes) {
        this.attributes = attributes;
    }

    public Armor getArmor() {
        return armor;
    }

    public Character equipArmor(Armor armor) {
        this.armor = armor;
        return this;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isCaster() {
        return isCaster;
    }

    public int[] getSlots() {
        return slots;
    }

    public void setSlots(int[] slots) {
        this.slots = slots;
    }

    private void generateSkills() {
        this.skills = SkillType.getSkillList(this);
    }

    public List<Skill> getSkills() {
        if (skills == null){
            generateSkills();
        }

        return skills;
    }

    public com.example.charactergenerator.model.CharacterType getCharacterType() {
        return characterType;
    }

    public void setCharacterType(CharacterType characterType) {
        this.characterType = characterType;
    }

    public List<SkillType> getProficiency() {
        return proficiencies;
    }
    public void setCaster(boolean caster) {
        isCaster = caster;
    }

    public void setProficiency(List<SkillType> proficiencies) {
        this.proficiencies = proficiencies;
    }
    public void assignSlots(int level) {
        if (isCaster && level > 0 && level <= 20) {
            int[] spellSlots;
            switch (level) {
                case 1 -> this.slots = new int[] {2};
                case 2 -> this.slots = new int[] {3};
                case 3 -> this.slots = new int[] {4, 2};
                case 4 -> this.slots = new int[] {4, 3};
                case 5 -> this.slots = new int[] {4, 3, 2};
                case 6 -> this.slots = new int[] {4, 3, 3};
                case 7 -> this.slots = new int[] {4, 3, 3, 1};
                case 8 -> this.slots = new int[] {4, 3, 3, 2};
                case 9 -> this.slots = new int[] {4, 3, 3, 3, 1};
                case 10 -> this.slots = new int[] {4, 3, 3, 3, 2};
                case 11, 12 -> this.slots = new int[] {4, 3, 3, 3, 2, 1};
                case 13, 14 -> this.slots = new int[] {4, 3, 3, 3, 2, 1, 1};
                case 15, 16 -> this.slots = new int[] {4, 3, 3, 3, 2, 1, 1, 1};
                case 17 -> this.slots = new int[] {4, 3, 3, 3, 2, 1, 1, 1, 1};
                case 18 -> this.slots = new int[] {4, 3, 3, 3, 3, 1, 1, 1, 1};
                case 19 -> this.slots = new int[] {4, 3, 3, 3, 3, 2, 1, 1, 1};
                case 20 -> this.slots = new int[] {4, 3, 3, 3, 3, 2, 2, 1, 1};
            }
        }
    }
}
