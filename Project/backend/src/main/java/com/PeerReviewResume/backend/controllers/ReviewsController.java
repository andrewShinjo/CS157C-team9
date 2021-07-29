package com.PeerReviewResume.backend.controllers;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.PeerReviewResume.backend.entity.Reviews;
import com.PeerReviewResume.backend.repositories.ReviewsRepository;

@Controller
public class ReviewsController {
	private ReviewsRepository reviewRepo;
	
	@GetMapping(value = "/review")
	public String getReviewData(Model model) {
		model.addAttribute("reviews", new Reviews());
		return "pages/review";
	}
	
	@PostMapping(value = "/review")
	public String onSubmit(@ModelAttribute Reviews reviews) {
		reviews.setUserid(new UUID(0,1));
		reviews.setDate(new java.util.Date());
		reviews.setField("Computer Science");
		reviews.setComments("good job");
		System.out.println(reviews.toString());
		reviewRepo.save(reviews);
		return "pages/review";
	}
}


