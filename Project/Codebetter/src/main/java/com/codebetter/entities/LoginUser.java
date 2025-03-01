package com.codebetter.entities;

import org.springframework.validation.annotation.Validated;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Validated
public class LoginUser {

	@Email(message = "Invaild email format")
	@NotBlank(message = "Email is Required")
	private String email;
	@NotBlank(message = "password is required")
	private String password;

	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginUser(@Email(message = "Invaild email format") @NotBlank(message = "Email is Required") String email,
			@NotBlank(message = "password is required") String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginUser [email=" + email + ", password=" + password + "]";
	}

}
