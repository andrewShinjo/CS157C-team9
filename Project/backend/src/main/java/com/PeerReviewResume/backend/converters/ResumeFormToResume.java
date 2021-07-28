package com.PeerReviewResume.backend.converters;
import com.PeerReviewResume.backend.commands.ResumeForm;
import com.PeerReviewResume.backend.repositories.UserCredentialsRepository;
import com.PeerReviewResume.backend.entity.Resume;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class ResumeFormToResume implements Converter<ResumeForm, Resume> {
	@Autowired
	UserCredentialsRepository userCredentialsRepository;
	
	
    @Override
    public Resume convert( ResumeForm resumeForm) {
        Resume resume = new Resume();
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        
        UUID currentUserId = userCredentialsRepository.findByEmail(email).get().getUserid();
        
        
        resume.setUserid(currentUserId);
        resume.setField(resumeForm.getField());
        resume.setObjective(resumeForm.getObjective());
        resume.setEducation(resumeForm.getEducation());
        resume.setQualifications(resumeForm.getQualifications());
        resume.setWork_experience(resumeForm.getWork_experience());
        resume.setCertificates(resumeForm.getCertificates());
        resume.setDate(new java.util.Date());
        return resume;
    }
}
