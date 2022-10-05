package com.example.charactergenerator.service;

import com.example.charactergenerator.dto.RollDto;
import org.springframework.stereotype.Service;

@Service
public class RollService {

    private final RandomService randomService;

    public RollService(RandomService diceService) {
        this.randomService = diceService;
    }

    public RollDto roll(String rollDefinition){
        int dIndex = rollDefinition.indexOf('d');

        int bonusSignIndex = getBonusSignIndex(rollDefinition);

        int sides = getSides(rollDefinition,dIndex,bonusSignIndex);

        int times = getTimes(rollDefinition, dIndex);

        int bonus = getBonus(rollDefinition, bonusSignIndex);

        RollDto roll = generateRoll(sides,times);

        if (bonus != 0){
            char bonusSign = rollDefinition.charAt(bonusSignIndex);
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

    protected RollDto generateRoll(int sides, int times) {
        int sum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++){
            int actualRollValue = randomService.randomRoll(sides);
            stringBuilder.append(actualRollValue);

            if (i < times - 1){
                stringBuilder.append(" + ");
            }

            sum += actualRollValue;
        }

        return new RollDto(stringBuilder.toString(), sum);
    }

    protected int getTimes(String rollDescription, int dIndex){
        if (dIndex > 0){
            return Integer.parseInt(rollDescription.substring(0,dIndex));
        }

        return 1;
    }

    protected int getBonus(String rollDescription, int bonusSignIndex){
        if (bonusSignIndex > 0){
            return Integer.parseInt(rollDescription.substring(bonusSignIndex + 1));
        }

        return 0;
    }

    protected int getSides(String rollDescription, int dIndex, int bonusSignIndex){
        int endIndex;
        if (bonusSignIndex == - 1){
            endIndex = rollDescription.length();
        }else{
            endIndex = bonusSignIndex;
        }

        return Integer.parseInt(rollDescription.substring(dIndex + 1, endIndex));
    }

    protected int getBonusSignIndex(String rollDescription){
        if (rollDescription.contains("+")){
            return rollDescription.indexOf("+");
        }
        if (rollDescription.contains("-")){
            return rollDescription.indexOf("-");
        }
        return -1;
    }

}
