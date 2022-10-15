package com.example.charactergenerator.controller;

import com.example.charactergenerator.dto.CharacterDto;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.service.*;
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
    private ArmorService armorService;
    private MeleeWeaponService meleeWeaponService;
    private RangedWeaponService rangedWeaponService;

    @Autowired
    public void setCharacterService(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Autowired
    public void setEncounterService(EncounterService encounterService) {
        this.encounterService = encounterService;
    }

    @Autowired
    public void setArmorService(ArmorService armorService) {
        this.armorService = armorService;
    }

    @Autowired
    public void setMeleeWeaponService(MeleeWeaponService meleeWeaponService) {
        this.meleeWeaponService = meleeWeaponService;
    }

    @Autowired
    public void setRangedWeaponService(RangedWeaponService rangedWeaponService) {
        this.rangedWeaponService = rangedWeaponService;
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

        return "encounter/builder";
    }

    @GetMapping("/encounter/builder/character")
    public String showCharacters(Model model){
        if (encounterService.getAllCharacter().isEmpty()){
            return "redirect:/encounter/builder";
        }

        List<Character> characters = encounterService.getAllCharacter();

        model.addAttribute("characters",characters);

        return "encounter/encounter-edit";
    }

    @GetMapping("/encounter/builder/character/edit/{id}")
    public String editCharacter(@PathVariable long id, Model model){

        model.addAttribute("character", encounterService.findCharacterById(id));
        model.addAttribute("armors", armorService.findAll());
        model.addAttribute("meleeWeapons", meleeWeaponService.findAll());
        model.addAttribute("randedWeapons", rangedWeaponService.findAll());
        model.addAttribute("casterLevels", List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));


        return "encounter/character-edit";
    }

    @PostMapping("/encounter/character/update")
    public String updateCharacter(CharacterDto characterDto){
        encounterService.updateCharacter(characterDto);

        return "redirect:/encounter/builder/character";
    }

    @PostMapping("/encounter/builder/character/add/{id}")
    public String addCharacterIntoBuilder(@PathVariable long id){
        encounterService.addCharacter(id);

        return "redirect:/encounter/builder";
    }

    @PostMapping("/encounter/builder/character/remove/{id}")
    public String removeCharacterFromCart(@PathVariable long id){
        encounterService.removeCharacterById(id);

        return "redirect:/encounter/builder";
    }

    @PostMapping("/encounter/builder/save")
    public String saveEncounter(){
        encounterService.saveEncounter();
        return "redirect:/encounter/character";
    }

    @GetMapping(value = {"/encounter/character", "/encounter/character/{id}"})
    public String showEncounter(@PathVariable(required = false) Long id,Model model){
        if (encounterService.isEncounterEditable()){
            return "redirect:/encounter/builder/character";
        }

        model.addAttribute("characters", encounterService.getAllCharacter());
        model.addAttribute("character", encounterService.findCharacterById(id));

        return "encounter/encounter";
    }
}
