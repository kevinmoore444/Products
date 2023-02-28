package com.codingdojo.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	Category findByIdIs(Long id);
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);
}
