package com.example.charactergenerator.controller;

import com.example.charactergenerator.model.Skill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SkillController {

    @GetMapping(value = {"/sheet"})
    public String getSkills(Model model) {
        // Service osztály kell hozzá
        List<Skill> skills = new ArrayList<>();

        Skill skill = new Skill();

        model.addAttribute("attributes", skills);

        return "skill";
    }
}
