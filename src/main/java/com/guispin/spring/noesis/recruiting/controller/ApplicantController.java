package com.guispin.spring.noesis.recruiting.controller;

import com.guispin.spring.noesis.recruiting.Service.ApplicantService;
import com.guispin.spring.noesis.recruiting.domain.Applicant;
import com.guispin.spring.noesis.recruiting.domain.TechnicalSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @RequestMapping(value = "/subscribeApplicant")
    public ModelAndView getPagesubscribeApplicant(ModelAndView mv) {
        mv.setViewName("subscribeApplicant");
        mv.addObject("applicant",new Applicant());

        return mv;
    }

    @RequestMapping(value = "/subscribeApplicant", method = RequestMethod.POST, params={"save"})
    public ModelAndView postPagesubscribeApplicant(@ModelAttribute Applicant applicant, ModelAndView mv) {
        applicantService.save(applicant);

        mv.setViewName("menu");

        return mv;
    }


    @RequestMapping(value="/subscribeApplicant", method = RequestMethod.POST, params={"addRow"})
    public String addRow(final Applicant applicant, final BindingResult bindingResult) {
        applicant.getTechnicalSkillsList().add(new TechnicalSkills());
        return "subscribeApplicant";
    }

    @RequestMapping(value="/subscribeApplicant", method = RequestMethod.POST, params={"removeRow"})
    public String removeRow(
            final Applicant applicant, final BindingResult bindingResult,
            final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        applicant.getTechnicalSkillsList().remove(rowId.intValue());
        return "subscribeApplicant";
    }

}
