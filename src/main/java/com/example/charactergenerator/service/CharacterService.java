package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CharacterService {

    private CharacterRepository characterRepository;


    public CharacterService(CharacterRepository characterRepository) {this.characterRepository= characterRepository;}

    public Character getCharacter(){
        return new Character("Aboleth",(byte)2,(byte)21,(byte)9,(byte)15,(byte)18,(byte)15,(byte)18);
    }


    public Character findByName(String charactername) {return characterRepository.findCharactersByName(charactername).orElseThrow();}

    public List<Character>getAllCharacter(){return (List<Character>) characterRepository.findAll();}

    public void newCharacter(Character character) {characterRepository.save(character);}

}
