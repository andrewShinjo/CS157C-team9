package com.PeerReviewResume.backend.controllers;
import com.PeerReviewResume.backend.commands.ResumeForm;
import com.PeerReviewResume.backend.converters.ResumeToResumeForm;
import com.PeerReviewResume.backend.entity.Resume;
import com.PeerReviewResume.backend.entity.UserCredentials;
import com.PeerReviewResume.backend.repositories.ResumeRepository;
import com.PeerReviewResume.backend.repositories.UserCredentialsRepository;
import com.PeerReviewResume.backend.services.ResumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ResumeController {
    private ResumeService resumeService;

    private ResumeToResumeForm resumeToResumeForm;
    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public void setResumeToResumeForm(ResumeToResumeForm resumeToResumeForm) {
        this.resumeToResumeForm = resumeToResumeForm;
    }

    @Autowired
    public void setResumeService(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @RequestMapping("/")
    public String redirToList() {
        return "pages/home";
    }

    @GetMapping ("/contactUs")
    public String contactUs() {
            return "pages/contactUs";
    }

    @RequestMapping("/review_content")
    public String showResumes( Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();


        UUID currentUserId = userCredentialsRepository.findByEmail(email).get().getUserid();
        List<Resume> resumes = new ArrayList<>();
        resumeRepository.findAll().forEach(resumes::add);
        for (Resume resume: resumes) {
            if(!resume.getUserid().equals(currentUserId)){

                model.addAttribute("resumes", resume);
                return "resume/review_content";
            }
        }
        return "redirect:/";

    }


    @RequestMapping({"/resume/list", "/resume"})
    public String listResumes( Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        UUID currentUserId = userCredentialsRepository.findByEmail(email).get().getUserid();
        model.addAttribute("resumes", resumeService.getById(currentUserId));
        return "resume/list";
    }

    @RequestMapping ("/resume/show/{id}")
    public String getResume(@PathVariable String id, Model model) {
        model.addAttribute("resumes", resumeService.getById(UUID.fromString(id)));
        return "resume/show";
    }

    @RequestMapping ("resume/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        Resume resume = resumeService.getById(UUID.fromString(id));
        ResumeForm resumeForm = resumeToResumeForm.convert(resume);

        model.addAttribute("resumeForm", resumeForm);
        return "resume/resumeform";
    }

    @RequestMapping ("/resume/new")
    public String newResume(Model model) {
        model.addAttribute("resumeForm", new ResumeForm());
        return "resume/resumeform";
    }

    @RequestMapping(value = "/resume", method = RequestMethod.POST)
    public String saveOrUpdateResume(@Valid ResumeForm resumeForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "resume/resumeform";
        }

        Resume savedResume = resumeService.saveOrUpdateResumeForm(resumeForm);
        return "redirect:/resume/show/" + savedResume.getUserid();
    }

    @RequestMapping("/resume/delete/{id}")
    public String delete(@PathVariable String id) {
        resumeService.delete(UUID.fromString(id));
        return "redirect:/resume/list";
    }



}
