package com.example.charactergenerator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    @Test
    void getArmorClassLight() {
        Armor armor = new Armor("Padded", ArmorType.LIGHT, (byte) 11);
        byte result = armor.getArmorClass((byte) 3);
        assertEquals(14, result);

        result = armor.getArmorClass((byte) -1);
        assertEquals(10, result);
    }

    @Test
    void getArmorClassMedium(){
        Armor armor = new Armor("Chain Shirt", ArmorType.MEDIUM, (byte) 13);
        byte result = armor.getArmorClass((byte) 1);
        assertEquals(14, result);

        result = armor.getArmorClass((byte) -1);
        assertEquals(12, result);

        result = armor.getArmorClass((byte) 2);
        assertEquals(15, result);

        result = armor.getArmorClass((byte) 3);
        assertEquals(15, result);
    }

    @Test
    void getArmorClassHeavy(){
        Armor armor = new Armor("Splint", ArmorType.HEAVY, (byte) 17);
        byte result = armor.getArmorClass((byte) 1);
        assertEquals(17, result);

        result = armor.getArmorClass((byte) -1);
        assertEquals(17, result);

        result = armor.getArmorClass((byte) 3);
        assertEquals(17, result);
    }
}