/**
 * 
 */
package com.example.easynotes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Electem2
 *
 */
@Entity
@Table(name = "Employees")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String ename;
	
	private Integer salary;
	
	@NotBlank
	private String erole;
	
	/**
	 * @return the id
	 */
	 @Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdAt;

	    @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date updatedAt;

		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}

		/**
		 * @return the ename
		 */
		public String getEname() {
			return ename;
		}

		/**
		 * @param ename the ename to set
		 */
		public void setEname(String ename) {
			this.ename = ename;
		}

		/**
		 * @return the salary
		 */
		public Integer getSalary() {
			return salary;
		}

		/**
		 * @param salary the salary to set
		 */
		public void setSalary(Integer salary) {
			this.salary = salary;
		}

		/**
		 * @return the erole
		 */
		public String getErole() {
			return erole;
		}

		/**
		 * @param erole the erole to set
		 */
		public void setErole(String erole) {
			this.erole = erole;
		}

		/**
		 * @return the createdAt
		 */
		public Date getCreatedAt() {
			return createdAt;
		}

		/**
		 * @param createdAt the createdAt to set
		 */
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		/**
		 * @return the updatedAt
		 */
		public Date getUpdatedAt() {
			return updatedAt;
		}

		/**
		 * @param updatedAt the updatedAt to set
		 */
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", ename=" + ename + ", salary=" + salary + ", erole=" + erole
					+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
		}
	

}
