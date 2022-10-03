package com.example.charactergenerator.model;

import java.util.ArrayList;
import java.util.List;


public class Encounter {
    private List<Character> characters = new ArrayList<>();
    private boolean editable = true;

    public Encounter(){

    }

    public void addCharacter(Character character){
        characters.add(character);
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}
