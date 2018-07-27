package com.guispin.spring.noesis.recruiting.Service.impl;

import com.guispin.spring.noesis.recruiting.Service.ApplicantService;
import com.guispin.spring.noesis.recruiting.Service.JobOfferService;
import com.guispin.spring.noesis.recruiting.domain.Applicant;
import com.guispin.spring.noesis.recruiting.domain.JobOffer;
import com.guispin.spring.noesis.recruiting.domain.TechnicalSkills;
import com.guispin.spring.noesis.recruiting.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private JobOfferService jobOfferService;

    @Override
    public List<Applicant> getListAll() {
        return (List) applicantRepository.findAll();
    }

    @Override
    public Applicant getApplicantDetail(Long id) {
        return applicantRepository.findById(id).get();
    }

    @Override
    public List<Applicant> getListApplicantDetail(Long id) {
        return Arrays.asList(applicantRepository.findById(id).get());
    }

    @Override
    public List<JobOffer> getListJobOfferFiltered(List<Applicant> applicantList) {
        Applicant applicant = applicantList.get(0);

        List<JobOffer> jobOfferList = jobOfferService.getListAll();
        List<JobOffer> jobOfferListFiltered = getMatchApplicants(applicant, jobOfferList);

        return jobOfferListFiltered;
    }

    @Override
    public void save(Applicant applicant) {
        applicantRepository.save(applicant);
    }

    @Override
    public List<Applicant> findAll() {
        return (List) applicantRepository.findAll();
    }

    private List<JobOffer> getMatchApplicants(Applicant applicant, List<JobOffer> jobOfferList) {
          return jobOfferList.stream()
                .filter(jobOffer ->  applicant.getMinimunSalary() >= jobOffer.getSalaryRangeMin())
                .filter(jobOffer -> jobOffer.getAcademicDegreeList().contains(applicant.getAcademicDegree()))
                .filter(jobOffer -> {
                    long count = jobOffer.getRequirementsList().stream().filter(requirements -> {
                        Optional<TechnicalSkills> optionalTechnicalSkills = applicant.getTechnicalSkillsList().stream().filter(
                                technicalSkills -> (technicalSkills.getName().equals(requirements.getName())) &&
                                        (Integer.valueOf(technicalSkills.getLevel()) >= Integer.valueOf(requirements.getLevel()))).findAny() ;
                        return optionalTechnicalSkills.isPresent();
                    }).count();

                    return count == jobOffer.getRequirementsList().size();
                }).collect(Collectors.toList());
    };
}
