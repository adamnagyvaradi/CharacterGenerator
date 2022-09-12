package com.example.charactergenerator.controller;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.service.CharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

        Character attributes = characterService.getCharacter();

        model.addAttribute("attributes", attributes);

        return "character";
    }
}
