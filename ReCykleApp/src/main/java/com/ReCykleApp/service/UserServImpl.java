package com.ReCykleApp.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReCykleApp.exception.LoginException;
import com.ReCykleApp.exception.UserException;
import com.ReCykleApp.module.CurrentSession;
import com.ReCykleApp.module.User;
import com.ReCykleApp.repository.SessionDao;
import com.ReCykleApp.repository.UserDao;

@Service
public class UserServImpl implements UserService {

	@Autowired
	private UserDao uDao;
	@Autowired
	private SessionDao sessionDao;
	@Autowired
	private UserDao udao;

	@Override
	public User createAccount(User user) throws UserException {
		
		User emailCheck = uDao.findByEmail(user.getEmail());
		if (emailCheck != null) {
			throw new UserException("Email already registered with us");
		}
		User phoneCheck = uDao.findByContact(user.getContact());
		if (phoneCheck != null) {
			throw new UserException("Phone number already registered with us");
		}

		LocalDateTime nowDate = LocalDateTime.now();
		user.setRegistrationDate(nowDate);
		return uDao.save(user);
	}

	

	@Override
	public User updateAccount(User user, String sessionId) throws UserException, LoginException {
		// session check
		CurrentSession cur = sessionDao.findByUuid(sessionId);
		if (cur == null) {
			throw new LoginException("Please log in to first");
		}
		Optional<User> activeUser = udao.findById(cur.getUserId());
		if (activeUser.isEmpty()) {
			throw new LoginException("Please login with your account");
		}
		// if new email already registered with another account
		// it will throw error
		User emailCheck = uDao.findByEmail(user.getEmail());
		if (emailCheck != null) {
			throw new UserException("Email already registered with us");
		}
		// if new phone already registered with another account
		// then throw error
		User phoneCheck = uDao.findByContact(user.getContact());
		if (phoneCheck != null) {
			throw new UserException("Phone number already registered with us");
		}
		
		// aadhar can't be modified

		User existUser = activeUser.get();
		if (user.getName() != null) {
			existUser.setName(user.getName());
		}
		if (user.getContact() != null) {
			existUser.setContact(user.getContact());
		}
		if (user.getEmail() != null) {
			existUser.setEmail(user.getEmail());
		}
		if (user.getPassword() != null) {
			existUser.setPassword(user.getPassword());
		}
		if (user.getDate_of_birth() != null) {
			existUser.setDate_of_birth(user.getDate_of_birth());
		}
		// modification date
		existUser.setDateModified(LocalDateTime.now());

		return udao.save(existUser);
	}

}
