package com.xinduswishlistmanagement.Service;

import com.xinduswishlistmanagement.Exception.UserException;
import com.xinduswishlistmanagement.Model.Users;

public interface UserService {
	
	public Users registerUser(Users users) throws UserException;

}
