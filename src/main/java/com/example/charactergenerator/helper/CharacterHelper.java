package com.example.charactergenerator.helper;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.model.SkillType;
import com.example.charactergenerator.service.CharacterService;
import com.example.charactergenerator.model.CharacterType;
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

    @Autowired
    public void setCharacterService(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        saveCharacters();
    }

    private void saveCharacters(){
        getCharacters().forEach(character -> characterService.save(character));
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
                        19,11,15,2,12,5,CharacterType.BEAST, new ArrayList<>())
        ));
    }

}
