package com.guispin.spring.noesis.recruiting.domain;

import com.guispin.spring.noesis.recruiting.enums.WorkingTimeEnum;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JobOffer {

    @Id
    @GeneratedValue
    @Column(name = "idJobOffer")
    private Long id;

    @Column(name = "companyName")
    private String companyName;
    @Column(name = "companyContactNumber")
    private String companyContactNumber;
    @Column(name = "jobTitle")
    private String jobTitle;
    @Column(name = "jobDescription")
    private String jobDescription;
    @Column(name = "salaryRangeMin")
    private Long salaryRangeMin;
    @Column(name = "salaryRangeMax")
    private Long salaryRangeMax;
    @Column(name = "workingTime")
    private WorkingTimeEnum workingTime;
    @OneToMany(cascade = CascadeType.ALL)
    @Size(min = 1)
    private List<AcademicDegree> academicDegreeList;
    @OneToMany(cascade = CascadeType.ALL)
    @Size(min = 1)
    private List<Requirements> requirementsList;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyContactNumber() {
        return companyContactNumber;
    }

    public void setCompanyContactNumber(String companyContactNumber) {
        this.companyContactNumber = companyContactNumber;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Long getSalaryRangeMin() {
        return salaryRangeMin;
    }

    public void setSalaryRangeMin(Long salaryRangeMin) {
        this.salaryRangeMin = salaryRangeMin;
    }

    public Long getSalaryRangeMax() {
        return salaryRangeMax;
    }

    public void setSalaryRangeMax(Long salaryRangeMax) {
        this.salaryRangeMax = salaryRangeMax;
    }

    public WorkingTimeEnum getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(WorkingTimeEnum workingTime) {
        this.workingTime = workingTime;
    }

    public List<AcademicDegree> getAcademicDegreeList() {
        if (academicDegreeList==null) {
            this.academicDegreeList = new ArrayList<AcademicDegree>();
        }
        return academicDegreeList;
    }

    public void setAcademicDegreeList(List<AcademicDegree> academicDegreeList) {
        this.academicDegreeList = academicDegreeList;
    }

    public List<Requirements> getRequirementsList() {
        if (requirementsList==null) {
            this.requirementsList = new ArrayList<Requirements>();
        }
        return requirementsList;
    }

    public void setRequirementsList(List<Requirements> requirementsList) {
        this.requirementsList = requirementsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "JobOffer{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyContactNumber='" + companyContactNumber + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", salaryRangeMin=" + salaryRangeMin +
                ", salaryRangeMax=" + salaryRangeMax +
                ", workingTime=" + workingTime +
                ", academicDegreeList=" + academicDegreeList +
                ", requirementsList=" + requirementsList +
                '}';
    }
}
