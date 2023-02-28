package com.codingdojo.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	Product findByIdIs(Long id);
	List<Product> findAllByCategories(Category category);
	List<Product> findByCategoriesNotContains(Category category);
}
