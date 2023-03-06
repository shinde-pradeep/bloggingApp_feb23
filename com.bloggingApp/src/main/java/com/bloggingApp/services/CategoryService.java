package com.bloggingApp.services;

import java.util.List;

import com.bloggingApp.entitiesDtos.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory (CategoryDto catDto);
	
	CategoryDto updateCategory (CategoryDto catDto,Integer catId);

	CategoryDto getCategoryById (Integer catID);

	List<CategoryDto> getAllCategories ();

	void deleteCategory (Integer catId);

}
