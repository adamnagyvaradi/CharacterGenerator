package com.example.charactergenerator.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class RollServiceTest {

    @Test
    void rollTest() {

        RandomService randomService = Mockito.mock(RandomService.class);

        Mockito.when(
                randomService.randomRoll(Mockito.anyInt()))
                .thenReturn(4);

        RollService service = new RollService(randomService);

        assertEquals(4, service.roll("1d4").getResult());
        assertEquals(4, service.roll("1d12").getResult());
        assertEquals(4, service.roll("1d20").getResult());

        assertEquals(8, service.roll("2d4").getResult());
        assertEquals(8, service.roll("2d12").getResult());
        assertEquals(8, service.roll("2d20").getResult());

        assertEquals(12, service.roll("3d4").getResult());
        assertEquals(16, service.roll("4d12").getResult());
        assertEquals(20, service.roll("5d20").getResult());

    }

}