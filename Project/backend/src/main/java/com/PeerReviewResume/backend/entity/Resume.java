package com.PeerReviewResume.backend.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * Representing table 'resumes'
 * @author Xiang Liu
 */
@Table("resumes")
public class Resume implements Serializable {
    @PrimaryKey
    private UUID userid;

    @Column
    private String category;
    @Column
    private String objective;
    @Column
    private String education;
    @Column
    private String qualifications;
    @Column
    private String work_experience;
    @Column
    private String date;

    /**
     * Default Constructor
     */
    public Resume() { userid = UUID.randomUUID(); }

    /**
     * Constructor with all parameters
     */
    public Resume(UUID userid, String category, String objective, String education, String qualifications, String work_experience, String date) {
        this.userid = userid;
        this.category = category;
        this.objective = objective;
        this.education = education;
        this.qualifications = qualifications;
        this.work_experience = work_experience;
        this.date = date;
    }

    // getter and setter methods for different fields
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

    public String getDate() { return date; }

    public void setDate (String date) {
        this.date = date;
    }
}
