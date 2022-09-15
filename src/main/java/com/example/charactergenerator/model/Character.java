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
                new Skill("Acrobatics", AttributeType.DEX, this),
                new Skill("Animal Handling", AttributeType.WIS, this),
                new Skill("Arcana", AttributeType.INT, this),
                new Skill("Athletics", AttributeType.STR, this),
                new Skill("Deception", AttributeType.CHA, this),
                new Skill("History", AttributeType.INT, this),
                new Skill("Insight", AttributeType.WIS, this),
                new Skill("Intimidation", AttributeType.CHA, this),
                new Skill("Investigation", AttributeType.INT, this),
                new Skill("Medicine", AttributeType.WIS, this),
                new Skill("Nature", AttributeType.INT, this),
                new Skill("Perception", AttributeType.WIS, this),
                new Skill("Performance", AttributeType.CHA,this),
                new Skill("Persuasion", AttributeType.CHA,this),
                new Skill("Religion", AttributeType.INT,this),
                new Skill("Sleight of Hand", AttributeType.DEX,this),
                new Skill("Stealth", AttributeType.DEX,this),
                new Skill("Survival", AttributeType.WIS,this)));

    }

    public List<Skill> getSkills() {
        if (skills == null){
            generateSkills();
        }

        return skills;
    }

    /*public void setSkillProficiency(String name){
        getSkills();
        for (Skill skill: skills){
            if (skill.getName().equals(name)){
                skill.setProficiency(true);
                AttributeType modifier = skill.getModifier();
                skill.setBonus(modifier.getBonus(attributes.get(modifier)) + proficiencyBonus);
            }
        }
    }*/

    /*private void setSkills() {
        for (Skill skill: skills) {
            switch (skill.getModifier()) {
                case DEX -> skill.setBonus(getAttributeBonus("DEX"));
                case WIS -> skill.setBonus(getAttributeBonus("WIS"));
                case INT -> skill.setBonus(getAttributeBonus("INT"));
                case CHA -> skill.setBonus(getAttributeBonus("CHA"));
                case CON -> skill.setBonus(getAttributeBonus("CON"));
                case STR-> skill.setBonus(getAttributeBonus("STR"));
            }
        }
    }*/
}
