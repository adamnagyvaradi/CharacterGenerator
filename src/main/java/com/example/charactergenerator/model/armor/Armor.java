package com.example.charactergenerator.model.armor;

public class Armor {

    private String Name;

    private ArmorType armorType;

    private byte armorValue;

    private Character character;

    public Armor(String name) {
    }

    public Armor() {
    }

    public Armor(String name, ArmorType armorType, byte armorValue) {
        Name = name;
        this.armorType = armorType;
        this.armorValue = armorValue;
    }

    public String getName() {
        return Name;
    }


    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public byte getArmorValue() {
        return armorValue;
    }

    public void setArmorValue(byte armorValue) {
        this.armorValue = armorValue;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public byte getBonus(){
        //getCharacter().
        return 0;
    }
}
