package com.guispin.spring.noesis.recruiting.domain;

import com.guispin.spring.noesis.recruiting.enums.AcademicDegreeEnum;
import com.guispin.spring.noesis.recruiting.enums.WorkingTimeEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Applicant {
    @Id
    @GeneratedValue
    @Column(name = "idApplicant")
    private Long id;
    @Column(name = "applicantFullname")
    private String fullname;
    @Column(name = "applicantEmail")
    private String email;
    @Column(name = "applicantContactNumber")
    private String contactNumber;
    @Column(name = "applicantMinimunSalary")
    private Long minimunSalary;
    @Column(name = "applicantWorkingTime")
    private WorkingTimeEnum workingTime;
    @OneToOne(cascade = CascadeType.ALL)
    private AcademicDegree academicDegree;
    @OneToMany(cascade = CascadeType.ALL)
    private List<TechnicalSkills> technicalSkillsList;

    private Integer rating;

    public Applicant() {
        this.academicDegree = new AcademicDegree();
        this.academicDegree.setAcademicDegreeName(AcademicDegreeEnum.bachelorCS);
    }

    public Integer getRating() {
        return technicalSkillsList
                .stream()
                .map(technicalSkills -> Integer.valueOf(technicalSkills.getLevel()))
                .reduce(Integer::sum).get();
    }

    public void setTechnicalSkillsList(List<TechnicalSkills> technicalSkillsList) {
        this.technicalSkillsList = technicalSkillsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Long getMinimunSalary() {
        return minimunSalary;
    }

    public void setMinimunSalary(Long minimunSalary) {
        this.minimunSalary = minimunSalary;
    }

    public WorkingTimeEnum getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(WorkingTimeEnum workingTime) {
        this.workingTime = workingTime;
    }

    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public String getAcademicDegreeName() {
        return this.academicDegree.getAcademicDegreeName().toString();
    }
    public void setAcademicDegreeName(String name) {
        this.academicDegree.setAcademicDegreeName(AcademicDegreeEnum.valueOf(name));
    }

    public void setAcademicDegree(AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public List<TechnicalSkills> getTechnicalSkillsList() {
        if (this.technicalSkillsList ==null) {
            this.technicalSkillsList = new ArrayList<TechnicalSkills>();
        }
        return technicalSkillsList;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", minimunSalary=" + minimunSalary +
                ", workingTime=" + workingTime +
                ", academicDegree='" + academicDegree + '\'' +
                ", technicalSkillsList=" + technicalSkillsList +
                '}';
    }
}
