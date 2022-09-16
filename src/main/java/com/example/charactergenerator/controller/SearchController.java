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

        if (keyword != null) {
            model.addAttribute("characters", searchservice.findByName(keyword));
        }
        else {
            model.addAttribute("characters",characterService.getAllCharacter());
        }
        return "search";
    }
}
