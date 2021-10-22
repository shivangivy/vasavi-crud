package com.example.easynotes.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@EntityListeners(AuditingEntityListener.class)
/**
 * @author Electem2
 *
 */
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * userId
	 *
	 */
	private Long userId;
	/**
	 * emailId
	 */
	private String emailId;
	/**
	 * phoneNumber
	 *
	 */

	private String phoneNumber;
	/**
	 * role
	 *
	 */
	private String role;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private List<CustomerModel> customers = new ArrayList<CustomerModel>();

	
	

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(final String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(final String role) {
		this.role = role;
	}

	/**
	 * @return the customers
	 */
	public List<CustomerModel> getCustomers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(final List<CustomerModel> customers) {
		this.customers = customers;
	}
	/**
	 * @param userId
	 * @param emailId
	 * @param phoneNumber
	 * @param role
	 * @param customers
	 */
	public User(final Long userId, final String emailId, final String phoneNumber, final String role,final  List<CustomerModel> customer) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.customers = customer;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + ", role=" + role
				+ ", customers=" + customers + "]";
	}

	/**
	 * 
	 */
	public User() {
		super();
	}

}
