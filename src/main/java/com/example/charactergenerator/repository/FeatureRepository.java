package com.example.charactergenerator.repository;

import com.example.charactergenerator.model.Feature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeatureRepository extends CrudRepository<Feature,Long> {

    Optional<Feature> findFeaturesByName(String featureName);
}
