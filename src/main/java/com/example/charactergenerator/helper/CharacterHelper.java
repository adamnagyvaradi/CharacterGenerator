package com.example.charactergenerator.helper;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CharacterHelper implements ApplicationRunner {
    private CharacterService characterService;

    @Autowired
    public void setCharacterService(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Character character = new Character("Aboleth",(byte)2,(byte)21,(byte)9,(byte)15,(byte)18,(byte)15,(byte)18);
        characterService.save(character);

        Character otherCharacter = characterService.findByName("Aboleth");
        System.out.println(otherCharacter.getAttributes());
    }
}
