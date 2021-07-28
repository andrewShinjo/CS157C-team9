package com.PeerReviewResume.backend.entity;
import java.util.UUID;
import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * Representing table 'user_credentials'
 * @author Xiang Liu
 */
@Table("user_credentials")
public class UserCredentials implements Serializable{
    @PrimaryKey
    private String email;

    @Column
    private String password;
    @Column
    private UUID userid;

    /**
     * Default constructor
     */
    public UserCredentials() {userid = UUID.randomUUID();}

    /**
     * Constructor with all parameters
     */
    public UserCredentials(String email, String password, UUID userid) {
        this.email = email;
        this.password = password;
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        UserCredentials userCredentials = (UserCredentials) o;
        return Objects.equals(email, userCredentials.email) && Objects.equals(password, userCredentials.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, userid);
    }


}
