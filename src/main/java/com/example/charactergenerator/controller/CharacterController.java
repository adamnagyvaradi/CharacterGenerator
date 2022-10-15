package com.example.charactergenerator.controller;

import com.example.charactergenerator.dto.CharacterDto;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.service.CharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CharacterController {

    private CharacterService characterService;


    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping(value = {"/sheet"})
    public String getAttributes(Model model){

        Character character = characterService.findById(1);
        model.addAttribute(character);
        model.addAttribute("rolled", "");

        return "character";
    }

    @GetMapping(value = {"/character/{id}"})
    public String showCharacterById(@PathVariable long id, Model model){
        Character character = characterService.findById(id);
        model.addAttribute(character);

        return "character";
    }

    @PostMapping(value={"/character/update"})
    public String updateCharacter(CharacterDto characterDto){
        Character character = characterService.findById(characterDto.getId());

        characterService.update(character, characterDto);

        return "redirect:/character/" + character.getId();
    }
}
