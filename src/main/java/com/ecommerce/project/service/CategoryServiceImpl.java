package com.ecommerce.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repositories.CategoryRespository;

@Service
public class CategoryServiceImpl implements CatergoryService {

//	private Long categoryId = 1L;

	@Autowired
	CategoryRespository categoryRepository;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public void createCategory(Category category) {
//		category.setCategoryId(categoryId++);
		categoryRepository.save(category);

	}

	@Override
	public String deleteCategories(Long categoryId) {

		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND"));

		categoryRepository.delete(category);
		return "category with categoryId: " + categoryId + " is deleted successfully";
	}

	@Override
	public Category updateCategory(Category updateCategory, Long categoryId) {

		Category savedCategory = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

		updateCategory.setCategoryId(categoryId);
		savedCategory = categoryRepository.save(updateCategory);
		return savedCategory;

	}

}
