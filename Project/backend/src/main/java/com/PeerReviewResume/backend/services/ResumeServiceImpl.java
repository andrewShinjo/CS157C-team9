package com.PeerReviewResume.backend.services;

import com.PeerReviewResume.backend.commands.ResumeForm;
import com.PeerReviewResume.backend.converters.ResumeFormToResume;
import com.PeerReviewResume.backend.entity.Resume;
import com.PeerReviewResume.backend.repositories.ResumeRepository;
import com.PeerReviewResume.backend.repositories.UserCredentialsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ResumeServiceImpl implements ResumeService {

    private ResumeRepository resumeRepository;
    private ResumeFormToResume resumeFormToResume;
    private ResumeService resumeService;
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public ResumeServiceImpl(ResumeRepository resumeRepository, ResumeFormToResume resumeFormToResume) {
        this.resumeRepository = resumeRepository;
        this.resumeFormToResume = resumeFormToResume;
    }

    @RequestMapping("/resume/review_content")
    public String showResumes( Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        UUID currentUserId = userCredentialsRepository.findByEmail(email).get().getUserid();
        model.addAttribute("resumes", resumeService.selectResume(currentUserId));
        return "resume/review_content";

    }
    @Override
    public List<Resume> listAll() {
        List<Resume> resumes = new ArrayList<>();
        resumeRepository.findAll().forEach(resumes::add);
        return resumes;
    }

    @Override
    public Resume getById(UUID id) {
        return resumeRepository.findById(id).orElse(null);
    }

    @Override
    public Resume saveOrUpdate(Resume resume) {
        resumeRepository.save(resume);
        return resume;
    }

    @Override
    public Resume selectResume(UUID id) {
        List<Resume> resumes = new ArrayList<>();
        resumeRepository.findAll().forEach(resumes::add);
        for (Resume resume: resumes) {
            if(!resume.getUserid().equals(id)){
                return resume;
            }
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        resumeRepository.deleteById(id);

    }

    @Override
    public Resume saveOrUpdateResumeForm(ResumeForm resumeForm) {
        Resume savedResume = saveOrUpdate(resumeFormToResume.convert(resumeForm));

        System.out.println("Saved Resume Id: " + savedResume.getUserid());
        return savedResume;
    }
}
