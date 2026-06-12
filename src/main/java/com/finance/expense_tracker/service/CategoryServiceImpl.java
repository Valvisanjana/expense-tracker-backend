package com.finance.expense_tracker.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.finance.expense_tracker.entity.Category;
import com.finance.expense_tracker.exception.CategoryNotFoundException;
import com.finance.expense_tracker.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category addCategory(Category category) {
		Category newCate = new Category();
		newCate.setCategoryName(category.getCategoryName());
		return categoryRepository.save(newCate);
	}

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
	
	@Override
	public Category getCateById(Long categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new CategoryNotFoundException("Category Not Found"));
		return category;
	}

	@Override
	public Category updateCategory(Long categoryId, Category category) {
		Category existCate = categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category Not Found with id: " + categoryId));
		
		existCate.setCategoryName(category.getCategoryName());
		return categoryRepository.save(existCate);
	}

	@Override
	public void deleteCate(Long categoryId) {
		categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category Not Found with id: " + categoryId));
		
		categoryRepository.deleteById(categoryId);
	}

}
