package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Armor;
import com.example.charactergenerator.model.RangedWeapon;
import com.example.charactergenerator.repository.ArmorRepository;
import com.example.charactergenerator.repository.RangedWeaponRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArmorServiceTest {

    @Test
    void saveAllTest() {

        ArmorRepository armorRepository
                = Mockito.mock(ArmorRepository.class);

        ArmorService armorService
                = new ArmorService(armorRepository);

        List<Armor> armorList = new ArrayList<>();

        armorService.saveAll(armorList);

        Mockito.verify(armorRepository).saveAll(armorList);
    }

    @Test
    void findAllTest() {

        ArmorRepository armorRepository
                = Mockito.mock(ArmorRepository.class);

        ArmorService armorService
                = new ArmorService(armorRepository);

        List<Armor> armorList = new ArrayList<>();

        Mockito.when(armorService.findAll()).thenReturn(armorList);

        List<Armor> serviceResult = armorService.findAll();

        assertEquals(armorList, serviceResult);
    }

}