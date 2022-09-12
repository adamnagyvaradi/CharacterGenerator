package com.example.charactergenerator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    Character testCharacter;

    @BeforeEach
    public void createTestCharacter() {
        testCharacter = new Character("Test", (byte) 10, (byte) 10, (byte) 10,
                (byte) 10, (byte) 10, (byte) 10, (byte) 10, (short) 10);
    }

    @Test
    public void nameTest() {
        assertEquals("Test", testCharacter.getName());
        assertNotEquals("test", testCharacter.getName());
    }

    @Test
    public void attributesTest() {
        assertEquals(10, testCharacter.getHitPoints());
        assertEquals(10, testCharacter.getProficiencyBonus());
        assertEquals(10, testCharacter.getStrength());
        assertEquals(10, testCharacter.getDexterity());
        assertEquals(10, testCharacter.getConstitution());
        assertEquals(10, testCharacter.getIntelligence());
        assertEquals(10, testCharacter.getWisdom());
        assertEquals(10, testCharacter.getCharisma());

        assertNotEquals(1, testCharacter.getHitPoints());
        assertNotEquals(1, testCharacter.getProficiencyBonus());
        assertNotEquals(1, testCharacter.getStrength());
        assertNotEquals(1, testCharacter.getDexterity());
        assertNotEquals(1, testCharacter.getConstitution());
        assertNotEquals(1, testCharacter.getIntelligence());
        assertNotEquals(1, testCharacter.getWisdom());
        assertNotEquals(1, testCharacter.getCharisma());
    }

    @Test
    public void skillsTest() {
        assertEquals(18, testCharacter.getSkills().size());
        assertNotEquals(1, testCharacter.getSkills().size());
    }

}