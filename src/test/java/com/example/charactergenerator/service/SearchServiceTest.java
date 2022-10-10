package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.repository.SearchRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {

    /*@Test
    void findByNameTest() {

        SearchRepository searchRepository
                = Mockito.mock(SearchRepository.class);

        SearchService searchService
                = new SearchService();

        List<Character> characterList = new ArrayList<>();

        characterList.add(new Character());

        Mockito.when(searchRepository.findCharactersByNameContains(Mockito.anyString())).thenReturn(characterList);

        List<Character> serviceResult = searchService.findByName("Test");

        assertEquals(characterList, serviceResult);
    }*/

}