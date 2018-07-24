package com.guispin.spring.noesis.recruiting.enums;

public enum AcademicDegreeEnum {
    bachelorCS("Bachelor in Computer Science"),
    mbaCS("MBA in ComputerScience"),
    bachelorE("Bachelor in Economy");

    private String description;

    AcademicDegreeEnum(String s) {
        this.description = s;
    }
}
