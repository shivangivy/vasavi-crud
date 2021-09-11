/**
 * 
 */
package com.example.easynotes.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Electem2
 *
 */
@Entity
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private  Long productId;
private String name;


@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="productId")
private ProductDescription productdescription;

@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
@JoinColumn(name="productId")
private Set<Company>company = new HashSet<Company>();
/**
 * @return the company
 */
public Set<Company> getCompany() {
	return company;
}
/**
 * @param company the company to set
 */
public void setCompany(Set<Company> company) {
	this.company = company;
}
/**
 * @return the productdescription
 */
public ProductDescription getProductdescription() {
	return productdescription;
}
/**
 * @param productdescription the productdescription to set
 */
public void setProductdescription(ProductDescription productdescription) {
	this.productdescription = productdescription;
}
/**
 * @return the productid
 */
public Long getProductid() {
	return productId;
}
/**
 * @param productid the productid to set
 */
public void setProductid(Long productId) {
	this.productId = productId;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
 
}
