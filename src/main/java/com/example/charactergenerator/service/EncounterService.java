package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.model.Encounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncounterService {
    private CharacterService characterService;

    @Autowired
    public void setCharacterService(CharacterService characterService) {
        this.characterService = characterService;
    }

    private Encounter encounter = new Encounter();

    public void addCharacter(Character character){
        long id = encounter.getCharacters().size() + 1L;
        character.setId(id);
        encounter.addCharacter(character);
    }

    public void addCharacter(long id){
        Character character = characterService.findById(id);
        addCharacter(character);
    }

    public List<Character> getAllCharacter(){
        return encounter.getCharacters();
    }
}
