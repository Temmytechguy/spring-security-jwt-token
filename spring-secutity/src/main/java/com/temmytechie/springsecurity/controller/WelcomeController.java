package com.temmytechie.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.temmytechie.springsecurity.entity.AuthRequest;
import com.temmytechie.springsecurity.util.JwtUtil;

@RestController
public class WelcomeController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String welcome()
	{
		return "Welcome to Temmytechie!!";
	}

	@PostMapping("/authenticate")
	public String generateTokenString(@RequestBody AuthRequest authRequest) throws Exception
	{
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		
		}
			
		 catch (Exception e) {
			 throw new Exception("Invalid userame/password");
		}
		
		return jwtUtil.generateToken(authRequest.getUserName());
		
	}

		
}
