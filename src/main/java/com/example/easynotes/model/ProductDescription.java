/**
 * 
 */
package com.example.easynotes.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Electem2
 *
 */
@Entity
@Table(name = "productdescripition")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class ProductDescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long prodesid;
	private String description;
	/**
	 * @return the prodesid
	 */
	public Long getProdesid() {
		return prodesid;
	}
	/**
	 * @param prodesid the prodesid to set
	 */
	public void setProdesid(Long prodesid) {
		this.prodesid = prodesid;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
