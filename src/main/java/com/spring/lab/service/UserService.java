package com.spring.lab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lab.model.User;
import com.spring.lab.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public void createUser(String email, String fullName) {
		User user = new User();
		user.setEmail(email);
		user.setFullName(fullName);
		
		userRepository.save(user);
	}
	
	public void updateUser(long id, String email, String fullName) {
		User user = userRepository.getOne(id);
		user.setEmail(email);
		user.setFullName(fullName);
		
		userRepository.save(user);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(long id) {
		return userRepository.getOne(id);
	}
	
	public void delete(long id) {
		userRepository.deleteById(id);
	}
 }
