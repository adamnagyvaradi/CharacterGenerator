package com.example.charactergenerator.model;

public class Roll {

    private Integer times;

    private int sides;

    public Roll() {
    }

    public Roll(Integer times, int sides) {
        this.times = times;
        this.sides = sides;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }
}
