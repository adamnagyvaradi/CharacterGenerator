package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Skill;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SkillService {

    public List<Skill> getSkills(){
        return new ArrayList<>(Arrays.asList(
                new Skill("Acrobatics", "Dexterity"),
                new Skill("Animal Handling", "Wisdom"),
                new Skill("Arcana", "Intelligence"),
                new Skill("Athletics", "Strength"),
                new Skill("Deception", "Charisma"),
                new Skill("History", "Intelligence"),
                new Skill("Insight", "Wisdom"),
                new Skill("Intimidation", "Charisma"),
                new Skill("Investigation", "Intelligence"),
                new Skill("Medicine", "Wisdom"),
                new Skill("Nature", "Intelligence"),
                new Skill("Perception", "Wisdom"),
                new Skill("Performance", "Charisma"),
                new Skill("Persuasion", "Charisma"),
                new Skill("Religion", "Intelligence"),
                new Skill("Sleight of Hand", "Dexterity"),
                new Skill("Stealth", "Dexterity"),
                new Skill("Survival", "Wisdom")
        ));
    }

}
