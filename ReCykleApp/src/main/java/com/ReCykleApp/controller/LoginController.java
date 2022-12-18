package com.ReCykleApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ReCykleApp.exception.LoginException;
import com.ReCykleApp.exception.UserException;
import com.ReCykleApp.module.LoginDTO;
import com.ReCykleApp.module.User;
import com.ReCykleApp.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService userLogin;

	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<String> logInUser(@Valid @RequestBody LoginDTO dto) throws LoginException {

		String result = userLogin.logIntoAccount(dto);

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

	@CrossOrigin
	@PostMapping("/logout")
	public String logoutUser(@RequestParam(required = false) String key) throws LoginException {
		return userLogin.logOutFromAccount(key);

	}

	@CrossOrigin
	@GetMapping("/get")
	public User getAccountDetails(@RequestParam String key, Integer userId) throws LoginException, UserException {

		return userLogin.getUser(key, userId);

	}

}