package com.finance.expense_tracker.service;

import java.util.List;

import com.finance.expense_tracker.entity.Category;

public interface CategoryService {

	Category addCategory(Category category);
		
	List<Category> getAll(); 
	
	Category updateCategory(Long categoryId, Category category);
	
	void deleteCate(Long categoryId);

	Category getCateById(Long categoryId);


	
}
