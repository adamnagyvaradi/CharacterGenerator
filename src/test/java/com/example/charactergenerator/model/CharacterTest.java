package com.example.charactergenerator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    Character testChar;

    @BeforeEach
    void createTestChar() {
        testChar =
                new Character("Test", 1, 1, "d10",1,
                        1, 1, 1, 1,
                        1, 1, 1,
                        CharacterType.ABERRATION,
                        Set.of(SkillType.HISTORY,SkillType.PERCEPTION));
    }

    @Test
    void getAttributeBonusTest() {
        assertEquals(-5, testChar.getAttributeBonus(AttributeType.STR));
        assertEquals(-5, testChar.getAttributeBonus(AttributeType.WIS));

        assertNotEquals(1, testChar.getAttributeBonus(AttributeType.INT));
        assertNotEquals(1, testChar.getAttributeBonus(AttributeType.DEX));
    }

    @Test
    void attributeValueTest() {
        assertEquals(1, testChar.getAttributeValue(AttributeType.STR));
        assertEquals(1, testChar.getAttributeValue(AttributeType.WIS));

        assertNotEquals(-5, testChar.getAttributeValue(AttributeType.INT));
        assertNotEquals(-5, testChar.getAttributeValue(AttributeType.DEX));

        testChar.setAttributeValue(AttributeType.STR, (byte) 7);
        testChar.setAttributeValue(AttributeType.WIS, (byte) 10);

        assertEquals(7, testChar.getAttributeValue(AttributeType.STR));
        assertEquals(10, testChar.getAttributeValue(AttributeType.WIS));

        assertNotEquals(1, testChar.getAttributeValue(AttributeType.STR));
        assertNotEquals(1, testChar.getAttributeValue(AttributeType.WIS));

    }

    @Test
    void proficiencyBonusTest() {
        assertEquals(2, testChar.getProficiencyBonus());
        assertNotEquals(1, testChar.getProficiencyBonus());

        testChar.setChallengeRating((byte) 23);

        assertEquals(7, testChar.getProficiencyBonus());
        assertNotEquals(2, testChar.getProficiencyBonus());

        testChar.setChallengeRating((byte) 35);

        assertThrows(IllegalStateException.class, () -> testChar.getProficiencyBonus());
    }

    @Test
    void  assignSlotsTest() {
        assertArrayEquals(null, testChar.getSlots());

        testChar.assignSlots(5);

        assertArrayEquals(new int[] {4, 3, 2}, testChar.getSlots());

        testChar.assignSlots(17);

        assertArrayEquals(new int[] {4, 3, 3, 3, 2, 1, 1, 1, 1}, testChar.getSlots());
    }
}