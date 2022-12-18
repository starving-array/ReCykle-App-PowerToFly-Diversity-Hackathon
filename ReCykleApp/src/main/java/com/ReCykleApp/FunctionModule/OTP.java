package com.ReCykleApp.FunctionModule;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OTP {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String otpKey;
	private Integer userId;
	private LocalDateTime sessionStart;

	// 5 min expire time for the OTP
	private LocalDateTime sessionExpire;
	private Boolean active;

}
