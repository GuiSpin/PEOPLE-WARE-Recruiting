package com.guispin.spring.noesis.recruiting.Service;

import com.guispin.spring.noesis.recruiting.domain.Applicant;
import com.guispin.spring.noesis.recruiting.domain.JobOffer;

import java.util.List;

public interface ApplicantService {
    List<Applicant> findAll();

    void save(Applicant applicant);

    List<Applicant> getListAll();

    List<Applicant> getListApplicantDetail(Long id);

    Applicant getApplicantDetail(Long id);

    List<JobOffer> getListJobOfferFiltered(List<Applicant> applicantList);
}
