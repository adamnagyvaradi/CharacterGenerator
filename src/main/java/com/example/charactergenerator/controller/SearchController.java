package com.example.charactergenerator.controller;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.model.CharacterType;
import com.example.charactergenerator.service.CharacterService;
import com.example.charactergenerator.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;
    @Autowired
    private CharacterService characterService;


    @GetMapping("/search")
    public String searchCharacter(Model model,
       @RequestParam(required = false, name = "characterName",defaultValue ="") String characterName,
       @RequestParam(required = false, name = "characterType") String characterType,
       @RequestParam(required = false, name = "challengeRating") Byte challengeRating) {

        List<Character> characterList = searchService.filterBy(characterName,characterType, challengeRating);
        model.addAttribute("characters",characterList);

       return "search";
    }
}
