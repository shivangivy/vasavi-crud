/**
 * 
 */
package com.example.easynotes.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * @author Electem2
 *
 */
@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskId;
	private String name;
		enum status{
		Doing, ToDo, Done
	}
	
	private String colourResult;
	private Date createdDate;
	private Date completedDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="developerId")
	private Developer developer;
	
	//@Transient
	private Integer days;
	/**
	 * @return the taskId
	 */
	public Integer getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
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
	 * @return the developer
	 */
	public Developer getDeveloper() {
		return developer;
	}
	/**
	 * @param developer the developer to set
	 */
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	
	/**
	 * @return the colourResult
	 */
	public String getColourResult() {
		return colourResult;
	}
	/**
	 * @param colourResult the colourResult to set
	 */
	public void setColourResult(String colourResult) {
		this.colourResult = colourResult;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the completedDate
	 */
	public Date getCompletedDate() {
		return completedDate;
	}
	/**
	 * @param completedDate the completedDate to set
	 */
	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}
	/**
	 * @return the days
	 */
	public Integer getDays() {
		return days;
	}
	/**
	 * @param days the days to set
	 */
	public void setDays(Integer days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", name=" + name + ", colourResult=" + colourResult + ", createdDate="
				+ createdDate + ", completedDate=" + completedDate + ", developer=" + developer + ", days=" + days
				+ "]";
	}
	
}
