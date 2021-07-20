package com.PeerReviewResume.backend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		userCredentials.add (new UserCredentials("Email", "Password", new UUID(0, 1)));
		userCredentials.add (new UserCredentials("email2", "password2", new UUID(0, 2)));
		userCredentials.add (new UserCredentials("email3", "password3", new UUID(0, 3)));
		
		userCredentialsRepository.saveAll(userCredentials);
	}
	
	@GetMapping ("/getAllUserCredentials")
	public List<UserCredentials> getUserCredentials () {
		return userCredentialsRepository.findAll ();
	}
	
	
}
