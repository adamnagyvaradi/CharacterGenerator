package com.example.charactergenerator.model;

import javax.persistence.*;
import java.util.*;

@Entity(name = "characters")
public class Character {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private short hitPoints; // hit dice

    private byte proficiencyBonus;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "characters_attributes",
        joinColumns = {@JoinColumn(name = "character_id",referencedColumnName = "id")})
    @MapKeyColumn(name = "modifier")
    Map<AttributeType, Byte> attributes = new EnumMap<>(AttributeType.class);

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
        attributes.put(AttributeType.STR, strength);
        attributes.put(AttributeType.DEX, dexterity);
        attributes.put(AttributeType.CON, constitution);
        attributes.put(AttributeType.INT, intelligence);
        attributes.put(AttributeType.WIS, wisdom);
        attributes.put(AttributeType.CHA, charisma);
    }

    public Character(String name, byte proficiencyBonus, byte strength, byte dexterity, byte constitution, byte intelligence, byte wisdom, byte charisma, short hp) {
        this(name, proficiencyBonus, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.hitPoints = hp;
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

    public Map<AttributeType, Byte> getAttributes(){
        return attributes;
    }

    public void setAttributes(Map<AttributeType, Byte> attributes){
        this.attributes = attributes;
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
        if (skills == null){
            generateSkills();
            setSkills();
        }

        return skills;
    }

    private void setSkills() {
        for (Skill skill: skills) {
            switch (skill.getModifier()) {
                case "Dexterity" -> skill.setBonus(getAttributeBonus("DEX"));
                case "Wisdom" -> skill.setBonus(getAttributeBonus("WIS"));
                case "Intelligence" -> skill.setBonus(getAttributeBonus("INT"));
                case "Charisma" -> skill.setBonus(getAttributeBonus("CHA"));
                case "Constitution" -> skill.setBonus(getAttributeBonus("CON"));
                case "Strength" -> skill.setBonus(getAttributeBonus("STR"));
            }
        }
    }
}
