package com.example.charactergenerator.service;

import com.example.charactergenerator.dto.RollDto;
import org.springframework.stereotype.Service;

@Service
public class RollService {

    public RollDto roll(String rollDescription){
        int dIndex = rollDescription.indexOf('d');

        int bonusSignIndex = getBonusSignIndex(rollDescription);

        int sides = getSides(rollDescription,dIndex,bonusSignIndex);

        int times = getTimes(rollDescription, dIndex);

        int bonus = getBonus(rollDescription, bonusSignIndex);

        RollDto roll = generateRoll(sides,times);

        if (bonus != 0){
            char bonusSign = rollDescription.charAt(bonusSignIndex);
            if (bonusSign == '+'){
                roll.setResult((short)(roll.getResult() + bonus));
            }else{
                roll.setResult((short)(roll.getResult() - bonus));
            }
            roll.setDetails(roll.getDetails() + " " + bonusSign + " " + bonus);
        }

        roll.setDetails(roll.getDetails() + " = " + roll.getResult());

        return roll;
    }

    private RollDto generateRoll(int sides, int times) {
        int sum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++){
            int actualRollValue = (int) ((Math.random() * sides + 1));
            stringBuilder.append(actualRollValue);

            if (i < times - 1){
                stringBuilder.append(" + ");
            }

            sum += actualRollValue;
        }

        return new RollDto(stringBuilder.toString(), sum);
    }

    private int getTimes(String rollDescription, int dIndex){
        if (dIndex > 0){
            return Integer.parseInt(rollDescription.substring(0,dIndex));
        }

        return 1;
    }

    private int getBonus(String rollDescription, int bonusSignIndex){
        if (bonusSignIndex > 0){
            return Integer.parseInt(rollDescription.substring(bonusSignIndex + 1));
        }

        return 0;
    }

    private int getSides(String rollDescription, int dIndex, int bonusSignIndex){
        int endIndex;
        if (bonusSignIndex == - 1){
            endIndex = rollDescription.length() - 1;
        }else{
            endIndex = bonusSignIndex;
        }

        return Integer.parseInt(rollDescription.substring(dIndex + 1, endIndex));
    }

    private int getBonusSignIndex(String rollDescription){
        if (rollDescription.contains("+")){
            return rollDescription.indexOf("+");
        }
        if (rollDescription.contains("-")){
            return rollDescription.indexOf("-");
        }
        return -1;
    }

}
