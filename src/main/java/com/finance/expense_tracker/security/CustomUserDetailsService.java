package com.finance.expense_tracker.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.finance.expense_tracker.entity.User;
import com.finance.expense_tracker.exception.UserNotFoundException;
import com.finance.expense_tracker.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> byEmail = userRepository.findByEmail(email);

		if (byEmail.isPresent()) {
			User user = byEmail.get();

			return org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
					.password(user.getPassword()).build();
		} 

		throw new UserNotFoundException("User not found : "+email);
	}

}
