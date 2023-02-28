package com.codingdojo.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	
	//Find All
	public List<Category> allCategories(){
		return categoryRepo.findAll();
	}
	
	//Find all categories associated with product being passed in
	public List<Category> getAssignedCategories(Product product) {
		return categoryRepo.findAllByProducts(product);
	}
	
	//Find all categories not associated with product being passed in.
	public List<Category> getUnassignedCategories(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
	
	//Find One - it's an optional so it can return null if nothing is found.
	public Category oneCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		else {
			return null;
		}
	}
	
	
	
	
	
	//Create one
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
		
	}
	
	
	//Update One
	public Category updateCateogry(Category category) {
		return categoryRepo.save(category);
	}
	
	//Delete One
	public void deleteCategory(Category category) {
		categoryRepo.delete(category);
	}
	
	
	
	

	
}
