package com.bloggingApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloggingApp.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
	

}
