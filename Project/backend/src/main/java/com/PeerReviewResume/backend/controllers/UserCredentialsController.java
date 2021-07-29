package com.PeerReviewResume.backend.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PeerReviewResume.backend.commands.ResumeForm;
import com.PeerReviewResume.backend.commands.UserForm;
import com.PeerReviewResume.backend.converters.UserFormToUserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.PeerReviewResume.backend.entity.User;
import com.PeerReviewResume.backend.entity.UserCredentials;
import com.PeerReviewResume.backend.repositories.UserCredentialsRepository;
import com.PeerReviewResume.backend.repositories.UserRepository;

@Controller
public class UserCredentialsController {
	@Autowired
	private UserFormToUserCredentials userFormToUserCredentials;
	@Autowired
	private UserCredentialsRepository userCredentialsRepository ;
	
	@Autowired 
	private UserRepository userRepository ;

	@GetMapping(value="/logout")
	public String logout(HttpServletRequest request , HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "/";
	}
	
	@GetMapping(value = "/signUp")
	public String getSignUpForm(Model model, Model model2) {
		model.addAttribute("userCredentials" , new UserCredentials());
		model2.addAttribute("user" , new User());
	
		return "pages/signUp" ;
	}
	
	@PostMapping(value="/signUp")
	public String getSubmittedSignUpDate (@ModelAttribute UserCredentials userCredentials, @ModelAttribute User user) {
		Optional<UserCredentials> uc = userCredentialsRepository.findByEmail(userCredentials.getEmail());
		if (uc.isEmpty()) {
			userCredentials.setPassword(passwordEncoder().encode(userCredentials.getPassword()));
			userCredentialsRepository.save(userCredentials);
			
			user.setCreatedAt(new Date());
			user.setEmail(userCredentials.getEmail());
			user.setUserid(userCredentials.getUserid());
			userRepository.save(user);
		}
		return "redirect:/resume/review_content" ;
	}


	
	@PostConstruct
	public void saveUserCredentials () {
		List<UserCredentials> userCredentials = new ArrayList<UserCredentials>();
		userCredentials.add (new UserCredentials("andrew", passwordEncoder().encode("andrew"), new UUID(0, 1)));
		userCredentials.add (new UserCredentials("martin", passwordEncoder().encode("martin"), new UUID(0, 2)));
		userCredentials.add (new UserCredentials("liu", passwordEncoder().encode("liu"), new UUID(0, 3)));
		
		userCredentialsRepository.saveAll(userCredentials);
	}
	
	@GetMapping ("/getAllUserCredentials")
	public List<UserCredentials> getUserCredentials () {
		return userCredentialsRepository.findAll ();
	}
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
