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
    private Date last_modified_date;

    /**
     * Default Constructor
     */
    public Resume() {}

    /**
     * Constructor with all parameters
     */
    public Resume(UUID userid, String category, String objective, String education, String qualifications, String work_experience, Date last_modified_date) {
        this.userid = userid;
        this.category = category;
        this.objective = objective;
        this.education = education;
        this.qualifications = qualifications;
        this.work_experience = work_experience;
        this.last_modified_date = last_modified_date;
    }



}
