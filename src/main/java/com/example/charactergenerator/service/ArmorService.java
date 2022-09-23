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
    Character skeleton = new Character("Giant Skeleton", (byte) 10, (short) 7, (byte) 8, (byte) 4, (byte) 4, (byte) 4, (byte) 8, (byte) 11, (byte) 4, (byte) 4);
    Character aarakocra = new Character("Aarakocra", (byte) 10, (short) 7, (byte) 8, (byte) 4, (byte) 4, (byte) 4, (byte) 8, (byte) 11, (byte) 4, (byte) 4);
    Character bandit = new Character("Bandit", (byte) 10, (short) 7, (byte) 8, (byte) 4, (byte) 4, (byte) 4, (byte) 8, (byte) 11, (byte) 4, (byte) 4);
    Character bandit2 = new Character("Banit Captain", (byte) 10, (short) 7, (byte) 8, (byte) 4, (byte) 4, (byte) 4, (byte) 8, (byte) 11, (byte) 4, (byte) 4);
    Character inquisitor = new Character("Drow Inquisitor", (byte) 10, (short) 7, (byte) 8, (byte) 4, (byte) 4, (byte) 4, (byte) 8, (byte) 11, (byte) 4, (byte) 4);
    Character grimlock = new Character("Grimlock", (byte) 11, (short) 11, (byte) 30 , (byte) 2, (byte) 16, (byte) 12, (byte) 12, (byte) 9, (byte) 8, (byte) 6);
    Character merfolk = new Character("Merfolk", (byte) 11, (short) 11, (byte) 10, (byte) 2, (byte) 10, (byte) 13, (byte) 12, (byte) 11, (byte) 11, (byte) 12);
    Character tribalWarrior = new Character("Tribal Warrior", (byte) 12, (short) 11, (byte) 30, (byte) 2, (byte) 13, (byte) 11, (byte) 12, (byte) 8, (byte) 11, (byte) 8);


}
