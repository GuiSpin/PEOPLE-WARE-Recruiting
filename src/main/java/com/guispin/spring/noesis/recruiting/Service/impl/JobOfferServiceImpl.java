package com.guispin.spring.noesis.recruiting.Service.impl;

import antlr.ASTNULLType;
import com.guispin.spring.noesis.recruiting.Service.ApplicantService;
import com.guispin.spring.noesis.recruiting.Service.JobOfferService;
import com.guispin.spring.noesis.recruiting.domain.Applicant;
import com.guispin.spring.noesis.recruiting.domain.JobOffer;
import com.guispin.spring.noesis.recruiting.domain.TechnicalSkills;
import com.guispin.spring.noesis.recruiting.repository.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobOfferServiceImpl implements JobOfferService {

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private ApplicantService applicantService;

    @Override
    public void save(JobOffer jobOffer) {
        jobOfferRepository.save(jobOffer);
    }

    @Override
    public List<JobOffer> getListAll() {
        return (List) jobOfferRepository.findAll();
    }

    @Override
    public JobOffer findById(Long id) {
        return jobOfferRepository.findById(id).get();
    }

    @Override
    public List<JobOffer> getListJobOfferDetail(Long id) {
        return Arrays.asList(jobOfferRepository.findById(id).get());
    }

    @Override
    public List<Applicant> getListApplicantSorted(List<JobOffer> jobOfferList) {
        JobOffer jobOffer = jobOfferList.get(0);

        List<Applicant> applicantList = applicantService.findAll();
        List<Applicant> applicantListFiltered = getMatchApplicants(jobOffer, applicantList);

        applicantListFiltered.sort(Comparator.comparing(Applicant::getRating).reversed());
        return applicantListFiltered;
    }

    private List<Applicant> getMatchApplicants(JobOffer jobOffer, List<Applicant> applicantList) {
        return applicantList.stream()
                    .filter(applicant -> applicant.getMinimunSalary() >= jobOffer.getSalaryRangeMin() &&
                            applicant.getMinimunSalary() <= jobOffer.getSalaryRangeMax())
                    .filter(applicant -> jobOffer.getAcademicDegreeList().contains(applicant.getAcademicDegree()))
                    .filter(applicant -> {
                        if (jobOffer.getRequirementsList().size() > applicant.getTechnicalSkillsList().size()) return false;
                        long count = jobOffer.getRequirementsList().stream().filter(requirements -> {
                            Optional<TechnicalSkills> optionalTechnicalSkills = applicant.getTechnicalSkillsList().stream().filter(
                                    technicalSkills -> (technicalSkills.getName().equals(requirements.getName())) &&
                                            (Integer.valueOf(technicalSkills.getLevel()) >= Integer.valueOf(requirements.getLevel()))).findAny() ;
                            return optionalTechnicalSkills.isPresent();
                        }).count();

                        return count == jobOffer.getRequirementsList().size();
                    }).collect(Collectors.toList());
    }
}
