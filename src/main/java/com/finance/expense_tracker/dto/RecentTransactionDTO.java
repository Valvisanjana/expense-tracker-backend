package com.finance.expense_tracker.dto;

import java.time.LocalDate;

public class RecentTransactionDTO {
    private String title;
    private Double amount;
    private String categoryName;
    private LocalDate date;
    
    public RecentTransactionDTO() {
		// TODO Auto-generated constructor stub
	}

	public RecentTransactionDTO(String title, Double amount, String categoryName, LocalDate date) {
		super();
		this.title = title;
		this.amount = amount;
		this.categoryName = categoryName;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
    
    
}
