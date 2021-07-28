package com.PeerReviewResume.backend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;

import javax.annotation.PostConstruct;

import com.PeerReviewResume.backend.commands.ResumeForm;
import com.PeerReviewResume.backend.commands.UserForm;
import com.PeerReviewResume.backend.converters.UserFormToUserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.PeerReviewResume.backend.entity.UserCredentials;
import com.PeerReviewResume.backend.repositories.UserCredentialsRepository;

@RestController
public class UserCredentialsController {
	private UserFormToUserCredentials userFormToUserCredentials;
	@Autowired
	private UserCredentialsRepository userCredentialsRepository ;

	@PostMapping("/users/signUp")
	public Status registerUser(@Valid @RequestBody UserForm userForm) {
		List<UserCredentials> userCredentials = userCredentialsRepository.findAll();
		UserCredentials newUser = userFormToUserCredentials.convert(userForm);
		for (UserCredentials userCredential : userCredentials) {
			if (userCredential.equals(newUser)) {
				System.out.println("User Already exists!");
				return Status.USER_ALREADY_EXISTS;
			}
		}
		userCredentialsRepository.save(newUser);
		return Status.SUCCESS;
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
