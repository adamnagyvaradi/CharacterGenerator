package com.example.charactergenerator.service;

import org.springframework.stereotype.Service;

@Service
public class RandomService {

    public int randomRoll(int sides) {
        return (int) ((Math.random() * sides + 1));
    }
}
