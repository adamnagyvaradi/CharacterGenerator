package com.example.charactergenerator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    Character testChar;

    @BeforeEach
    void createTestChar() {
        testChar =
                new Character("Test", 1, 1, 1,
                        1, 1, 1, 1,
                        1, 1, 1,
                        CharacterType.ABERRATION,
                        List.of(SkillType.ACROBATICS,SkillType.RELIGION, SkillType.ARCANA));
    }


    @Test
    void assignSlots() {

    }

    @Test
    void getAttributeBonusTest() {


    }
}