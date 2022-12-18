package com.ReCykleApp.service;


import com.ReCykleApp.exception.LoginException;
import com.ReCykleApp.exception.UserException;
import com.ReCykleApp.module.LoginDTO;
import com.ReCykleApp.module.User;

public interface LoginService {
	public String logIntoAccount(LoginDTO dto) throws LoginException;

	public String logOutFromAccount(String key) throws LoginException;

	public User getUser(String key, Integer userId) throws LoginException, UserException;
	
	public String OTPgenerate(String sessionId) throws LoginException;

}
