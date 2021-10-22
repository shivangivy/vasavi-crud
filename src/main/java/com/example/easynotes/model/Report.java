/**
 * 
 */
package com.example.easynotes.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

/**
 * @author Electem2
 *
 */
@Entity
	
public class Report {
	
	
	/**
	 * @reportId
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;
	/**
	 * @ reportName
	 */
    private String reportName;
    /**
	 * @createdDate
	 */
    private DateTime createdDate;
    /**
	 * @type
	 */
    private String type;
    /**
	 * @return the customerId
	 */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name ="customerId")
   private CustomerModel customer;

	/**
	 * @return the reportId
	 */
	public Long getReportId() {
		return reportId;
	}

	/**
	 * @param reportId the reportId to set
	 */
	public void setReportId(final Long reportId) {
		this.reportId = reportId;
	}

	/**
	 * @return the reportName
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * @param reportName the reportName to set
	 */
	public void setReportName(final String reportName) {
		this.reportName = reportName;
	}

	/**
	 * @return the createdDate
	 */
	public DateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(final DateTime createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(final String type) {
		this.type = type;
	}

	/**
	 * @return the customer
	 */
	public CustomerModel getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(final CustomerModel customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", reportName=" + reportName + ", createdDate=" + createdDate
				+ ", type=" + type + ", customer=" + customer + "]";
	}

	/**
	 * @param reportId
	 * @param reportName
	 * @param createdDate
	 * @param type
	 * @param customer
	 */
	public Report(final Long reportId, final String reportName,final DateTime createdDate,final String type,final CustomerModel customer) {
		super();
		this.reportId = reportId;
		this.reportName = reportName;
		this.createdDate = createdDate;
		this.type = type;
		this.customer = customer;
	}

	public Report() {
		
	}

	/**
	 * @param reportId
	 * @param reportName
	 * @param createdDate
	 * @param type
	 * @param customer
	 */
	

	
	
	
	
	
	
}
   