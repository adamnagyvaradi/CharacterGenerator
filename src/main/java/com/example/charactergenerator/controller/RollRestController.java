package com.example.charactergenerator.controller;

import com.example.charactergenerator.dto.RollDto;
import com.example.charactergenerator.service.RandomService;
import com.example.charactergenerator.service.RollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RollRestController {

    RollService rollService = new RollService(new RandomService());

    @Autowired
    public void setRollService(RollService rollService) {
        this.rollService = rollService;
    }

    @CrossOrigin
    @GetMapping("/roll/{rollDefinition}")
    public RollDto rollDice(@PathVariable String rollDefinition){
        return rollService.roll(rollDefinition);
    }

}
