package com.PeerReviewResume.backend.repositories;
import com.PeerReviewResume.backend.entity.Resume;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;
public interface ResumeRepository extends CrudRepository<Resume, UUID>  {

}
