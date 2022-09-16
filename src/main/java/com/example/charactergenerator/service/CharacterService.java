package com.example.charactergenerator.service;

import com.example.charactergenerator.dto.CharacterDto;
import com.example.charactergenerator.model.AttributeType;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CharacterService {

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

    public void update(Character character, CharacterDto characterDto) {
        character.setName(characterDto.getName());
        character.setAttributeValue(AttributeType.STR, characterDto.getStrength());
        character.setAttributeValue(AttributeType.DEX, characterDto.getDexterity());
        character.setAttributeValue(AttributeType.CON, characterDto.getConstitution());
        character.setAttributeValue(AttributeType.INT, characterDto.getIntelligence());
        character.setAttributeValue(AttributeType.WIS, characterDto.getWisdom());
        character.setAttributeValue(AttributeType.CHA, characterDto.getCharisma());

        save(character);
    }
}
