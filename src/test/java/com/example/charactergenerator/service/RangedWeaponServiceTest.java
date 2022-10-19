package com.example.charactergenerator.service;

import com.example.charactergenerator.model.RangedWeapon;
import com.example.charactergenerator.repository.RangedWeaponRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RangedWeaponServiceTest {

    @Test
    void saveAllTest() {

        RangedWeaponRepository rangedWeaponRepository
                = Mockito.mock(RangedWeaponRepository.class);

        RangedWeaponService rangedWeaponService
                = new RangedWeaponService(rangedWeaponRepository);

        List<RangedWeapon> rangedWeaponList = new ArrayList<>();

        rangedWeaponService.saveAll(rangedWeaponList);

        Mockito.verify(rangedWeaponRepository).saveAll(rangedWeaponList);
    }

    @Test
    void findAllTest() {

        RangedWeaponRepository rangedWeaponRepository
                = Mockito.mock(RangedWeaponRepository.class);

        RangedWeaponService rangedWeaponService
                = new RangedWeaponService(rangedWeaponRepository);

        List<RangedWeapon> rangedWeaponList = new ArrayList<>();

        Mockito.when(rangedWeaponService.findAll()).thenReturn(rangedWeaponList);

        List<RangedWeapon> serviceResult = rangedWeaponService.findAll();

        assertEquals(rangedWeaponList, serviceResult);
    }

}