package com.example.charactergenerator.controller;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.service.CharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CharacterController {

    private CharacterService characterService;


    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }
    @GetMapping(value = {"/sheet"})
    public String getAttributes(Model model){

        Character character = characterService.findById(1);

        System.out.println(character.getAttributes());
        System.out.println(character.getSkills());

        character.setSkillProficiency("Survival");

        model.addAttribute("character", character);

        return "character";
    }

    @GetMapping(value = {"/character/{id}"})
    public String showCharacterById(@PathVariable long id, Model model){
        Character character = characterService.findById(id);
        model.addAttribute("character",character);

        return "character";
    }
}
