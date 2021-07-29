package com.PeerReviewResume.backend.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.PeerReviewResume.backend.entity.Resume;
import com.PeerReviewResume.backend.repositories.ResumeRepository;
import com.PeerReviewResume.backend.repositories.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.PeerReviewResume.backend.entity.Reviews;
import com.PeerReviewResume.backend.repositories.ReviewsRepository;

@Controller
public class ReviewsController {
	@Autowired
	private ReviewsRepository reviewRepo;
	@Autowired
	private UserCredentialsRepository userCredentialsRepository;
	@Autowired
	private ResumeRepository resumeRepository;


	@GetMapping(value = "/review")
	public String getReviewData(Model model) {
		model.addAttribute("reviews", new Reviews());
		return "pages/review";
	}
	
	@PostMapping(value ="review")
	public String onSubmit(@ModelAttribute Reviews reviews) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		UUID currentUserId = userCredentialsRepository.findByEmail(email).get().getUserid();
		List<Resume> resumes = new ArrayList<>();
		resumeRepository.findAll().forEach(resumes::add);
		for (Resume resume: resumes) {
			if (!resume.getUserid().equals(currentUserId)) {
				reviews.setUserid(resume.getUserid());
				reviews.setField(resume.getField());
			}
		}
		reviews.setDate(new Date());
		reviewRepo.save(reviews);
		return "pages/review";
	}
}


