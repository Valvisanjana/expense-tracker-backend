package com.finance.expense_tracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.expense_tracker.dto.UserRequestDTO;
import com.finance.expense_tracker.dto.UserResponseDTO;
import com.finance.expense_tracker.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	UserResponseDTO save(UserRequestDTO request);

	Optional<User> findByUsername(String username);

}
