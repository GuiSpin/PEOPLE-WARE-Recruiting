package com.guispin.spring.noesis.recruiting.controller;

import com.guispin.spring.noesis.recruiting.Service.JobOfferService;
import com.guispin.spring.noesis.recruiting.domain.AcademicDegree;
import com.guispin.spring.noesis.recruiting.domain.Applicant;
import com.guispin.spring.noesis.recruiting.domain.JobOffer;
import com.guispin.spring.noesis.recruiting.domain.Requirements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class JobOfferController {

    @Autowired
    private JobOfferService jobOfferService;

    @RequestMapping(value = "/postJobOffer")
    public ModelAndView getPagePostJobOffer(ModelAndView mv) {
        mv.setViewName("postJobOffer");
        mv.addObject("jobOffer",new JobOffer());

        return mv;
    }

    @RequestMapping(value = "/postJobOffer", method = RequestMethod.POST, params={"save"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView postPagePostJobOffer(@ModelAttribute @Valid JobOffer jobOffer, ModelAndView mv) {
        jobOfferService.save(jobOffer);

        mv.setViewName("menu");

        return mv;
    }

    @RequestMapping(value="/postJobOffer", params={"addAcademicRow"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addAcademicRow(final JobOffer jobOffer, final BindingResult bindingResult) {
        jobOffer.getAcademicDegreeList().add(new AcademicDegree());
        return "postJobOffer";
    }

    @RequestMapping(value="/postJobOffer", params={"removeAcademicRow"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String removeAcademicRow(
            final JobOffer jobOffer, final BindingResult bindingResult,
            final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeAcademicRow"));
        jobOffer.getAcademicDegreeList().remove(rowId.intValue());
        return "postJobOffer";
    }

    @RequestMapping(value="/postJobOffer", params={"addSkillRow"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addSkillRow(final JobOffer jobOffer, final BindingResult bindingResult) {
        jobOffer.getRequirementsList().add(new Requirements());
        return "postJobOffer";
    }

    @RequestMapping(value="/postJobOffer", params={"removeSkillRow"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String removeSkillRow(
            final JobOffer jobOffer, final BindingResult bindingResult,
            final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeSkillRow"));
        jobOffer.getRequirementsList().remove(rowId.intValue());
        return "postJobOffer";
    }

    @RequestMapping(value = "/listAllJobOffer")
    public ModelAndView listAllJobOffer(ModelAndView mv) {
        List<JobOffer> jobOfferList = jobOfferService.getListAll();

        mv.addObject("jobOfferList", jobOfferList);
        mv.setViewName("listAllJobOffers");

        return mv;
    }

    @RequestMapping(value = "/jobOfferDetail/{id}")
    public ModelAndView jobOfferDetail(@PathVariable String id, ModelAndView mv, HttpServletRequest request) {

        List<JobOffer> jobOfferList = jobOfferService.getListJobOfferDetail(Long.valueOf(id));

        List<Applicant> applicantListFiltered = jobOfferService.getListApplicantSorted(jobOfferList);

        mv.addObject("applicantList", applicantListFiltered);
        mv.addObject("jobOfferList", jobOfferList);

        mv.setViewName("jobOfferDetail");
        return mv;
    }
}
