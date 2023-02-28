package com.codingdojo.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.repositories.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository productRepo;
	
	
	//Find All
	public List<Product> allProducts(){
		return productRepo.findAll();
	}
	
	//Find all products associated with category being passed in
	public List<Product> getAssignedProducts(Category category){
		return productRepo.findAllByCategories(category);
	}
	
	
	//Find all products not associated with category being passed in.
	public List<Product> getUnassignedProducts(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
	
	//Find One
	public Product oneProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return null;
		}
	}
	
	
	//Create One
	public Product createProduct(Product product) {
		return productRepo.save(product);
		
	}
	
	//Update One
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
	

	
	
}
