package com.guispin.spring.noesis.recruiting.domain;

import javax.persistence.*;

@Entity
public class Requirements {

    @Id
    @GeneratedValue
    @Column(name = "idRequirementJob")
    private Long id;
    @Column(name = "nameRequirement")
    private String name;
    @Column(name = "levelRequirement")
    private String level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Requirements{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
