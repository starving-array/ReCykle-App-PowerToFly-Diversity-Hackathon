package com.ReCykleApp.module;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginDTO {

	@NotBlank
	private String mobileNo;

	@NotBlank
	private String password;
}
