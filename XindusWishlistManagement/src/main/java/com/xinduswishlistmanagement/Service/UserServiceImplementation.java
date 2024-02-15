package com.xinduswishlistmanagement.Service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xinduswishlistmanagement.Exception.UserException;
import com.xinduswishlistmanagement.Model.Users;
import com.xinduswishlistmanagement.Repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	
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
	
}
