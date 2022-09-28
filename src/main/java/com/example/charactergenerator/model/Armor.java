package com.example.charactergenerator.model;

import javax.persistence.*;

@Entity
public class Armor {

   @Id
   @GeneratedValue
    private long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private ArmorType armorType;

    private byte armorValue;



    public Armor() {
    }

    public Armor(String name, ArmorType armorType, byte armorValue) {
        this.name = name;
        this.armorType = armorType;
        this.armorValue = armorValue;
    }

    public Armor(long id, String name, ArmorType armorType, byte armorValue) {
        this.id = id;
        this.name = name;
        this.armorType = armorType;
        this.armorValue = armorValue;
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

