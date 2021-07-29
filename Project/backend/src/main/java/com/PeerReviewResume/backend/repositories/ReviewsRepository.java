package com.PeerReviewResume.backend.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;
import com.PeerReviewResume.backend.entity.Reviews;
import java.util.UUID;

public interface ReviewsRepository extends CassandraRepository <Reviews, UUID> {
}