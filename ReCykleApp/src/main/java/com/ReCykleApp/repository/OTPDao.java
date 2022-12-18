package com.ReCykleApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ReCykleApp.FunctionModule.OTP;

public interface OTPDao extends JpaRepository<OTP, Integer> {

	@Query("select c from OTP c where otpKey=?1")
	public OTP getbyOTP(String OTP);

}
