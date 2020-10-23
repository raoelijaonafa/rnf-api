package com.rnf.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderProvider {
	private static PasswordEncoderProvider instance = new PasswordEncoderProvider();
	
	private PasswordEncoder passwordEncoder;
	
	private PasswordEncoderProvider() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public static PasswordEncoderProvider getInstance()
	{
		return instance;
	}
	
	public PasswordEncoder getPasswordEncoder() {
		return this.passwordEncoder;
	}
}
