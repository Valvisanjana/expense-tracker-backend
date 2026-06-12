package com.finance.expense_tracker.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExpenseRequestDTO {
	private String title;
	private Double amount;
	private LocalDate date;
	private Long categoryId;

}
