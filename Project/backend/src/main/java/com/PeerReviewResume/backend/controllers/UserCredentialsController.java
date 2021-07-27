package com.PeerReviewResume.backend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PeerReviewResume.backend.entity.UserCredentials;
import com.PeerReviewResume.backend.repositories.UserCredentialsRepository;

@RestController
public class UserCredentialsController {

	@Autowired
	private UserCredentialsRepository userCredentialsRepository ;
	
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
