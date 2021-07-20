package com.PeerReviewResume.backend.converters;

import com.PeerReviewResume.backend.commands.ResumeForm;
import com.PeerReviewResume.backend.entity.Resume;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ResumeToResumeForm implements Converter<Resume, ResumeForm> {
    @Override
    public ResumeForm convert (Resume resume) {
        ResumeForm resumeForm = new ResumeForm();
        resumeForm.setUserid(resume.getUserid());
        resumeForm.setCategory(resume.getCategory());
        resumeForm.setObjective(resume.getObjective());
        resumeForm.setEducation(resume.getEducation());
        resumeForm.setQualifications(resume.getQualifications());
        resumeForm.setWork_experience(resume.getWork_experience());
        resumeForm.setDate(resume.getDate());
        return resumeForm;
    }
}
