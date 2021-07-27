package com.PeerReviewResume.backend.converters;
import com.PeerReviewResume.backend.commands.ResumeForm;
import com.PeerReviewResume.backend.entity.Resume;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ResumeFormToResume implements Converter<ResumeForm, Resume> {
    @Override
    public Resume convert( ResumeForm resumeForm) {
        Resume resume = new Resume();
        if (resumeForm.getUserid() != null) {
            resume.setUserid(resumeForm.getUserid());
        }
        resume.setField(resumeForm.getField());
        resume.setObjective(resumeForm.getObjective());
        resume.setEducation(resumeForm.getEducation());
        resume.setQualifications(resumeForm.getQualifications());
        resume.setWork_experience(resumeForm.getWork_experience());
        resume.setCertificates(resumeForm.getCertificates());
        resume.setDate(resumeForm.getDate());
        return resume;
    }
}
