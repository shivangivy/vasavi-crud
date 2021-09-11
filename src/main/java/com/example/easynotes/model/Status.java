/**
 * 
 */
package com.example.easynotes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Electem2
 *
 */
@Entity
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer statusId;
	private int currentlyDoingCount;
	private int completedCount;
	private int toDoCount;

	/**
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the currentlyDoingCount
	 */
	public int getCurrentlyDoingCount() {
		return currentlyDoingCount;
	}

	/**
	 * @param currentlyDoingCount the currentlyDoingCount to set
	 */
	public void setCurrentlyDoingCount(int currentlyDoingCount) {
		this.currentlyDoingCount = currentlyDoingCount;
	}

	/**
	 * @return the completedCount
	 */
	public int getCompletedCount() {
		return completedCount;
	}

	/**
	 * @param completedCount the completedCount to set
	 */
	public void setCompletedCount(int completedCount) {
		this.completedCount = completedCount;
	}

	/**
	 * @return the toDoCount
	 */
	public int getToDoCount() {
		return toDoCount;
	}

	/**
	 * @param toDoCount the toDoCount to set
	 */
	public void setToDoCount(int toDoCount) {
		this.toDoCount = toDoCount;
	}

}
