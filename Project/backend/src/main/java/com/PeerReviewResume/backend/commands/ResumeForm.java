package com.PeerReviewResume.backend.commands;

import java.util.Date;
import java.util.UUID;

public class ResumeForm {
    private UUID userid;
    private String category;
    private String objective;
    private String education;
    private String qualifications;
    private String work_experience;
    private Date date;

    public UUID getUserid () { return userid; }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public String getCategory() { return category; }

    public void setCategory(String category) {
        this.category = category;

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

    public Date getDate() { return date; }

    public void setDate (Date date) {
        this.date = date;
    }
}
