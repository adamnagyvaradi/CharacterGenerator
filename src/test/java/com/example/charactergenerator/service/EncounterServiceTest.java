package com.example.charactergenerator.service;

import com.example.charactergenerator.dto.CharacterDto;
import com.example.charactergenerator.model.Character;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncounterServiceTest {

    @Test
    void addCharacterTest() {

        EncounterService encounterService
                = Mockito.mock(EncounterService.class);

        encounterService.addCharacter(1);

        Mockito.verify(encounterService).addCharacter(1);
    }

    @Test
    void getAllCharacterTest() {

        EncounterService encounterService
                = Mockito.mock(EncounterService.class);

        List<Character> characterList = new ArrayList<>();

        characterList.add(new Character());

        Mockito.when(encounterService.getAllCharacter()).thenReturn(characterList);

        List<Character> serviceResult = encounterService.getAllCharacter();

        assertEquals(characterList, serviceResult);
    }

    @Test
    void findCharacterByIdTest() {

        EncounterService encounterService
                = Mockito.mock(EncounterService.class);

        Character testChar = new Character();

        Mockito.when(encounterService.findCharacterById(Mockito.anyLong())).thenReturn(testChar);

        Character serviceResult = encounterService.findCharacterById(3);

        assertEquals(testChar, serviceResult);
    }

    @Test
    void removeCharacterByIdTest() {

        EncounterService encounterService
                = Mockito.mock(EncounterService.class);

        encounterService.removeCharacterById(1);

        Mockito.verify(encounterService).removeCharacterById(1);
    }

    @Test
    void updateCharacterTest() {

        EncounterService encounterService
                = Mockito.mock(EncounterService.class);

        CharacterDto testChar = new CharacterDto();

        encounterService.updateCharacter(testChar);

        Mockito.verify(encounterService).updateCharacter(testChar);
    }
}