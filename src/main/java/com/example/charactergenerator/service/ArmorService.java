package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Armor;
import com.example.charactergenerator.model.ArmorType;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.repository.ArmorRepository;
import org.springframework.stereotype.Service;

@Service
public class ArmorService {

    private ArmorRepository armorRepository;

    Character goblin = new Character("Hobgoblin", (byte) 10, (short) 7, (byte) 8, (byte) 4, (byte) 4, (byte) 4, (byte) 8, (byte) 11, (byte) 4, (byte) 4);


}
