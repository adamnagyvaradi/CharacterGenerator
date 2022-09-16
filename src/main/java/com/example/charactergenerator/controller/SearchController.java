package com.example.charactergenerator.controller;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.repository.CharacterRepository;
import com.example.charactergenerator.service.CharacterService;
import com.example.charactergenerator.service.Searchservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @Autowired
    private Searchservice searchservice;
    @Autowired
    private CharacterService characterService;


    @GetMapping("/search")
    public String searchcaracter(Model model, @RequestParam(required = false, name = "keyword", defaultValue = "") String keyword) {

        if (!keyword.isBlank()) {
            model.addAttribute("characters", searchservice.findByName(keyword));
        }
        else {
            model.addAttribute("characters",characterService.getAllCharacter());
        }
        return "search";
    }
}
