/**
 * 
 */
package com.example.easynotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.Product;
import com.example.easynotes.model.ProductType;

/**
 * @author Electem2
 *
 */
@Repository
public interface ProductRespository extends JpaRepository<Product, Long>{
	@Query(value = "SELECT n FROM Product n WHERE n.name = :name")
	List<Product> findAllByname(@Param(value = "name") String name);
	      @Query(value = "SELECT * FROM product P WHERE P.product_type =:productType", nativeQuery = true)
	List<Product> findAllByProductType(@Param(value = "productType") String productType);
	
}


