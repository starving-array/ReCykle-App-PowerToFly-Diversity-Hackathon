package com.ReCykleApp.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReCykleApp.FunctionModule.OTP;
import com.ReCykleApp.exception.LoginException;
import com.ReCykleApp.exception.UserException;
import com.ReCykleApp.module.CurrentSession;
import com.ReCykleApp.module.LoginDTO;
import com.ReCykleApp.module.User;
import com.ReCykleApp.repository.OTPDao;
import com.ReCykleApp.repository.SessionDao;
import com.ReCykleApp.repository.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServImpl implements LoginService {

	@Autowired
	private UserDao uDao;

	@Autowired
	private SessionDao sDao;

	@Autowired
	private OTPDao otpDao;

	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {

		User existingUser = uDao.findByContact(dto.getMobileNo());

		if (existingUser == null) {

			throw new LoginException("Please Enter a valid mobile number");

		}

		Optional<CurrentSession> validUserSessionOpt = sDao.findById(existingUser.getUserId());

		if (validUserSessionOpt.isPresent()) {

			throw new LoginException("User already Logged In with this number");

		}

		if (existingUser.getPassword().equals(dto.getPassword())) {

			String key = RandomString.make(7);

			CurrentSession currentUserSession = new CurrentSession(existingUser.getUserId(), key, LocalDateTime.now());

			sDao.save(currentUserSession);

			return currentUserSession.toString();
		} else
			throw new LoginException("Please Enter a valid password");

	}

	// **************************************************

	@Override
	public String logOutFromAccount(String key) throws LoginException {

		CurrentSession validUserSession = sDao.findByUuid(key);

		if (validUserSession == null) {
			throw new LoginException("User Not Logged In with this number");
		}

		sDao.delete(validUserSession);

		return "Logged Out..!!";

	}

	@Override
	public User getUser(String key, Integer userId) throws LoginException, UserException {
		// TODO Auto-generated method stub
		User user = new User();
		CurrentSession validUserSession = sDao.findByUuid(key);
		Optional<User> validUser = uDao.findById(userId);

		if (validUserSession == null) {
			throw new LoginException("Please enter correct key..!!");

		}
		if (validUser.isEmpty()) {
			throw new UserException("Please enter correct user id..!!");

		}

		if (validUserSession.getUserId() == validUser.get().getUserId()) {
			user = validUser.get();
			return user;
		}
		throw new UserException("Please enter correct user id..!!");

	}

	@Override
	public String OTPgenerate(String sessionId) throws LoginException {
		CurrentSession validUserSession = sDao.findByUuid(sessionId);
		if (validUserSession == null) {
			throw new LoginException("Please enter correct key..!!");

		}
		OTP otp = new OTP();

		String otpKey = RandomString.make(4);

		OTP checkOtp = otpDao.getbyOTP(otpKey);
		while (checkOtp != null) {
			otpKey = RandomString.make(4);
			checkOtp = otpDao.getbyOTP(otpKey);
		}
		OTP newOtp = new OTP();
		newOtp.setActive(true);
		newOtp.setOtpKey(otpKey);
		newOtp.setSessionStart(LocalDateTime.now());
		newOtp.setSessionExpire(LocalDateTime.now().minusMinutes(5));
		newOtp.setUserId(validUserSession.getUserId());
		otpDao.save(newOtp);
		return otpKey;

	}

}
