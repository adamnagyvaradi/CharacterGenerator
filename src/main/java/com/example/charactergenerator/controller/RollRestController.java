package com.example.charactergenerator.controller;

import com.example.charactergenerator.dto.RollDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RollRestController {

    @CrossOrigin
    @GetMapping("/roll/{rollDefinition}")
    public RollDto rollDice(@PathVariable String rollDefinition){
        System.out.println(rollDefinition);
        return new RollDto("5 + 4 = 9", 9);
    }

}
