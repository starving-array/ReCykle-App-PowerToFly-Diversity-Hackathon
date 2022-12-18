package com.ReCykleApp.service;

import com.ReCykleApp.exception.LoginException;
import com.ReCykleApp.exception.UserException;
import com.ReCykleApp.module.User;

public interface UserService {

	public User createAccount(User user) throws UserException;
	
	public User updateAccount(User user, String sessionId) throws UserException, LoginException;
	
	
	

	
	
	

}
