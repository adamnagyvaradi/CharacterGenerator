package com.example.charactergenerator.helper;

import com.example.charactergenerator.model.Character;
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
                new Character("Aboleth",(byte)17, (short)135,(byte)10,(byte)10,(byte)21,(byte)9,(byte)15,(byte)18,(byte)15,(byte)18, CharacterType.ABERRATION),
                new Character("Acolyte",(byte)10, (short)9,(byte)30,(byte)0,(byte)10,(byte)10,(byte)10,(byte)10,(byte)14,(byte)11,CharacterType.HUMANOID),
                new Character("Air Elemental",(byte)15, (short)90,(byte)0,(byte) 4,(byte)14,(byte)20,(byte)14,(byte)6,(byte)10,(byte)6,CharacterType.ELEMENTAL),
                new Character("Allosaurus",(byte)13, (short)51,(byte)60,(byte) 2,(byte)19,(byte)13,(byte)17,(byte)2,(byte)12,(byte)5,CharacterType.BEAST),
                new Character("Animated Armor",(byte)18, (short)33,(byte)25,(byte) 4,(byte)14,(byte)11,(byte)13,(byte)1,(byte)3,(byte)1,CharacterType.CONSTRUCT),
                new Character("Ankheg",(byte)14, (short) 39,(byte)30,(byte)10,(byte)17,(byte)11,(byte)13,(byte)1,(byte)13,(byte)6,CharacterType.MONSTROSITY),
                new Character("Ankylosaurus",(byte)15, (short)68, (byte)30,(byte) 16,(byte)19,(byte)11,(byte)15,(byte)2,(byte)12,(byte)5,CharacterType.BEAST)
        ));
    }

}
