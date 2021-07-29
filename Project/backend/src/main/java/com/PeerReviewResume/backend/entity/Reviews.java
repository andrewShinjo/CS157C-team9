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
public class Reviews implements Serializable {
    @PrimaryKey
    private UUID userid;

    @Column
    private String field;
    @Column
    private int objective;
    @Column
    private int education;
    @Column
    private int qualifications;
    @Column
    private int work_experience;
    @Column
    private int certificates;
    @Column
    private String comments;
    @Column
    private Date date;

    /**
     * Default Constructor
     */
    public Reviews() {}

    /**
     * Constructor with all parameters
     */
    public Reviews(UUID userid, String field, int objective, int education, int qualifications, int work_experience, int certificates, String comments, Date date) {
        this.userid = userid;
        this.field = field;
        this.objective = objective;
        this.education = education;
        this.qualifications = qualifications;
        this.work_experience = work_experience;
        this.certificates = certificates;
        this.comments = comments;
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

    public int getObjective() { return objective; }

    public void setObjective(int objective) {
        this.objective = objective;
    }

    public int getEducation() { return education; }

    public void setEducation(int education) {
        this.education = education;
    }

    public int getQualifications() { return qualifications; }

    public void setQualifications(int qualifications) {
        this.qualifications = qualifications;
    }

    public int getWork_experience() { return work_experience; }

    public void setWork_experience(int work_experience) {
        this.work_experience = work_experience;
    }

    public int getCertificates() { return certificates; }

    public void setCertificates(int certificates) { this.certificates = certificates; }

    public String getComments() { return comments;}

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDate() { return date; }

    public void setDate (Date date) {
        this.date = date;
    }

	@Override
	public String toString() {
		return "Reviews [userid=" + userid + ", field=" + field + ", objective=" + objective + ", education="
				+ education + ", qualifications=" + qualifications + ", work_experience=" + work_experience
				+ ", certificates=" + certificates + ", comments=" + comments + ", date=" + date + "]";
	}
    
    
}
