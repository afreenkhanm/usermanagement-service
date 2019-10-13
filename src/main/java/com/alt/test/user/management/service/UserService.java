package com.alt.test.user.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alt.test.user.management.model.User;
import com.alt.test.user.management.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(Long userId) {
		return userRepository.findById(userId);
	}

	public void deleteUser(Long userId) {
	    userRepository.deleteById(userId);
	}

}
