package com.PeerReviewResume.backend.controllers;

import com.PeerReviewResume.backend.entity.Reviews;
import com.PeerReviewResume.backend.entity.Resume;
import com.PeerReviewResume.backend.repositories.ReviewsRepository;
import com.PeerReviewResume.backend.repositories.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.Optional;

public class ReviewsController {

    @Autowired
    private ReviewsRepository reviewsRepository;

    @GetMapping(value = "/review")
    public String getReviewForm(Model model) {
        model.addAttribute("reviews" , new Reviews());

        return "pages/review" ;
    }

    @PostMapping({"/review", "/resume/review_content"})
    public String getSubmittedSignUpDate (@ModelAttribute Reviews reviews, @ModelAttribute Resume resumes) {
        reviews.setUserid(resumes.getUserid());
        reviews.setField(resumes.getField());
        reviews.setDate(new Date());
        reviewsRepository.save(reviews);

        return "redirect:/" ;
    }
}
