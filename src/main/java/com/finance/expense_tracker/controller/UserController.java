package com.finance.expense_tracker.controller;
import org.springframework.web.bind.annotation.RestController;

import com.finance.expense_tracker.dto.UserRequestDTO;
import com.finance.expense_tracker.dto.UserResponseDTO;
import com.finance.expense_tracker.entity.User;
import com.finance.expense_tracker.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController 
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

     
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	public UserController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
     
     @PostMapping("/register")
     public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO request, User id) {  
    	 
    	 // DTO → Entity convert
    	    User user = new User();
    	    user.setUsername(request.getUsername());
    	    user.setEmail(request.getEmail());
    	    user.setPassword(passwordEncoder.encode(request.getPassword()));

    	    // Save entity
    	    User savedUser = userRepository.save(user);

    	    // Entity → Response DTO
    	    UserResponseDTO response = new UserResponseDTO();
    	    response.setUsername(savedUser.getUsername());
    	    response.setEmail(savedUser.getEmail());

    	    return new ResponseEntity<>(response, HttpStatus.CREATED);
         
     }
     
      
}
