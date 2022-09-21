package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Armor;
import com.example.charactergenerator.model.ArmorType;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.repository.ArmorRepository;
import org.springframework.stereotype.Service;

@Service
public class ArmorService {

    private ArmorRepository armorRepository;

    Character character1 = new Character("Padded", ArmorType.LIGHT, (byte) 0);
    Character character2 = new Character("Leather", ArmorType.LIGHT, (byte) 1);
    Character character3 = new Character("Studded leather", ArmorType.LIGHT, (byte) 3);
    Character character4 = new Character("Chain shirt", ArmorType.MEDIUM, (byte) 0);
    Character character5 = new Character("Scale mail", ArmorType.MEDIUM, (byte) 1);
    Character character6 = new Character("Breastplate", ArmorType.MEDIUM, (byte) 3);
    Character character7 = new Character("Ring mail", ArmorType.HEAVY, (byte) 0);
    Character character8 = new Character("Chain mail\t", ArmorType.HEAVY, (byte) 1);
    Character character9 = new Character("Splint", ArmorType.HEAVY, (byte) 3);


}
