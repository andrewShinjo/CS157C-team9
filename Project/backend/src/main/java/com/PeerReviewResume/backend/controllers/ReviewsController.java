package com.PeerReviewResume.backend.controllers;

import java.util.Date;
import java.util.UUID;

import com.PeerReviewResume.backend.entity.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.PeerReviewResume.backend.entity.Reviews;
import com.PeerReviewResume.backend.repositories.ReviewsRepository;

@Controller
public class ReviewsController {
	@Autowired
	private ReviewsRepository reviewRepo;
	
	@GetMapping(value = "/review")
	public String getReviewData(Model model) {
		model.addAttribute("reviews", new Reviews());
		return "pages/review";
	}
	
	@PostMapping({"review", "/resume/review_content"})
	public String onSubmit(@ModelAttribute Reviews reviews, @ModelAttribute Resume resumes) {
		reviews.setUserid(resumes.getUserid());
		reviews.setDate(new Date());
		reviews.setField(resumes.getField());
		reviewRepo.save(reviews);
		return "pages/review";
	}
}


