package com.example.charactergenerator.service;

import com.example.charactergenerator.model.MeleeWeapon;
import com.example.charactergenerator.repository.MeleeWeaponRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeleeWeaponServiceTest {

    @Test
    void saveAllTest() {

        MeleeWeaponRepository meleeWeaponRepository
                = Mockito.mock(MeleeWeaponRepository.class);

        MeleeWeaponService meleeWeaponService
                = new MeleeWeaponService(meleeWeaponRepository);

        List<MeleeWeapon> meleeWeaponList = new ArrayList<>();

        meleeWeaponService.saveAll(meleeWeaponList);

        Mockito.verify(meleeWeaponRepository).saveAll(meleeWeaponList);
    }

    @Test
    void findAllTest() {

        MeleeWeaponRepository meleeWeaponRepository
                = Mockito.mock(MeleeWeaponRepository.class);

        MeleeWeaponService meleeWeaponService
                = new MeleeWeaponService(meleeWeaponRepository);

        List<MeleeWeapon> meleeWeaponList = new ArrayList<>();

        Mockito.when(meleeWeaponService.findAll()).thenReturn(meleeWeaponList);

        List<MeleeWeapon> serviceResult = meleeWeaponService.findAll();

        assertEquals(meleeWeaponList, serviceResult);
    }

}