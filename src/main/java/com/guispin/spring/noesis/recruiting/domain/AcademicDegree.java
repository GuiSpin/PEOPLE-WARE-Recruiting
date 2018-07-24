package com.guispin.spring.noesis.recruiting.domain;

import com.guispin.spring.noesis.recruiting.enums.AcademicDegreeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AcademicDegree {

    @Id
    @GeneratedValue
    @Column(name = "idacademicDegree")
    private Long id;
    @Column(name = "academicDegreeName")
    private AcademicDegreeEnum academicDegreeName;

    public AcademicDegreeEnum getAcademicDegreeName() {
        return academicDegreeName;
    }

    public void setAcademicDegreeName(AcademicDegreeEnum academicDegreeName) {
        this.academicDegreeName = academicDegreeName;
    }

    @Override
    public int hashCode() {
        return academicDegreeName.name().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof AcademicDegree)) {
            return false;
        }

        return (this.getAcademicDegreeName().name().equals(((AcademicDegree) o).academicDegreeName.name()));

    }

    @Override
    public String toString() {
        return "AcademicDegree{" +
                "id=" + id +
                ", academicDegreeName=" + academicDegreeName +
                '}';
    }
}
