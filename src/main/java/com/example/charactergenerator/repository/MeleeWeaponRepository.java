package com.example.charactergenerator.repository;

import com.example.charactergenerator.model.MeleeWeapon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeleeWeaponRepository extends CrudRepository<MeleeWeapon, Long> {
}
