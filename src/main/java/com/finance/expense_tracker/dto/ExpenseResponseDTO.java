package com.finance.expense_tracker.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseResponseDTO {
	private int id; 
	private String title;
	private Double amount;
	private LocalDate date;
	private String categoryName;
}
