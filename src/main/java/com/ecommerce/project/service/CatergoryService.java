package com.ecommerce.project.service;

import java.util.List;

import com.ecommerce.project.model.Category;

public interface CatergoryService {

	List<Category> getAllCategories();

	void createCategory(Category category);

	String deleteCategories(Long categoryId);

	Category updateCategory(Category updateCategory, Long categoryId);

}
