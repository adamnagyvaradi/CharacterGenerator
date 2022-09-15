package com.example.charactergenerator.controller;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.service.CharacterService;
import com.example.charactergenerator.service.Searchservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CharacterController {

    private CharacterService characterService;
    private Searchservice searchservice;


    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }
    @GetMapping(value = {"/sheet"})
    public String getAttributes(Model model){

        Character character = characterService.findById(1);

        System.out.println(character.getAttributes());
        System.out.println(character.getSkills());

        model.addAttribute("character", character);

        return "character";
    }

    @GetMapping(value = {"/character/{id}"})
    public String showCharacterById(@PathVariable long id, Model model, String keyword){
        Character character = characterService.findById(id);
        model.addAttribute("character",character);

        if (keyword != null) {
            model.addAttribute("character", searchservice.findByKeyword(keyword));
        }
        else {
            model.addAttribute("character",characterService.findById(id));
        }

        return "character";
    }
}
