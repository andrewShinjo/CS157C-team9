package com.PeerReviewResume.backend.services;
import com.PeerReviewResume.backend.commands.ResumeForm;
import com.PeerReviewResume.backend.entity.Resume;

import java.util.List;
import java.util.UUID;

public interface ResumeService {
    List<Resume> listAll();
    Resume getById (UUID id);
    Resume saveOrUpdate (Resume resume);
    Resume selectResume(UUID id);
    void delete(UUID id);
    Resume saveOrUpdateResumeForm( ResumeForm resumeForm);
}
