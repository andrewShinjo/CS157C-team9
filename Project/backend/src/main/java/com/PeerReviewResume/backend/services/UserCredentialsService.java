package com.PeerReviewResume.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.PeerReviewResume.backend.entity.UserCredentials;
import com.PeerReviewResume.backend.repositories.UserCredentialsRepository;

@Service
public class UserCredentialsService implements UserDetailsService {
	@Autowired
	private UserCredentialsRepository userCredentialsRepository ;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserCredentials userCredentials = userCredentialsRepository.findByEmail(username).get();
		
		if(userCredentials == null) throw new UsernameNotFoundException(username) ;
		UserDetails user = User.withUsername(userCredentials.getEmail())
								.password(userCredentials.getPassword())
								.authorities("USER").build();
		
		return user ;
	}

}
