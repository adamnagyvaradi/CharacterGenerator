package com.example.charactergenerator.helper;

import com.example.charactergenerator.model.*;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.repository.ArmorRepository;
import com.example.charactergenerator.service.ArmorService;
import com.example.charactergenerator.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CharacterHelper implements ApplicationRunner {
    private CharacterService characterService;

    private ArmorService armorService;


    @Autowired
    public void setArmorRepository(ArmorService armorService) {
        this.armorService = armorService;
    }

    @Autowired
    public void setCharacterService(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        saveArmors();
        saveCharacters();
    }

    private void saveCharacters(){
        getCharacters().forEach(character -> characterService.save(character));
    }

    private void saveArmors(){
        armorService.saveAll(getAllArmors());
    }

    public Armor getArmorByName(String name){
        for (Armor armor : getAllArmors()) {
            if (armor.getName().equals(name)) {
                return armor;
            }
        }
        throw new IllegalArgumentException();
    }

    private List<Character> getCharacters(){
        return new ArrayList<>(Arrays.asList(
                new Character("Aboleth",17, 135,10,10,
                        21,9,15,18,15,18,CharacterType.ABERRATION, Arrays.asList(SkillType.HISTORY, SkillType.PERCEPTION)),
                new Character("Acolyte",10, 9,30,0,
                        10,10,10,10,14,11,CharacterType.HUMANOID,Arrays.asList(SkillType.MEDICINE, SkillType.RELIGION)),
                new Character("Air Elemental",15, 90,0, 4,
                        14,20,14,6,10,6,CharacterType.ELEMENTAL,new ArrayList<>()),
                new Character("Allosaurus",13, 51,60, 2,
                        19,13,17,2,12,5,CharacterType.BEAST,Arrays.asList(SkillType.PERCEPTION)),
                new Character("Animated Armor",18, 33,25, 4,
                        14,11,13,1,3,1,CharacterType.CONSTRUCT,new ArrayList<>()),
                new Character("Ankheg",14, 39, 30, 10,
                        17, 11, 13, 1, 13, 6,CharacterType.MONSTROSITY, new ArrayList<>()),
                new Character("Ankylosaurus",15, 68, 30, 16,
                        19,11,15,2,12,5,CharacterType.BEAST, new ArrayList<>()),
                new Character("Hobgoblin", 10, 7, 8, 4, 4, 4, 8,
                        11, 4, 4, CharacterType.HUMANOID, new ArrayList<>()),
                new Character("Giant Skeleton", 10, 7, 8, 4, 4, 4,  8,
                        11, 4, 4, CharacterType.UNDEAD, new ArrayList<>()),
                new Character("Aarakocra", 10, 7, 8, 4, 4, 4, 8,
                        11, 4, 4, CharacterType.ABERRATION, new ArrayList<>()),
                new Character("Bandit", 10, 7, 8, 4, 4, 4, 8,
                        11, 4, 4, CharacterType.HUMANOID,new ArrayList<>()),
                new Character("Bandit Captain", 10, 7, 8, 4, 4, 4, 8,
                        11, 4, 4, CharacterType.HUMANOID, new ArrayList<>()).equipArmor(getArmorByName("Chain shirt")),
                new Character("Drow Inquisitor", 10, 7, 8, 4, 4, 4, 8,
                        11, 4, 4,  CharacterType.HUMANOID, new ArrayList<>()),
                new Character("Grimlock", 11, 11, 30, 2, 16, 12, 12,
                        9, 8, 6, CharacterType.BEAST, new ArrayList<>()),
                new Character("Merfolk", 11, 11, 10, 2, 10, 13, 12,
                        11, 11, 12, CharacterType.HUMANOID, new ArrayList<>()),
                new Character("Tribal Warrior", 12, 11, 30, 2, 13, 11,
                        12, 8, 11, 8, CharacterType.HUMANOID, new ArrayList<>())
        ));
    }

    public List<Armor> getAllArmors() {

        return new ArrayList<>(Arrays.asList(
                new Armor(1,"Padded", ArmorType.LIGHT, (byte) 11),
                new Armor(3,"Leather", ArmorType.LIGHT, (byte) 11),
                new Armor(4, "Studded leather", ArmorType.LIGHT, (byte) 12),
                new Armor(5,"Hide", ArmorType.MEDIUM, (byte) 12),
                new Armor(6,"Chain shirt", ArmorType.MEDIUM, (byte) 13),
                new Armor(7,"Scale mail", ArmorType.MEDIUM, (byte) 14),
                new Armor(8,"Breastplate", ArmorType.MEDIUM, (byte) 14),
                new Armor(9,"Half plate", ArmorType.MEDIUM, (byte) 15),
                new Armor(10,"Ring mail", ArmorType.HEAVY, (byte) 14),
                new Armor(11,"Chain mail", ArmorType.HEAVY, (byte) 16),
                new Armor(12,"Splint", ArmorType.HEAVY, (byte) 17),
                new Armor(13,"Plate", ArmorType.HEAVY, (byte) 18)));
    }

}
