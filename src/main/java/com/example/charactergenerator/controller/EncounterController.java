package com.example.charactergenerator.controller;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.service.CharacterService;
import com.example.charactergenerator.service.EncounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/encounter/builder")
    public String showEncounterBuilder(Model model,
                                       @RequestParam(required = false, name = "keyword", defaultValue = "") String keyword){
        List<Character> characters;

        if(keyword.isBlank()){
            characters = characterService.findAll();
        }else{
            characters = characterService.findAllByNameContains(keyword);
        }

        model.addAttribute("characters",characters);
        model.addAttribute("charactersCart",encounterService.getAllCharacter());

        return "encounter-builder";
    }

    @GetMapping("/encounter/builder/character")
    public String showCharacters(Model model){
        List<Character> characters = encounterService.getAllCharacter();

        model.addAttribute("characters",characters);

        return "encounter-edit";
    }

    @PostMapping("/encounter/builder/character/edit/{id}")
    public String editCharacter(@PathVariable long id){

        return "character-edit";
    }

    @PostMapping("/encounter/builder/character/add/{id}")
    public String addCharacterIntoBuilder(@PathVariable long id){
        encounterService.addCharacter(id);

        return "redirect:/encounter/builder";
    }


}
