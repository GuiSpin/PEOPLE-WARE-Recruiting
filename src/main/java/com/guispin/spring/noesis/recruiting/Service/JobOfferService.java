package com.guispin.spring.noesis.recruiting.Service;

import com.guispin.spring.noesis.recruiting.domain.Applicant;
import com.guispin.spring.noesis.recruiting.domain.JobOffer;

import java.util.List;

public interface JobOfferService {
    void save(JobOffer jobOffer);

    List getListAll();

    JobOffer findById(Long id);

    List<JobOffer> getListJobOfferDetail(Long id);

    List<Applicant> getListApplicantSorted(List<JobOffer> jobOfferList);
}
