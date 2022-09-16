package com.example.charactergenerator.controller;

import com.example.charactergenerator.dto.CharacterDto;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.model.Dice;
import com.example.charactergenerator.model.Roll;
import com.example.charactergenerator.service.CharacterService;
import com.example.charactergenerator.service.DiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CharacterController {

    private CharacterService characterService;

    private DiceService diceService;


    public CharacterController(CharacterService characterService, DiceService diceService){
        this.characterService = characterService;
        this.diceService = diceService;
    }

    @GetMapping(value = {"/sheet"})
    public String getAttributes(Model model){

        Character character = characterService.findById(1);
        CharacterDto characterDto = new CharacterDto(character);
        model.addAttribute(character);
        model.addAttribute(characterDto);

        model.addAttribute("d4", diceService.loadD4());
        model.addAttribute("d6", diceService.loadD6());
        model.addAttribute("d8", diceService.loadD8());
        model.addAttribute("d10", diceService.loadD10());
        model.addAttribute("d12", diceService.loadD12());
        model.addAttribute("d20", diceService.loadD20());
        model.addAttribute("d100", diceService.loadD100());

        model.addAttribute("roll", new Roll());

        return "character";
    }

    @GetMapping(value = {"/character/{id}"})
    public String showCharacterById(@PathVariable long id, Model model){
        Character character = characterService.findById(id);
        CharacterDto characterDto = new CharacterDto(character);
        model.addAttribute(character);
        model.addAttribute(characterDto);


        return "character";
    }

    @PostMapping(value={"/character/update"})
    public String updateCharacter(CharacterDto characterDto){
        Character character = characterService.findById(characterDto.getId());

        characterService.update(character, characterDto);

        return "redirect:/character/" + character.getId();
    }
}
