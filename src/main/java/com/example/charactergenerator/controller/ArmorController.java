package com.example.charactergenerator.controller;

import com.example.charactergenerator.dto.CharacterDto;
import com.example.charactergenerator.model.Armor;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.service.ArmorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ArmorController {

    @Autowired
    private ArmorService armorService;


    @GetMapping(value = {"/test"})
    public String getArmorbyCharacter(Model model){
       armorService.addArmorToCharacters();


        return "character";
    }
}
