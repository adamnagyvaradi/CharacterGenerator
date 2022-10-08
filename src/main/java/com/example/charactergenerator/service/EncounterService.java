package com.example.charactergenerator.service;

import com.example.charactergenerator.dto.CharacterDto;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.model.Encounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncounterService {
    private CharacterService characterService;
    private long lastId = 0;

    @Autowired
    public void setCharacterService(CharacterService characterService) {
        this.characterService = characterService;
    }

    private Encounter encounter = new Encounter();

    public void addCharacter(Character character){
        character.setId(++lastId);
        encounter.addCharacter(character);
    }

    public void addCharacter(long id){
        Character character = characterService.findById(id);
        addCharacter(character);
    }

    public List<Character> getAllCharacter(){
        return encounter.getCharacters();
    }

    public Character findCharacterById(long id){
        return encounter.findById(id);
    }

    public void removeCharacterById(long id){
        encounter.removeCharacterById(id);
    }

    public void updateCharacter(CharacterDto characterDto){

    }
}
