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
    private String field;
    @Column
    private String objective;
    @Column
    private String education;
    @Column
    private String qualifications;
    @Column
    private String work_experience;
    @Column
    private String certificates;
    @Column
    private Date date;

    /**
     * Default Constructor
     */
    public Resume() {}

    /**
     * Constructor with all parameters
     */
    public Resume(UUID userid, String field, String objective, String education, String qualifications, String work_experience, String certificates, Date date) {
        this.userid = userid;
        this.field = field;
        this.objective = objective;
        this.education = education;
        this.qualifications = qualifications;
        this.work_experience = work_experience;
        this.certificates = certificates;
        this.date = date;
    }

    // getter and setter methods for different fields
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

    public String getCertificates() { return certificates; }

    public void setCertificates(String certificates) { this.certificates = certificates; }

    public Date getDate() { return date; }

    public void setDate (Date date) {
        this.date = date;
    }
}
