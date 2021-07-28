package com.PeerReviewResume.backend.repositories;

import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.PeerReviewResume.backend.entity.UserCredentials;

public interface UserCredentialsRepository extends CassandraRepository <UserCredentials, String> {
	Optional<UserCredentials> findByEmail (String email);
}
