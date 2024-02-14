package com.xinduswishlistmanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xinduswishlistmanagement.Exception.UserException;
import com.xinduswishlistmanagement.Model.Users;
import com.xinduswishlistmanagement.Service.UserService;

@RestController
@RequestMapping("/home")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/user")
	public String getUser(){
		return "Welcome Back";
	} 
	
	@GetMapping("/users")
	public List<Users> getAllUsers() throws UserException{
		return userService.getAllUserDetails();
	} 
	

}
