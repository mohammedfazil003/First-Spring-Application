package com.ecommerce.project.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CatergoryService;

@RestController
@RequestMapping("/api/public")
public class CategoryController {

	@Autowired
	CatergoryService categoryService;

	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategories() {
		return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
	}

	@PostMapping("/categories")
	public ResponseEntity<String> createCategory(@RequestBody Category category) {
		categoryService.createCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body("Category created successfully!");
	}

	@DeleteMapping("/categories/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
		try {
			String status = categoryService.deleteCategories(categoryId);
			return new ResponseEntity<>(status, HttpStatus.OK);

		} catch (ResponseStatusException ex) {
			return new ResponseEntity<>(ex.getReason(), ex.getStatusCode());
		}
	}

	@PutMapping("/categories/{categoryId}")
	public ResponseEntity<String> updateCategory(@RequestBody Category updateCategory, @PathVariable Long categoryId) {

		try {

			Category category = categoryService.updateCategory(updateCategory, categoryId);
			return new ResponseEntity<>("category with category id " + category.getCategoryId() + "is updated",
					HttpStatus.OK);

		} catch (ResponseStatusException ex) {
			return new ResponseEntity<>(ex.getReason(), ex.getStatusCode());

		}
	}

}
