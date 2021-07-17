package com.PeerReviewResume.backend.entity;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.Column;

/**
 * Representing table 'users'.
 * @author Xiang Liu
 */
@Table("users")
public class User {
    @PrimaryKey
    private UUID userid;

    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String email;
    @Column
    private Date created_date;

    /**
     * Default constructor
     */
    public User() {}

    /**
     * Constructor with all parameters.
     */
    public User(UUID userid, String firstname, String lastname, String email, Date created_date) {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.created_date = created_date;
    }

    // Getter and setter methods for different fields
    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname () {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return created_date;
    }

    public void setCreatedAt(Date created_date) {
        this.created_date = created_date;
    }
}
