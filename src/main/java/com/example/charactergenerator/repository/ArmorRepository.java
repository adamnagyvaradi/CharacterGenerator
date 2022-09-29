package com.example.charactergenerator.repository;

import com.example.charactergenerator.model.Armor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmorRepository extends CrudRepository<Armor,Long> {


}
