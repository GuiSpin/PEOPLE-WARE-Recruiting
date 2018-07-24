package com.guispin.spring.noesis.recruiting.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TechnicalSkills {

    @Id
    @GeneratedValue
    @Column(name = "idTechnicalSkill")
    private Long id;

    @Column(name = "nameTechnicalSkill")
    private String name;
    @Column(name = "levelTechnicalSkill")
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
        return "TechnicalSkills{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
