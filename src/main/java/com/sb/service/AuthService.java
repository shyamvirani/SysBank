package com.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.exception.CustomerNotFoundException;
import com.sb.model.User;
import com.sb.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional(readOnly = true)
	public User getCurrentUser() {
		org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		//principal.get
		return userRepository.findByUsername(principal.getUsername())
				.orElseThrow(() -> new CustomerNotFoundException("User name not found - " + principal.getUsername()));
	}
}
