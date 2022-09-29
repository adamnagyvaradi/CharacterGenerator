package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.model.Encounter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncounterService {
    private Encounter encounter = new Encounter();

    public void addCharacter(Character character){
        encounter.addCharacter(character);
    }

    public List<Character> getAllCharacter(){
        return encounter.getCharacters();
    }
}
