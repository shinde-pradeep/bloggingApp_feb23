package com.bloggingApp.configuration;

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

import com.bloggingApp.entitiesDtos.CategoryDto;
import com.bloggingApp.exceptions.ApiResp;
import com.bloggingApp.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cat")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	
//................................................................
	
//1.create category...............................................

//http://localhost:8083/api/cat/	
	@PostMapping ("/")	
	public ResponseEntity<CategoryDto>  createCategory(@Valid @RequestBody CategoryDto catDto) {

	CategoryDto createdCategor = this.categoryService.createCategory(catDto);
	return new ResponseEntity<CategoryDto>(createdCategor,HttpStatus.CREATED);
		
	}
		
//2.update category...............................................
	
//http://localhost:8083/api/cat/1
		@PutMapping("/{catId}")
		public ResponseEntity <CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categDto, @PathVariable int catId) {
		
		CategoryDto updatedCategory = this.categoryService.updateCategory(categDto, catId);
		return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);

		}		
		
//3.get/find category by id...............................................

//http://localhost:8083/api/cat/1		
		@GetMapping("/{categoryId}")
		public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int categoryId) {		
		
			CategoryDto requiredCategory = this.categoryService.getCategoryById(categoryId);
			return new ResponseEntity<CategoryDto>(requiredCategory,HttpStatus.OK);
			
		}
	
//4.get/find all categories...............................................
		
//http://localhost:8083/api/cat/
		@GetMapping("/")
		public ResponseEntity <List<CategoryDto>> getAllCategories() {		
		
			List<CategoryDto> allCategories = this.categoryService.getAllCategories();
			return new ResponseEntity <List<CategoryDto>> (allCategories, HttpStatus.OK);

		}

		
// 5.delete category by id...............................................

//http://localhost:8083/api/cat/1

		@DeleteMapping("/{catId}")
		public ResponseEntity<ApiResp> deleteCategory(@PathVariable int catId) {

			this.categoryService.deleteCategory(catId);
			return new ResponseEntity<ApiResp>(new ApiResp("category deleted successfully", true), HttpStatus.OK);

		}
		
}
