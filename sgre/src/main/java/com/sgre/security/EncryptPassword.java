package com.sgre.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPassword {
	public static void main(String[] args) {
		String adminPassword = new BCryptPasswordEncoder().encode("admin");
		String userPassword = new BCryptPasswordEncoder().encode("user");
		System.out.println(adminPassword);
		System.out.println(userPassword);
	}
}
