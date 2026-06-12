package com.finance.expense_tracker.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class IncomeResponseDTO {

	private Long incomeId;
	private Double amount;
	private String incomeName;
	private LocalDate date;

}
