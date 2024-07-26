package com.ecommerce.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.model.Category;

public interface CategoryRespository extends JpaRepository<Category, Long> {

}
