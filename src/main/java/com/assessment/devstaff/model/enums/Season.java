package com.assessment.devstaff.model.enums;

public enum Season {
    SPRING("spring"),
    SUMMER("summer"),
    AUTUMN("autumn"),
    WINTER("winter");

    private final String type;

    Season(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
