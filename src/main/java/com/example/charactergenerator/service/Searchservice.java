package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Searchservice {

    @Autowired
    private SearchRepository searchRepository;

    public List<Character>findByName(String keyword){
        return searchRepository.findByKeyword(keyword);
    };
}
