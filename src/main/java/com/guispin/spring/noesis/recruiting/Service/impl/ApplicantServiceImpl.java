package com.guispin.spring.noesis.recruiting.Service.impl;

import com.guispin.spring.noesis.recruiting.Service.ApplicantService;
import com.guispin.spring.noesis.recruiting.domain.Applicant;
import com.guispin.spring.noesis.recruiting.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public void save(Applicant applicant) {
        applicantRepository.save(applicant);
    }

    @Override
    public List<Applicant> findAll() {
        return (List) applicantRepository.findAll();
    }
}
