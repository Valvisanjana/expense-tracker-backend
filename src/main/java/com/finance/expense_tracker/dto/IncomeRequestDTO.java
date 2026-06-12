package com.finance.expense_tracker.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IncomeRequestDTO {
	private Double amount;
	private String incomeName;
    private LocalDate date; 
}
