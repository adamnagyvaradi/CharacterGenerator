package com.example.charactergenerator.repository;

import com.example.charactergenerator.model.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends CrudRepository<Character,Long> {

    Optional<Character>findCharactersByName(String characterName);
    List<Character> findAllByNameContains(String keyword);

}
