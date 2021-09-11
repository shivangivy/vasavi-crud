/**
 * 
 */
package com.example.easynotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Product;
import com.example.easynotes.repository.ProductRespository;

/**
 * @author Electem2
 *
 */
@Service
public class ProductService {
	@Autowired
	ProductRespository productrepository;

	public Product saveProduct(Product product) {
		return productrepository.save(product);

	}

	public Product fetchById(Long productid) {

		return productrepository.findById(productid)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", productid));
	}

	public Product updateProduct(Product productdetails, Long productid) {

		Product product = productrepository.findById(productid)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", productid));
		product.setName(productdetails.getName());
		product.setProductdescription(productdetails.getProductdescription());
		productrepository.save(product);
		return productdetails;

	}

}
