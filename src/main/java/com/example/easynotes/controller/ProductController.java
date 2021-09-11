/**
 * 
 */
package com.example.easynotes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.model.Product;
import com.example.easynotes.service.ProductService;

/**
 * @author Electem2
 *
 */
@RestController
@RequestMapping("/productapi")
public class ProductController {
	@Autowired
	ProductService productservice;

	@PostMapping("/product")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productservice.saveProduct(product);

	}

	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable(value = "id") Long productid) {
		return productservice.fetchById(productid);
	}

	@PutMapping("/productss/{id}")
	public Product updateProduct(@Valid @RequestBody Product productdetails,
			@PathVariable(value = "id") Long productid) {
		return productservice.updateProduct(productdetails, productid);

	}

}
