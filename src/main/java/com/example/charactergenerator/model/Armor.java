package com.example.charactergenerator.model;

public class Armor {

    private String Name;

    private ArmorType armorType;

    private byte armorValue;

    private Character character;

    private boolean equipped;


    public Armor() {
    }

    public Armor(String name, ArmorType armorType, byte armorValue, Character character, boolean equipped) {
        Name = name;
        this.armorType = armorType;
        this.armorValue = armorValue;
        this.character = character;
        this.equipped = equipped;
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
        getCharacter().getAttributeBonus(AttributeType.DEX);
        return 0;
    }

    public byte getArmorClass(Armor armor){
        if (armor.getArmorType().equals(ArmorType.HEAVY)){
            return armor.getArmorValue();
        } else if (armor.getArmorType().equals(ArmorType.MEDIUM)) {
            if (armor.getBonus() >= 2){
                return (byte) (armor.getArmorValue() + 2);
            }
            return (byte) (armor.getArmorValue() + armor.getBonus());
        } else {
            return (byte) (armor.getArmorValue() + armor.getBonus());
        }
    }
}
