package com.example.charactergenerator.controller;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.service.CharacterService;
import com.example.charactergenerator.service.EncounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EncounterController {
    private CharacterService characterService;
    private EncounterService encounterService;

    @Autowired
    public void setCharacterService(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Autowired
    public void setEncounterService(EncounterService encounterService) {
        this.encounterService = encounterService;
    }

    @GetMapping("/encounter/build")
    public String showEncounterBuilder(Model model){
        List<Character> characters = characterService.findAll();
        List<Character> charactersCart = encounterService.getAllCharacter();

        model.addAttribute("characters",characters);
        model.addAttribute("charactersCart",charactersCart);

        return "encounter-builder";
    }
}
