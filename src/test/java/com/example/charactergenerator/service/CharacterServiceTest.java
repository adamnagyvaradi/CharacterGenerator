package com.example.charactergenerator.service;

import com.example.charactergenerator.dto.CharacterDto;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.model.CharacterType;
import com.example.charactergenerator.model.SkillType;
import com.example.charactergenerator.repository.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CharacterServiceTest {

    Character testChar;

    @BeforeEach
    void createTestChar() {
        testChar =
                new Character("Test", 1, 1, "d10", 1,
                        1, 1, 1, 1,
                        1, 1, 1,
                        CharacterType.ABERRATION,
                        Set.of(SkillType.HISTORY,SkillType.PERCEPTION));
    }

    @Test
    void findByNameTest() {

        CharacterRepository characterRepository
                = Mockito.mock(CharacterRepository.class);

        CharacterService characterService
                = new CharacterService(characterRepository);

        Mockito.when(characterRepository.findCharactersByName(Mockito.anyString())).thenReturn(Optional.ofNullable(testChar));

        Character serviceResult = characterService.findByName("Test");

        assertEquals(testChar, serviceResult);
    }

    @Test
    void findAllByNameContainsTest() {

        CharacterRepository characterRepository
                = Mockito.mock(CharacterRepository.class);

        CharacterService characterService
                = new CharacterService(characterRepository);

        List<Character> characterList = new ArrayList<>();

        Mockito.when(characterService.findAllByNameContains(Mockito.anyString())).thenReturn(characterList);

        List<Character> serviceResult = characterService.findAllByNameContains("Test");

        assertEquals(characterList, serviceResult);
    }

    @Test
    void findByIdTest() {

        CharacterRepository characterRepository
                = Mockito.mock(CharacterRepository.class);

        CharacterService characterService
                = new CharacterService(characterRepository);

        Mockito.when(characterRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(testChar));

        Character serviceResult = characterService.findById(3);

        assertEquals(testChar, serviceResult);
    }

    @Test
    void saveTest() {

        CharacterRepository characterRepository
                = Mockito.mock(CharacterRepository.class);

        CharacterService characterService
                = new CharacterService(characterRepository);

        characterService.save(testChar);

        Mockito.verify(characterRepository).save(testChar);
    }

    @Test
    void findAllTest() {

        CharacterRepository characterRepository
                = Mockito.mock(CharacterRepository.class);

        CharacterService characterService
                = new CharacterService(characterRepository);

        List<Character> characterList = new ArrayList<>();

        characterList.add(testChar);

        Mockito.when(characterService.findAll()).thenReturn(characterList);

        List<Character> serviceResult = characterService.findAll();

        assertEquals(characterList, serviceResult);
    }

    @Test
    void updateTest() {

        CharacterRepository characterRepository
                = Mockito.mock(CharacterRepository.class);

        CharacterService characterService
                = new CharacterService(characterRepository);

        CharacterDto testCharDto = new CharacterDto();

        characterService.update(testChar, testCharDto);

        Mockito.verify(characterRepository).save(testChar);
    }
}