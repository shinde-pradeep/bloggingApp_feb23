package com.bloggingApp.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloggingApp.entities.Category;
import com.bloggingApp.entitiesDtos.CategoryDto;
import com.bloggingApp.exceptions.ResourceNotFoundExceptionnn;
import com.bloggingApp.repositories.CategoryRepo;
import com.bloggingApp.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

//..................................................................

//1.create category...............................................
	
	@Override
	public CategoryDto createCategory(CategoryDto catDto) {

		Category category = this.modelMapper.map(catDto,Category.class);
		Category savedCategory =this.categoryRepo.save(category);	 
		CategoryDto catDto_converted=this.modelMapper.map(savedCategory, CategoryDto.class);
		
		return catDto_converted;
	}
	
	
//2.update category...............................................
	

	@Override
	public CategoryDto updateCategory(CategoryDto catDto, Integer catId) {

		Category requiredCategory = this.categoryRepo.findById(catId).orElseThrow(()->new ResourceNotFoundExceptionnn("category","cat. id", catId));
		
		requiredCategory.setcTitle(catDto.getcTitle());
		requiredCategory.setcDescription(catDto.getcDescription());
		
    	Category updatedCategory = this.categoryRepo.save(requiredCategory);
    	CategoryDto converted_catDto = this.modelMapper.map(updatedCategory,CategoryDto.class);
		
    	return converted_catDto;
	}

	
//3.get/find category by id...............................................
	
	@Override
	public CategoryDto getCategoryById(Integer  catId) {
		
		Category requiredCategory = this.categoryRepo.findById(catId).orElseThrow(()->new ResourceNotFoundExceptionnn("category","cat. id", catId));
	    CategoryDto converted_requiredCategory = this.modelMapper.map(requiredCategory,CategoryDto.class);
		return converted_requiredCategory;
	}

//4.get/find all categories...............................................
	

	@Override
	public List<CategoryDto> getAllCategories() {
		
    List<Category> allCategories = this.categoryRepo.findAll();
    List<CategoryDto> converted_allCat = allCategories.stream().map((cat)->this.modelMapper.map(cat,CategoryDto.class))
    		                                                   .collect(Collectors.toList());
	return converted_allCat;
	}

	
//5.delete category by id...............................................
	
	@Override
	public void deleteCategory(Integer catId) {

		Category catToDelete = this.categoryRepo.findById(catId).orElseThrow(()->new ResourceNotFoundExceptionnn("category","category Id", catId));
        this.categoryRepo.delete(catToDelete);	
	
	}
	
	
	
	
	
	
	
}
