package com.example.charactergenerator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Armor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String Name;

    private ArmorType armorType;

    private byte armorValue;

    private boolean equipped;


    public Armor() {
    }

    public Armor(String name, ArmorType armorType, byte armorValue, boolean equipped) {
        Name = name;
        this.armorType = armorType;
        this.armorValue = armorValue;
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

    public byte getArmorValue(byte dexBonus) {
        return getArmorClass(dexBonus);
    }


    public byte getArmorClass(byte dexBonus){
        if (armorType.equals(ArmorType.HEAVY)){
            return armorValue;
        } else if (armorType.equals(ArmorType.MEDIUM)) {
            if (dexBonus >= 2){
                return (byte) (armorValue + 2);
            }
            return (byte) (armorValue + dexBonus);
        } else {
            return (byte) (armorValue + dexBonus);
        }
    }

}
