package com.example.charactergenerator.controller;

import com.example.charactergenerator.model.Character;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CharacterController {

    @GetMapping(value = {"/sheet"})
    public String getAttributes(Model model){
        List<Character> attributes;

        Character character = new Character();

        model.addAttribute("attributes", attributes);

        return "character";
    }
}
