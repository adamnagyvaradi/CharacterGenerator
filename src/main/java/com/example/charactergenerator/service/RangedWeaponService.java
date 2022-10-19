package com.example.charactergenerator.service;

import com.example.charactergenerator.model.RangedWeapon;
import com.example.charactergenerator.repository.RangedWeaponRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RangedWeaponService {

    private RangedWeaponRepository rangedWeaponRepository;

    public RangedWeaponService(RangedWeaponRepository rangedWeaponRepository){
        this.rangedWeaponRepository = rangedWeaponRepository;
    }

    public void saveAll(List<RangedWeapon> rangedWeapons){
        rangedWeaponRepository.saveAll(rangedWeapons);
    }

    public List<RangedWeapon> findAll(){
        return (List<RangedWeapon>) rangedWeaponRepository.findAll();
    }

    public RangedWeapon findById(String id){
        return rangedWeaponRepository.findById(Long.parseLong(id)).orElseThrow();
    }
}
