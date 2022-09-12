package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CharacterService {

 private CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {this.characterRepository= characterRepository;}

    public Character findByName(String charactername) {return characterRepository.findCharactersByName(charactername).orElseThrow();}

    public List<Character>getAllCharacter(){return (List<Character>) characterRepository.findAll();}

    public void newCharacter(Character character) {characterRepository.save(character);}

}
