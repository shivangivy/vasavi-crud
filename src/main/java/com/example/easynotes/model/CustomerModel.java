/**
 * 
 */
package com.example.easynotes.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author Electem2
 *
 */
@Entity
public class CustomerModel {
	/**
	 *customerId
	 *
	 */
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long customerId;
	    /**
	     * emailId
	     *
	     */
		private String emailId;
		/**
		 * name
		 *
		 */
		private String name;
		/**
		 * active
		 *
		 */
		private boolean active;
		/**
		 * @author Electem2
		 *
		 */
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinColumn(name="customerId")
		private List<Report> reports=new ArrayList<Report>();
		/**
		 * @author Electem2
		 *
		 */
		
		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(final Long customerId) {
			this.customerId = customerId;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(final String emailId) {
			this.emailId = emailId;
		}

		public String getName() {
			return name;
		}

		public void setName(final String name) {
			this.name = name;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(final boolean active) {
			this.active = active;
		}

		/**
		 * @return the reports
		 */
		public List<Report> getReports() {
			return reports;
		}

		/**
		 * @param reports the reports to set
		 */
		public void setReports(final List<Report> reports) {
			this.reports = reports;
		}

		@Override
		public String toString() {
			return "CustomerModel [customerId=" + customerId + ", emailId=" + emailId + ", name=" + name + ", active="
					+ active + ", reports=" + reports + "]";
		}

		/**
		 * @param customerId
		 * @param emailId
		 * @param name
		 * @param active
		 * @param reports
		 */
		public CustomerModel(final Long customerId, final String emailId, final String name,final  boolean active, final List<Report> reports) {
			super();
			this.customerId = customerId;
			this.emailId = emailId;
			this.name = name;
			this.active = active;
			this.reports = reports;
		}

		/**
		 * 
		 */
		public CustomerModel() {
			super();
		}

		
}
