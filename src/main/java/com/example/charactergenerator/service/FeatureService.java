package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Feature;
import com.example.charactergenerator.repository.FeatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureService {

    private final FeatureRepository featureRepository;

    public FeatureService(FeatureRepository featureRepository){
        this.featureRepository = featureRepository;
    }

    public Feature findFeatureByName(String name){
        return featureRepository.findFeaturesByName(name).orElseThrow();
    }

    public List<Feature> findAllFeatures(){
        return (List<Feature>) featureRepository.findAll();
    }
}
