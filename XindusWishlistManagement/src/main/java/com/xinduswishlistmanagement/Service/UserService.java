package com.xinduswishlistmanagement.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xinduswishlistmanagement.Exception.UserException;
import com.xinduswishlistmanagement.Model.Users;
import com.xinduswishlistmanagement.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Users registerUser(Users users) throws UserException {
		Optional<Users> optUser = userRepository.findByEmail(users.getEmail());
		if (optUser.isPresent()) {
	       throw new UserException("User exists with email " + users.getEmail());
		}
		users.setUserId(UUID.randomUUID().toString());
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		return	userRepository.save(users);
	}
	
	public List<Users> getAllUserDetails() throws UserException {
		List<Users> users = userRepository.findAll();
		if (users == null) {
			throw new UserException("No user found");
		}
		return users;
	}

}
