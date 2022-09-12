package com.example.charactergenerator.controller;

import com.example.charactergenerator.model.Dice;
import com.example.charactergenerator.model.Roll;
import com.example.charactergenerator.service.DiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DiceController {

    private DiceService diceService;



    @Autowired
    public DiceController(DiceService diceService){
        this.diceService = diceService;
    }



    /*@GetMapping(value = {"/roller"})
    public String loadDice(Model model){
        Dice d4 = diceService.loadD4();
        Dice d6 = diceService.loadD6();
        Dice d8 = diceService.loadD8();
        Dice d10 = diceService.loadD10();
        Dice d12 = diceService.loadD12();
        Dice d20 = diceService.loadD20();
        Dice d100 = diceService.loadD100();
        Roll roll = diceService.loadRoll();


        model.addAttribute("d4", d4);
        model.addAttribute("d6", d6);
        model.addAttribute("d8", d8);
        model.addAttribute("d10", d10);
        model.addAttribute("d12", d12);
        model.addAttribute("d20", d20);
        model.addAttribute("d100", d100);
        model.addAttribute("roll", roll);

        return "roller";
    }*/

    /* @PostMapping(value = {"/roller"})
     public String rolled(Model model, Roll roll) {

        diceService.adRolle(roll);
        List<Integer> rolled = diceService.rollDice(roll.getSides(),roll.getTimes());

        model.addAttribute("rolled", rolled);

         return "result";
     }*/
   /* @PostMapping(value = {"/roller"})
    public String rollerCosted(@RequestParam int sides, @RequestParam int times, Model model){
        List<Integer> rolled = diceService.rollDice(sides, times);

        Roll roll = new Roll(times, sides);

        model.addAttribute("rolled", rolled);

        return "result";
    }*/



}
