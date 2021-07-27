package com.PeerReviewResume.backend.commands;

import java.util.Date;
import java.util.UUID;

public class ResumeForm {
    private UUID userid;
    private String field;
    private String objective;
    private String education;
    private String qualifications;
    private String work_experience;
    private String certificates;
    private Date date;

    public UUID getUserid () { return userid; }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public String getField() { return field; }

    public void setField(String field) {
        this.field = field;
    }

    public String getObjective() { return objective; }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getEducation() { return education; }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getQualifications() { return qualifications; }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getWork_experience() { return work_experience; }

    public void setWork_experience(String work_experience) {
        this.work_experience = work_experience;
    }

    public String getCertificates() {
        return certificates;
    }

    public void setCertificates(String certificates) {
        this.certificates = certificates;
    }
    public Date getDate() { return date; }

    public void setDate (Date date) {
        this.date = date;
    }
}
