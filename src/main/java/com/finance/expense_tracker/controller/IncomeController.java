package com.finance.expense_tracker.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.expense_tracker.dto.IncomeRequestDTO;
import com.finance.expense_tracker.dto.IncomeResponseDTO;
import com.finance.expense_tracker.service.IncomeService;

@RestController
@RequestMapping("/api/income")
@CrossOrigin(origins = "http://localhost:5173")
public class IncomeController {

	private final IncomeService incomeService; 
	
	public IncomeController(IncomeService incomeService) {
		this.incomeService = incomeService;
	}
	
	@PostMapping("/addIncome")
	public IncomeResponseDTO addIncome(@RequestBody IncomeRequestDTO req, @AuthenticationPrincipal UserDetails userDetails) {		
		return incomeService.addIncome(req, userDetails.getUsername());
	}
	
	@DeleteMapping("/removeIncome/{id}")
	public void deleteIncome(@PathVariable Long id) {		
		incomeService.deleteIncomeById(id);
	}
	 
	@GetMapping("/getAllIncomes")
	public List<IncomeResponseDTO> getAllIncomes(@AuthenticationPrincipal UserDetails userDetails) {
	    return incomeService.getAllIncomes(userDetails.getUsername());
	} 
	
}
