package com.finance.expense_tracker.dto;

import java.util.List;

import com.finance.expense_tracker.entity.Expense;

public class DashboardDTO {
	private Double totalIncome;
	private Double totalExpense;
	private Double totalSaving;

	private List<RecentTransactionDTO> recentTransaction;
	
	public DashboardDTO() {
		super();
	}

	public DashboardDTO(Double totalIncome, Double totalExpense, Double totalSaving, List<RecentTransactionDTO> recentTransaction) {
		super();
		this.totalIncome = totalIncome;
		this.totalExpense = totalExpense;
		this.totalSaving = totalSaving;
		this.recentTransaction = recentTransaction;
	}
	
	public Double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(Double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public Double getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(Double totalExpense) {
		this.totalExpense = totalExpense;
	}

	public Double getTotalSaving() {
		return totalSaving;
	}

	public void setTotalSaving(Double totalSaving) {
		this.totalSaving = totalSaving;
	}

	public List<RecentTransactionDTO> getRecentTransaction() {
		return recentTransaction;
	}

	public void setRecentTransaction(List<RecentTransactionDTO> recentTransaction) {
		this.recentTransaction = recentTransaction;
	}

	
}
