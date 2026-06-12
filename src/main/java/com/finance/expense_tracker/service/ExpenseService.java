package com.finance.expense_tracker.service;

import java.util.List;

import com.finance.expense_tracker.dto.ExpenseRequestDTO;
import com.finance.expense_tracker.dto.ExpenseResponseDTO;

public interface ExpenseService {
	
	List<ExpenseResponseDTO> getAllExpense();
	 
	ExpenseResponseDTO getExpenseById(int id);
	
	ExpenseResponseDTO updateExpenseById(ExpenseRequestDTO dto, int id);
	
	void deleteExpenseById(int id);

	ExpenseResponseDTO expenseAdd(ExpenseRequestDTO dto, String userEmail);
}
