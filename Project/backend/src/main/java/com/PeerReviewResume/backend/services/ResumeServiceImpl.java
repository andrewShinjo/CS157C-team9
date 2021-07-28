package com.PeerReviewResume.backend.services;

import com.PeerReviewResume.backend.commands.ResumeForm;
import com.PeerReviewResume.backend.converters.ResumeFormToResume;
import com.PeerReviewResume.backend.entity.Resume;
import com.PeerReviewResume.backend.repositories.ResumeRepository;
import com.PeerReviewResume.backend.repositories.UserCredentialsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ResumeServiceImpl implements ResumeService {

    private ResumeRepository resumeRepository;
    private ResumeFormToResume resumeFormToResume;
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public ResumeServiceImpl(ResumeRepository resumeRepository, ResumeFormToResume resumeFormToResume) {
        this.resumeRepository = resumeRepository;
        this.resumeFormToResume = resumeFormToResume;
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
