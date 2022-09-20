package com.example.charactergenerator.service;

import com.example.charactergenerator.model.armor.Armor;
import com.example.charactergenerator.model.armor.ArmorType;

public class ArmorService {
    public byte getArmorClass(Armor armor){
        if (armor.getArmorType().equals(ArmorType.HEAVY)){
            return armor.getArmorValue();
        } else if (armor.getArmorType().equals(ArmorType.MEDIUM)) {

        }
        return 0;
    }
}
