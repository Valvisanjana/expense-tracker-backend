package com.finance.expense_tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finance.expense_tracker.dto.ExpenseRequestDTO;
import com.finance.expense_tracker.dto.ExpenseResponseDTO;
import com.finance.expense_tracker.entity.Category;
import com.finance.expense_tracker.entity.Expense;
import com.finance.expense_tracker.entity.User;
import com.finance.expense_tracker.exception.CategoryNotFoundException;
import com.finance.expense_tracker.exception.ExpenseNotFoundException;
import com.finance.expense_tracker.exception.UserNotFoundException;
import com.finance.expense_tracker.repository.CategoryRepository;
import com.finance.expense_tracker.repository.ExpenseRepository;
import com.finance.expense_tracker.repository.UserRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	private final ExpenseRepository expenseRepository;
	private final CategoryRepository categoryRepository;
	private final UserRepository userRepository;

	public ExpenseServiceImpl(ExpenseRepository expenseRepository, CategoryRepository categoryRepository,
			UserRepository userRepository) {
		this.expenseRepository = expenseRepository;
		this.categoryRepository = categoryRepository;
		this.userRepository = userRepository;
	}

	@Override
	public ExpenseResponseDTO expenseAdd(ExpenseRequestDTO dto, String userEmail) {
		// Fetch logged-in user from email (from JWT)
		User user = userRepository.findByEmail(userEmail)
				.orElseThrow(() -> new UserNotFoundException("User not found"));

		// Creating new expense
		Expense expense = new Expense();
		expense.setAmount(dto.getAmount());
		expense.setTitle(dto.getTitle());
		expense.setDate(dto.getDate());

		// category check
		Category category = categoryRepository.findById(dto.getCategoryId())
				.orElseThrow(() -> new CategoryNotFoundException("Category not found"));
		expense.setCategory(category);
		expense.setUser(user);

		// save to DB
		Expense savedExpense = expenseRepository.save(expense);
		return new ExpenseResponseDTO(savedExpense.getId(), savedExpense.getTitle(), savedExpense.getAmount(),
				savedExpense.getDate(), savedExpense.getCategory().getCategoryName());
	}

	@Override
	public List<ExpenseResponseDTO> getAllExpense() {
		// get entity data
		List<Expense> expenses = expenseRepository.findAll();
		// entity data converted into DTO
		return expenses.stream().map(ex -> new ExpenseResponseDTO(ex.getId(), ex.getTitle(), ex.getAmount(),
				ex.getDate(), ex.getCategory().getCategoryName())).toList();
	}

	@Override
	public ExpenseResponseDTO getExpenseById(int id) {
		// if id found
		Expense expense = expenseRepository.findById(id)
				.orElseThrow(() -> new ExpenseNotFoundException("Expense Not Found with ID: " + id));
		// then return
		return new ExpenseResponseDTO(expense.getId(), expense.getTitle(), expense.getAmount(), expense.getDate(),
				expense.getCategory().getCategoryName());
	}

	@Override
	public ExpenseResponseDTO updateExpenseById(ExpenseRequestDTO dto, int id) {
		// if expense exist
		Expense expense = expenseRepository.findById(id)
				.orElseThrow(() -> new ExpenseNotFoundException("Expense Not Found with ID: " + id));
		// update field
		expense.setAmount(dto.getAmount());
		expense.setDate(dto.getDate());
		expense.setTitle(dto.getTitle());

		// category check
		Category category = categoryRepository.findById(dto.getCategoryId())
				.orElseThrow(() -> new CategoryNotFoundException("Catgeory not Found"));
		expense.setCategory(category);

		// save new updated expense to DB
		Expense updatedExpense = expenseRepository.save(expense);
		// in response convert into DTO
		return new ExpenseResponseDTO(updatedExpense.getId(), updatedExpense.getTitle(), updatedExpense.getAmount(),
				updatedExpense.getDate(), updatedExpense.getCategory().getCategoryName());

	}

	@Override
	public void deleteExpenseById(int id) {
		// if expense exist
		if (!expenseRepository.existsById(id)) {
			throw new ExpenseNotFoundException("Expense Not Found with ID: " + id);
		}

		expenseRepository.deleteById(id);
	}

}
