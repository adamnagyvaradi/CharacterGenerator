package com.example.charactergenerator.controller;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.repository.CharacterRepository;
import com.example.charactergenerator.service.CharacterService;
import com.example.charactergenerator.service.Searchservice;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {

    private Searchservice searchservice;

    private CharacterService characterService;


    @GetMapping("/search")
    public String searchcaracter(Model model, String keyword, long id) {
        model.addAttribute("Character",characterService.findById(id));
        if (keyword != null) {
            model.addAttribute("character", searchservice.findByKeyword(keyword));
        }
        else {
            model.addAttribute("character",characterService.getAllCharacter());
        }
        return "search";
    }
}
