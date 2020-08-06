package com.sb.service;

import com.sb.dto.UserDto;
import com.sb.model.User;
import com.sb.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Autowired
	private UserRepository userRepository;

    public User save(UserDto user) {
    	User newUser = new User();
  	    newUser.setUsername(user.getUsername());
  	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
  		//newUser.setRoles(user.getRole());
       return userRepository.save(newUser);
    	
    }
    public List<User> findAll(){
    	return userRepository.findAll();
    }
    
    public boolean delete(Long id) {
    	userRepository.deleteById(id);
    	return true;
    	
    }
    public Optional<User> findOne(String username) {
    	return userRepository.findByUsername(username);
    }

    public Optional<User> findById(Long id) {
    	return userRepository.findById(id);
    }
}
