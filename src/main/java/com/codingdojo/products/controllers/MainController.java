package com.codingdojo.products.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.services.CategoryService;
import com.codingdojo.products.services.ProductService;

@Controller
public class MainController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
    //Dash-board
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
    	model.addAttribute("categoryList", categoryService.allCategories());
    	model.addAttribute("productList", productService.allProducts());
    	return "dashboard.jsp";
    }
    
    //Create Category - display form
    @GetMapping("/category/new")
    public String displayNewCategoryForm(@ModelAttribute("newCategory") Category newCategory) {
    	return "newCategory.jsp";
    }
    
    //Create Category - process form
   	@PostMapping("/category/new")
   	public String processCategoryForm(@Valid @ModelAttribute("newCategory") Category newCategory, BindingResult result) {
   		if(result.hasErrors()) {
   			return "newCategory.jsp";
   		}
   		else {
   			categoryService.createCategory(newCategory);
   			return "redirect:/dashboard";
   		}
   	}
    
    
    //Create Product - display form
    @GetMapping("/product/new")
    public String displayNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
    	return "newProduct.jsp";
    }
    
    //Create Product - process form
   	@PostMapping("/product/new")
   	public String processProductForm(@Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result) {
   		if(result.hasErrors()) {
   			return "newProduct.jsp";
   		}
   		else {
   			productService.createProduct(newProduct);
   			return "redirect:/dashboard";
   		}
   	}
   	
   	
   	//View One Category
   	@GetMapping("/category/{id}")
   	public String viewOneCategory(@PathVariable("id") Long id, Model model) {
   		Category category = categoryService.oneCategory(id);
   		model.addAttribute("category", category);
   		model.addAttribute("assignedProducts", productService.getAssignedProducts(category));
   		model.addAttribute("unassignedProducts", productService.getUnassignedProducts(category));
   			return "viewOneCategory.jsp";
   	}
   	
   	
   	//Edit One Category
   	@PostMapping("/category/{id}")
   	public String updateCategory(@PathVariable("id") Long id, @RequestParam(value="productId") Long productId, Model model) {
   		Category category = categoryService.oneCategory(id);
   		Product product = productService.oneProduct(productId);
   		category.getProducts().add(product);
   		categoryService.updateCateogry(category);
   			return "redirect:/category/"+ id;
   	}
   	
   	
   	//View One Product
   	@GetMapping("/product/{id}")
   	public String viewOneProduct(@PathVariable("id") Long id, Model model) {
   		Product product = productService.oneProduct(id);
   		model.addAttribute("product", product);
   		model.addAttribute("assignedCategories", categoryService.getAssignedCategories(product));
   		model.addAttribute("unassignedCategories", categoryService.getUnassignedCategories(product));
   			return "viewOneProduct.jsp";
   	}
   	
   	
   	//Edit One Product
   	@PostMapping("/product/{id}")
   	public String updateProduct(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long categoryId, Model model) {
   		Product product = productService.oneProduct(id);
   		Category category = categoryService.oneCategory(categoryId);
   		product.getCategories().add(category);
   		productService.updateProduct(product);
   			return "redirect:/product/"+ id;
   	}
   	
   	
   	
   	
   	
   	

   	
   	
   	
   	
	
}
