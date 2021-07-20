package com.PeerReviewResume.backend.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.PeerReviewResume.backend.entity.UserCredentials;

public interface UserCredentialsRepository 
extends CassandraRepository <UserCredentials, Integer>{}
