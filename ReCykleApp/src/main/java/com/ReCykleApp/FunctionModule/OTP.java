package com.ReCykleApp.FunctionModule;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
