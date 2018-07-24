package com.guispin.spring.noesis.recruiting.Service;

import com.guispin.spring.noesis.recruiting.domain.Applicant;

import java.util.List;

public interface ApplicantService {
    List<Applicant> findAll();

    void save(Applicant applicant);
}
