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
@Table(name = "Company")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long comid;
	private String name;
	private String address;
	private String vatNumber;
	
	/**
	 * @return the comid
	 */
	public Long getComid() {
		return comid;
	}
	/**
	 * @param comid the comid to set
	 */
	public void setComid(Long comid) {
		this.comid = comid;
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
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the vatNumber
	 */
	public String getVatNumber() {
		return vatNumber;
	}
	/**
	 * @param vatNumber the vatNumber to set
	 */
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

}
