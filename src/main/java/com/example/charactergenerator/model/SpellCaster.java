package com.example.charactergenerator.model;


public class SpellCaster {

    private int level;

    private int[] slots;


    public SpellCaster() {
    }

    public SpellCaster(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int[] getSlots() {
        return slots;
    }

    public void setSlots(int[] slots) {
        this.slots = slots;
    }

    public void assignSlots(int level){
        int[] spellSlots = new int[10];

        switch (level) {
            case 1 -> spellSlots[1] = 2;
            case 2 -> spellSlots[1] = 3;
            case 3 -> {
                spellSlots[1] = 4;
                spellSlots[2] = 2;
            }
            case 4 -> {
                spellSlots[1] = 4;
                spellSlots[2] = 3;
            }
            case 5 -> {
                spellSlots[1] = 4;
                spellSlots[2] = 3;
                spellSlots[3] = 2;
            }
            case 6 -> {
                spellSlots[1] = 4;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
            }
            case 7 -> {
                spellSlots[1] = 4;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 1;
            }
            case 8 -> {
                spellSlots[1] = 4;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 2;
            }
            case 9 -> {
                spellSlots[1] = 4;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 3;
                spellSlots[5] = 1;
            }
            case 10 -> {
                spellSlots[1] = 4;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 3;
                spellSlots[5] = 2;
            }
            case 11, 12 -> {
                spellSlots[1] = 4;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 3;
                spellSlots[5] = 2;
                spellSlots[6] = 1;
            }
            case 13, 14 -> {
                spellSlots[1] = 4;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 3;
                spellSlots[5] = 2;
                spellSlots[6] = 1;
                spellSlots[7] = 1;
            }
            case 15, 16 -> {
                spellSlots[1] = 4;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 3;
                spellSlots[5] = 2;
                spellSlots[6] = 1;
                spellSlots[7] = 1;
                spellSlots[8] = 1;
            }
            case 17 -> {
                spellSlots[1] = 4;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 3;
                spellSlots[5] = 2;
                spellSlots[6] = 1;
                spellSlots[7] = 1;
                spellSlots[8] = 1;
                spellSlots[9] = 1;
            }
            case 18 -> {
                spellSlots[1] = 4;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 3;
                spellSlots[5] = 3;
                spellSlots[6] = 1;
                spellSlots[7] = 1;
                spellSlots[8] = 1;
                spellSlots[9] = 1;
            }
            case 19 -> {
                spellSlots[1] = 4;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 3;
                spellSlots[5] = 3;
                spellSlots[6] = 2;
                spellSlots[7] = 1;
                spellSlots[8] = 1;
                spellSlots[9] = 1;
            }
            case 20 -> {
                spellSlots[1] = 4;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 3;
                spellSlots[5] = 3;
                spellSlots[6] = 2;
                spellSlots[7] = 2;
                spellSlots[8] = 1;
                spellSlots[9] = 1;
            }
            default -> {
                spellSlots[1] = 0;
                spellSlots[2] = 0;
                spellSlots[3] = 0;
                spellSlots[4] = 0;
                spellSlots[5] = 0;
                spellSlots[6] = 0;
                spellSlots[7] = 0;
                spellSlots[8] = 0;
                spellSlots[9] = 0;
            }
        }

        slots = spellSlots;

     }

}
