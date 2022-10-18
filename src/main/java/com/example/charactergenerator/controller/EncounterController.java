package com.example.charactergenerator.controller;

import com.example.charactergenerator.dto.CharacterDto;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EncounterController {
    private static final List<Integer> CASTER_LEVELS =
            List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
    private static final List<String> CHALLENGE_RATINGS =
            List.of("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
                    "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30");
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
    public String searchCharacter(Model model,
                                  @RequestParam(required = false, name = "characterName",defaultValue ="") String characterName,
                                  @RequestParam(required = false, name = "characterType") String characterType,
                                  @RequestParam(required = false, name = "challengeRating") Byte challengeRating) {

        List<Character> characters = characterService.filterBy(characterName,characterType, challengeRating);
        List<Character> charactersCart = encounterService.getAllCharacter();
        model.addAttribute("characters",characters);
        model.addAttribute("charactersCart", charactersCart);
        model.addAttribute("challengeRatings",CHALLENGE_RATINGS);

        return "encounter/builder";
    }

    @GetMapping("/encounter/builder/character")
    public String showCharacters(Model model){
        if (encounterService.getAllCharacter().isEmpty()){
            return "redirect:/encounter/builder";
        }
        if (!encounterService.isEncounterEditable()){
            return "redirect:/encounter/character";
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
        model.addAttribute("rangedWeapons", rangedWeaponService.findAll());
        model.addAttribute("casterLevels", CASTER_LEVELS);


        return "encounter/character-edit";
    }

    @PostMapping("/encounter/character/update")
    public String updateCharacter(CharacterDto characterDto){
        encounterService.updateCharacter(characterDto);

        return "redirect:/encounter/builder/character";
    }

    @PostMapping("/encounter/builder/character/add/{id}")
    public String addCharacterIntoBuilder(@PathVariable long id, @RequestHeader(value = "referer", required = false) String referer){
        encounterService.addCharacter(id);

        return getEncounterBuilderRedirect(referer);
    }

    @PostMapping("/encounter/builder/character/remove/{id}")
    public String removeCharacterFromCart(@PathVariable long id, @RequestHeader(value = "referer", required = false) String referer){
        encounterService.removeCharacterById(id);

        return getEncounterBuilderRedirect(referer);
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

    @GetMapping("/encounter/builder/new")
    public String newEncounter(){
        encounterService.resetEncounter();
        return "redirect:/encounter/builder";
    }

    @PostMapping("/encounter/character/{id}/hp/update")
    public String updateHitPoints(@PathVariable long id, short hp){
        encounterService.modifyHitPoints(id,hp);
        return "redirect:/encounter/character/" + id;
    }

    private String getEncounterBuilderRedirect(String url){
        int startIndex = url.indexOf("?");
        if (startIndex == -1){
            return "redirect:/encounter/builder";
        } else{
            return "redirect:/encounter/builder" + url.substring(startIndex);
        }
    }
}
