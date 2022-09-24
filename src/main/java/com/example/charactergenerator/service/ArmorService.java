package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Armor;
import com.example.charactergenerator.model.ArmorType;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.model.CharacterType;
import com.example.charactergenerator.repository.ArmorRepository;
import com.example.charactergenerator.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class ArmorService {

    private ArmorRepository armorRepository;

    private CharacterRepository characterRepository;

    public ArmorService(ArmorRepository armorRepository, CharacterRepository characterRepository) {
        this.armorRepository = armorRepository;
        this.characterRepository = characterRepository;
    }

    public List<Character> getNewCharacters() {
        if (characterRepository.count() == 0) {
            characterRepository.saveAll(Arrays.asList(
                    new Character("Hobgoblin", (byte) 10, (short) 7, (byte) 8, (byte) 4, (byte) 4, (byte) 4, (byte) 8,
                            (byte) 11, (byte) 4, (byte) 4, CharacterType.HUMANOID),
                    new Character("Giant Skeleton", (byte) 10, (short) 7, (byte) 8, (byte) 4, (byte) 4, (byte) 4, (byte) 8,
                            (byte) 11, (byte) 4, (byte) 4, CharacterType.UNDEAD),
                    new Character("Aarakocra", (byte) 10, (short) 7, (byte) 8, (byte) 4, (byte) 4, (byte) 4, (byte) 8,
                            (byte) 11, (byte) 4, (byte) 4, CharacterType.ABERRATION),
                    new Character("Bandit", (byte) 10, (short) 7, (byte) 8, (byte) 4, (byte) 4, (byte) 4, (byte) 8,
                            (byte) 11, (byte) 4, (byte) 4, CharacterType.HUMANOID),
                    new Character("Bandit Captain", (byte) 10, (short) 7, (byte) 8, (byte) 4, (byte) 4, (byte) 4, (byte) 8,
                            (byte) 11, (byte) 4, (byte) 4, CharacterType.HUMANOID),
                    new Character("Drow Inquisitor", (byte) 10, (short) 7, (byte) 8, (byte) 4, (byte) 4, (byte) 4, (byte) 8,
                            (byte) 11, (byte) 4, (byte) 4,  CharacterType.HUMANOID),
                    new Character("Grimlock", (byte) 11, (short) 11, (byte) 30, (byte) 2, (byte) 16, (byte) 12, (byte) 12,
                            (byte) 9, (byte) 8, (byte) 6, CharacterType.BEAST),
                    new Character("Merfolk", (byte) 11, (short) 11, (byte) 10, (byte) 2, (byte) 10, (byte) 13, (byte) 12,
                            (byte) 11, (byte) 11, (byte) 12, CharacterType.HUMANOID),
                    new Character("Tribal Warrior", (byte) 12, (short) 11, (byte) 30, (byte) 2, (byte) 13, (byte) 11,
                            (byte) 12, (byte) 8, (byte) 11, (byte) 8, CharacterType.HUMANOID)
            ));
        }

        return (List<Character>) characterRepository.findAll();

    }

    @Transactional
    public void addArmorToCharacters () {
        List<Character> newCharacters = getNewCharacters();

        List<Armor> armors = (List<Armor>) armorRepository.saveAll(Arrays.asList( new Armor("Padded", ArmorType.LIGHT, (byte) 11),
                                            new Armor("Chain shirt", ArmorType.MEDIUM, (byte) 13),
                                            new Armor("Splint", ArmorType.HEAVY, (byte) 17)));


        for (Character character : newCharacters) {
            character.setArmor(armors.get((int) (Math.random() * 3)));

        }
    }

    @Transactional
    public void addArmorToCharacters () {
        List<Character> newCharacters = getNewCharacters();

        List<Armor> armors = (List<Armor>) armorRepository.saveAll(Arrays.asList( new Armor("Padded", ArmorType.LIGHT, (byte) 11),
                                            new Armor("Chain shirt", ArmorType.MEDIUM, (byte) 13),
                                            new Armor("Splint", ArmorType.HEAVY, (byte) 17)));


        for (Character character : newCharacters) {
            character.setArmor(armors.get((int) (Math.random() * 3)));

        }
    }
}
