package com.example.charactergenerator.service;

import com.example.charactergenerator.model.MeleeWeapon;
import com.example.charactergenerator.repository.MeleeWeaponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeleeWeaponService {

    private MeleeWeaponRepository meleeWeaponRepository;

    public MeleeWeaponService(MeleeWeaponRepository meleeWeaponRepository){
        this.meleeWeaponRepository = meleeWeaponRepository;
    }

    private void saveAll(List<MeleeWeapon> meleeWeapons){
        meleeWeaponRepository.saveAll(meleeWeapons);
    }

    private List<MeleeWeapon> findAll(){
        return (List<MeleeWeapon>) meleeWeaponRepository.findAll();
    }
}
