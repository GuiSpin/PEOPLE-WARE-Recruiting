package com.guispin.spring.noesis.recruiting.enums;

public enum WorkingTimeEnum {
    fulltime("Full-Time"),
    parttime("Part-Time"),
    both("Both");

    private String name;
    WorkingTimeEnum(String s) {
        this.name=s;
    }
}
