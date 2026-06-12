package com.finance.expense_tracker.dto;

import java.util.List;

import com.finance.expense_tracker.entity.Expense;
import com.finance.expense_tracker.entity.Income;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardDTO {
	private Double totalIncome;
	private Double totalExpense;
	private Double totalSaving;
	
	private List<Expense> recentTransaction;
	private List<Income> incomeChart;
}
 