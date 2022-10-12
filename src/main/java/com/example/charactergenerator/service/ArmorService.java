package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Armor;
import com.example.charactergenerator.model.ArmorType;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.model.CharacterType;
import com.example.charactergenerator.repository.ArmorRepository;
import com.example.charactergenerator.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class ArmorService {

    private ArmorRepository armorRepository;

    public ArmorService(ArmorRepository armorRepository) {
        this.armorRepository = armorRepository;
    }

    /*@Autowired
    public void setArmorRepository(ArmorRepository armorRepository) {
        this.armorRepository = armorRepository;
    }*/

    public void saveAll(List<Armor> armors) {
        armorRepository.saveAll(armors);
    }

    public List<Armor> findAll() {
        return (List<Armor>) armorRepository.findAll();
    }

}
