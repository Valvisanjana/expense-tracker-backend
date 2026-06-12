package com.finance.expense_tracker.controller;

import java.util.List;

import com.finance.expense_tracker.entity.Category;
import com.finance.expense_tracker.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService ) {
		this.categoryService = categoryService;
	}
	 
	@PostMapping("/addCategory")
	public Category addCateg(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	
	@GetMapping("/categories")
	public List<Category> getAll() {
		return categoryService.getAll();
	}
	
	@GetMapping("/get/{id}")
	public Category getCateById(@PathVariable Long id) {
		return categoryService.getCateById(id);
	}
	
	@PutMapping("/updateCate/{id}")
	public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {		
		return categoryService.updateCategory(id, category);
	}
	
	@DeleteMapping("/remove/{id}")
	public String deleteCategory(@PathVariable Long id) {
		categoryService.deleteCate(id);
		return "Catgeory Removed";
		
	}
	

}
