package com.example.charactergenerator.controller;

import com.example.charactergenerator.service.CharacterService;
import com.example.charactergenerator.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;
    @Autowired
    private CharacterService characterService;


    @GetMapping("/search")
    public String searchCharacter(Model model,
       @RequestParam(required = false, name = "keyword", defaultValue = "") String keyword) {

        if (!keyword.isBlank()) {
            model.addAttribute("characters", searchService.findByName(keyword));
        }
        else {
            model.addAttribute("characters",characterService.getAllCharacter());
        }
        return "search";
    }
}
