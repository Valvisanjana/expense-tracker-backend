package com.finance.expense_tracker.service;

import java.util.List;

import com.finance.expense_tracker.dto.IncomeRequestDTO;
import com.finance.expense_tracker.dto.IncomeResponseDTO;

public interface IncomeService {

	IncomeResponseDTO addIncome(IncomeRequestDTO req, String email);
		
	void deleteIncomeById(Long incomeId);

	List<IncomeResponseDTO> getAllIncomes(String email);


}
