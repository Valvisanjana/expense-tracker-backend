package com.finance.expense_tracker.controller;

import org.springframework.web.bind.annotation.RestController;

import com.finance.expense_tracker.dto.AuthRequest;
import com.finance.expense_tracker.exception.UserNotFoundException;
import com.finance.expense_tracker.security.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@PostMapping("/login")
	public String login(@RequestBody AuthRequest request) {

		// Authenticate user - name and password check
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		// if valid -> generate token
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(request.getEmail());
		} else {
			throw new UserNotFoundException("Invalid username or password");
		}
	}

}
