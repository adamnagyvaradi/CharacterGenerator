package com.example.charactergenerator.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class RollServiceTest {

    @Test
    void rollTest() {

        RandomService diceService = Mockito.mock(RandomService.class);

        Mockito.when(
                diceService.randomRoll(Mockito.anyInt()))
                .thenReturn(4);

        RollService service = new RollService(diceService);

        assertEquals(8, service.roll("2d4").getResult());
    }

}