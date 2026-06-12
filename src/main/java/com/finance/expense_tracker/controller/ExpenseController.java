package com.finance.expense_tracker.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.expense_tracker.dto.ExpenseRequestDTO;
import com.finance.expense_tracker.dto.ExpenseResponseDTO;
import com.finance.expense_tracker.service.ExpenseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/expense")
@CrossOrigin(origins = "http://localhost:5173")
public class ExpenseController {

	private final ExpenseService expenseService;

	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	@PostMapping("/add")
	public ExpenseResponseDTO addExpense(@RequestBody ExpenseRequestDTO dto,
	                                     @AuthenticationPrincipal UserDetails userDetails) {
	    return expenseService.expenseAdd(dto, userDetails.getUsername());
	}

	@GetMapping("/getAll/expenses")
	public List<ExpenseResponseDTO> getExpenses() {
		return expenseService.getAllExpense();
	}

	@GetMapping("/get/{id}")
	public ExpenseResponseDTO getExpenseById(@PathVariable int id) {
		return expenseService.getExpenseById(id);
	}

	@PutMapping("/update/{id}")
	public ExpenseResponseDTO updateExpense(@PathVariable int id, @RequestBody ExpenseRequestDTO dto) {
		return expenseService.updateExpenseById(dto, id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteExpense(@PathVariable int id) {
		expenseService.deleteExpenseById(id);
		return "Expense deleted successfully"; 
	} 

}
