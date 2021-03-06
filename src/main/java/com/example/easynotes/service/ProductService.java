/**
 * 
 */
package com.example.easynotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Product;
import com.example.easynotes.model.ProductType;
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

	public List<Product> fetchallProduct(String name) {
		if(!name.isEmpty())
		{
		 	return productrepository.findAllByname(name);
		}
		return productrepository.findAll();
	}

	public List<Product> fetchByProductType(String productType) {
		return productrepository.findAllByProductType(productType);
	}
}
