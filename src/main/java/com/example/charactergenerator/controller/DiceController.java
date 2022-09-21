package com.example.charactergenerator.controller;

import com.example.charactergenerator.dto.CharacterDto;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DiceController {
    private CharacterService characterService;


    @Autowired
    public DiceController(CharacterService characterService){
        this.characterService = characterService;
    }

    @PostMapping(value = {"/sheet"})
    public String rollerCosted(@RequestParam int sides, @RequestParam int times, Model model){

        Character character = characterService.findById(1);
        CharacterDto characterDto = new CharacterDto(character);
        model.addAttribute(character);
        model.addAttribute(characterDto);

        model.addAttribute("character", character);


        return "character";
    }



}
