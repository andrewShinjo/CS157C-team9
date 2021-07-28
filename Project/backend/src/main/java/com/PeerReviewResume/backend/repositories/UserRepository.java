package com.PeerReviewResume.backend.repositories;
import com.PeerReviewResume.backend.entity.User;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;
public interface UserRepository extends CrudRepository<User, UUID>  {

}

