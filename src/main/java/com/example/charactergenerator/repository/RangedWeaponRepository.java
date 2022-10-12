package com.example.charactergenerator.repository;

import com.example.charactergenerator.model.RangedWeapon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RangedWeaponRepository extends CrudRepository<RangedWeapon, Long> {
}
