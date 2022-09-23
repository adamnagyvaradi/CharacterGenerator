package com.example.charactergenerator.dto;

public class RollDto {
    private String details;
    private int result;

    public RollDto() {

    }

    public RollDto(String details, int result) {
        this.details = details;
        this.result = result;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getResult() {
        return result;
    }

    public void setResult(short result) {
        this.result = result;
    }
}
