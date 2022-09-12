package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Dice;
import com.example.charactergenerator.model.Roll;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiceService {


    public Roll loadRoll() {
        return new Roll();
    }

    public List<Integer> rollDice(int sides, int times){
        int count = 0;
        List<Integer> result = new ArrayList<>();
        while (count < times) {
            result.add((int) ((Math.random() * sides + 1)));
            count++;
        }
        return result;
    }


    public Dice loadD4() {
        Dice d4 = new Dice(4);
        return d4;
    }
    public Dice loadD6() {
        Dice d4 = new Dice(6);
        return d4;
    }
    public Dice loadD8() {
        Dice d4 = new Dice(8);
        return d4;
    }
    public Dice loadD10() {
        Dice d4 = new Dice(10);
        return d4;
    }
    public Dice loadD12() {
        Dice d4 = new Dice(12);
        return d4;
    }
    public Dice loadD20() {
        Dice d4 = new Dice(20);
        return d4;
    }
    public Dice loadD100() {
        Dice d4 = new Dice(100);
        return d4;
    }
}
