package com.example.charactergenerator.controller;

import com.example.charactergenerator.dto.CharacterDto;
import com.example.charactergenerator.model.Armor;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.service.ArmorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ArmorController {

    private ArmorService armorService;

    @GetMapping(value = {"/character/{armor}"})
    public String getArmorbyCharacter(Model model){
        //List<Armor> allArmors = ArmorService.


        return "character";
    }
}
