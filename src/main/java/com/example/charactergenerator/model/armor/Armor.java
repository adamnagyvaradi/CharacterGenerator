package com.example.charactergenerator.model.armor;

public class Armor {

    private String Name;

    private ArmorType armorType;

    private byte armorValue;

    public Armor(String name) {
    }

    public Armor() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
}
