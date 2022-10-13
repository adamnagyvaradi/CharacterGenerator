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

    public void saveAll(List<MeleeWeapon> meleeWeapons){
        meleeWeaponRepository.saveAll(meleeWeapons);
    }

    public List<MeleeWeapon> findAll(){
        return (List<MeleeWeapon>) meleeWeaponRepository.findAll();
    }

    public MeleeWeapon findById(String id) {
        return meleeWeaponRepository.findById(Long.parseLong(id)).orElseThrow();
    }
}
