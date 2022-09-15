package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository= characterRepository;
    }

    public Character findByName(String characterName) {
        return characterRepository.findCharactersByName(characterName).orElseThrow();
    }

    public Character findById(long id){
        return characterRepository.findById(id).orElseThrow();
    }

    public List<Character>getAllCharacter(){return (List<Character>) characterRepository.findAll();}

    public void save(Character character) {characterRepository.save(character);}


}
